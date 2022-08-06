package tictactoe;

import java.util.Arrays;

public class Board {
    private final String[][] grid = new String[3][3];

    public Board(String symbols) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = String.valueOf(symbols.charAt(i * 3 + j));
            }
        }
    }

    public String toString() {
        var repr = "---------\n";

        for (int i = 0; i < 3; i++) {
            repr = repr.concat("| ");
            for (int j = 0; j < 3; j++) {
                repr = repr.concat(grid[i][j] + " ");
            }
            repr = repr.concat("|\n");
        }
        repr = repr.concat("---------");

        return repr;
    }

    public String getState() {
        if (isImpossible()) {
            return "Impossible";
        } else if (xWon()) {
            return "X wins";
        } else if (oWon()) {
            return "O wins";
        } else if (isDraw()) {
            return "Draw";
        }

        return "Game not finished";
    }

    private boolean isImpossible() {
        var xCount = 0;
        var oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].equals("X")) {
                    xCount++;
                } else if (grid[i][j].equals("O")) {
                    oCount++;
                }
            }
        }

        if (Math.abs(xCount - oCount) > 1) {
            return true;
        } else {
            return xWon() && oWon();
        }
    }

    private boolean isDraw() {
        var nEmptyCells = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].equals("_")) {
                    nEmptyCells++;
                }
            }
        }

        return nEmptyCells == 0;
    }

    private boolean oWon() {
        return playerWon("O");
    }

    private boolean xWon() {
        return playerWon("X");
    }

    private boolean playerWon(String player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (Arrays.stream(grid[i]).allMatch(symbol -> symbol.equals(player))) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (grid[0][i].equals(player) && grid[1][i].equals(player) && grid[2][i].equals(player)) {
                return true;
            }
        }

        // Check main diagonal
        if (grid[0][0].equals(player) && grid[1][1].equals(player) && grid[2][2].equals(player)) {
            return true;
        }

        // Check side diagonal
        if (grid[0][2].equals(player) && grid[1][1].equals(player) && grid[2][0].equals(player)) {
            return true;
        }

        return false;
    }

    public void markSymbolAt(String symbol, int row, int column) {
        grid[row][column] = symbol;
    }

    public boolean isCellOccupied(int row, int column) {
        return !grid[row][column].equals("_");
    }
}
