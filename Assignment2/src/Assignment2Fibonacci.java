public class Assignment2Fibonacci {

    // A recursive method to calculate the nth term of the Fibonacci sequence
    public static int fibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n has to be a positive integer");
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // Method to get the ordinal suffix for a number (make output grammatically correct)
    public static String getOrdinalSuffix(int number) {
        if (number >= 11 && number <= 13) {
            return "th";
        }
        switch (number % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    public static void main(String[] args) {
        int n = 10; // Change n to calculate a different term
        if (n <= 0) {
            System.out.println("n has to be a positive integer");
        } else {
            int result = fibonacci(n);
            String ordinalSuffix = getOrdinalSuffix(n);
            System.out.println("The " + n + ordinalSuffix + " term of the Fibonacci sequence is " + result + ".");
        }
    }
}
