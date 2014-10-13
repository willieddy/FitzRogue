package creature;

import java.awt.Color;

import world.FloorContainer;

public class Creature {
	private int x;
    private int y;
    private int z;
    
    private CreatureAi ai;
    private CreatureEnum creatureEnum;
    private DirectionEnum directionEnum;
    
    public Creature(CreatureEnum creatureEnum) {
    	this.creatureEnum = creatureEnum;
    	ai = new CreatureAi();
    }
    
	public void move(FloorContainer floorContainer) {
    	do {
    		directionEnum = ai.move();
    	} while (!floorContainer.getFloor(z - 1).getTile(x + directionEnum.getX(), y + directionEnum.getY() - 1).isGround());
    	x += directionEnum.getX();
    	y += directionEnum.getY();
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
