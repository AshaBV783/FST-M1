package Activity6;


public class Activity6 {
    public static void main(String[] args) { 
        Plane plane = new Plane(10); 
        plane.onboard("Asha");
        plane.onboard("Nidhi");
        plane.onboard("Ram");
 
        System.out.println("Plane took off at: " + plane.takeOff());
 
        System.out.println("Passengers onboard: " + plane.getPassengers());
 
        try {
            Thread.sleep(5000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

      
        plane.land();
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
 
        System.out.println("Passengers after landing: " + plane.getPassengers());
    }
}
