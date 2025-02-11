package konrad.lubaski;

public class Board {

    final static int height = 3;
    final static int width = 4;

    public String composeBoardView(){
        String board = "";
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                board += " | ";
            }
            board += "\n";
        }
        return board;
    }
}
