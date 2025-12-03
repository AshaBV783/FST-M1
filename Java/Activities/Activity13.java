package Activity8;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13  {
    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Random indexGen = new Random();

        System.out.println("Enter integers:");


        while (scan.hasNextInt()) {
            list.add(scan.nextInt());
        }


        Integer nums[] = list.toArray(new Integer[0]);


        int randomIndex = indexGen.nextInt(nums.length);


        System.out.println("Random index generated: " + randomIndex);
        System.out.println("Value at that index: " + nums[randomIndex]);


        scan.close();
    }
}

