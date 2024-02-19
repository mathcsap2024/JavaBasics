package Shapes;

import Geometry.Point;
import Main.Board;
import Main.Pixel;

public class Vertex extends Shape {

    public Vertex(Point location, char notation) {
        super(location, notation);
    }

    @Override
    public void render(Board board) {
        board.setPixel(location.getY(),location.getX(), new Pixel(notation));
    }

    public Vertex(Point location) {
        this(location, 'O');
    }
}
