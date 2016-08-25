import java.util.Comparator;

/**
 * Created by rguleria on 20/08/16.
 */

interface Fly {
    int i = 2;
    default void takeOff() { System.out.println("Fly::takeOff"); }
    default void land() { System.out.println("Fly::land"); }
    default void turn() { System.out.println("Fly::turn"); }
    default void cruise() { System.out.println("Fly::cruise"); }
    static void stuff(){
        System.out.println("");
    }
}

interface FastFly extends Fly {
    default void takeOff() { System.out.println("FastFly::takeOff"); }
}

interface Sail {
    default void cruise() { System.out.println("Sail::Cruise"); }
    default void turn() { System.out.println("Sail::turn"); }
}

class Vehicle {
    public void turn() { System.out.println("Vehicle::turn"); }
}

class SeaPlane extends Vehicle implements FastFly, Sail {

    int i;

    @Override
    public void cruise() {
        i = 2;
        FastFly.super.cruise();
        Fly.stuff();
        Sail.super.cruise();
    }
}

public class InterfaceExample {

    public void test(){
        Fly.stuff();
    }

    public static void main(String[] args){

        Vehicle vehicle = new SeaPlane();

        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();
    }

}
