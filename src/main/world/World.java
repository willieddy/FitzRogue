package main.world;

import main.creature.*;
import main.Hero.HeroContainer;
import main.asciiPanel.AsciiPanel;

public class World {
	FloorContainer floorContainer;
	CreatureContainer creatureContainer;
	HeroContainer heroContainer;
	
	private int currentFloorNumber;
	private int screenWidth;
	private int screenHeight;
	private int left;
	private int top;
	
	public World (int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		
		currentFloorNumber = 0;
		floorContainer = new FloorContainer();
		currentFloorNumber = floorContainer.descend(currentFloorNumber, FloorTypeEnum.CAVE);
		
		creatureContainer = new CreatureContainer();
		creatureContainer.generateCreatures(8, floorContainer.getFloor(currentFloorNumber - 1), currentFloorNumber);
		
		heroContainer = new HeroContainer();
	}

	public void update(int mx, int my) {
		if (creatureContainer.searchCreature(heroContainer.getHeroX() + mx, heroContainer.getHeroY() + my, currentFloorNumber) != null) {
			creatureContainer.attackCreature(creatureContainer.searchCreature(heroContainer.getHeroX() + mx, heroContainer.getHeroY() + my, currentFloorNumber));
		} else {
			heroContainer.moveHero(floorContainer.getFloor(currentFloorNumber - 1), mx, my);
		}
		creatureContainer.update(floorContainer);
	}
	
	public void descend() {
		currentFloorNumber = floorContainer.descend(currentFloorNumber, FloorTypeEnum.CAVE);
		creatureContainer.generateCreatures(8, floorContainer.getFloor(currentFloorNumber - 1), currentFloorNumber);
	}

	public void display(AsciiPanel terminal) {
		left = getScrollX();
        top = getScrollY();
        
        floorContainer.displayTiles(terminal, left, top, screenWidth, screenHeight, currentFloorNumber);
        creatureContainer.displayCreatures(terminal, left, top, screenWidth, screenHeight, currentFloorNumber);
        heroContainer.displayHero(terminal, left, top);
	}
	
	private int getScrollX() {
        return Math.max(0, Math.min(heroContainer.getHeroX() - screenWidth / 2, floorContainer.getFloor(currentFloorNumber - 1).getWidth() - screenWidth));
    }
    
    private int getScrollY() {
        return Math.max(0, Math.min(heroContainer.getHeroY() - screenHeight / 2, floorContainer.getFloor(currentFloorNumber - 1).getHeight() - screenHeight));
    }
	
	
}
