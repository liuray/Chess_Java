package pieces;

import chess.Board;
/**
 * The method of Queen
 * @author Jiwei Chen
 * @author Pengrui Liu
 *
 */

public class Queen extends Piece{
	/**
	 * To check Queen has correct move or not.
	 * 
	 * @param x  Row coordinate of start position.
	 * @param y  Column coordinate of start position.
	 * @param a	 Row coordinate of end position.
	 * @param b	 Column coordinate of end position.
	 * @return	If Queen can move return true.
	 */
	public static boolean move(int x, int y, int a, int b) {
		if (Bishop.move(x, y, a, b)==false && Rook.move(x, y, a, b)==false){
			return false;
		}
		LastMov.temp1 = x;
		LastMov.temp2 = y;
		LastMov.temp3 = a;
		LastMov.temp4 = b;
		LastMov.info = Board.ChessBoard[x][y];
		return true;
	}
}
