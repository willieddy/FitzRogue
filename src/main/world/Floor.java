package main.world;

import java.awt.Color;

import main.floorBuilders.*;

public class Floor {
	private TileEnum[][] tiles;
	private int width;
    private int height;
    private int floorNumber;
    private FloorTypeEnum floorType;
    private FloorBuilder floorBuilder;
    
    public Floor(FloorTypeEnum floorType){
    	this.floorType = floorType;
    	width = floorType.getWidth();
    	height = floorType.getHeight();
    	tiles = new TileEnum[width][height];
        createFloor();
    }

	public int getHeight() { 
    	return height; 
	}
    
    public int getWidth() { 
    	return width; 
	}
    
    public int getFloorNumber() {
    	return floorNumber;
    }
 
    public TileEnum getTile(int x, int y) {
    	if (x < 0 || x >= width || y < 0 || y >= height)
            return TileEnum.BOUNDS;
        else
            return tiles[x][y];
    }
    
    public char getGlyph(int x, int y){
        return getTile(x, y).getGlyph();
    }
    
    public Color getColor(int x, int y) {
    	return getTile(x, y).getColor();
    }
    
    private void createFloor() {
		switch (floorType) {
			case CAVE:
				floorBuilder = new CaveBuilder(width, height);
				tiles = floorBuilder.build();
				break;
			default:
				System.out.println("Not a compatible floor type to generate");
		}
	}

	public void dig(int x, int y) {
		tiles[x][y] = TileEnum.FLOOR;
	}
}
