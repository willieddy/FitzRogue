package creature;

import java.util.ArrayList;
import java.util.List;

import world.Floor;
import world.FloorContainer;
import asciiPanel.AsciiPanel;

public class CreatureContainer {
	List<Creature> creatures;
	Creature creature;
	
	public CreatureContainer() {
		creatures = new ArrayList<Creature>();
	}
	
	public Creature isCreature(int x, int y) {
		for (Creature creature : creatures) {
			if (creature.getX() == x && creature.getY() == y) {
				return creature;
			}
		}
		return null;
	}
	
	public void generateCreatures(int number, Floor floor, int floorNumber) {
		int x;
		int y;
		
		int floorWidth = floor.getWidth();
		int floorHeight = floor.getHeight();
		
		for (int i = 0; i < number; i++) {
			do {
				x = (int)(Math.random() * floorWidth-1);
				y = (int)(Math.random() * floorHeight-1);
			} while (!floor.getTile(x, y).isGround() || isCreature(x,y) != null);
			
			creature = new Creature(CreatureEnum.GOBLIN);
			creature.setX(x);
			creature.setY(y);
			creature.setZ(floorNumber);
			creatures.add(creature);
		}
	}
	
	public void displayCreatures(AsciiPanel terminal, int left, int top, int currentFloorNumber) {
		for (Creature creature : creatures) {
			if (creature.getZ() == currentFloorNumber) {
				terminal.write(creature.getGlyph(), creature.getX() - left, creature.getY() - top, creature.getColor());
			}
		}
    }
	
	public void move(FloorContainer floorContainer) {
		for (Creature creature : creatures) {
			creature.move(floorContainer);
		}
	}
}
