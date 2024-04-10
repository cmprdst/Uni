package Uebung7;
/*
Besser:
nur interface Haustier (Methoden Play)
abstract class Tier und Roboter
auch abstract class Hundeartig und Katzenartig (Kein Tier "Hundeartig")
 */
public class AdHocInterfacesAndInheritance {

    public abstract class Roboter implements RoboDog { public abstract String Go(String dest); }
    public class Agent extends Roboter {
        public String Go(String dest) { return "Go" + dest; }
        public String walk(int meter) { return "Walk" + meter; }
    }
    public interface RoboDog { String walk(int meter); }

    public abstract class Haustier implements RoboDog, Katze, Hund {}
    public interface Katze {}

    public abstract class Tier {}
    public class Katzenartig extends Tier implements Katze {}
    public class Löwe extends Katzenartig {}
    public class Leopard extends Katzenartig {}
    public class Elefant extends Tier {}
    public class Hundeartig extends Tier implements Hund {}
    public interface Hund {}
    public class Panda extends Hundeartig {}
}