package Shapes;

import Geometry.Point;
import Main.Board;
import Main.Pixel;

public class HorizontalLine extends Line {
    public HorizontalLine(Point location, char notation, int length) {
        super(location, notation, length);
    }

    public HorizontalLine(Point location, int length) {
        super(location, '-', length);
    }

    @Override
    public void render(Board board) {
        for(int i=0;i<length;i++) {
            board.setPixel(location.getX()+i,location.getY(), new Pixel(notation));
        }
    }
}
