package konrad.lubaski;

import java.util.Random;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        start();
    }

    final static int COMPUTER_SYMBOL = 2;
    final static int height = 3;
    final static int width = 3;
    final static int[][] boardArray = new int[3][3];
    final static Scanner scanner = new Scanner(System.in);
    static int currentPlayer = 1;


    public static void start() {
        System.out.println(composeBoard(boardArray));
        while (true) {
            if (currentPlayer == 1) {
                String playerMove;
                do {
                    playerMove = scanner.nextLine().toLowerCase();
                } while (!isCorrectMove(playerMove));
                executeMove(playerMove, 1);
            } else {
                computerMove(2);
            }
            //todo drukowanie planszy
            if (isEndOfGame()) {
                break;
            }
            switchPlayer();
        }
    }

    public static String composeBoard(int[][] board) {
        StringBuilder boardView = new StringBuilder();
        boardView.append("   ");
        for (char letter = 'A'; letter < 'A' + width; letter++) {
            boardView.append(" ").append(letter).append("  ");
        }
        boardView.append("\n");

        for (int x = 0; x < height; x++) {
            boardView.append(x + 1).append(" ");

            for (int y = 0; y < width; y++) {
                boardView.append("| ");

                if (board[x][y] == 1) {
                    boardView.append("X ");
                } else if (board[x][y] == 2) {
                    boardView.append("O ");
                } else {
                    boardView.append("  ");
                }
            }
            boardView.append("|\n");
        }
        return boardView.toString();
    }

    public static int[] readCoords(String playerMove) {
        int row = Character.getNumericValue(playerMove.charAt(1)) - 1;
        int col = playerMove.charAt(0) - 'a';
        System.out.println(row);
        System.out.println(col);
        return new int[]{row, col};
    }

    public static boolean isCorrectMove(String input) {
        if (!(input.charAt(0) >= 'a' && input.charAt(0) <= 'c' && input.charAt(1) >= '1' && input.charAt(1) <= '3')) {
            System.out.println("Invalid input. Please enter a letter between a-c and number between 1-3");
            return false;
        }

        if (!isFieldFree(input.charAt(0) - 'a', Character.getNumericValue(input.charAt(1)) - 1)) {
            System.out.println("Field is occupied, choose another one");
            return false;
        }
        return true;
    }

    public static boolean isFieldFree(int row, int col) {
        return boardArray[row][col] == 0;
    }

    public static void executeMove(String playerMove, int playerSymbol) {
        int[] coords = readCoords(playerMove);
        boardArray[coords[0]][coords[1]] = playerSymbol;
        System.out.println(composeBoard(boardArray));
    }

    public static boolean isEndOfGame() {
        return isBoardFull();
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (boardArray[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void checkWinner() {

    }

    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    public static void computerMove(int playerSymbol) {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isFieldFree(row, col));
        boardArray[row][col] = playerSymbol;
        System.out.println(composeBoard(boardArray));
    }

    private static boolean checkLine(Field playerSymbol, boolean rowWin) {
//        for (int i = 0; i < HEIGHT; i++) {
//            boolean lineWin = true;
//            for (int j = 0; j < WIDTH; j++) {
//                int x = rowWin ? j : i;
//                int y = rowWin ? i : j;
//                if (boardArray[y][x] != playerSymbol) {
//                    lineWin = true;
//                    break;
//                }
//            }
//            if (lineWin) return true;
//        }
        return false;
    }
}
