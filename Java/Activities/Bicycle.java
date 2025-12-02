package Activity7;


public class Bicycle implements bicycleparts, BicycleOperations {
    protected int gears;
    protected int currentSpeed;


    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }
 
   // @Override
    public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println("Brake applied. Current speed: " + currentSpeed);
    } 
   // @Override
    public void speedUp(int increment) {
        currentSpeed += increment;
        if (currentSpeed > maxSpeed) currentSpeed = maxSpeed;
        System.out.println("Speed increased. Current speed: " + currentSpeed);
    }
 
    public void bicycleDesc() {
        System.out.println("Bicycle has " + gears + " gears and max speed of " + maxSpeed + " km/h.");
    }
}

