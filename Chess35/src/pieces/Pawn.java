package pieces;

import chess.Board;
/**
 * The method of Pawn
 * @author Jiwei Chen
 * @author Pengrui Liu
 *
 */

public class Pawn extends Piece{
	/**
	 * To check Pawn has correct move or not.
	 * 
	 * @param x  Row coordinate of start position.
	 * @param y  Column coordinate of start position.
	 * @param a	 Row coordinate of end position.
	 * @param b	 Column coordinate of end position.
	 * @return	If Pawn can move return true.
	 */
	public static boolean move(int x, int y, int a, int b){
		if (Board.ChessBoard[a][b].charAt(0)==Board.ChessBoard[x][y].charAt(0)){
			return false;
		}
		if (x > a && b == y){
			if (Board.ChessBoard[x][y].charAt(0) == 'b'){
				return false;
			}
			if (x-a > 2){
				return false;
			}
			else if (x-a == 1){
				if (!Board.ChessBoard[a][b].equals("   ") && !Board.ChessBoard[a][b].equals("## ")){
					return false;
				}
				LastMov.temp1 = x;
				LastMov.temp2 = y;
				LastMov.temp3 = a;
				LastMov.temp4 = b;
				LastMov.info = Board.ChessBoard[x][y];
				return true;
			}
			else if (x-a == 2){
				if (!Board.ChessBoard[a][b].equals("   ") && !Board.ChessBoard[a][b].equals("## ")){
					return false;
				}
				if (!Board.ChessBoard[a+1][b].equals("   ") && !Board.ChessBoard[a+1][b].equals("## ")){
					return false;
				}
				if (x == 6){
					LastMov.temp1 = x;
					LastMov.temp2 = y;
					LastMov.temp3 = a;
					LastMov.temp4 = b;
					LastMov.info = Board.ChessBoard[x][y];
					return true;
				}
				else return false;
			}
		}
		else if (x < a && b == y){
			if (Board.ChessBoard[x][y].charAt(0) == 'w'){
				return false;
			}
			if (a - x > 2){
				return false;
			}
			else if (a - x == 1){
				if (!Board.ChessBoard[a][b].equals("   ") && !Board.ChessBoard[a][b].equals("## ")){
					return false;
				}
				LastMov.temp1 = x;
				LastMov.temp2 = y;
				LastMov.temp3 = a;
				LastMov.temp4 = b;
				LastMov.info = Board.ChessBoard[x][y];
				return true;
			}
			else if (a - x == 2){
				if (!Board.ChessBoard[a][b].equals("   ") && !Board.ChessBoard[a][b].equals("## ")){
					return false;
				}
				if (!Board.ChessBoard[a-1][b].equals("   ") && !Board.ChessBoard[a-1][b].equals("## ")){
					return false;
				}
				if (x == 1){
					LastMov.temp1 = x;
					LastMov.temp2 = y;
					LastMov.temp3 = a;
					LastMov.temp4 = b;
					LastMov.info = Board.ChessBoard[x][y];
					return true;
				}
				else return false;
			}
		}
		else if (Math.abs(y-b)==1 && a == x){
			if (LastMov.info.contains("P")){
				if(Math.abs(LastMov.temp3 - LastMov.temp1)==2){
					if (LastMov.temp3 == a && LastMov.temp4 == b){
						LastMov.temp1 = x;
						LastMov.temp2 = y;
						LastMov.temp3 = a;
						LastMov.temp4 = b;
						LastMov.info = Board.ChessBoard[x][y];
						return true;
					}
					else return false;
				}
				else return false;
			}
			else {
				return false;
			}
		}
		else if (Math.abs(y-b) == 1 && a - x == 1){
			if (Board.ChessBoard[x][y].charAt(0) == 'w'){
				return false;
			}
			if (Board.ChessBoard[a][b].charAt(0) == 'w'){
				LastMov.temp1 = x;
				LastMov.temp2 = y;
				LastMov.temp3 = a;
				LastMov.temp4 = b;
				LastMov.info = Board.ChessBoard[x][y];
				return true;
			}
			else return false;
		}
		else if (Math.abs(y-b) == 1 && x - a == 1){
			if (Board.ChessBoard[x][y].charAt(0) == 'b'){
				return false;
			}
			if (Board.ChessBoard[a][b].charAt(0) == 'b'){
				LastMov.temp1 = x;
				LastMov.temp2 = y;
				LastMov.temp3 = a;
				LastMov.temp4 = b;
				LastMov.info = Board.ChessBoard[x][y];
				return true;
			}
			else return false;
		}
		return false;
	}
}
