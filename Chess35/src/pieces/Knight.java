package pieces;

import chess.Board;

/**
 * The method of Knight
 * @author Jiwei Chen
 * @author Pengrui Liu
 *
 */

public class Knight extends Piece{
	/**
	 * To check Knight has correct move or not.
	 * 
	 * @param x  Row coordinate of start position.
	 * @param y  Column coordinate of start position.
	 * @param a	 Row coordinate of end position.
	 * @param b	 Column coordinate of end position.
	 * @return	if Knight can move return true
	 */
	public static boolean move(int x, int y, int a, int b) {
		if (Board.ChessBoard[a][b].charAt(0)==Board.ChessBoard[x][y].charAt(0)){
			return false;
		}
		if (a > x && b > y){
			if (x+1==a && y+2==b){
				return true;
			}
			else if (x+2 == a && y+1 == b){
				return true;
			}
			return false;
		}
		else if (a > x && b < y){
			if (x+1==a && y-2==b){
				return true;
			}
			else if (x+2 == a && y-1 == b){
				return true;
			}
			return false;
		}
		else if (a < x && b < y){
			if (x-1==a && y-2==b){
				return true;
			}
			else if (x-2 == a && y-1 == b){
				return true;
			}
			return false;
		}
		else if (a < x && b > y){
			if (x-1 == a && y+2 == b){
				return true;
			}
			else if (x-2 == a && y+1 == b){
				return true;
			}
			return false;
		}

		return false;
	}
}
