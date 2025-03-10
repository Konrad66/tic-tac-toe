package konrad.lubaski;

public class TicTacToe {

    private Player currentPlayer;
    private Board board;
    private Player humanPlayer;
    private Player computerPlayer;

    public TicTacToe() {
        board = new Board();
        humanPlayer = new HumanPlayer();
        computerPlayer = new ComputerPlayer();
        currentPlayer = humanPlayer;
    }

    public MoveResults move() {
        int[] move = currentPlayer.generateMove(board);
        board.doMove(move, currentPlayer.getField());
        MoveResults checkWinner = checkResults(board);
        switchPlayer(humanPlayer, computerPlayer);
        return checkWinner;
    }

    private MoveResults checkResults(Board board) {
        if (board.isBoardFull()) {
            return new MoveResults(currentPlayer.getPlayerType(), ResultType.TIE);
        }
        if (board.checkWin(currentPlayer.getField())) {
            return new MoveResults(currentPlayer.getPlayerType(), ResultType.WIN);
        }
        return new MoveResults(currentPlayer.getPlayerType(), ResultType.NORMAL_MOVE);
    }

    public void switchPlayer(Player player1, Player player2) {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Field[][] getBoardArray() {
        return board.getBoardArray();
    }
}