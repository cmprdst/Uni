package Uebung7.OOPVererbungUndPolymorphie;

public class Example {

    abstract class Animal {
        public abstract void move(String s);

        public void move(int x) {
            System.out.println("teleport to " + x);
        }
    }

    class Fish extends Animal {
        public void move(String dest) {
            System.out.println("swim to " + dest);
        }
    }

    class Bird extends Animal {
        public void move(String dest) {
            System.out.println("fly to " + dest);
        }

        public void move(int x, int y) {
            System.out.println("fly to " + x + y);
        }
    }

    class RoadRunner extends Bird {
        public void move(String dest) {
            System.out.println("run to " + dest);
        }

        public void move(int x) {
            System.out.println("run faster to " + x);
        }
    }
}