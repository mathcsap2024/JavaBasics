package Shapes;

import Geometry.Point;

public abstract class Line extends Shape{
    protected int length;

    protected Line(Point location, char notation,int length) {
        super(location, notation);
        this.length = length;
    }
}
