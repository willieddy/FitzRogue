package main.fitzRogue;
 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import main.view.*;
import main.asciiPanel.*;
 
public class Start extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1060623638149583738L;
 
    private AsciiPanel terminal;
    private Screen screen;
 
    public Start(){
        super();
        terminal = new AsciiPanel();
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }
    
    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }
    
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }
 
    public void keyReleased(KeyEvent e) { }
 
    public void keyTyped(KeyEvent e) { }
 
    public static void main(String[] args) {
        Start app = new Start();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
