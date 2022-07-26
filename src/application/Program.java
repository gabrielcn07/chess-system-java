package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println("\n");
				System.out.print("DIGITE A POSICAO DA PECA QUE DESEJA MOVER: ");
				ChessPosition source = UI.readChessPosition(scan);

				System.out.println();
				System.out.print("DIGITE A POSICAO EM QUE DESEJA COLOCAR A PECA: ");
				ChessPosition target = UI.readChessPosition(scan);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				scan.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				scan.nextLine();
			}
		}

	}

}
