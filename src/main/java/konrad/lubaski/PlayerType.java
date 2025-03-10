package konrad.lubaski;

public enum PlayerType {

    HUMAN(Field.X), COMPUTER(Field.O);

    private Field field;

    PlayerType(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }
}