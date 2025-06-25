import java.util.Scanner;
import java.util.Arrays;

/**
 * A collection of algorithms from the provided document, all implemented in Java.
 * This single class includes methods for:
 * - Sequential Search
 * - Finding the Maximum Element
 * - Checking for Unique Elements
 * - Matrix Multiplication
 * - Iterative and Recursive Binary Digit Counting
 * - Recursive Factorial
 * - Gaussian Elimination
 *
 * The main method provides a menu to demonstrate each algorithm.
 */
public class AlgorithmCollection {

    // --- 1. Sequential Search ---
    /**
     * Sequential Search
     *
     * Pseudocode:
     * --------------------------
     * procedure SequentialSearch(arr, key)
     *     for i = 0 to arr.length - 1 do
     *         if arr[i] == key then
     *             return i
     *     return -1
     * end procedure
     * --------------------------
     *
     * Flowchart (ASCII):
     * 
     *   +-------------------+
     *   |   Start           |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | i = 0             |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------------------+
     *   | i < arr.length ?               |
     *   +-------------------------------+
     *      | Yes                | No
     *      v                    v
     * +-------------------+   +---------+
     * | arr[i] == key ?   |   | Return  |
     * +-------------------+   |   -1    |
     *   | Yes   | No          +---------+
     *   v       v
     * Return   i = i + 1
     *  i      (loop back to i < arr.length)
     *
     * Algorithm (Step by Step):
     * 1. Start from the first element of the array.
     * 2. Compare the current element with the key.
     * 3. If they are equal, return the current index.
     * 4. If not, move to the next element.
     * 5. Repeat steps 2-4 until the end of the array.
     * 6. If the key is not found, return -1.
     *
     * Time Complexity:
     * - Best Case: O(1)   (key is at the first position)
     * - Worst Case: O(n)  (key is at the last position or not present)
     * - Average Case: O(n)
     */
    public static int sequentialSearch(int[] arr, int key) {
        if (arr == null) return -1;
        int n = arr.length;
        int i = 0;
        while (i < n && arr[i] != key) {
            i++;
        }
        if (i < n) {
            return i;
        } else {
            return -1;
        }
    }

    // --- 2. Find Maximum Element ---
    /**
     * Finds the largest element in an array of integers.
     *
     * Pseudocode:
     * --------------------------
     * procedure FindMaxElement(arr)
     *     maxval = arr[0]
     *     for i = 1 to arr.length - 1 do
     *         if arr[i] > maxval then
     *             maxval = arr[i]
     *     return maxval
     * end procedure
     * --------------------------
     *
     * Flowchart (ASCII):
     *
     *   +-------------------+
     *   |   Start           |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | maxval = arr[0]   |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------------------+
     *   | i = 1 to arr.length - 1       |
     *   +-------------------------------+
     *            |
     *            v
     *   +---------------------------+
     *   | arr[i] > maxval ?         |
     *   +---------------------------+
     *      | Yes         | No
     *      v             v
     * maxval = arr[i]   (do nothing)
     *      |             |
     *      +------<------+
     *            |
     *            v
     *   +-------------------+
     *   |   Return maxval   |
     *   +-------------------+
     *
     * Algorithm (Step by Step):
     * 1. Assume the first element is the maximum.
     * 2. Compare each subsequent element to the current maximum.
     * 3. If a larger element is found, update the maximum.
     * 4. Continue until all elements are checked.
     * 5. Return the maximum value found.
     *
     * Time Complexity:
     * - Best Case: O(n)
     * - Worst Case: O(n)
     * - Average Case: O(n)
     *
     * @param arr The array of integers to search.
     * @return The largest integer value in the array.
     * @throws IllegalArgumentException if the array is null or empty.
     */
    public static int findMaxElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        int maxval = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxval) {
                maxval = arr[i];
            }
        }
        return maxval;
    }

    // --- 3. Check for Unique Elements ---
    /**
     * Checks if all elements in an array are unique by comparing each element to every other.
     *
     * Pseudocode:
     * --------------------------
     * procedure AreElementsUnique(arr)
     *     for i = 0 to arr.length - 2 do
     *         for j = i + 1 to arr.length - 1 do
     *             if arr[i] == arr[j] then
     *                 return false
     *     return true
     * end procedure
     * --------------------------
     *
     * Flowchart (ASCII):
     *
     *   +-------------------+
     *   |   Start           |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------------------+
     *   | i = 0 to n-2                  |
     *   +-------------------------------+
     *            |
     *            v
     *   +-------------------------------+
     *   | j = i+1 to n-1                |
     *   +-------------------------------+
     *            |
     *            v
     *   +---------------------------+
     *   | arr[i] == arr[j] ?        |
     *   +---------------------------+
     *      | Yes         | No
     *      v             v
     *   Return false   (continue)
     *      |             |
     *      +------<------+
     *            |
     *            v
     *   +-------------------+
     *   |   Return true     |
     *   +-------------------+
     *
     * Algorithm (Step by Step):
     * 1. For each element in the array, compare it to every other element after it.
     * 2. If any two elements are equal, return false.
     * 3. If no duplicates are found, return true.
     *
     * Time Complexity:
     * - Best Case: O(1) (if duplicate found at start)
     * - Worst Case: O(n^2)
     * - Average Case: O(n^2)
     *
     * @param arr The array of integers to check.
     * @return true if all elements are unique, false otherwise.
     */
    public static boolean areElementsUnique(int[] arr) {
        if (arr == null) return true;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // --- 4. Matrix Multiplication ---
    /**
     * Multiplies two n x n square matrices (A and B).
     *
     * Pseudocode:
     * --------------------------
     * procedure MatrixMultiply(A, B)
     *     for i = 0 to n-1 do
     *         for j = 0 to n-1 do
     *             C[i][j] = 0
     *             for k = 0 to n-1 do
     *                 C[i][j] = C[i][j] + A[i][k] * B[k][j]
     *     return C
     * end procedure
     * --------------------------
     *
     * Flowchart (ASCII):
     *
     *   +-------------------+
     *   |   Start           |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | for i = 0 to n-1  |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | for j = 0 to n-1  |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | C[i][j] = 0       |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | for k = 0 to n-1  |
     *   +-------------------+
     *            |
     *            v
     *   +--------------------------------------+
     *   | C[i][j] += A[i][k] * B[k][j]         |
     *   +--------------------------------------+
     *            |
     *            v
     *   +-------------------+
     *   |   Return C        |
     *   +-------------------+
     *
     * Algorithm (Step by Step):
     * 1. For each row i of matrix A and each column j of matrix B:
     * 2. Initialize C[i][j] to 0.
     * 3. For each k from 0 to n-1, multiply A[i][k] by B[k][j] and add to C[i][j].
     * 4. Repeat for all i and j.
     * 5. Return the resulting matrix C.
     *
     * Time Complexity:
     * - Best Case: O(n^3)
     * - Worst Case: O(n^3)
     * - Average Case: O(n^3)
     *
     * @param A The first n x n matrix.
     * @param B The second n x n matrix.
     * @return The resulting n x n matrix C = A * B. Returns null if matrices are invalid.
     */
    public static double[][] matrixMultiply(double[][] A, double[][] B) {
        if (A == null || B == null || A.length == 0 || A.length != B.length || A[0].length != A.length) {
            return null;
        }
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0.0;
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
    
    // --- 5. Count Binary Digits (Iterative) ---
    /**
     * Iteratively calculates the number of digits in the binary representation of a positive integer n.
     *
     * Pseudocode:
     * --------------------------
     * procedure CountBinaryDigitsIterative(n)
     *     if n <= 0 then
     *         return 0
     *     count = 1
     *     while n > 1 do
     *         count = count + 1
     *         n = n / 2
     *     return count
     * end procedure
     * --------------------------
     *
     * Flowchart (ASCII):
     *
     *   +-------------------+
     *   |   Start           |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | n <= 0 ?          |
     *   +-------------------+
     *      | Yes   | No
     *      v       v
     *   Return 0  count = 1
     *              |
     *              v
     *   +-------------------+
     *   | n > 1 ?           |
     *   +-------------------+
     *      | Yes   | No
     *      v       v
     *   count++   Return count
     *   n = n/2
     *   (loop back to n > 1)
     *
     * Algorithm (Step by Step):
     * 1. If n <= 0, return 0.
     * 2. Initialize count to 1.
     * 3. While n > 1, increment count and divide n by 2.
     * 4. When n <= 1, return count.
     *
     * Time Complexity:
     * - Best Case: O(1) (n = 1)
     * - Worst Case: O(log n)
     * - Average Case: O(log n)
     */
    public static int countBinaryDigitsIterative(int n) {
        if (n <= 0) return 0;
        int count = 1;
        while (n > 1) {
            count++;
            n = n / 2;
        }
        return count;
    }

    // --- 6. Factorial (Recursive) ---
    /**
     * Computes the factorial of a non-negative integer using recursion.
     *
     * Pseudocode:
     * --------------------------
     * procedure Factorial(n)
     *     if n < 0 then
     *         error "undefined"
     *     if n == 0 then
     *         return 1
     *     else
     *         return n * Factorial(n - 1)
     * end procedure
     * --------------------------
     *
     * Flowchart (ASCII):
     *
     *   +-------------------+
     *   |   Start           |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | n < 0 ?           |
     *   +-------------------+
     *      | Yes   | No
     *      v       v
     *   Error   n == 0 ?
     *           +-------------------+
     *           | Yes   | No        |
     *           v       v
     *        Return 1  Return n * Factorial(n-1)
     *
     * Algorithm (Step by Step):
     * 1. If n < 0, throw an error (undefined).
     * 2. If n == 0, return 1.
     * 3. Otherwise, return n multiplied by the factorial of (n-1).
     *
     * Time Complexity:
     * - Best Case: O(1) (n = 0)
     * - Worst Case: O(n)
     * - Average Case: O(n)
     */
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // --- 7. Count Binary Digits (Recursive) ---
    /**
     * Recursively calculates the number of digits in the binary representation of a positive integer n.
     *
     * Pseudocode:
     * --------------------------
     * procedure CountBinaryDigitsRecursive(n)
     *     if n <= 0 then
     *         return 0
     *     if n == 1 then
     *         return 1
     *     else
     *         return CountBinaryDigitsRecursive(n / 2) + 1
     * end procedure
     * --------------------------
     *
     * Flowchart (ASCII):
     *
     *   +-------------------+
     *   |   Start           |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | n <= 0 ?          |
     *   +-------------------+
     *      | Yes   | No
     *      v       v
     *   Return 0  n == 1 ?
     *              +-------------------+
     *              | Yes   | No        |
     *              v       v
     *           Return 1  Return CountBinaryDigitsRecursive(n/2) + 1
     *
     * Algorithm (Step by Step):
     * 1. If n <= 0, return 0.
     * 2. If n == 1, return 1.
     * 3. Otherwise, return 1 plus the result of the function called with n/2.
     *
     * Time Complexity:
     * - Best Case: O(1) (n = 1)
     * - Worst Case: O(log n)
     * - Average Case: O(log n)
     */
    public static int countBinaryDigitsRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) {
            return 1;
        } else {
            return countBinaryDigitsRecursive(n / 2) + 1;
        }
    }

    // --- 8. Gaussian Elimination ---
    /**
     * Performs Gaussian elimination on an n x (n+1) augmented matrix to convert it to row-echelon form.
     *
     * Pseudocode:
     * --------------------------
     * procedure GaussianElimination(A)
     *     for i = 0 to n-2 do
     *         if A[i][i] == 0 then
     *             warning "Zero pivot"
     *         for j = i+1 to n-1 do
     *             if A[i][i] == 0 then continue
     *             factor = A[j][i] / A[i][i]
     *             for k = i to n do
     *                 A[j][k] = A[j][k] - factor * A[i][k]
     * end procedure
     * --------------------------
     *
     * Flowchart (ASCII):
     *
     *   +-------------------+
     *   |   Start           |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | for i = 0 to n-2  |
     *   +-------------------+
     *            |
     *            v
     *   +-------------------+
     *   | A[i][i] == 0 ?    |
     *   +-------------------+
     *      | Yes   | No
     *      v       v
     *   Warn    for j = i+1 to n-1
     *              |
     *              v
     *         A[i][i] == 0 ?
     *           | Yes   | No
     *           v       v
     *         continue  factor = A[j][i]/A[i][i]
     *                   for k = i to n
     *                       A[j][k] -= factor * A[i][k]
     *   +-------------------+
     *   |   End             |
     *   +-------------------+
     *
     * Algorithm (Step by Step):
     * 1. For each row i from 0 to n-2:
     * 2. If the pivot A[i][i] is zero, warn and continue.
     * 3. For each row j below i, compute the factor for elimination.
     * 4. Subtract factor times the i-th row from the j-th row for all columns.
     * 5. Repeat for all rows to form upper triangular (row-echelon) form.
     *
     * Time Complexity:
     * - Best Case: O(n^3)
     * - Worst Case: O(n^3)
     * - Average Case: O(n^3)
     *
     * @param A The n x (n+1) augmented matrix, which is modified in place.
     */
    public static void gaussianElimination(double[][] A) {
        if (A == null || A.length == 0) return;
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            // Simple check for zero pivot. A robust implementation would use row swapping.
            if (A[i][i] == 0) {
                System.out.println("Warning: Zero pivot encountered at A[" + i + "][" + i + "]. Algorithm may fail.");
                // Continue, but results might be incorrect.
            }
            for (int j = i + 1; j < n; j++) {
                if(A[i][i] == 0) continue; // Avoid division by zero
                double factor = A[j][i] / A[i][i];
                for (int k = i; k < n + 1; k++) {
                    A[j][k] -= factor * A[i][k];
                }
            }
        }
    }

    // --- Main Method for Demonstration ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n--- Algorithm Demonstration Menu ---");
            System.out.println("1. Sequential Search");
            System.out.println("2. Find Maximum Element");
            System.out.println("3. Check for Unique Elements");
            System.out.println("4. Matrix Multiplication");
            System.out.println("5. Count Binary Digits (Iterative)");
            System.out.println("6. Factorial (Recursive)");
            System.out.println("7. Count Binary Digits (Recursive)");
            System.out.println("8. Gaussian Elimination");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        demoSequentialSearch(scanner);
                        break;
                    case 2:
                        demoMaxElement(scanner);
                        break;
                    case 3:
                        demoUniqueElements(scanner);
                        break;
                    case 4:
                        demoMatrixMultiplication(scanner);
                        break;
                    case 5:
                        demoBinaryDigitsIterative(scanner);
                        break;
                    case 6:
                        demoFactorial(scanner);
                        break;
                    case 7:
                        demoBinaryDigitsRecursive(scanner);
                        break;
                    case 8:
                        demoGaussianElimination(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear invalid input from scanner
            }
        }
        scanner.close();
    }

    // --- Demonstration Methods ---
    private static void demoSequentialSearch(Scanner scanner) {
        System.out.print("Enter number of elements in array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        System.out.print("Enter key to search for: ");
        int key = scanner.nextInt();
        int result = sequentialSearch(arr, key);
        if (result != -1) {
            System.out.println("Key found at index: " + result);
        } else {
            System.out.println("Key not found.");
        }
    }

    private static void demoMaxElement(Scanner scanner) {
        System.out.print("Enter number of elements in array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        int max = findMaxElement(arr);
        System.out.println("The maximum element is: " + max);
    }

    private static void demoUniqueElements(Scanner scanner) {
        System.out.print("Enter number of elements in array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        boolean isUnique = areElementsUnique(arr);
        if (isUnique) {
            System.out.println("All elements are unique.");
        } else {
            System.out.println("The array contains duplicate elements.");
        }
    }

    private static void demoMatrixMultiplication(Scanner scanner) {
        System.out.print("Enter the dimension 'n' for the n x n matrices: ");
        int n = scanner.nextInt();
        double[][] A = new double[n][n];
        double[][] B = new double[n][n];
        System.out.println("Enter elements for Matrix A:");
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) A[i][j] = scanner.nextDouble();
        System.out.println("Enter elements for Matrix B:");
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) B[i][j] = scanner.nextDouble();
        
        double[][] C = matrixMultiply(A, B);
        
        System.out.println("Result Matrix C = A * B:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(C[i]));
        }
    }

    private static void demoBinaryDigitsIterative(Scanner scanner) {
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        int count = countBinaryDigitsIterative(n);
        System.out.println("Number of binary digits (iterative): " + count);
    }
    
    private static void demoFactorial(Scanner scanner) {
        System.out.print("Enter a non-negative integer (e.g., 0-20): ");
        int n = scanner.nextInt();
        long result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }

    private static void demoBinaryDigitsRecursive(Scanner scanner) {
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        int count = countBinaryDigitsRecursive(n);
        System.out.println("Number of binary digits (recursive): " + count);
    }

    private static void demoGaussianElimination(Scanner scanner) {
        System.out.print("Enter the number of equations (n): ");
        int n = scanner.nextInt();
        double[][] A = new double[n][n + 1];
        System.out.println("Enter augmented matrix coefficients [A|b]:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.printf("A[%d][%d]: ", i, j);
                A[i][j] = scanner.nextDouble();
            }
        }
        
        gaussianElimination(A);
        
        System.out.println("Matrix in Row-Echelon Form:");
        for (int i = 0; i < n; i++) {
            for(int j=0; j < n+1; j++) {
                System.out.printf("%8.2f ", A[i][j]);
            }
            System.out.println();
        }
    }
}