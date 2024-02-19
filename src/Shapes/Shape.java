package Shapes;

import Geometry.Point;
import Main.Board;

public abstract class Shape {
    protected Point location;
    protected char notation;

    public abstract void render(Board board);

    protected Shape(Point location, char notation) {
        this.location = location;
        this.notation=notation;
    }

    protected Shape(Point location) {
        this(location, 'o');
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
