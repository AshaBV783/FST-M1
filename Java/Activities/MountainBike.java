package Activity7;


public class MountainBike extends Bicycle {
    private int seatHeight;
 
    public MountainBike(int gears, int currentSpeed, int seatHeight) {
        super(gears, currentSpeed);
        this.seatHeight = seatHeight;
    }
 
    public void setHeight(int newHeight) {
        this.seatHeight = newHeight;
        System.out.println("Seat height set to: " + seatHeight);
    }
 
    @Override
    public void bicycleDesc() {
        System.out.println("MountainBike has " + gears + " gears, max speed of " + maxSpeed +
                " km/h, and seat height of " + seatHeight + " cm.");
    }
}

