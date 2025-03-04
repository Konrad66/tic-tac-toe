package konrad.lubaski;

public abstract class Player {

    public abstract int[] generateMove(Board board);

    public abstract PlayerType getPlayerType();

    public Field getField() {
        return getPlayerType().getField();
    }
}
