package Human;

import Human.Human;

public class Main {
    public static void main(String[] args) {
        Human human = new Human(170);
        System.out.println("Human length: " + human.getLength());

        Human.Foot foot = human.new Foot(40);
        System.out.println("Foot length: " + foot.getLength());
        System.out.println("Human length from Foot: " + foot.getHumanLength());
    }
}
