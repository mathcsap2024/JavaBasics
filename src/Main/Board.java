package Main;

import Main.Exceptions.OutOfBoardException;

public class Board {
    private int height, width;
    private Pixel[][] pixels;
    private String name;

    public Board(int w, int h) {
        width = w;
        height = h;
        pixels = new Pixel[height][width];

        for(int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                pixels[i][j] = new Pixel();
            }
        }

        name = "Default Main.Board";
    }

    public void draw() {
        for(int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                pixels[i][j].draw();
            }
            System.out.println();
        }
    }

    public void setPixel(int x, int y, Pixel p) throws OutOfBoardException {
        if(y<0 || y>=pixels.length || x<0 || x>=pixels[0].length) {
            throw new OutOfBoardException();
        }
        pixels[y][x]=p;
    }

    public Pixel getPixel(int x, int y) {
        return pixels[y][x];
    }
}
