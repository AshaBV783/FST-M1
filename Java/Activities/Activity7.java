package Activity7;

public class Activity7 {
 
    public static void main(String[] args) {
        // Create MountainBike object
        MountainBike mb = new MountainBike(5, 10, 25);

        // Access methods
        mb.bicycleDesc();          // Description
        mb.speedUp(15);            // Increase speed
        mb.applyBrake(5);          // Apply brake
        mb.setHeight(30);          // Change seat height
        mb.bicycleDesc();          // Updated description
    }
}

