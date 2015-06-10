package main.creature;

import java.awt.Color;

import main.ai.CreatureAi;

public class Creature {
	private int x;
    private int y;
    private int z;
    
    private CreatureAi ai;
    private CreatureEnum creatureEnum;
    
    public Creature(CreatureEnum creatureEnum, CreatureAi ai) {
    	this.creatureEnum = creatureEnum;
    	this.ai = ai;
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

    public void move(DirectionEnum move) {
        x += move.getX();
        y += move.getY();
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


    public DirectionEnum onUpdate() {
        return ai.onUpdate();
    }
}
