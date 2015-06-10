package main.view;

import java.awt.event.KeyEvent;

import main.asciiPanel.AsciiPanel;

public class StartScreen implements Screen {
	
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("FitzRogue", 1, 1);
		terminal.writeCenter("-- press [enter] to start --", 22);
	}
	
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}
