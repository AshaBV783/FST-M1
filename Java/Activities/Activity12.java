package Activity8;

 
interface Addable {
 int add(int num1, int num2);
}

public class Activity12 {
 public static void main(String[] args) { 
     Addable ad1 = (a, b) -> (a + b);


     Addable ad2 = (int a, int b) -> {
         return (a + b);
     };


     int result1 = ad1.add(10, 20);
     int result2 = ad2.add(30, 40);

     System.out.println("Result from ad1: " + result1);
     System.out.println("Result from ad2: " + result2);
 }
}
