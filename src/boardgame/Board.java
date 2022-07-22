package boardgame;

public class Board {

	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;

	public Board(Integer columns, Integer rows) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Tabuleiro de tamanho invalido!");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public Piece piece(int column, int row) {
		if (!positionExists(row, column)) {
			throw new BoardException("Esta posição não existe no tabuleiro!");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Esta posição não existe no tabuleiro!");
		}
		return pieces[position.getColumn()][position.getRow()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Jogada invalida, esta posição ja esta ocupada por uma peça");
		}
		pieces[position.getColumn()][position.getRow()] = piece;
		piece.position = position;
	}

	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Esta posição não existe no tabuleiro!");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getColumn()][position.getRow()] = null;
		return aux;
	}

	private boolean positionExists(int column, int row) {
		return row >= 0 && row <= rows && column >= 0 && column <= columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getColumn(), position.getRow());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Esta posição não existe no tabuleiro!");
		}
		return piece(position) != null;
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

}
