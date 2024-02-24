package Main.Exceptions;

public class OutOfBoardException extends Exception {
    public OutOfBoardException() {
        super("Access to a pixel which is not in the range of the board");
    }
}
