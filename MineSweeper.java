package PostAPJavaProject;
import java.util.*;
import java.util.Scanner;

class Main {

//import javax.swing.JFrame;

private static int[][] board = new int[8][8];
private static int[][] userBoard = new int[8][8];


public static void main(String[] args) { 
 //State rules and controls of the game
  System.out.println("The goal of this game is to AVOID the mines. To play enter the position along the Vertica on the keyboard. Hit ENTER. enter position along the Horizontal. Hit ENTER. An updated board will appear. Continue untill you hit a mine.");

	placeMines();
	adjacentToMines();
	repeat();
}

public static void placeMines() {

  for(int row = 0; row < 8; row++) {

    for(int col = 0; col < 8; col++) {
      int age = (int)(Math.random()*8);
      if(age >= 6) {
    	  board[row][col] = 9;
      }
     
      }
    }
  board[0][0] = 0;
  }
  
public static void userBoardReset() {

  for(int row = 0; row < 8; row++) {

    for(int col = 0; col < 8; col++) {
      userBoard[row][col] = 0;
    }
  }
}

public static boolean hitMine(int x, int y) {
boolean mine = false;
  if (board[x][y] == 9){
    mine = true;
  }
  return mine;
}
public static void repeat() {
	Scanner scanner = new Scanner(System.in);
	int xCord;
	int yCord;
	int Counter = 0;
	boolean mine = false;
	while (mine == false){

	Counter++;
	//user inputs position
	System.out.println("Enter Y axis position");
	xCord = scanner.nextInt();
	System.out.println("Enter X axis position");
	yCord = scanner.nextInt();

  if (xCord < 1 || xCord > 8 || yCord < 1 || yCord > 8){
    System.out.println("Entered number out of range!");} else{

	  userBoard [xCord-1][yCord-1] = board[xCord-1][yCord-1];
	  if(hitMine(xCord-1, yCord-1)) {
		  mine = true;
	  }
	  //Prints updated board
	  for(int row = 0; row < 8; row++) {
		  for(int col = 0; col < 8; col++) {
			  System.out.print(userBoard[row][col]+" ");
		  }
		  System.out.println("");
	  }
  }
}
//After hit a mine
System.out.println("Game Over: you lasted " + Counter + " turns");
}

public static void adjacentToMines() {
	for(int row = 1; row < 8; row++) {
		
		for(int col = 1; col < 8; col++) {
			
			if(board[row][col] != 9) { // Top left of [row][col]
				if(board[row-1][col-1] == 9) {
					board[row][col]++;
				}
			}
		}
	}
  for(int row = 0; row < 8; row++) {
		
		for(int col = 1; col < 8; col++) {
			
			if(board[row][col] != 9) { // Left of [row][col]
				if(board[row][col-1] == 9) {
					board[row][col]++;
				}
			}
		}	
	}
    for(int row = 0; row < 7; row++) {
		
		for(int col = 1; col < 8; col++) {
			
			if(board[row][col] != 9) { // Bottom Left [row][col]
				if(board[row+1][col-1] == 9) {
					board[row][col]++;
				}
			}
		}	
	}
    for(int row = 1; row < 8; row++) {
		
		for(int col = 0; col < 8; col++) {
			
			if(board[row][col] != 9) { // Top [row][col]
				if(board[row-1][col] == 9) {
					board[row][col]++;
				}
			}
		}	
	}

   for(int row = 0; row < 7; row++) {
		
		for(int col = 0; col < 8; col++) {
			
			if(board[row][col] != 9) { // Bottom [row][col]
				if(board[row+1][col] == 9) {
					board[row][col]++;
				}
			}
		}	
	}
for(int row = 0; row < 8; row++) {
		
		for(int col = 0; col < 7; col++) {
			
			if(board[row][col] != 9) { // Right of [row][col]
				if(board[row][col+1] == 9) {
					board[row][col]++;
				}
			}
		}	
	}
for(int row = 1; row < 8; row++) {
		
		for(int col = 0; col < 7; col++) {
			
			if(board[row][col] != 9) { // Top Right of [row][col]
				if(board[row-1][col+1] == 9) {
					board[row][col]++;
				}
			}
		}	
	}
for(int row = 0; row < 7; row++) {
		
		for(int col = 0; col < 7; col++) {
			
			if(board[row][col] != 9) { // Bottom Right of [row][col]
				if(board[row+1][col+1] == 9) {
					board[row][col]++;
				}
			}
		}	
  }
}
}
