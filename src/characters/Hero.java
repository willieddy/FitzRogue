package characters;

import java.awt.Color;

public class Hero {
	private int x;
	private int y;
	
	private char glyph;
	private Color color;
	
	public Hero() {
		glyph = '@';
		color = Color.BLUE;
	}
	
	public char getGlyph() {
		return glyph;
	}
	
	public Color getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
