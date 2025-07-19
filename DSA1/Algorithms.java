package DSA1;
import java.util.*;

public class Algorithms {

    // ALGORITHM 1: Sequential Search
    // Searches for a given value in a given array by sequential search
    // Input: An array A[0..n-1] and a search key K
    // Output: The index of the first element of A that matches K or -1 if there are no matching elements
    //
    // Flowchart (ASCII):
    //   +-------------------+
    //   |      Start        |
    //   +-------------------+
    //            |
    //            v
    //   +-------------------+
    //   |   i = 0           |
    //   +-------------------+
    //            |
    //            v
    //   +---------------------------+
    //   | i < n && A[i] != K ?      |
    //   +---------------------------+
    //      | Yes           | No
    //      v               v
    //   i = i + 1     +-------------------+
    //    |           | i < n ?            |
    //    +-----------+--------------------+
    //                | Yes   | No
    //                v       v
    //           Return i   Return -1
    public static void sequentialSearch(Scanner sc) {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print("Enter key to search for: ");
        int k = sc.nextInt();
        int i = 0;
        while (i < n && arr[i] != k) i++;
        if (i < n)
            System.out.println("Key found at index: " + i);
        else
            System.out.println("Key not found.");
    }

    // ALGORITHM 2: Find Largest Element
    // Determines the value of the largest element in a given array
    // Input: An array A[0..n-1] of real numbers
    // Output: The value of the largest element in A
    //
    // Flowchart (ASCII):
    //   +-------------------+
    //   |      Start        |
    //   +-------------------+
    //            |
    //            v
    //   +-------------------+
    //   | maxval = A[0]     |
    //   +-------------------+
    //            |
    //            v
    //   +---------------------------+
    //   | i = 1 to n-1              |
    //   +---------------------------+
    //            |
    //            v
    //   +---------------------------+
    //   | A[i] > maxval ?           |
    //   +---------------------------+
    //      | Yes           | No
    //      v               v
    //   maxval = A[i]   (do nothing)
    //      |               |
    //      +-------<-------+
    //              |
    //              v
    //   +-------------------+
    //   |  Return maxval    |
    //   +-------------------+
    public static void findLargestElement(Scanner sc) {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int max = arr[0];
        for (int i = 1; i < n; i++) if (arr[i] > max) max = arr[i];
        System.out.println("Largest element: " + max);
    }

    // ALGORITHM 3: Check If Array Elements Are Distinct
    // Determines whether all the elements in a given array are distinct
    // Input: An array A[0..n-1]
    // Output: Returns "true" if all the elements in A are distinct and "false" otherwise
    //
    // Flowchart (ASCII):
    //   +-------------------+
    //   |      Start        |
    //   +-------------------+
    //            |
    //            v
    //   +---------------------------+
    //   | i = 0 to n-2              |
    //   +---------------------------+
    //            |
    //            v
    //   +---------------------------+
    //   | j = i+1 to n-1            |
    //   +---------------------------+
    //            |
    //            v
    //   +---------------------------+
    //   | A[i] == A[j] ?            |
    //   +---------------------------+
    //      | Yes           | No
    //      v               v
    //   Return false   (continue)
    //      |               |
    //      +-------<-------+
    //              |
    //              v
    //   +-------------------+
    //   |  Return true      |
    //   +-------------------+
    public static void checkAllDistinct(Scanner sc) {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();
        Set<Integer> uniques = new LinkedHashSet<>();
        for (int value : arr) {
            if (!seen.add(value)) {
                duplicates.add(value);
            } else {
                uniques.add(value);
            }
        }
        uniques.removeAll(duplicates);
        if (duplicates.isEmpty()) {
            System.out.println("All elements are distinct.");
        } else {
            System.out.print("Unique elements: ");
            for (int value : uniques) System.out.print(value + " ");
            System.out.println();
            System.out.print("Duplicate elements: ");
            for (int value : duplicates) System.out.print(value + " ");
            System.out.println();
            System.out.println("Not all elements are distinct.");
        }
    }

    // ALGORITHM 4: Matrix Multiplication
    // Multiplies two n-by-n matrices by the definition-based algorithm
    // Input: Two n-by-n matrices A and B
    // Output: Matrix C = AB
    //
    // Flowchart (ASCII):
    //   +-------------------+
    //   |      Start        |
    //   +-------------------+
    //            |
    //            v
    //   +-------------------+
    //   | for i = 0 to n-1  |
    //   +-------------------+
    //            |
    //            v
    //   +-------------------+
    //   | for j = 0 to n-1  |
    //   +-------------------+
    //            |
    //            v
    //   +-------------------+
    //   | C[i][j] = 0       |
    //   +-------------------+
    //            |
    //            v
    //   +---------------------------+
    //   | for k = 0 to n-1          |
    //   +---------------------------+
    //            |
    //            v
    //   +---------------------------+
    //   | C[i][j] += A[i][k]*B[k][j]|
    //   +---------------------------+
    //            |
    //            v
    //   +-------------------+
    //   |   Return C        |
    //   +-------------------+
    public static void multiplyMatrices(Scanner sc) {
        System.out.print("Enter matrix size n: ");
        int n = sc.nextInt();
        int[][] A = new int[n][n], B = new int[n][n], C = new int[n][n];
        System.out.println("Enter Matrix A:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = sc.nextInt();

        System.out.println("Enter Matrix B:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    C[i][j] += A[i][k] * B[k][j];

        System.out.println("Result Matrix C:");
        for (int[] row : C) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    // ALGORITHM 5: Count Binary Digits
    // Counts the number of binary digits in the binary representation of a given positive integer
    // Input: A positive integer n
    // Output: The number of binary digits in n
    //
    // Flowchart (ASCII):
    //   +-------------------+
    //   |      Start        |
    //   +-------------------+
    //            |
    //            v
    //   +-------------------+
    //   | count = 0         |
    //   +-------------------+
    //            |
    //            v
    //   +-------------------+
    //   | n > 0 ?           |
    //   +-------------------+
    //      | Yes   | No
    //      v       v
    //   n = n/2  Return count
    //   count++
    //   (loop back to n > 0)
    public static void countBinaryDigits(Scanner sc) {
        System.out.print("Enter a positive number: ");
        int n = sc.nextInt();

        int count = 0;
        int original = n;
        while (n > 0) {
            n = n / 2;
            count++;
        }
        System.out.println("Number of binary digits in " + original + ": " + count);
    }

    // ALGORITHM 6: Factorial (Recursive)
    // Computes the factorial of a given non-negative integer n using recursion
    // Input: A non-negative integer n
    // Output: The factorial of n
    //
    // Flowchart (ASCII):
    //   +-------------------+
    //   |      Start        |
    //   +-------------------+
    //            |
    //            v
    //   +-------------------+
    //   | n <= 1 ?          |
    //   +-------------------+
    //      | Yes   | No
    //      v       v
    //   Return 1  Return n * factorial(n-1)
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void runFactorial(Scanner sc) {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    // ALGORITHM 7: Tower of Hanoi (Recursive)
    // Solves the Tower of Hanoi puzzle using recursion
    // Input: The number of disks n, and the names of the source, auxiliary, and destination pegs
    // Output: The sequence of moves to solve the puzzle
    //
    // Flowchart (ASCII):
    //   +-------------------+
    //   |      Start        |
    //   +-------------------+
    //            |
    //            v
    //   +-------------------+
    //   | n == 1 ?          |
    //   +-------------------+
    //      | Yes   | No
    //      v       v
    //   Move disk  | towerOfHanoi(n-1,src,dest,aux)
    //   1 from src | Move disk n from src to dest
    //   to dest    | towerOfHanoi(n-1,aux,src,dest)
    public static void towerOfHanoi(int n, char src, char aux, char dest) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }
        towerOfHanoi(n - 1, src, dest, aux);
        System.out.println("Move disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n - 1, aux, src, dest);
    }

    public static void runHanoi(Scanner sc) {
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        towerOfHanoi(n, 'A', 'B', 'C');
    }

    // Main method with menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Algorithm Menu ---");
            System.out.println("1. Sequential Search");
            System.out.println("2. Find Largest Element");
            System.out.println("3. Check If Array Elements Are Distinct");
            System.out.println("4. Matrix Multiplication");
            System.out.println("5. Count Binary Digits");
            System.out.println("6. Factorial (Recursive)");
            System.out.println("7. Tower of Hanoi (Recursive)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sequentialSearch(sc);
                    break;
                case 2:
                    findLargestElement(sc);
                    break;
                case 3:
                    checkAllDistinct(sc);
                    break;
                case 4:
                    multiplyMatrices(sc);
                    break;
                case 5:
                    countBinaryDigits(sc);
                    break;
                case 6:
                    runFactorial(sc);
                    break;
                case 7:
                    runHanoi(sc);
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        sc.close();
    }
}
// End of Algorithms.java