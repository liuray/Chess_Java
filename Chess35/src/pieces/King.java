package pieces;

import chess.Board;

/**
 *  The method of King
 * @author Jiwei Chen
 * @author Pengrui Liu
 *
 */

public class King extends Piece {
	static boolean black, white;

	/**
	 * To check King has correct move or not, and also check the king is check by other pieces or not.
	 * 
	 * @param x  Row coordinate of start position.
	 * @param y  Column coordinate of start position.
	 * @param a	 Row coordinate of end position.
	 * @param b	 Column coordinate of end position.
	 * @return	if Kind can move return true
	 */
	public static boolean move(int x, int y, int a, int b) {
		if (Board.ChessBoard[a][b].charAt(0) == Board.ChessBoard[x][y].charAt(0)) {
			return false;
		}
		if (Math.abs(b - y) <= 1 && a == x) {
			if (Board.ChessBoard[x][y].equals("wK ")) {

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (Board.ChessBoard[i][j].contains("b")) {
							if (Board.ChessBoard[i][j].charAt(1) == 'P') {
								if (Pawn.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'Q') {
								if (Queen.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'R') {
								if (Rook.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");

									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'K') {
								if (King.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
							else if (Board.ChessBoard[i][j].charAt(1) == 'B') {
								if (Bishop.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
						}
					}
				}
			} else if (Board.ChessBoard[x][y].equals("bK ")) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (Board.ChessBoard[i][j].contains("w")) {
							if (Board.ChessBoard[i][j].charAt(1) == 'P') {
								if (Pawn.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'Q') {
								if (Queen.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'R') {
								if (Rook.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'K') {
								if (King.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
							else if (Board.ChessBoard[i][j].charAt(1) == 'B') {
								if (Bishop.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
						}
					}
				}
			}
			if (y == 0 && x == 4) {
				black = true;
			} else if (y == 7 && x == 4) {
				white = true;
			}
			LastMov.temp1 = x;
			LastMov.temp2 = y;
			LastMov.temp3 = a;
			LastMov.temp4 = b;
			LastMov.info = Board.ChessBoard[x][y];
			return true;
		}
		else if (y == b && Math.abs(a - x) <= 1) {
			if (Board.ChessBoard[x][y].equals("wK ")) {

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (Board.ChessBoard[i][j].contains("b")) {
							if (Board.ChessBoard[i][j].charAt(1) == 'P') {
								if (Pawn.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'Q') {
								if (Queen.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'R') {
								if (Rook.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");

									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'K') {
								if (King.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
							else if (Board.ChessBoard[i][j].charAt(1) == 'B') {
								if (Bishop.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
						}
					}
				}
			} else if (Board.ChessBoard[x][y].equals("bK ")) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (Board.ChessBoard[i][j].contains("w")) {
							if (Board.ChessBoard[i][j].charAt(1) == 'P') {
								if (Pawn.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'Q') {
								if (Queen.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'R') {
								if (Rook.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'K') {
								if (King.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
							else if (Board.ChessBoard[i][j].charAt(1) == 'B') {
								if (Bishop.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
						}
					}
				}
			}
			if (y == 0 && x == 4) {
				black = true;
			} else if (y == 7 && x == 4) {
				white = true;
			}
			LastMov.temp1 = x;
			LastMov.temp2 = y;
			LastMov.temp3 = a;
			LastMov.temp4 = b;
			LastMov.info = Board.ChessBoard[x][y];
			return true;
		}
		
		else if (Math.abs(b - y) <= 1 && Math.abs(a - x) <= 1) {
			if (Board.ChessBoard[x][y].equals("wK ")) {

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (Board.ChessBoard[i][j].contains("b")) {
							if (Board.ChessBoard[i][j].charAt(1) == 'P') {
								if (Pawn.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'Q') {
								if (Queen.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'R') {
								if (Rook.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");

									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'K') {
								if (King.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
							else if (Board.ChessBoard[i][j].charAt(1) == 'B') {
								if (Bishop.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
						}
					}
				}
			} else if (Board.ChessBoard[x][y].equals("bK ")) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (Board.ChessBoard[i][j].contains("w")) {
							if (Board.ChessBoard[i][j].charAt(1) == 'P') {
								if (Pawn.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'Q') {
								if (Queen.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'R') {
								if (Rook.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'N') {
								if (Knight.move(i, j, a, b)) {
									//System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							} else if (Board.ChessBoard[i][j].charAt(1) == 'K') {
								if (King.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
							else if (Board.ChessBoard[i][j].charAt(1) == 'B') {
								if (Bishop.move(i, j, a, b)) {
								//	System.out.println("Illegal move, try again.");
									return false;
								} else
									continue;
							}
						}
					}
				}
			}
			if (y == 0 && x == 4) {
				black = true;
			} else if (y == 7 && x == 4) {
				white = true;
			}
			LastMov.temp1 = x;
			LastMov.temp2 = y;
			LastMov.temp3 = a;
			LastMov.temp4 = b;
			LastMov.info = Board.ChessBoard[x][y];
			return true;
		} else if (x == a && Math.abs(b - y) == 2) {
			if (Board.ChessBoard[x][y].equals("bK ")) {
				if (black == true) {
					return false;
				}
				if (b > y) {
					if (Rook.black2 == true) {
						return false;
					}
					for (int i = 1; i < 3; i++) {
						if (!Board.ChessBoard[x][y + i].equals("   ") && !Board.ChessBoard[x][y + i].equals("## ")) {
							return false;
						}
					}
					black = true;
					LastMov.temp1 = x;
					LastMov.temp2 = y;
					LastMov.temp3 = a;
					LastMov.temp4 = b;
					LastMov.info = Board.ChessBoard[x][y];
					return true;
				} else if (b < y) {
					if (Rook.black1 == true) {
						return false;
					}
					for (int i = 1; i < 4; i++) {
						if (!Board.ChessBoard[x][y - i].equals("   ") && !Board.ChessBoard[x][y - i].equals("## ")) {
							return false;
						}
					}
					black = true;
					LastMov.temp1 = x;
					LastMov.temp2 = y;
					LastMov.temp3 = a;
					LastMov.temp4 = b;
					LastMov.info = Board.ChessBoard[x][y];
					return true;
				}
			} else if (Board.ChessBoard[x][y].equals("wK ")) {
				if (white == true) {
					return false;
				}
				if (y < b) {
					if (Rook.white2 == true) {
						return false;
					}
					for (int i = 1; i < 3; i++) {
						if (!Board.ChessBoard[x][y + i].equals("   ") && !Board.ChessBoard[x][y + i].equals("## ")) {
							return false;
						}
					}
					white = true;
					LastMov.temp1 = x;
					LastMov.temp2 = y;
					LastMov.temp3 = a;
					LastMov.temp4 = b;
					LastMov.info = Board.ChessBoard[x][y];
					return true;
				} else if (b < y) {
					if (Rook.white1 == true) {
						return false;
					}
					for (int i = 1; i < 4; i++) {
						if (!Board.ChessBoard[x][y - i].equals("   ") && !Board.ChessBoard[x][y - i].equals("## ")) {
							return false;
						}
					}
					white = true;
					LastMov.temp1 = x;
					LastMov.temp2 = y;
					LastMov.temp3 = a;
					LastMov.temp4 = b;
					LastMov.info = Board.ChessBoard[x][y];
					return true;
				}
			}
		}
		return false;

	}

}
