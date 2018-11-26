package battleshipgame;

public class Controller {

	Board userBoard;
	Board guessBoard;
	Board enemyBoard;
	UserInterface userInterface;
	
	public Controller(Board userBoard, Board guessBoard, Board enemyBoard, UserInterface userInterface) {
		this.userBoard = userBoard;
		this.guessBoard = guessBoard;
		this.enemyBoard = enemyBoard;
		this.userInterface = userInterface;
	}
	
	
	//Starts the game, checks every round if the game is over, then allows the user and computer to guess alternately every round
	public void run() {
		resetBoards();
		placeAllShips();
		randomlyPlaceShips(enemyBoard);
		boolean gameOver = false;
		while (!gameOver) {
			if(userBoard.allShipsSunk() || enemyBoard.allShipsSunk()) {
				userInterface.displayMessage(" Game Over!!!");
				gameOver = true;
			}
			userGuessShipLocation();
			
			if(userBoard.allShipsSunk() || enemyBoard.allShipsSunk()) {
				userInterface.displayMessage(" Game Over!!!");
				gameOver = true;
			}
			enemyGuessLocation();
		}
		
	}

	// loads all the boards and erases any previous ships
	private void resetBoards() {
		userBoard.resetBoard();
		guessBoard.resetBoard();
		enemyBoard.resetBoard();
	}
	
	//prompts the user to guess a location and checks the enemy's board for the result
	private void userGuessShipLocation() {
		boolean isValid = false;
		while(!isValid) {
			String coordinate = userInterface.getUserInput(" Please enter the coordinate to guess:");
			int validNum = enemyBoard.checkCoordinate(coordinate);
			if (validNum == 1) {
				enemyBoard.placeHit(coordinate);
				guessBoard.placeHit(coordinate);
				userInterface.displayMessage(" **** HIT!!! ****");
				isValid = true;
			} else if (validNum == 2) {
				enemyBoard.placeMiss(coordinate);
				guessBoard.placeMiss(coordinate);
				userInterface.displayMessage(" ---- Miss ----");
				isValid = false;
			}	else {
				userInterface.displayMessage(" Please enter a valid coordinate that hasn't been guessed");
			}
		}
	}
	
	
	//randomly creates a coordinate and checks the user's board for the result
	private void enemyGuessLocation() {
		boolean isValid = false;
		while(!isValid) {
			String coordinate = userBoard.generateCoordinate();
			int validNum = userBoard.checkCoordinate(coordinate);
			if (validNum == 1) {
				userBoard.placeHit(coordinate);
				userInterface.displayMessage(" **** HIT!!! ****");
				userInterface.displayMessage(" The guess was:  " + coordinate);
				isValid = true;
			} else if (validNum == 2) {
				userBoard.placeMiss(coordinate);
				userInterface.displayMessage(" ---- Miss ----");
				userInterface.displayMessage(" The guess was:  " + coordinate);
				isValid = true;
			} 
		}
	}

	//prompts the user to place all the ships and loads the board
	private void placeAllShips() {
		userInterface.displayBoard(userBoard);

		userInterface.displayMessage(" Please place Carrier:");
		userPlaceShip(5, userBoard);

		userInterface.displayMessage(" Please place Battleship:");
		userPlaceShip(4, userBoard);

		userInterface.displayMessage(" Please place Destroyer:");
		userPlaceShip(3, userBoard);

		userInterface.displayMessage(" Please place Submarine");
		userPlaceShip(3, userBoard);

		userInterface.displayMessage(" Please place Patrol Boat");
		userPlaceShip(2, userBoard);
	}
	
	//randomly places all ships for a board
	private void randomlyPlaceShips(Board board) {
		boolean shipsPlaced = false;
		while (!shipsPlaced) {
			board.resetBoard();
			boolean carrierPlaced = board.generateShip(5);
			boolean battleshipPlaced = board.generateShip(4);
			boolean destroyerPlaced = board.generateShip(3);
			boolean subPlaced = board.generateShip(3);
			boolean patrolPlaced = board.generateShip(2);
			if (carrierPlaced && battleshipPlaced && destroyerPlaced && subPlaced && patrolPlaced) {
				userInterface.displayBoard(board);
				shipsPlaced = true;
			}
		}

	}
	
	// Prompts the user to place a ship of a given length on a given Board.
	// Returns true if the ship is succesfully placed, false if it's unable to place ship
	private boolean userPlaceShip(int shipSize, Board board) {
		boolean isInRange = false;
		while (!isInRange) {
			Ship ship;
			int horzVert = 0;
			try {
				horzVert = Integer.parseInt(userInterface.getUserInput(" Would you like your ship (1)Horizontal "
					+ "	or (2)Vertical?"));
			} catch(NumberFormatException e) {
				userInterface.displayMessage(" Couldn't find the Horizontal or Vertical");
			}
			switch (horzVert) {
			case 1:
				userInterface.displayMessage(" Please select the leftmost desired coordinate:");
				String coordinate = userInterface.getUserInput(" Please enter a coordinate:").toUpperCase();
				ship = new Ship(board.getFullPosition(coordinate, shipSize, 1));
				if (board.checkShipIsValid(ship)) {
					Ship myShip = new Ship(board.getFullPosition(coordinate, shipSize, 1));
					board.placeShip(myShip);
					userInterface.displayBoard(board);
					return true;
				} else {
					userInterface.displayMessage(" Out of Range!!");
				}
			case 2:
				userInterface.displayMessage(" Please select the highest desired coordinate:");
				coordinate = userInterface.getUserInput(" Please enter a coordinate:").toUpperCase();
				ship = new Ship(board.getFullPosition(coordinate, shipSize, 2));
				if (board.checkShipIsValid(ship)) {
					Ship myShip = new Ship(board.getFullPosition(coordinate, shipSize, 2));
					board.placeShip(myShip);
					userInterface.displayBoard(board);
					return true;
				} else {
					userInterface.displayMessage(" Out of Range!!");
				}
			}
		}
		return false;
	}
}
