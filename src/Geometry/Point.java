package Geometry;

public class Point {
    private double radius, theta;

    public Point(int x, int y) {
        setRadiusAndThetaFromXY(x, y);
    }

    public Point(double r, double theta) {
        this.radius = radius;
        this.theta = theta;
    }

    public Point() {
        this(0, 0);
    }

    public int getX() {
        return (int) (radius * Math.cos(theta));
    }

    public void setX(int x) {
        setRadiusAndThetaFromXY(x, this.getY());
    }

    public int getY() {
        return (int) (radius * Math.sin(theta));
    }

    public void setY(int y) {
        setRadiusAndThetaFromXY(this.getX(), y);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        System.out.println("The value is changed to: " + radius);
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    private void setRadiusAndThetaFromXY(int x, int y) {
        theta = Math.atan2(y, x);
        radius = Math.sqrt(x * x + y * y);
    }
}
