package Main;

public class Pixel {
    private int x,y;
    private char value;

    public Pixel(char value) {
        this.value = value;
    }

    public Pixel() {
        this('.');
    }

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void draw() {
        System.out.print(value);
    }
}
