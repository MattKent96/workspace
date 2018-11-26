package battleshipgame;

public class App {
	public static void main(String[] args) {
		UserInterface userInterface = new UserInterface();
		Board myBoard = new Board();
		Board enemyBoard = new Board();
		Board guessBoard = new Board();
		Controller controller = new Controller(myBoard, guessBoard, enemyBoard, userInterface);
		
		//Starts the game
		controller.run();
	}
}
