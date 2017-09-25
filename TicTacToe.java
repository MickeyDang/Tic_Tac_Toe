import java.util.Scanner;
import java.lang.Math;
public class TicTacToe {
	static int[][] mGrid = new int[3][3];
	
	public static void main(String[] args) {
		int turn = 1;
		System.out.println("The grid is set up as \n 0 1 2 \n 3 4 5 \n 6 7 8" + "");
		displayGrid();
		
		while (gameWon(1) == false || gameWon(2) == false) {
			
			if (turn == 1) {
				makeMove(1);
				turn = 2;
				displayGrid();
				if (gameWon(1)) {
					congratWinner(1);
					break;
				}
			}
			
			if (turn == 2) {
				makeMove(2);
				turn = 1;
				displayGrid();
				if (gameWon(2)) {
					congratWinner(2);
					break;
				}
			}
			
		}	
	}
	
	private static void makeMove(int a) {
		System.out.println("Player " + a + "'s turn! Type in a number from 0 to 8");
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		while (x > 8 || x < 0) {
			System.out.println("That is an invalid input try again");
			x = scanner.nextInt();
		}		
		while (mGrid[x/3][x%3] != 0) {
			System.out.println("That spot is taken please try again!");
			x = scanner.nextInt();
		} 
		
		mGrid[x/3][x%3] = a;
		
	}
	
	private static void displayGrid() {
		System.out.println("");
		for (int x = 0; x < mGrid.length ; x++) {
			for (int y = 0 ; y < mGrid.length ; y++) {
				if (mGrid[x][y] == 0) {
					System.out.print("[ ]");
				} else if (mGrid[x][y] == 1) {
					System.out.print(" X ");
				} else if (mGrid[x][y] == 2) {
					System.out.print(" O ");
				}
			}	
			System.out.println("");	
		}
	}
	
	private static boolean gameWon(int number) {
		boolean rowOfThree = true;
		boolean diagonalOfThree = true;
		boolean altDiagonalOfThree = true;
		for (int x = 0; x < mGrid.length ; x++) {
			boolean columnOfThree = true;
			if (mGrid[x][x] != number) {
				diagonalOfThree = false;
			}	
			if (mGrid[x][2-x] != number) {
				altDiagonalOfThree = false;
			}
			for (int y = 0; y < mGrid.length; y++) {
				if (mGrid[x][y] != number) {
					columnOfThree = false;
				}
				if (mGrid[y][x] != number) {
					rowOfThree = false;
				}
			}
			if (columnOfThree) {
				return true;
			}
			if (rowOfThree) {
				return true;
			}
		}	
		if (diagonalOfThree) {
			return true;
		}	
		if (altDiagonalOfThree) {
			return true;
		}
		return false;
	}
	
	private static void congratWinner(int n) {
		System.out.println("Congrats player" + n + " you won!");
	}
}	
