package Activity8;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) { 
        ArrayList<String> myList = new ArrayList<String>(); 
        myList.add("Red");
        myList.add("Yellow");
        myList.add("Blue"); 
        myList.add(3, "Green");
        myList.add(1, "Black");
        
        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Brown is in list: " + myList.contains("Brown"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("Black");
        
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}
