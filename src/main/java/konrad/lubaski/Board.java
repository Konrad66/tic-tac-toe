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

    public void doMove(int[] move, Field field) {
        boardArray[move[1]][move[0]] = field;
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
        if (checkWinRow(playerSymbol)) return true;
        if (checkWinColumn(playerSymbol)) return true;

        if (boardArray[0][0] == playerSymbol && boardArray[1][1] == playerSymbol && boardArray[2][2] == playerSymbol) {
            return true;
        }

        if (boardArray[0][2] == playerSymbol && boardArray[1][1] == playerSymbol && boardArray[2][0] == playerSymbol) {
            return true;
        }

        return false;
    }

    private boolean checkWinRow(Field playerSymbol) {
        for (int y = 0; y < HEIGHT; y++) {
            boolean rowWin = true;
            for (int x = 0; x < WIDTH; x++) {
                if (boardArray[y][x] != playerSymbol) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) return true;
        }
        return false;
    }

    private boolean checkWinColumn(Field playerSymbol) {
        for (int x = 0; x < WIDTH; x++) {
            boolean columnWin = true;
            for (int y = 0; y < HEIGHT; y++) {
                if (boardArray[y][x] != playerSymbol) {
                    columnWin = false;
                    break;
                }
            }
            if (columnWin) return true;
        }
        return false;
    }

    public boolean isInvalidMove(int x, int y) {
        return x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT || !isFieldFree(x, y);
    }

    public boolean isFieldFree(int x, int y) {
        return boardArray[y][x] == Field.EMPTY;
    }

    public Field[][] getBoardArray() {
        return boardArray;
    }
}