package battleshipgame;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	private List<String> position;
	private int numberOfHits;
	
	public Ship(List<String> position) {
		for (String coordinate : position) {
			this.position.add(coordinate);
		}
		numberOfHits = position.size();
	}
	
	
	// returns all the coordinates that contain the ship positions
	public List<String> getPosition() {
		return position;
	}
	
	// adjusts the number of hits the ship has taken 
	public void placeHit() {
		numberOfHits--;
	}
	
	// returns true if the ship is sunk
	public boolean isSunk() {
		return numberOfHits == 0;
	}
}
	
