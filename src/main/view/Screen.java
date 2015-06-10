package main.view;

import java.awt.event.KeyEvent;
import main.asciiPanel.AsciiPanel;

public interface Screen {
	public void displayOutput(AsciiPanel terminal);
	
	public Screen respondToUserInput(KeyEvent key);
}
