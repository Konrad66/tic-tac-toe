package konrad.lubaski;

public class Menu {

    private boolean running = true;

    void startProgram() {
        do {
            printMenu();
            int playerChoice = UserDialogs.readNumber();
            executeMenu(playerChoice);
        } while (running);
    }

    private void printMenu() {
        System.out.println("Welcome to Tic Tac Toe game. Choose one of the following options:");
        System.out.println("1. Tic Tac Toe");
        System.out.println("4. Exit");
    }

    private void executeMenu(int playerChoice) {
        switch (playerChoice) {
            case 1:
                play();
                break;
            case 4:
                running = false;
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    void play() {
        TicTacToe ticTacToe = new TicTacToe();
        System.out.println(getBoardView(ticTacToe.getBoardArray()));
        while (true) {
            MoveResults checkWinner = ticTacToe.move();
            if (checkWinner.getResultType() == ResultType.TIE) {
                System.out.println("It's tie!");
            } else if (checkWinner.getResultType() == ResultType.WIN) {
                System.out.println(checkWinner.getPlayerType() + " win!");
            }
            if (checkWinner.getResultType().isEnd()) return;
            System.out.println(getBoardView(ticTacToe.getBoardArray()));
        }
    }

    public String getBoardView(Field[][] boardArray) {
        StringBuilder boardView = new StringBuilder();
        boardView.append("   ");
        for (char letter = 'A'; letter < 'A' + boardArray[0].length; letter++) {
            boardView.append(" ").append(letter).append("  ");
        }
        boardView.append("\n");

        for (int y = 0; y < boardArray.length; y++) {
            boardView.append(y + 1).append(" ");

            for (int x = 0; x < boardArray[0].length; x++) {
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