package abstraction;

public class Car {
    int speed;
    String model;

    Car(String model, int speed){
        this.speed = speed;
        this.model = model;

    }
    void start(){
        System.out.println(model+" has started.");

    }

    void acc(int incr){
        speed += incr;
        System.out.println(model + "'s speed is increased to "+ speed);

    }
    void brake(){
        System.out.println(model + " has stopped.");

    }
    
    
}
