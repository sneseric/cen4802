/**
 * This class contains methods to calculate Fibonacci sequence terms and get ordinal suffixes.
 */
public class Assignment2Fibonacci {

    /**
     * Calculates the nth term of the Fibonacci sequence using a recursive approach.
     *
     * @param n The position of the term to be calculated (must be a positive integer).
     * @return The nth term of the Fibonacci sequence.
     * @throws IllegalArgumentException If n is not a positive integer.
     */
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

    /**
     * Gets the ordinal suffix for a number to make the output grammatically correct.
     *
     * @param number The number for which the ordinal suffix is needed.
     * @return The ordinal suffix (e.g., "st" for 1, "nd" for 2, "rd" for 3, "th" for others).
     */
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
