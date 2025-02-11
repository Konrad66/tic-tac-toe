package konrad.lubaski;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        String boardView = board.composeBoardView();
        System.out.println(boardView);
    }
}