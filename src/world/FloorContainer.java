package world;

import java.util.ArrayList;
import java.util.List;

import asciiPanel.AsciiPanel;

public class FloorContainer {
	List<Floor> floors;
	
	public FloorContainer() {
		floors = new ArrayList<Floor>();
	}
	
	public int descend(int currentFloorNumber, FloorTypeEnum floorTypeEnum) {
		if (floors.size() < currentFloorNumber + 1) {
			generateNewFloor();
		}
		return currentFloorNumber + 1;
	}
	
	public void createInitialFloor() {
		floors.add(new Floor(FloorTypeEnum.CAVE));
	}
	
	public void displayTiles(AsciiPanel terminal, int left, int top, int screenWidth, int screenHeight, int currentFloor) {
        for (int x = 0; x < screenWidth; x++){
            for (int y = 0; y < screenHeight; y++){
                int wx = x + left;
                int wy = y + top;
     
                terminal.write(floors.get(currentFloor - 1).getGlyph(wx, wy), x, y, floors.get(currentFloor - 1).getColor(wx, wy));
            }
        }
    }
	
	public Floor getFloor(int floorNumber) {
		return floors.get(floorNumber);
	}
	
	private void generateNewFloor() {
		floors.add(new Floor(FloorTypeEnum.CAVE));
	}
}
