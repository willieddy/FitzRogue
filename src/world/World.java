package world;

import java.util.ArrayList;
import java.util.List;

import characters.*;

public class World {
	List<Floor> floors;
	Floor currentFloor;
	private int currentFloorNumber;
	Hero hero;
	
	public World () {
		floors = new ArrayList<Floor>();
		currentFloorNumber = 0;
		createInitialFloor();
		currentFloor = floors.get(currentFloorNumber);
		createHero();
	}

	public Floor getCurrentFloor() {
		return currentFloor;
	}
	
	public int getCurrentFloorNumber() {
		return currentFloorNumber;
	}
	
	public void descend() {
		if (floors.size() > currentFloorNumber + 1) {
			currentFloor = floors.get(++currentFloorNumber);
		} else {
			descendToNewFloor();
		}
	}
	
	public void moveHero(int mx, int my) {
		TileEnum tile = currentFloor.getTile(hero.getX() + mx, hero.getY() + my);
		if (tile.isGround()){
			hero.setX(Math.max(0, Math.min(hero.getX() + mx, currentFloor.getWidth() - 1)));
	    	hero.setY(Math.max(0, Math.min(hero.getY() + my, currentFloor.getHeight() - 1)));
	    } else if (tile.isDiggable()) {
	        currentFloor.dig(hero.getX() + mx, hero.getY() + my);
	    }
	}

	public int getHeroX() {
		return hero.getX();
	}
	
	public int getHeroY() {
		return hero.getY();
	}
	
	public char getHeroGlyph() {
		return hero.getGlyph();
	}

	private void descendToNewFloor() {
		floors.add(new Floor(FloorTypeEnum.CAVE));
		currentFloor = floors.get(++currentFloorNumber);
	}
	
	private void createInitialFloor() {
		floors.add(new Floor(FloorTypeEnum.CAVE));
	}
	
	private void createHero() {
		hero = new Hero();
		hero.setX(1);
		hero.setY(1);
	}
	
	

}
