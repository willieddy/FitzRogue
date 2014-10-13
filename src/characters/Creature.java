package characters;

import java.awt.Color;

public class Creature {
	public int x;
    public int y;
    public int z;
 
    private char glyph;
    private Color color;
    private CreatureAi ai;
    
    public char glyph() { 
    	return glyph; 
	}
    
    public Color color() { 
    	return color; 
	}
    
    public void setCreatureAi(CreatureAi ai) {
    	this.ai = ai;
    }
    
    public void move() {
    	ai.move();
    }
}
