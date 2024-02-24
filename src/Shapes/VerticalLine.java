package Shapes;

import Geometry.Point;
import Main.Board;
import Main.Exceptions.OutOfBoardException;
import Main.Pixel;

import java.io.IOException;

public class VerticalLine extends Line{
    public VerticalLine(Point location, char notation, int length) {
        super(location, notation, length);
    }

    public VerticalLine(Point location, int length) {
        super(location, '|', length);
    }

    @Override
    public void render(Board board) {
        for(int i=0;i<length;i++) {
            try {
                board.setPixel(location.getX(), location.getY() + i, new Pixel(notation));
                System.out.println(location.getX()+"-"+(location.getY() + i)+""+" Done.");
            }
            catch (ArrayIndexOutOfBoundsException | OutOfBoardException ex)
            {
                System.out.println(ex.getMessage());
                break;
            }
            System.out.println("Loop iterated.");
        }
        System.out.println("Method finished.");
    }
}
