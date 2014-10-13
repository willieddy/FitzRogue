package world;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public enum TileEnum {
	FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    BOUNDS('x', AsciiPanel.brightBlack);
 
    private char glyph;
    private Color color;
    
    TileEnum(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }
    
    public char getGlyph() { 
    	return glyph; 
	}
    
    public Color getColor() { 
    	return color; 
	}
    
    public boolean isGround() {
    	return this == FLOOR;
    }
    
    public boolean isDiggable() {
    	return this == TileEnum.WALL;
    }
}
