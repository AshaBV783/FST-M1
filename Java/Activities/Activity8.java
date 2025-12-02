package Activity8;

public class Activity8 {
 
 
    public static void exceptionTest(String value) throws CustomException {
        if (value == null) {
            throw new CustomException("Error: String value cannot be null!");
        } else {
            System.out.println("String value: " + value);
        }
    }

    public static void main(String[] args) {
        try { 
            exceptionTest("Hello, World!");
 
            exceptionTest(null);

        } catch (CustomException e) { 
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}

