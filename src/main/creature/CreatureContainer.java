package main.creature;

import java.util.ArrayList;
import java.util.List;

import main.world.Floor;
import main.world.FloorContainer;
import main.asciiPanel.AsciiPanel;

public class CreatureContainer {
	private List<Creature> creatures;
	private CreatureFactory creatureFactory;
	private Creature creature;
	
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
	
	public void generateCreatures(int creatureCount, Floor floor, int floorNumber) {
        while (creatureCount > 0) {
            creatures.add(creatureFactory.generateCreature(floor, floorNumber, this));
            creatureCount--;
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
		for (Creature creature : creatures) {
            DirectionEnum move = null;
            while(unavailableSpace(floorContainer, move, creature)) {
                move = creature.onUpdate();
            }
            creature.move(move);
		}
	}
	
	private boolean unavailableSpace(FloorContainer floorContainer, DirectionEnum directionEnum, Creature creature) {
        if (directionEnum == null) return true;

		int x = creature.getX() + directionEnum.getX();
		int y = creature.getY() + directionEnum.getY();
		return (!floorContainer.getFloor(creature.getZ() - 1).getTile(x, y).isGround() && searchCreature(x, y, creature.getZ()) == null);
	}
	
	public void removeCreature(Creature creature) {
		creatures.remove(creature);
	}
}
