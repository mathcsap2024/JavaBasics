package GUI.Animation;

import Geometry.Point;

public class MyCircle {
    Point direction;

    public void increaseTheta(Integer degree) {
        direction.setTheta(direction.getTheta()+Math.toRadians(degree));
    }

    public void resetTheta() {
        direction.setTheta(0);
    }

    public MyCircle(Point direction) {
        this.direction = direction;
    }

    public Point getDirection() {
        return direction;
    }
}
