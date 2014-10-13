package view;

import java.awt.event.KeyEvent;

import world.World;
import asciiPanel.AsciiPanel;

public class PlayScreen extends StartScreen implements Screen {
	private World world;
    private int screenWidth;
    private int screenHeight;
 
    public PlayScreen(){
        screenWidth = 90;
        screenHeight = 30;
        world = new World();
    }

	public void displayOutput(AsciiPanel terminal) {
		int left = getScrollX();
        int top = getScrollY();
    
        displayTiles(terminal, left, top);
        terminal.write(world.getHeroGlyph(), world.getHeroX() - left, world.getHeroY() - top);
    }
 
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
	        case KeyEvent.VK_ESCAPE: return new LoseScreen();
	        case KeyEvent.VK_ENTER: return new WinScreen();
	        case KeyEvent.VK_LEFT:
	        case KeyEvent.VK_H: world.moveHero(-1, 0); break;
	        case KeyEvent.VK_RIGHT:
	        case KeyEvent.VK_L: world.moveHero( 1, 0); break;
	        case KeyEvent.VK_UP:
	        case KeyEvent.VK_K: world.moveHero( 0,-1); break;
	        case KeyEvent.VK_DOWN:
	        case KeyEvent.VK_J: world.moveHero( 0, 1); break;
	        case KeyEvent.VK_Y: world.moveHero(-1,-1); break;
	        case KeyEvent.VK_U: world.moveHero( 1,-1); break;
	        case KeyEvent.VK_B: world.moveHero(-1, 1); break;
	        case KeyEvent.VK_N: world.moveHero( 1, 1); break;
	        case KeyEvent.VK_X: world.descend(); break;
        }
     
        return this;
    }
    
    public int getScrollX() {
        return Math.max(0, Math.min(world.getHeroX() - screenWidth / 2, world.getCurrentFloor().getWidth() - screenWidth));
    }
    
    public int getScrollY() {
        return Math.max(0, Math.min(world.getHeroY() - screenHeight / 2, world.getCurrentFloor().getHeight() - screenHeight));
    }
    
    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++){
            for (int y = 0; y < screenHeight; y++){
                int wx = x + left;
                int wy = y + top;
     
                terminal.write(world.getCurrentFloor().getGlyph(wx, wy), x, y, world.getCurrentFloor().getColor(wx, wy));
            }
        }
    }
}
