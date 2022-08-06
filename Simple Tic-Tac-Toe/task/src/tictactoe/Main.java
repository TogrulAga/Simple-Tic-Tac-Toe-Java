package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board("_________");
        Player player1 = new Player(board, "X");
        Player player2 = new Player(board, "O");

        System.out.println(board);

        var round = 0;
        while (board.getState().equals("Game not finished")) {
            if (round % 2 == 0) {
                player1.makeMove();
            } else {
                player2.makeMove();
            }

            System.out.println(board);

            round++;
        }

        System.out.println(board.getState());
    }
}


