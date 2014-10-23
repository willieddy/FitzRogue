package creature;

import java.util.ArrayList;
import java.util.List;

import world.Floor;
import world.FloorContainer;
import asciiPanel.AsciiPanel;

public class CreatureContainer {
	List<Creature> creatures;
	CreatureFactory creatureFactory;
	Creature creature;
	
	public CreatureContainer() {
		creatures = new ArrayList<Creature>();
		creatureFactory = new CreatureFactory();
	}
	
	public Creature searchCreature(int x, int y, int z) {
		for (Creature creature : creatures) {
			if (creature.getX() == x && creature.getY() == y && creature.getZ() == z) {
				return creature;
			}
		}
		return null;
	}
	
	public void attackCreature(Creature creature) {
		removeCreature(creature);
	}
	
	public void generateCreatures(int number, Floor floor, int floorNumber) {
		for (int i = 0; i < number; i++) {
			creatures.add(creatureFactory.generateCreature(floor, floorNumber, this));
		}
	}
	
	public void displayCreatures(AsciiPanel terminal, int left, int top, int screenWidth, int screenHeight, int currentFloorNumber) {
		for (Creature creature : creatures) {
			if (creature.getZ() == currentFloorNumber && 
					creature.getX() >= left && creature.getX() < left + screenWidth &&
					creature.getY() >= top && creature.getY() < top + screenHeight) {
				terminal.write(creature.getGlyph(), creature.getX() - left, creature.getY() - top, creature.getColor());
			}
		}
    }
	
	public void update(FloorContainer floorContainer) {
		DirectionEnum directionEnum;
		for (Creature creature : creatures) {
			do {
	    		directionEnum = creature.getAi().randomMove();
	    	} while (unavailableSpace(floorContainer, directionEnum, creature));
	    	creature.setX(creature.getX() + directionEnum.getX());
	    	creature.setY(creature.getY() + directionEnum.getY());
		}
	}
	
	private boolean unavailableSpace(FloorContainer floorContainer, DirectionEnum directionEnum, Creature creature) {
		int x = creature.getX() + directionEnum.getX();
		int y = creature.getY() + directionEnum.getY();
		return (floorContainer.getFloor(creature.getZ() - 1).getTile(x, y).isGround() && searchCreature(x, y, creature.getZ()) == null);
	}
	
	public void removeCreature(Creature creature) {
		creatures.remove(creature);
	}
}
