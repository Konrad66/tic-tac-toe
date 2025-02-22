package konrad.lubaski;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTestSuite {

    @Test
    void testComposeBoardView() {
        //Given
        Board board = new Board();

        //When
        String expectedBoard = board.toString();

        //Then
        assertEquals(expectedBoard, "    A   B   C  \n" +
                "1 |   |   |   |\n" +
                "2 |   |   |   |\n" +
                "3 |   |   |   |\n");
    }
}