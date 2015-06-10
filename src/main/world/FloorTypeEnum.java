package main.world;

public enum FloorTypeEnum {
	CAVE (90, 31);
	
	private final int width;
	private final int height;
	
	FloorTypeEnum(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
