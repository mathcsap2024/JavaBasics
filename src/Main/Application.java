package Main;

import Geometry.Point;
import Shapes.HorizontalLine;
import Shapes.Shape;
import Shapes.Vertex;
import Shapes.VerticalLine;

import java.util.ArrayList;
import java.util.Scanner;

//CLASSPATH

public class Application {
    private Board board;
    private Scanner scanner;
    private ArrayList<Shape> shapes;

    public Application() {
        initScanner();
        initBoard();
        shapes = new ArrayList<>();
    }

    private void initScanner() {
        scanner = new Scanner(System.in);
    }

    private void initBoard() {
        int height = 10;
        int width = 10;

//        System.out.println("Please enter height: ");
//        height = scanner.nextInt();
//
//        System.out.println("Please enter width: ");
//        width = scanner.nextInt();

        board = new Board(width, height);
    }

    public void setBoardPixel(int x, int y, Pixel p) {
        board.setPixel(x, y, p);
    }

    public void run() {
        this.draw();
        System.out.println("");
        addShape(new Vertex(new Point(4,5)));
        addShape(new VerticalLine(new Point(1,1), 40));
        addShape(new HorizontalLine(new Point(5,2), 3));
        this.draw();
    }

    public void render() {
        for(Shape shape: shapes) {
            shape.render(board);
        }
    }

    public void draw() {
        board.draw();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        this.render();
    }
}
