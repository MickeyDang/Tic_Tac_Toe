import java.util.Scanner;
import java.lang.Math;
public class TicTacToe {
	//game board
	static int[][] mGrid = new int[3][3];
	
	public static void main(String[] args) {
		//initializes the turn of player one
		int turn = 1;
		System.out.println("The grid is set up as \n 0 1 2 \n 3 4 5 \n 6 7 8" + "");
		displayGrid();
		
		//runs as long as game is not won
		while (gameWon(1) == false || gameWon(2) == false) {
			
			//player one turn
			if (turn == 1) {
				makeMove(1);
				turn = 2;
				displayGrid();
				if (gameWon(1)) {
					congratWinner(1);
					break;
				}
			}
			
			//player two turn
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
	
	//method to handle player making move (typing in number)
	private static void makeMove(int a) {
		System.out.println("Player " + a + "'s turn! Type in a number from 0 to 8");
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		//handles input outside of range
		while (x > 8 || x < 0) {
			System.out.println("That is an invalid input try again");
			x = scanner.nextInt();
		}		
		//handles input of an already occupied square
		while (mGrid[x/3][x%3] != 0) {
			System.out.println("That spot is taken please try again!");
			x = scanner.nextInt();	
		} 
		//assigns a value to square on grid
		//0 is default (no one), 1 is player 1, 2 is player 2
		//calculations done to turn input of 0-8 into the corresponding (y,x) coordinate
		mGrid[x/3][x%3] = a;
	}
	
	//displays the grid
	private static void displayGrid() {
		System.out.println("");
		//iterates through the grid and displays X (player 1) or O (player 2) or [] if unoccupied
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
	
	//checks if game is won
	//number is the code corresponding to a player occupied square (1 or 2)
	private static boolean gameWon(int number) {
		//starts as true. if the loop catches a non player number it switches to false.
		boolean diagonalOfThree = true;
		boolean altDiagonalOfThree = true;
		
		//iterates through the grid column by column left to right
		for (int x = 0; x < mGrid.length ; x++) {
			//reinitializes the variable at the start of each loop when it checks a different column and row
			boolean columnOfThree = true;
			boolean rowOfThree = true;
	
			if (mGrid[x][x] != number) {
				diagonalOfThree = false;
			}	
			if (mGrid[x][2-x] != number) {
				altDiagonalOfThree = false;
			}
			for (int y = 0; y < mGrid.length; y++) {
				if (mGrid[y][x] != number) {
					columnOfThree = false;
				}
				if (mGrid[x][y] != number) {
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
		
		//default return
		return false;
	}
	
	//congratulates winner
	private static void congratWinner(int n) {
		System.out.println("Congrats player" + n + " you won!");
	}
}	
