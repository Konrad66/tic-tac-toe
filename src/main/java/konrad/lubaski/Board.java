package konrad.lubaski;

public class Board {

    final static int HEIGHT = 3;
    final static int WIDTH = 3;
    private Field[][] boardArray;

    public Board() {
        boardArray = new Field[HEIGHT][WIDTH];
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                boardArray[y][x] = Field.EMPTY;
            }
        }
    }

    public void doMove(int[] move, Player player) {
        boardArray[move[1]][move[0]] = player.getField();
    }

    public boolean isBoardFull() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (boardArray[y][x] == Field.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(Field playerSymbol) {
        for (int i = 0; i < WIDTH; i++) {
            if (boardArray[i][0] == playerSymbol && boardArray[i][1] == playerSymbol && boardArray[i][2] == playerSymbol) {
                return true;
            }
        }

        for (int i = 0; i < HEIGHT; i++) {
            if (boardArray[0][i] == playerSymbol && boardArray[1][i] == playerSymbol && boardArray[2][i] == playerSymbol) {
                return true;
            }
        }

        if (boardArray[0][0] == playerSymbol && boardArray[1][1] == playerSymbol && boardArray[2][2] == playerSymbol) {
            return true;
        }

        if (boardArray[0][2] == playerSymbol && boardArray[1][1] == playerSymbol && boardArray[2][0] == playerSymbol) {
            return true;
        }

        return false;
    }

    public boolean isInValidMove(int x, int y) {
        return x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT || !isFieldFree(x, y);
    }

    public boolean isFieldFree(int x, int y) {
        return boardArray[y][x] == Field.EMPTY;
    }

    @Override
    public String toString() {
        StringBuilder boardView = new StringBuilder();
        boardView.append("   ");
        for (char letter = 'A'; letter < 'A' + WIDTH; letter++) {
            boardView.append(" ").append(letter).append("  ");
        }
        boardView.append("\n");

        for (int y = 0; y < HEIGHT; y++) {
            boardView.append(y + 1).append(" ");

            for (int x = 0; x < WIDTH; x++) {
                boardView.append("| ");

                if (boardArray[y][x] == Field.X) {
                    boardView.append("X ");
                } else if (boardArray[y][x] == Field.O) {
                    boardView.append("O ");
                } else {
                    boardView.append("  ");
                }
            }
            boardView.append("|\n");
        }
        return boardView.toString();
    }
}