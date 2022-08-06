package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private Board _board;
    private String _symbol;
    private Scanner scanner = new Scanner(System.in);

    public Player(Board board, String symbol) {
        _board = board;
        _symbol = symbol;
    }

    public void makeMove() {
        while (true) {
            try {
                var row = scanner.nextInt() - 1;
                var column = scanner.nextInt() - 1;

                if (_board.isCellOccupied(row, column)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                _board.markSymbolAt(_symbol, row, column);
                break;
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
    }
}
