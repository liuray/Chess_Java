package chess;

import java.util.List;
import java.util.Scanner;
import pieces.*;;

/**
 * In this class can print chess board, resetChessBoard, IdentityPieces,Promotion and Castling.
 * @author Pengrui Liu
 * @author Jiwei Chen
 *
 */
public class Board {
	/**
	 * if variable q = 0 , return.
	 */
	public static int q = 0;
	/**
	 * if variable d = 0 , return.
	 */
	public static int d = 0;
	/**
	 * To remember and update white Kind row position
	 */
	private static int whitePos1 = 7;
	/**
	 * To remember and update white Kind column position
	 */
	private static int whitePos2 = 4;
	/**
	 * To remember and update black Kind row position
	 */
	private static int blackPos1 = 0;
	/**
	 * To remember and update black Kind column position
	 */
	private static int blackPos2 = 4;
	/**
	 * The white color of the chess board
	 */
	private final static String tem = "   ";
	/**
	 * Using 2-D array to draw a Chess Board
	 */
	public static final String ChessBoard[][] = { 
			{ "bR ", "bN ", "bB ", "bQ ", "bK ", "bB ", "bN ", "bR ", " 8" },
			{ "bP ", "bP ", "bP ", "bP ", "bP ", "bP ", "bP ", "bP ", " 7" },
			{ "   ", "## ", "   ", "## ", "   ", "## ", "   ", "## ", " 6" },
			{ "## ", "   ", "## ", "   ", "## ", "   ", "## ", "   ", " 5" },
			{ "   ", "## ", "   ", "## ", "   ", "## ", "   ", "## ", " 4" },
			{ "## ", "   ", "## ", "   ", "## ", "   ", "## ", "   ", " 3" },
			{ "wP ", "wP ", "wP ", "wP ", "wP ", "wP ", "wP ", "wP ", " 2" },
			{ "wR ", "wN ", "wB ", "wQ ", "wK ", "wB ", "wN ", "wR ", " 1" },
			{ " a", "  b", "  c", "  d", "  e", "  f", "  g", "  h", "" }, };



	/**
	 * To check chess board's black color ("## ") coordinate. If find black
	 * color coordinate become white color, use this method check white color to
	 * black
	 */
	public static void resetChessBoard() {
		int row = 0;
		int col = 0;
		int count = 0;
		for (row = 0; row <= 7; row++) {
			// check it is even or add row
			if (count % 2 == 0) {
				for (col = 1; col <= 7; col = col + 2) {
					if (ChessBoard[row][col] == "   ") {
						ChessBoard[row][col] = "## ";
					} else {
						continue;
					}
				}
			} else if (count % 2 != 0) {
				for (col = 0; col <= 7; col = col + 2) {
					if (ChessBoard[row][col] == "   ") {
						ChessBoard[row][col] = "## ";
					} else {
						continue;
					}
				}
			}
			count++;
		}
	}

	/**
	 * To check which pieces of chess are you move, and at same time to call the
	 * different pieces method dependent which pieces are you moved. In this
	 * method also include the Illegal move, check and which sides player win
	 * this game.
	 */
	public static void identityPieces() {
		List<Integer> list = Chess.positions;

		int y = list.get(0);
		int x = list.get(1);
		int b = list.get(2);
		int a = list.get(3);

		String sData = ChessBoard[x][y];
		String eData = ChessBoard[a][b];
		char piece = sData.charAt(1);

		if (piece == 'P') {

			if (Pawn.move(x, y, a, b) == true) {
				// Enpassant(x, y, a, b);
				promotion(x, y, a, b);
				Board.ChessBoard[a][b] = Board.ChessBoard[x][y];
				Board.ChessBoard[x][y] = tem;
				if (Board.ChessBoard[a][b].contains("w")) {
					if (Pawn.move(a, b, blackPos1, blackPos2)) {
						d = 1;
						if (isCheckMated(blackPos1, blackPos2)) {
							q = 1;
							Chess.print();
							System.out.println("White wins");
							
							return;
						}
						d = 0;
						System.out.println("Checkkkkk!\n");
					}
				} else {
					if (Pawn.move(a, b, whitePos1, whitePos2)) {
						d = 1;
						if (isCheckMated(whitePos1, whitePos2)) {
							q = 1;
							Chess.print();
							System.out.println("Black wins");
							
							return;
						}
						d = 0;
						System.out.println("Checkkkkk!\n");
					}
				}

			} else {
				System.out.println("Illegal move, try again.");
				Chess.moves--;
			}
		} else if (piece == 'N') {
			if (pieces.Knight.move(x, y, a, b) == true) {
				Board.ChessBoard[a][b] = Board.ChessBoard[x][y];
				Board.ChessBoard[x][y] = tem;
				if (Board.ChessBoard[a][b].contains("w")) {
					if (Knight.move(a, b, blackPos1, blackPos2)) {
						d = 1;
						if (isCheckMated(blackPos1, blackPos2)) {
							q = 1;
							Chess.print();
							System.out.println("White wins");
							
							return;
						}
						d = 0;
						System.out.println("Checkkkkk!\n");
					}
				} else {
					if (Knight.move(a, b, whitePos1, whitePos2)) {
						d = 1;
						if (isCheckMated(whitePos1, whitePos2)) {
							q = 1;
							Chess.print();
							System.out.println("Black wins");
							
							return;
						}
						d = 0;
						System.out.println("Checkkkkk!\n");
					}
				}
			} else {
				System.out.println("Illegal move, try again.");
				Chess.moves--;
			}
		} else if (piece == 'B') {
			if (pieces.Bishop.move(x, y, a, b) == true) {
				Board.ChessBoard[a][b] = Board.ChessBoard[x][y];
				Board.ChessBoard[x][y] = tem;
				if (Board.ChessBoard[a][b].contains("w")) {
					if (Bishop.move(a, b, blackPos1, blackPos2)) {
						d = 1;
						if (isCheckMated(blackPos1, blackPos2)) {
							q = 1;
							Chess.print();
							System.out.println("White wins");
							
							return;
						}
						d = 0;
						System.out.println("Checkkkkk!\n");
					}
				} else {
					if (Bishop.move(a, b, whitePos1, whitePos2)) {
						d = 1;
						if (isCheckMated(whitePos1, whitePos2)) {
							q = 1;
							Chess.print();
							System.out.println("Black wins");
							
							return;
						}
						d = 0;
						System.out.println("Checkkkkk!\n");
					}
				}
			} else {
				System.out.println("Illegal move, try again.");
				Chess.moves--;
			}
		} else if (piece == 'Q') {
			if (pieces.Queen.move(x, y, a, b) == true) {
				Board.ChessBoard[a][b] = Board.ChessBoard[x][y];
				Board.ChessBoard[x][y] = tem;
				if (Board.ChessBoard[a][b].contains("w")) {
					if (Queen.move(a, b, blackPos1, blackPos2)) {
						d = 1;
						if (isCheckMated(blackPos1, blackPos2)) {
							q = 1;
							Chess.print();
							System.out.println("White wins");
							
							return;
						}
						d = 0;
						System.out.println("Checkkkkk!\n");
					}
				} else {
					if (Queen.move(a, b, whitePos1, whitePos2)) {
						d = 1;
						if (isCheckMated(whitePos1, whitePos2)) {
							q = 1;
							Chess.print();
							System.out.println("Black wins");
							
							return;
						}
						d = 0;
						System.out.println("Checkkkkk!");
					}
				}
			} else {
				System.out.println("Illegal move, try again.");
				Chess.moves--;
			}
		} else if (piece == 'K') {
			if (pieces.King.move(x, y, a, b) == true) {
				Castling(x, y, a, b);
				if (Board.ChessBoard[a][b].equals("wK ")) {
					whitePos1 = a;
					whitePos2 = b;
				} else {
					blackPos1 = a;
					blackPos2 = b;
				}
			} else {
				System.out.println("Illegal move, try again.");
				Chess.moves--;
			}
		} else if (piece == 'R') {
			if (pieces.Rook.move(x, y, a, b)) {
				Board.ChessBoard[a][b] = Board.ChessBoard[x][y];
				Board.ChessBoard[x][y] = tem;
				if (Board.ChessBoard[a][b].contains("w")) {
					if (Rook.move(a, b, blackPos1, blackPos2)) {
						d = 1;
						if (isCheckMated(blackPos1, blackPos2)) {
							q = 1;
							Chess.print();
							System.out.println("White wins");
							
							return;
						}
						d = 0;
						System.out.println("Checkkkkk!\n");
					}
				} else {
					if (Rook.move(a, b, whitePos1, whitePos2)) {
						d = 1;
						if (isCheckMated(whitePos1, whitePos2)) {
							q = 1;
							Chess.print();
							System.out.println("Black wins");
							
							return;
						}
						d = 0;
						System.out.println("Checkkkkk!\n");
					}
				}
			} else {
				System.out.println("Illegal move, try again.");
				Chess.moves--;
			}
		}
	}

	/**
	 * Identification of check-mate
	 * 
	 * @param x
	 *            Row coordinate of start position.
	 * @param y
	 *            Column coordinate of start position
	 * @return 	If check-mate return .
	 */
	private static boolean isCheckMated(int x, int y) {
		if (x == 7 && y == 0) {
			if (!King.move(x, y, x, y + 1) && !King.move(x, y, x - 1, y + 1) && !King.move(x, y, x - 1, y)) {
				return true;
			} else
				return false;
		} else if (x == 7 && y == 7) {
			if (!King.move(x, y, x, y - 1) && !King.move(x, y, x - 1, y - 1) && !King.move(x, y, x - 1, y)) {
				return true;
			} else
				return false;
		} else if (x == 0 && y == 7) {
			if (!King.move(x, y, x, y - 1) && !King.move(x, y, x + 1, y - 1) && !King.move(x, y, x + 1, y)) {
				return true;
			} else
				return false;
		} else if (x == 0 && y == 0) {
			if (!King.move(x, y, x, y + 1) && !King.move(x, y, x + 1, y + 1) && !King.move(x, y, x + 1, y)) {
				return true;
			} else
				return false;
		} else if (y == 0) {
			if (!King.move(x, y, x, y + 1) && !King.move(x, y, x + 1, y + 1) && !King.move(x, y, x + 1, y)
					&& !King.move(x, y, x - 1, y + 1) && !King.move(x, y, x - 1, y)) {
				return true;
			} else
				return false;
		} else if (y == 7) {
			if (!King.move(x, y, x, y - 1) && !King.move(x, y, x - 1, y - 1) && !King.move(x, y, x - 1, y)
					&& !King.move(x, y, x + 1, y - 1) && !King.move(x, y, x + 1, y)) {
				return true;
			} else
				return false;
		} else if (x == 0) {
			if (y == 4) {
				if (!King.move(x, y, x, y - 2) && !King.move(x, y, x, y + 2)) {
					return true;
				} else
					return false;
			}
			if (!King.move(x, y, x, y - 1) && !King.move(x, y, x + 1, y - 1) && !King.move(x, y, x + 1, y + 1)
					&& !King.move(x, y, x, y + 1) && !King.move(x, y, x + 1, y)) {
				return true;
			} else
				return false;
		} else if (x == 7) {
			if (y == 4) {
				if (!King.move(x, y, x, y - 2) && !King.move(x, y, x, y + 2)) {
					return true;
				} else
					return false;
			}
			if (!King.move(x, y, x, y - 1) && !King.move(x, y, x - 1, y + 1) && !King.move(x, y, x - 1, y - 1)
					&& !King.move(x, y, x, y + 1) && !King.move(x, y, x - 1, y)) {
				return true;
			} else
				return false;
		} else {
			if (!King.move(x, y, x, y - 1) && !King.move(x, y, x - 1, y + 1) && !King.move(x, y, x - 1, y - 1)
					&& !King.move(x, y, x, y + 1) && King.move(x, y, x - 1, y) && !King.move(x, y, x + 1, y - 1)
					&& !King.move(x, y, x + 1, y + 1) && !King.move(x, y, x + 1, y)) {
				return true;
			} else
				return false;
		}
	}

	/**
	 * Identification of Pawn Promotion,if pawn reach other side immediately changed into the player's choice of a queen, 
	 * knight, rook, or bishop of the same color
	 * 
	 * @param x  Row coordinate of start position.
	 * @param y  Column coordinate of start position.
	 * @param a	 Row coordinate of end position.
	 * @param b	 Column coordinate of end position.
	 */
	// Pawn Promotion

	private static void promotion(int x, int y, int a, int b) {
		String p = ChessBoard[x][y];
		int num = 0;
		// check pawn reach the top or bottom row
		if (a == 7 || a == 0) {
			do {
				System.out.println("Pawn Promtion!! Which Pieces Do You Want Change:  ");
				System.out.println("1.Queen\n" + "2.Rook\n" + "3.Bishop\n" + "4.Knight");
				Scanner sc = new Scanner(System.in);
				num = sc.nextInt();
			} while (num > 4 || num < 1);
		}

		if (p.charAt(0) == 'w') {
			if (num == 1) {
				ChessBoard[x][y] = "wQ ";
				pieces.Queen.move(x, y, a, b);
			} else if (num == 2) {
				ChessBoard[x][y] = "wR ";
				pieces.Rook.move(x, y, a, b);
			} else if (num == 3) {
				ChessBoard[x][y] = "wB ";
				pieces.Bishop.move(x, y, a, b);
			} else if (num == 4) {
				ChessBoard[x][y] = "wN ";
				pieces.Knight.move(x, y, a, b);
			}

		}
		// to check color
		if (p.charAt(0) == 'b') {
			if (num == 1) {
				ChessBoard[x][y] = "bQ ";
				pieces.Queen.move(x, y, a, b);
			} else if (num == 2) {
				ChessBoard[x][y] = "bR ";
				pieces.Rook.move(x, y, a, b);
			} else if (num == 3) {
				ChessBoard[x][y] = "bB ";
				pieces.Bishop.move(x, y, a, b);
			} else if (num == 4) {
				ChessBoard[x][y] = "bN ";
				pieces.Knight.move(x, y, a, b);
			}

		}
	}


	/**
	 * Identification of Castling. If the king and the chosen rook are on the player's first rank,
	 * neither the king nor the chosen rook has previously moved, and there are no pieces between the king and the chosen rook.
	 * The king allow move to right or left two steps, if king move to right side, the rock should be the left of the king.or
	 * king move to left side, the rock should be the right of the king.
	 * @param x  Row coordinate of start position.
	 * @param y  Column coordinate of start position.
	 * @param a	 Row coordinate of end position.
	 * @param b	 Column coordinate of end position.
	 */
	private static void Castling(int x, int y, int a, int b) {

		if (Board.ChessBoard[x][y].charAt(0) == 'w') {
			if (y - b == 2) {

				ChessBoard[a][b] = ChessBoard[x][y];
				ChessBoard[x][y] = tem;
				ChessBoard[a][b + 1] = ChessBoard[7][0];
				ChessBoard[7][0] = tem;
				whitePos1 = a;
				whitePos2 = b;
			} else if (b - y == 2) {

				ChessBoard[a][b] = ChessBoard[x][y];
				ChessBoard[x][y] = tem;
				ChessBoard[a][b - 1] = ChessBoard[7][7];
				ChessBoard[7][7] = tem;
				whitePos1 = a;
				whitePos2 = b;
			} else {
				ChessBoard[a][b] = ChessBoard[x][y];
				ChessBoard[x][y] = tem;
				whitePos1 = a;
				whitePos2 = b;
			}
		}
		if (Board.ChessBoard[x][y].charAt(0) == 'b') {

			if (y - b == 2) {

				ChessBoard[a][b] = ChessBoard[x][y];
				ChessBoard[x][y] = tem;
				ChessBoard[a][b + 1] = ChessBoard[0][0];
				ChessBoard[0][0] = tem;
				blackPos1 = a;
				blackPos2 = b;
			} else if (b - y == 2) {

				ChessBoard[a][b] = ChessBoard[x][y];
				ChessBoard[x][y] = tem;
				ChessBoard[a][b - 1] = ChessBoard[0][7];
				ChessBoard[0][7] = tem;
				blackPos1 = a;
				blackPos2 = b;
			} else {
				ChessBoard[a][b] = ChessBoard[x][y];
				ChessBoard[x][y] = tem;
				blackPos1 = a;
				blackPos2 = b;
			}
		}
	}

}