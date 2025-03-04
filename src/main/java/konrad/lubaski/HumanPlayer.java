package konrad.lubaski;

public class HumanPlayer extends Player {

    @Override
    public int[] generateMove(Board board) {
        int x, y;
        do {
            String playerInput = UserDialogs.readText();
            y = Character.getNumericValue(playerInput.charAt(1)) - 1;
            x = playerInput.charAt(0) - 'a';
        } while (!board.isValidMove(x, y));
        return new int[]{x, y};
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.HUMAN;
    }
}
