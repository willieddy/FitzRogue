package creature;

import java.awt.Color;

public enum CreatureEnum {
	GOBLIN ("Green and mean", 'g', Color.GREEN),
	FUNGUS ("Green and not mean", 'f', Color.GREEN);
	
	private final String description;
	private final char glyph;
	private final Color color;
	
	private CreatureEnum(String descpriton, char glyph, Color color) {
		this.description = descpriton;
		this.glyph = glyph;
		this.color = color;
	}

	public String getDescription() {
		return description;
	}
	
	public char getGlyph() {
		return glyph;
	}

	public Color getColor() {
		return color;
	}
}
