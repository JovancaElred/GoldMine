package GoldMine;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char input;
		board b1 = new board(6);
		Scanner scan = new Scanner(System.in);
		
		while(b1.currGold > 0) {
			System.out.println("Gold to Collect: " + b1.currGold);
			b1.displayBoard();
			System.out.print("Input move: ");
			input = scan.nextLine().toLowerCase().charAt(0);
			b1.move(input);
		}
		System.out.println("Gold to Collect: " + b1.currGold);
		b1.displayBoard();
		
		
	}

}
