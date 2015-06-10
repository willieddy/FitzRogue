package main.creature;

public enum DirectionEnum {
	UP (0, -1), 
	DOWN (0, 1), 
	LEFT (-1, 0), 
	RIGHT (1, 0), 
	TOP_RIGHT (1, -1), 
	TOP_LEFT (-1, -1),
	BOTTOM_RIGHT (1, 1), 
	BOTTOM_LEFT (-1, 1),
	STAND_STILL (0, 0);
	
	private final int x;
	private final int y;
	
	private DirectionEnum(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
