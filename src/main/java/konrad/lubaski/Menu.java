package konrad.lubaski;

public class Menu {

    private boolean running = true;
    private TicTacToe ticTacToe = new TicTacToe();

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
                ticTacToe.play();
            case 4:
                running = false;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
}