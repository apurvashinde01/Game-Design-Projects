
package main;
import java.util.*;

public class TicTacToe{
public static int[][] ticbox;
	public static int win(int [][]tic) {

		//check all rows 
		for(int i=0;i<3;i++) {
				if((ticbox[i][0] == 1) && (ticbox[i][1] == 1) && (ticbox[i][2] == 1))
					return 1;
				if((ticbox[i][0] == 2) && (ticbox[i][1] == 2) && (ticbox[i][2] == 2))
					return 2;
		}
		
		//check all cols
		for(int i=0;i<3;i++) {
			if((ticbox[0][i] == 1) && (ticbox[1][i] == 1) && (ticbox[2][i] == 1))
				return 1;
			if((ticbox[0][i] == 2) && (ticbox[1][i] == 2) && (ticbox[2][i] == 2))
				return 2;
	    }
		
		//left diagonal
		if((ticbox[0][0] == 1) && (ticbox[1][1] == 1) && (ticbox[2][2] == 1))
			return 1;
		if((ticbox[0][0] == 2) && (ticbox[1][1] == 2) && (ticbox[2][2] == 2))
			return 2;
		
		//right diagonal
		if((ticbox[0][2] == 1) && (ticbox[1][1] == 1) && (ticbox[2][0] == 1))
			return 1;
		if((ticbox[0][2] == 1) && (ticbox[1][1] == 1) && (ticbox[2][0] == 1))
			return 2;
		
		return 0;
	}
	
	//To print the matrix
	public static void printBox(int [][]tic) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(tic[i][j]);
			}
			System.out.println("");
		}
	}
	public static boolean validate(int a1,int a2,int [][] tic) {
		//check if a1 is between 0 & 3
		//check if a2 is between 0 & 3
		//check if the selected box is empty ie, already not marked by other player
		//if all checks pass, return true.
		
		if( ((0 <= a1) && (a1 < 3)) && ((0 <= a2) && (a2 < 3)) )
		{
			if(ticbox[a1][a2] == 0)
				return true;
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		
		ticbox = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				ticbox[i][j] = 0;
			}
		}
		
		int chk = win(ticbox);

		boolean turn= true;
		int limit = 9;
		while(chk==0 && limit > 0) {
			//if true player 1	
			if(turn) {
				System.out.println("Player 1 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
					ticbox[a1][a2] = 1;
					chk = win(ticbox);
					turn = false;
					limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}
			//else player 2
			else 
			{
				System.out.println("Player 2 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
				ticbox[a1][a2] = 2;
				chk = win(ticbox);
				turn = true;
				limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}

		}
		
		if(chk!=0) {
			System.out.println("The winner is Player "+chk);
		}else {
			System.out.println("Its a draw match!!");
		}
		
	}
}
