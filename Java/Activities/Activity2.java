package Activity2;


public class Activity2 {
    public static void main(String[] args) {

        int[] numbers = {10, 77, 10, 54, -11, 10};

        // Variable to store the sum of all 10's
        int sum = 0;

        // Loop through the array and add all 10's
        for (int num : numbers) {
            if (num == 10) {
                sum += num;
            }
        }

        // Check if the sum equals 30
        boolean result = (sum == 30);

        // Print the result
        System.out.println("Is the sum of all 10's exactly 30? " + result);
    }
}

