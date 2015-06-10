package main.Hero;

import main.asciiPanel.AsciiPanel;
import main.world.Floor;
import main.world.TileEnum;

public class HeroContainer {
	Hero hero;
	
	public HeroContainer() {
		hero = new Peasant();
		hero.setX(1);
		hero.setY(1);
	}
	
	public void moveHero(Floor currentFloor, int mx, int my) {
		TileEnum tile = currentFloor.getTile(hero.getX() + mx, hero.getY() + my);
		if (tile.isGround()){
			hero.setX(Math.max(0, Math.min(hero.getX() + mx, currentFloor.getWidth() - 1)));
	    	hero.setY(Math.max(0, Math.min(hero.getY() + my, currentFloor.getHeight() - 1)));
	    } else if (tile.isDiggable()) {
	        currentFloor.dig(hero.getX() + mx, hero.getY() + my);
	    }
	}

	public void displayHero(AsciiPanel terminal, int left, int top) {
		terminal.write(hero.getGlyph(), hero.getX() - left, hero.getY() - top);
	}

	public int getHeroX() {
		return hero.getX();
	}
	
	public int getHeroY() {
		return hero.getY();
	}
}
