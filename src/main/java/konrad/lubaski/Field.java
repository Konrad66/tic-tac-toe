package konrad.lubaski;

public enum Field {

    X("X"), O("O"), EMPTY(" ");

    private String symbol;

    Field(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}