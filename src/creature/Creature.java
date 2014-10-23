package creature;

import java.awt.Color;

import ai.CreatureAi;
import world.FloorContainer;

public class Creature {
	private int x;
    private int y;
    private int z;
    
    private CreatureAi ai;
    private CreatureEnum creatureEnum;
    
    public Creature(CreatureEnum creatureEnum) {
    	this.creatureEnum = creatureEnum;
    	ai = new CreatureAi(creatureEnum);
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

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public CreatureAi getAi() {
		return ai;
	}

	public char getGlyph() {
		return creatureEnum.getGlyph();
	}

	public Color getColor() {
		return creatureEnum.getColor();
	}
	
	public String getName() {
		return creatureEnum.toString();
	}
	
	public String getDescription() {
		return creatureEnum.getDescription();
	}

	

}
