package konrad.lubaski;

public class MoveResults {

    private PlayerType playerType;
    private ResultType resultType;

    public MoveResults(PlayerType playerType, ResultType resultType) {
        this.playerType = playerType;
        this.resultType = resultType;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public ResultType getResultType() {
        return resultType;
    }
}
