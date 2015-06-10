package main.creature;

import main.ai.FungusAi;
import main.ai.GoblinAi;
import main.world.Floor;

public class CreatureFactory {
	
	public Creature generateCreature (Floor floor, int floorNumber, CreatureContainer creatureContainer) {
		int floorWidth = floor.getWidth();
		int floorHeight = floor.getHeight();
		
		int xCoordinate;
		int yCoordinate;
		
		do {
			xCoordinate = (int)(Math.random() * floorWidth);
			yCoordinate = (int)(Math.random() * floorHeight);
		} while (!floor.getTile(xCoordinate, yCoordinate).isGround() || creatureContainer.searchCreature(xCoordinate, yCoordinate, floorNumber) != null);
		
		Creature creature = chooseCreatureType(floorNumber);
		creature.setX(xCoordinate);
		creature.setY(yCoordinate);
		creature.setZ(floorNumber);
		return creature;
	}

	private Creature chooseCreatureType(int floorNumber) {
		if (Math.random() < 0.5) {
			return new Creature(CreatureEnum.GOBLIN, new GoblinAi());
		} else {
			return new Creature(CreatureEnum.FUNGUS, new FungusAi());
		}
	}
}
