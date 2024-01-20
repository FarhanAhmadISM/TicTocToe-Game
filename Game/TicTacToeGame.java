import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public Deque<Player> players = new ArrayDeque<>();
    public Board gameBoard;

    public TicTacToeGame(Player firstPlayer, Player secondPlayer, Board board) {
        this.players.addFirst(firstPlayer);
        this.players.addLast(secondPlayer);
        this.gameBoard = board;
    }

    public String StartGame() {
        boolean gameIsOn = true;
        while (gameIsOn) {
            gameBoard.printGameBoard();
            List<String> freeCells = gameBoard.getFreeCells();
            if (freeCells.isEmpty()) {
                gameIsOn = false;
                continue;
            }

            Player currentPlayer = players.removeFirst();
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();

            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            boolean addedPiece = gameBoard.addPiece(inputRow, inputColumn, currentPlayer);
            if (!addedPiece) {
                players.addFirst(currentPlayer);
                System.out.println("Already filled position, please try again !");
                continue;
            }
            players.addLast(currentPlayer);
            boolean winner = isThereAWinner(inputRow, inputColumn, currentPlayer.piece);
            if (winner) {
                return currentPlayer.name;
            }
        }
        return "None of them, match Tied!";
    }

    private boolean isThereAWinner(int row, int col, PlayingPiece piece) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][col] == null || gameBoard.board[i][col] != piece) {
                columnMatch = false;
                break;
            }
        }

        for (int j = 0; j < gameBoard.size; j++) {
            if (gameBoard.board[row][j] == null || gameBoard.board[row][j] != piece) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0, j = 0; i < gameBoard.size && j < gameBoard.size; i++, j++) {
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j] != piece) {
                diagonalMatch = false;
                break;
            }
        }

        for (int i = 0, j = gameBoard.size - 1 ; i < gameBoard.size && j >= 0; i++, j--) {
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j] != piece) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
