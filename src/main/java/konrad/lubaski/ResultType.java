package konrad.lubaski;

public enum ResultType {

    TIE(true), WIN(true), NORMAL_MOVE(false);

    private boolean end;

    ResultType(boolean end) {
        this.end = end;
    }

    public boolean isEnd() {
        return end;
    }
}
