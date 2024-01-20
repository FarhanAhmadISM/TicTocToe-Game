import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public void printGameBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print(".");
                } else {
                    System.out.print(board[i][j].playingPieceType);
                }
            }
            System.out.println();
        }
    }

    public List<String> getFreeCells() {
        List<String> freeCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    freeCells.add(i + "," + j);
                }
            }
        }
        return freeCells;
    }

    public boolean addPiece(int row, int col, Player player) {
        if(board[row][col] != null) {
            return false;
        }
        board[row][col] = player.piece;
        return true;
    }
}
