package chess;

import boardgame.Position;

public class ChessPosition {

	private int row;
	private char column;

	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Jogada de posicao invalida, sao aceitos de A1 a H8");
		}
		this.row = row;
		this.column = column;
	}
	
	protected Position toPositon() {
		return new Position((column - 'a'), (8 - row));
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}

	public int getRow() {
		return row;
	}

	public char getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "" + column + row;
	}
	
}
