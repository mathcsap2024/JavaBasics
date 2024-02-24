package Shapes;

import Geometry.Point;
import Main.Board;
import Main.Exceptions.OutOfBoardException;

public abstract class Shape implements Drawable{
    protected Point location;
    protected char notation;

    private static int count = 0;

    public static int getCount() {
        return Shape.count;
    }

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
