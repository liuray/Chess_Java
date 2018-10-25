package pieces;

import chess.Board;
/**
 * The method of Rook
 * @author Jiwei Chen
 * @author Pengrui Liu
 *
 */

public class Rook extends Piece{
	
	/**
	 *  return default value true
	 */
	static boolean black1,black2,white1,white2;
	/**
	 * To check Rook has correct move or not.
	 * 
	 * @param x  Row coordinate of start position.
	 * @param y  Column coordinate of start position.
	 * @param a	 Row coordinate of end position.
	 * @param b	 Column coordinate of end position.
	 * @return	if Rook can move return true.
	 */
	public static boolean move(int x, int y, int a, int b){
		if (Board.ChessBoard[a][b].charAt(0)==Board.ChessBoard[x][y].charAt(0)){
			return false;
		}
		if (a == x && b > y){
			for (int i = 1; i + y < 8; i ++){
				if (y+i == b){
					for (int j = 1;  y + j < 8; j ++){
						if (b != y+j){
							if (Board.d == 0 && 
									!Board.ChessBoard[x][y+j].equals("   ")
									&&!Board.ChessBoard[x][y+j].equals("## ")){
								return false;
							}
							else if (Board.d == 1 && 
									!Board.ChessBoard[x][y+j].equals("   ")
									&&!Board.ChessBoard[x][y+j].equals("## ")){
								if (Board.ChessBoard[x][y+j].contains("wK")){
									if (Board.ChessBoard[x][y].contains("b")){
										continue;
									}
									else return false;
								}
								else if (Board.ChessBoard[x][y+j].contains("bK")){
									if (Board.ChessBoard[x][y].contains("w")){
										continue;
									}
									else return false;
								}
								else return false;
							}
						}
						else if (b == y+j){
							if (x==0&&y==0){
								black1 = true;
							}
							else if (x==7&&y==0){
								black2 = true;
							}
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
		else if (a > x && b == y){
			for (int i = 1; x + i < 8; i ++){
				if (x+i == a){
					for (int j = 1; x + j < 8; j ++){
						if (a != x+j){
							if (Board.d == 0 && !Board.ChessBoard[x+j][y].equals("   ")&&!Board.ChessBoard[x+j][y].equals("## ")){
								return false;
							}
							else if (Board.d == 1 && 
									!Board.ChessBoard[x+j][y].equals("   ")
									&&!Board.ChessBoard[x+j][y].equals("## ")){
								if (Board.ChessBoard[x+j][y].contains("wK")){
									if (Board.ChessBoard[x][y].contains("b")){
										continue;
									}
									else return false;
								}
								else if (Board.ChessBoard[x+j][y].contains("bK")){
									if (Board.ChessBoard[x][y].contains("w")){
										continue;
									}
									else return false;
								}
								else return false;
							}
						}
						else if (a == x+j){
							if (x==0&&y==0){
								black1 = true;
							}
							else if (x==0&&y==7){
								white1 = true;
							}
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
		else if (a < x && b == y){
			for (int i = 1; x - i > -1; i ++){
				if (x-i == a){
					for (int j = 1; x - j > -1; j ++){
						if (a != x-j){
							if (Board.d == 0 && !Board.ChessBoard[x-j][y].equals("   ")&&!Board.ChessBoard[x-j][y].equals("## ")){
								return false;
							}
							else if (Board.d == 1 && 
									!Board.ChessBoard[x-j][y].equals("   ")
									&&!Board.ChessBoard[x-j][y].equals("## ")){
								if (Board.ChessBoard[x-j][y].contains("wK")){
									if (Board.ChessBoard[x][y].contains("b")){
										continue;
									}
									else return false;
								}
								else if (Board.ChessBoard[x-j][y].contains("bK")){
									if (Board.ChessBoard[x][y].contains("w")){
										continue;
									}
									else return false;
								}
								else return false;
							}
						}
						else if (a == x-j){
							if (x==7&&y==0){
								black2 = true;
							}
							else if (x==7&&y==7){
								white2 = true;
							}
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
		else if (a == x && b < y){
			for (int i = 1; y - i > -1; i ++){
				if (y-i == b){
					for (int j = 1; y - j > -1; j ++){
						if (b != y-j){
							if (Board.d == 0 && !Board.ChessBoard[x][y-j].equals("   ")&&!Board.ChessBoard[x][y-j].equals("## ")){
								return false;
							}
							else if (Board.d == 1 && 
									!Board.ChessBoard[x][y-j].equals("   ")
									&&!Board.ChessBoard[x][y-j].equals("## ")){
								if (Board.ChessBoard[x][y-j].contains("wK")){
									if (Board.ChessBoard[x][y].contains("b")){
										continue;
									}
									else return false;
								}
								else if (Board.ChessBoard[x][y-j].contains("bK")){
									if (Board.ChessBoard[x][y].contains("w")){
										continue;
									}
									else return false;
								}
								else return false;
							}
						}
						else if (b == y-j){
							if (x==0&&y==7){
								white1 = true;
							}
							else if (x==7&&y==7){
								white2 = true;
							}
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
