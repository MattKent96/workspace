package battleshipgame;

import java.util.Scanner;

public class UserInterface {
	
	private Scanner scr = new Scanner(System.in);
	
	// Takes in a board, and displays all values of the board in a 10x10 grid
	public void displayBoard (Board board) {
		System.out.print("\n  1  2  3  4  5  6  7  8  9  10\n");
		System.out.print("A ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(board.getCoordinateValue("A" + i) + "  ");
		}
		System.out.print("A \nB ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(board.getCoordinateValue("B" + i) + "  ");
		}
		System.out.print("B \nC ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(board.getCoordinateValue("C" + i) + "  ");
		}
		System.out.print("C \nD ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(board.getCoordinateValue("D" + i) + "  ");
		}
		System.out.print("D \nE ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(board.getCoordinateValue("E" + i) + "  ");
		}
		System.out.print("E \nF ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(board.getCoordinateValue("F" + i) + "  ");
		}
		System.out.print("F \nG ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(board.getCoordinateValue("G" + i) + "  ");
		}
		System.out.print("G \nH ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(board.getCoordinateValue("H" + i) + "  ");
		}
		System.out.print("H \nI ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(board.getCoordinateValue("I" + i) + "  ");
		}
		System.out.print("I \nJ ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(board.getCoordinateValue("J" + i) + "  ");
		}
		System.out.print("J\n");
		System.out.print("  1  2  3  4  5  6  7  8  9  10\n");
	}
	
	//Displays a message to the user
	public void displayMessage(String message) {
		System.out.println(message);
	}
	
	//Displays a prompt to the user and returns the value of the input
	public String getUserInput(String prompt) {
		System.out.println(prompt);
		String input = scr.nextLine();
		return input;
	}
	
	public void displayHitBanner() {
		System.out.println(" **** HIT!! ****");
	}
	
	public void displayMissBanner() {
		System.out.println(" ---- MISS ----");
	}
	
	public void dipslayGuess(String coordinate) {
		System.out.println(" The guess was: " + coordinate);
	}
	
	public void displayWelcomeBanner() {
		System.out.println(" === Welcome to BattleShip! ===");
	}
	
	
}
