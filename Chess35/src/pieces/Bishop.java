package pieces;

import chess.Board;



/** 
 * The method of Bishop
 * @author Jiwei Chen
 * @author Pengrui Liu
 *
 */
public class Bishop extends Piece {
	/**
	 * To check Bishop has correct move or not.
	 * 
	 * @param x  Row coordinate of start position.
	 * @param y  Column coordinate of start position.
	 * @param a	 Row coordinate of end position.
	 * @param b	 Column coordinate of end position.
	 * @return	if Bishop can move return true
	 */
	public static boolean move(int x, int y, int a, int b){
		if (Board.ChessBoard[a][b].charAt(0)==Board.ChessBoard[x][y].charAt(0)){
			return false;
		}
		if (a > x && b > y){
			for (int i = 1; i+x < 8 && i + y < 8; i ++){
				if (x+i == a && y+i == b){
					for (int j = 1; j + x < 8 && y + j < 8; j ++){
						if (a != x+j && b != y+j){
							if (Board.d == 0 && !Board.ChessBoard[x+j][y+j].equals("   ")&&!Board.ChessBoard[x+j][y+j].equals("## ")){
								return false;
							}
							else if (Board.d == 1 && 
									!Board.ChessBoard[x+j][y+j].equals("   ")
									&&!Board.ChessBoard[x+j][y+j].equals("## ")){
								if (Board.ChessBoard[x+j][y+j].contains("wK")){
									if (Board.ChessBoard[x][y].contains("b")){
										continue;
									}
									else return false;
								}
								else if (Board.ChessBoard[x+j][y+j].contains("bK")){
									if (Board.ChessBoard[x][y].contains("w")){
										continue;
									}
									else return false;
								}
								else return false;
							}
						}
						else if (a == x+j && b == y+j){
							LastMov.temp1 = x;
							LastMov.temp2 = y;
							LastMov.temp3 = a;
							LastMov.temp4 = b;
							LastMov.info = Board.ChessBoard[x][y];
							return true;
						}
					}
				}	
			}
			return false;
		}
		else if (a > x && b < y){
			for (int i = 1; x + i < 8 && y - i > -1; i ++){
				if (x+i == a && y-i == b){
					for (int j = 1; x + j < 8 && y - j > -1; j ++){
						if (a != x+j && b != y-j){
							if (Board.d == 0 && !Board.ChessBoard[x+j][y-j].equals("   ")&&!Board.ChessBoard[x+j][y-j].equals("## ")){
								return false;
							}
							else if (Board.d == 1 && 
									!Board.ChessBoard[x+j][y-j].equals("   ")
									&&!Board.ChessBoard[x+j][y-j].equals("## ")){
								if (Board.ChessBoard[x+j][y-j].contains("wK")){
									if (Board.ChessBoard[x][y].contains("b")){
										continue;
									}
									else return false;
								}
								else if (Board.ChessBoard[x+j][y-j].contains("bK")){
									if (Board.ChessBoard[x][y].contains("w")){
										continue;
									}
									else return false;
								}
								else return false;
							}
						}
						else if (a == x+j && b == y-j){
							LastMov.temp1 = x;
							LastMov.temp2 = y;
							LastMov.temp3 = a;
							LastMov.temp4 = b;
							LastMov.info = Board.ChessBoard[x][y];
							return true;
						}
					}
				}	
			}
			return false;
		}
		else if (a < x && b > y){
			for (int i = 1; x - i > -1 && y + i < 8; i ++){
				if (x-i == a && y+i == b){
					for (int j = 1; x - j > -1 && y + j < 8; j ++){
						if (a != x-j && b != y+j){
							if (Board.d == 0 && !Board.ChessBoard[x-j][y+j].equals("   ")&&!Board.ChessBoard[x-j][y+j].equals("## ")){
								return false;
							}
							else if (Board.d == 1 && 
									!Board.ChessBoard[x-j][y+j].equals("   ")
									&&!Board.ChessBoard[x-j][y+j].equals("## ")){
								if (Board.ChessBoard[x-j][y+j].contains("wK")){
									if (Board.ChessBoard[x][y].contains("b")){
										continue;
									}
									else return false;
								}
								else if (Board.ChessBoard[x-j][y+j].contains("bK")){
									if (Board.ChessBoard[x][y].contains("w")){
										continue;
									}
									else return false;
								}
								else return false;
							}
						}
						else if (a == x-j && b == y+j){
							LastMov.temp1 = x;
							LastMov.temp2 = y;
							LastMov.temp3 = a;
							LastMov.temp4 = b;
							LastMov.info = Board.ChessBoard[x][y];
							return true;
						}
					}
				}	
			}
			return false;
		}
		else if (a < x && b < y){
			for (int i = 1; x - i > -1 && y - i > -1; i ++){
				if (x-i == a && y-i == b){
					for (int j = 1; x - j > -1 && y - j > -1; j ++){
						if (a != x-j && b != y-j){
							if (Board.d == 0 && !Board.ChessBoard[x-j][y-j].equals("   ")&&!Board.ChessBoard[x-j][y-j].equals("## ")){
								return false;
							}
							else if (Board.d == 1 && 
									!Board.ChessBoard[x-j][y-j].equals("   ")
									&&!Board.ChessBoard[x-j][y-j].equals("## ")){
								if (Board.ChessBoard[x-j][y-j].contains("wK")){
									if (Board.ChessBoard[x][y].contains("b")){
										continue;
									}
									else return false;
								}
								else if (Board.ChessBoard[x-j][y-j].contains("bK")){
									if (Board.ChessBoard[x][y].contains("w")){
										continue;
									}
									else return false;
								}
								else return false;
							}
						}
						else if (a == x-j && b == y-j){
							LastMov.temp1 = x;
							LastMov.temp2 = y;
							LastMov.temp3 = a;
							LastMov.temp4 = b;
							LastMov.info = Board.ChessBoard[x][y];
							return true;
						}
					}
				}	
			}
			return false;
		}
		
		return false;
	}
}
