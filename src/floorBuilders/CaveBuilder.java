package floorBuilders;

import world.TileEnum;

public class CaveBuilder implements FloorBuilder {
	private int width;
	private int height;
	private TileEnum[][] tiles;	
	
	public CaveBuilder(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new TileEnum[width][height];
	}
	
	public TileEnum[][] build() {
		randomizeTiles();
		smooth(5);
		return tiles;
	}
	
	private void randomizeTiles() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Math.random() < 0.5 ? TileEnum.FLOOR : TileEnum.WALL;
            }
        }
    }

	private void smooth(int times) {
        TileEnum[][] tiles2 = new TileEnum[width][height];
        for (int time = 0; time < times; time++) {
 
         for (int x = 0; x < width; x++) {
             for (int y = 0; y < height; y++) {
              int floors = 0;
              int rocks = 0;
 
              for (int ox = -1; ox < 2; ox++) {
                  for (int oy = -1; oy < 2; oy++) {
                   if (x + ox < 0 || x + ox >= width || y + oy < 0
                        || y + oy >= height)
                       continue;
 
                   if (tiles[x + ox][y + oy] == TileEnum.FLOOR)
                       floors++;
                   else
                       rocks++;
                  }
              }
              tiles2[x][y] = floors >= rocks ? TileEnum.FLOOR : TileEnum.WALL;
             }
         }
         tiles = tiles2;
        }
    }
}
