package battleshipgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Board {

	private Map<String, String> board = new HashMap<String, String>();
	private List<Ship> shipPositions = new ArrayList<Ship>();
	private Converter converter = new Converter();

	// Populates the Map with a 10x10 grid that acts as the board, with . in every
	// location
	public void resetBoard() {
		String[] yAxisRows = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		for (int i = 1; i <= 10; i++) {
			for (String j : yAxisRows) {
				board.put(j + i, ".");
			}
		}
	}

	// Marks on the Map the locations of a ship with a # symbol
	public void placeShip(Ship position) {
		for (String coordinate : position.getPosition()) {
			board.put(coordinate, "#");
		}
		shipPositions.add(position);
	}

	// Marks on the Map the locations of the coordinate where a ship was, and marks
	// it with a 0
	public void placeHit(String coordinate) {
		board.put(coordinate, "0");
	}

	// Marks on the Map the location of a coordinate without a ship, and marks it
	// with an x
	public void placeMiss(String coordinate) {
		board.put(coordinate, "x");
	}

	// Returns the the value of a location on the board
	public String getCoordinateValue(String coordinate) {
		return board.get(coordinate);
	}

	// Returns 1 if the coordinate hadn't been guessed yet and is a hit,
	// and places a hit if a ship was there or a 2 if it was a miss
	// and returns 0 if the guess was invalid or a repeat
	public int checkCoordinate(String coordinate) {
		try {
			String value = board.get(coordinate);
			if (value.equals("#")) {
				placeHit(coordinate);
				return 1;
			} else if (value.equals(".")) {
				placeMiss(coordinate);
				return 2;
			} else if (value.equals("x") || value.equals("0")) {
				return 0;
			}
			return 0;
		} catch (NullPointerException e) {
			return 0;
		}
	}

	// alters the hit count on the ship that is hit
	public void findHitShip(String coordinate) {
		for (Ship ship : shipPositions) {
			for (String location : ship.getPosition()) {
				if (coordinate.equals(location)) {
					ship.placeHit();
				}
			}
		}
	}

	// returns true if all ships in the board are sunk
	public boolean allShipsSunk() {
		for (Ship ship : shipPositions) {
			if (!ship.isSunk()) {
				return false;
			}
		}
		return true;
	}

	// Returns true if the Ship doesn't overlap with other Ships on the board and is
	// within the 10x10 grid.
	public boolean checkShipIsValid(Ship ship) {
		for (String coordinate : ship.getPosition()) {
			try {
				if (board.get(coordinate).equals("#")) {
					return false;
				}
			} catch (NullPointerException e) {
				return false;
			}
		}
		for (String coordinate : ship.getPosition()) {
			try {
				board.put(coordinate, "#");
			} catch (NullPointerException e) {
				return false;
			}
		}
		return true;
	}

	// Returns a List of the coordinates for the full length of ship, given its
	// starting coordinate,
	// how long the ship is, and whether it's to be placed vertically or
	// horizontally.
	public List<String> getFullPosition(String startPosition, int shipSize, int horzVert) {
		List<String> ship = new ArrayList<String>();
		switch (horzVert) {
		case 1:
			int j = Integer.parseInt(startPosition.substring(1));
			for (int i = 0; i < shipSize; i++) {
				ship.add(startPosition.substring(0, 1) + j);
				j++;
			}
			return ship;
		case 2:
			String yAxis = startPosition.substring(0, 1);
			j = converter.convertLetterToNumber(yAxis);
			if (j != 0) {
				for (int i = 0; i < shipSize; i++) {
					yAxis = converter.convertNumberToLetter(j);
					ship.add(yAxis + startPosition.substring(1));
					j++;
				}
			}
			return ship;
		default:
			return ship;
		}
	}

	// Randomly generates a ship on the board given the desired length of the ship
	// Returns true if the ship was successfully placed, false if the generated ship
	// is invalid
	public boolean generateShip(int shipSize) {
		Random rng = new Random();
		int horzVert = rng.nextInt(2) + 1;
		String startLocation = generateCoordinate();
		Ship ship = new Ship(getFullPosition(startLocation, shipSize, horzVert));
		if (checkShipIsValid(ship)) {
			shipPositions.add(ship);
			return true;
		}
		return false;
	}
	
	// Randomly generates a coordinate location for starting locations for ships as well as random guesses
	// for the computer while playing
	public String generateCoordinate() {
		Random rng = new Random();
		String horz = converter.convertNumberToLetter(rng.nextInt(10) + 1);
		int vert = rng.nextInt(10) + 1;
		return horz + vert;
	}
}
