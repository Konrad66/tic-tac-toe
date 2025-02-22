package konrad.lubaski;

public class Board {

    final static int height = 3;
    final static int width = 3;

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        board.append("   ");
        for (char letter = 'A'; letter < 'A' + width; letter++) {
            board.append(" ").append(letter).append("  ");
        }
        board.append("\n");

        for (int x = 0; x < height; x++) {
            board.append(x + 1).append(" ");

            for (int y = 0; y < width; y++) {
                board.append("|   ");
            }
            board.append("|\n");
        }
        return board.toString();
    }
}