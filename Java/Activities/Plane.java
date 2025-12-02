package Activity6;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane { 
    private int maxPassengers;
    private List<String> passengers;
    private Date lastTimeLanded;
 
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }
 
    public void onboard(String passengerName) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passengerName);
        } else {
            System.out.println("Cannot onboard " + passengerName + ". Plane is full!");
        }
    }
 
    public Date takeOff() {
        return new Date();  
    }
 
    public void land() {
        this.lastTimeLanded = new Date();  
        passengers.clear();  
    }
 
    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }
 
    public List<String> getPassengers() {
        return passengers;
    }
}
