package Activity8;


import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) { 
        HashSet<String> hs = new HashSet<>();
 
        hs.add("Apple");
        hs.add("Banana");
        hs.add("Cherry");
        hs.add("Date");
        hs.add("Elderberry");
        hs.add("Fig");


        System.out.println("Size of HashSet: " + hs.size());


        hs.remove("Banana");
        System.out.println("After removing 'Banana', size: " + hs.size());


        boolean removed = hs.remove("Grapes");
        System.out.println("Trying to remove 'Grapes': " + removed);


        boolean containsCherry = hs.contains("Cherry");
        System.out.println("Does HashSet contain 'Cherry'? " + containsCherry);


        System.out.println("Updated HashSet: " + hs);
    }
}

