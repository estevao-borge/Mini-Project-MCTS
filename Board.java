import java.util.*;

public class Board implements Ilayout{
	
	final private static int dim = 3;
	final private static int area = dim * dim;
	private boolean hasWinner = false;
	private boolean playerX = false;
	private boolean gameOver = false;
	private int winner = 0;
	String board[][];

	public Board(){
		board = new String[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				board[i][j] = "-";
			}
		}
	}

	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if(j != dim-1) {
					result.append(this.board[i][j]);
					result.append(" ");					
				}
				else
					result.append(this.board[i][j]);
			}
			result.append("\n");
		}
		return new String(result);
	}
	
	@Override
	public void play(int row, int col) {
		if(board[row][col] != "-" ) 
			throw new IllegalStateException("Invalid play. Position ocupied!");
		else {
			board[row][col] = playerX ? "X " : "O ";
			if(playerX == true) {
				playerX = false;
			} else 
				playerX = true;
		}
	}
	
	@Override
	public void isOver() {
		checkCols();
		checkRows();
		checkFirstDiagonal();
		checkSecondDiagonal();
	}
	
	@Override
	public void whoWins() {
		if(gameOver != true) throw new IllegalStateException("There is no winner!");
			if(playerX == true) winner = 1;
			else winner = 2;
			System.out.println(winner);
	}
	
	void checkCols() {
		for (int j = 0; j < dim; j++) {
			for (int i = 1; i < dim; i++) {
				if(board[i-1][j] == "- ") break;
				else {
					if (board[i][j] != (board[i-1][j])) break;
					if(i == dim-1) {
						gameOver = true;
						System.out.println("há uma coluna");
					}
				}
			}
		}	
	}
	
	void checkRows() {
		for (int i = 0; i < dim; i++) {
			for (int j = 1; j < dim; j++) {
				if(board[i][j-1] == "- ") break;
				else {
					if (board[i][j] != board[i][j-1]) break;
					if(j == dim-1) {
						gameOver = true;
						System.out.println("há uma linha");
					}
				}
			}	
		}
	}	
	
	void checkFirstDiagonal() {
		for (int i = 1; i < dim; i++) {
			for (int j = 1; j < dim; j++) {
				while(i == j && board[i][j] != "- ") {
					if(board[i][j] != board[i-1][j-1] ) break;
					if(i == dim-1 && j == dim-1) {
						gameOver = true;
						System.out.println("1- Há uma diagonal!");
						return;
					} else break;
				}
			}
		}
	}
	
	void checkSecondDiagonal() {
		int count = 0;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				while(i+j == 2) {
					if(( i == 2 && j == 0)) {
						if(count > 2) {
							gameOver = true;
							System.out.println("2- Há uma diagonal!");
							return;	
						}
						else return;
					} else {
						if(board[i][j] != board[i+1][j-1]) break;
						count++;
					}
				}
			}
		}
	}
	
	public Board clone() {
		Board copy = new Board();
		for (int i = 0; i < copy.area; i++) {
			copy.board[i] = this.board[i].clone();
		}
		copy.gameOver = this.gameOver;
		copy.hasWinner = this.hasWinner;
		copy.playerX = this.playerX;
		copy.winner = this.winner;
		return copy;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (!Arrays.deepEquals(board, other.board))
			return false;
		if (gameOver != other.gameOver)
			return false;
		if (hasWinner != other.hasWinner)
			return false;
		if (playerX != other.playerX)
			return false;
		if (winner != other.winner)
			return false;
		return true;
	}
	
//	public boolean equals(Board other) {
//		
//	}
	
	
}
