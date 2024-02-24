package Human;

public class Human {
    private int length;

    public Human(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public class Foot {
        int length;

        public Foot(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        public int getHumanLength() {
            return Human.this.length;
        }
    }
}
