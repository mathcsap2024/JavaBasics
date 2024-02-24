package Shapes;

import Geometry.Point;
import Main.Board;
import Main.Exceptions.OutOfBoardException;
import Main.Pixel;

public class Vertex extends Shape{

    public Vertex(Point location, char notation) {
        super(location, notation);
    }

    @Override
    public void render(Board board) {
        try {
            board.setPixel(location.getY(), location.getX(), new Pixel(notation));
        }
        catch (OutOfBoardException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public Vertex(Point location) {
        this(location, 'O');
    }
}
