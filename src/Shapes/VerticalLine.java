package Shapes;

import Geometry.Point;
import Main.Board;
import Main.Pixel;

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
            board.setPixel(location.getX(),location.getY()+i, new Pixel(notation));
        }
    }
}
