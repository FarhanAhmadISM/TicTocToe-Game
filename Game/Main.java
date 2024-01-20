import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayingPieceX pieceX = new PlayingPieceX();
        PlayingPieceO pieceO = new PlayingPieceO();

        System.out.println("What is your name playerX ?");
        Scanner inputA = new Scanner(System.in);
        String playerA = inputA.nextLine();

        Player playerX = new Player(playerA, pieceX);

        System.out.println("What is your name playerO ?");
        Scanner inputB = new Scanner(System.in);
        String playerB = inputB.nextLine();

        Player playerO = new Player(playerB, pieceO);

        System.out.println("Enter the size of board");
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt(input.nextLine());
        Board gameBoard = new Board(size);

        TicTacToeGame game = new TicTacToeGame(playerX, playerO, gameBoard);
        String winnerName = game.StartGame();
        System.out.println("Game winner is: " + winnerName);
    }
}