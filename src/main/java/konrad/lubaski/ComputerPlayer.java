package konrad.lubaski;

import java.util.Random;

public class ComputerPlayer extends Player {

    @Override
    public int[] generateMove(Board board) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!board.isValidMove(x, y));
        return new int[]{x, y};
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.COMPUTER;
    }
}