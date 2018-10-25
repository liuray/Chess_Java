package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * In this class can print the chess board, and read data from two players, and check is correct move or not. 
 * @author Pengrui Liu
 * @author Jiwei Chen
 *  
 */
public class Chess {
	/**
	 * if variable temp = 0 , return.
	 */
	private static int temp = 0;
	/**
	 * Update the move steps, if even print "White's move:" otherwise print "Black's move:".
	 */
	static int moves = 1;
	/**
	 * if variable ab = 0,return method.
	 */
	private static int ab =0;
	/**
	 * A list to store move position
	 */
	public static List<Integer> positions = new ArrayList<>();
	/**
	 * Default value false  
	 */
	private static boolean black = false, white = false;

	public static void main(String[] args) {
		print();
		while (true) {
		
			reader();
			if (temp == 1)
				return;
			if (Board.q == 1){
				return;
			}
			
			print();
		}
	}
	
	/**
	 * To print the chess board
	 */
	public static void print() {
		chess.Board.resetChessBoard();
		String a[][] = Board.ChessBoard;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		if (moves%2 == 0){
			if (Board.q != 1)
			System.out.print("Black's move: ");		
		}
		else{
			if (Board.q != 1)
				System.out.print("White's move: ");
		}
	}

	/**
	 *  To read and store player enter data.
	 */
	public static void reader()  {
		ab = 0;
		positions.removeAll(positions);
		String[] token;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String re = "";

		do {
			try {
				re = br.readLine();
			} catch (IOException ioe) {
				System.out.println("error");
			}
			token = re.split(" ");
		} while (token == null);

		if (token.length == 0) {
			System.out.println("Please enter: ");
			reader();
		} else if (token.length == 1) {
			if (token[0].equalsIgnoreCase("resign")) {
				temp = 1;
				return;
			} else {
				System.out.println("Please enter the corret data!!!!!!");
				reader();
				return;
			}
		}  else if (token.length == 2 && isPosValid(token) == true) {

			int pos1 = letterPos(token[0].toLowerCase());
			int pos2 = letterPos(token[1].toLowerCase());
			int num1 = numPos(token[0].toLowerCase());
			int num2 = numPos(token[1].toLowerCase());
			if (hasPiece(Board.ChessBoard[num1][pos1]) == false) {
				System.out.println("Nothing here reinput please.");
				reader();
			}
			
			if (pos1 == 10 && pos2 == 10) {
				System.out.println("Please enter right position");
				reader();
			}
			if (moves%2 == 0){
				if (Board.ChessBoard[num1][pos1].charAt(0)=='w'){
					System.out.println("Please give right position");
					reader();
				}
				else moves++;
			}
			else{
				if (Board.ChessBoard[num1][pos1].charAt(0)=='b'){
					System.out.println("Please give right position");
					reader();
				}
				else moves++;
			}
			
			positions.add(pos1);
			positions.add(num1);
			positions.add(pos2);
			positions.add(num2);

		} else if (token.length == 3 && isPosValid(token) == true) {
			if (token[2].equalsIgnoreCase("draw?")) {
				ab = 1;
				Scanner sc = new Scanner(System.in);
				String dr ="";
				do{ dr = sc.nextLine();
				if (dr.equalsIgnoreCase("draw")) {
					temp = 1;
					return;
				}
				System.out.println("Please enter corret spell"+"'draw'.");
				}while(!dr.equalsIgnoreCase("draw"));
				
			}else{
				System.out.println("Please enter again: ");
				reader();
				
			}
			
		}else {
			System.out.println("Incorroet format!!");
			reader();
			return;
		}
		if(ab == 0)
		chess.Board.identityPieces();
		return;
	}

	/**
	 * To check has piece or not.
	 * @param s  The string of start position
	 * @return If has piece return true, otherwise false
	 */
	private static boolean hasPiece(String s) {
		if (s == "   " || s == "## ") {
			return false;
		}
		return true;
	}

	// To check the letter is "a b c d e f g h" or not
	private static boolean isPosValid(String[] move) {
		if (move[0].equalsIgnoreCase(move[1])) {
			return false;
		}
		for (int i = 0; i < 2; i++) {
			String pos = move[i].toLowerCase();
			if (pos.length() != 2 || pos.charAt(0) < 'a' || pos.charAt(0) > 'h' || pos.charAt(1) < '1'
					|| pos.charAt(1) > '8') {
				return false;
			}
		}
		return true;
	}

	// know about which one should be gone, black or white.
	

	// the letter "a b c d e f g h" has each index of 2d array
	/**
	 * 	Make the letter "a b c d e f g h" has each index of 2D - array
	 * @param c 	Letter string
	 * @return  Row index if 2D - array 
	 */
	private static int letterPos(String c) {
		char letter = c.charAt(0);

		switch (letter) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		case 'h':
			return 7;
		default:
			return 10;

		}
	}
	
	// correct number position in chess board
	/**
	 * 	Make the numbers have each index of 2D - array
	 * @param s  string
	 * @return  Column index if 2D - array 
	 */
	private static int numPos(String s) {
		char a = s.charAt(1);
		int num = Character.getNumericValue(a);

		switch (num) {
		case 1:
			return 7;
		case 2:
			return 6;
		case 3:
			return 5;
		case 4:
			return 4;
		case 5:
			return 3;
		case 6:
			return 2;
		case 7:
			return 1;
		case 8:
			return 0;
		default:
			return 10;

		}
	}
}
