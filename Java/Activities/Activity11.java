package Activity8;


import java.util.HashMap; 

public class Activity11  {
    public static void main(String[] args) { 
        HashMap<Integer, String> colours = new HashMap<>();


        colours.put(1, "Red");
        colours.put(2, "Blue");
        colours.put(3, "Green");
        colours.put(4, "Yellow");
        colours.put(5, "Purple");


        System.out.println("Colours Map: " + colours);


        colours.remove(4); 
        System.out.println("After removing key 4: " + colours);


        boolean hasGreen = colours.containsValue("Green");
        System.out.println("Does the Map contain 'Green'? " + hasGreen);


        System.out.println("Size of the Map: " + colours.size());
    }
}

