package main.view;

import java.awt.event.KeyEvent;

import main.world.World;
import main.asciiPanel.AsciiPanel;

public class PlayScreen extends StartScreen implements Screen {
	private World world;
    private int screenWidth;
    private int screenHeight;
 
    public PlayScreen(){
        screenWidth = 90;
        screenHeight = 30;
        world = new World(screenWidth, screenHeight);
    }

	public void displayOutput(AsciiPanel terminal) {
        world.display(terminal);
    }
 
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                return new LoseScreen();
            case KeyEvent.VK_ENTER:
                return new WinScreen();
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H:
                world.update(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L:
                world.update(1, 0);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_K:
                world.update(0, -1);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J:
                world.update(0, 1);
                break;
            case KeyEvent.VK_Y:
                world.update(-1, -1);
                break;
            case KeyEvent.VK_U:
                world.update(1, -1);
                break;
            case KeyEvent.VK_B:
                world.update(-1, 1);
                break;
            case KeyEvent.VK_N:
                world.update(1, 1);
                break;
            case KeyEvent.VK_X:
                world.descend();
                break;
        }
     
        return this;
    } 
}
