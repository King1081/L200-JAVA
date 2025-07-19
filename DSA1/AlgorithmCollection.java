package DSA1;
import java.util.Scanner;
import java.util.Arrays;

/**
 * A collection of classic algorithms, each with:
 * - Pseudocode
 * - ASCII flowchart
 * - Step-by-step algorithm description
 * - Time complexity analysis
 * - Java implementation
 */
public class AlgorithmCollection {

    // --- 1. Sequential Search ---
    /**
     * Algorithm (Step by Step):
     * 1. Start from the first element of the array.
     * 2. Compare the current element with the key.
     * 3. If they are equal, return the current index.
     * 4. If not, move to the next element.
     * 5. Repeat steps 2-4 until the end of the array.
     * 6. If the key is not found, return -1.
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
     * Java Implementation:
     */
    public static int sequentialSearch(int[] arr, int key) {
        if (arr == null) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }
    /**
     * Time Complexity:
     * - Best Case: O(1)   (key is at the first position)
     * - Worst Case: O(n)  (key is at the last position or not present)
     * - Average Case: O(n)
     */

    // --- 2. Find Maximum Element ---
    /**
     * Algorithm (Step by Step):
     * 1. Assume the first element is the maximum.
     * 2. Compare each subsequent element to the current maximum.
     * 3. If a larger element is found, update the maximum.
     * 4. Continue until all elements are checked.
     * 5. Return the maximum value found.
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
     * Java Implementation:
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
    /**
     * Time Complexity:
     * - Best Case: O(n)
     * - Worst Case: O(n)
     * - Average Case: O(n)
     */

    // --- 3. Check for Unique Elements ---
    /**
     * Algorithm (Step by Step):
     * 1. For each element in the array, compare it to every other element after it.
     * 2. If any two elements are equal, return false.
     * 3. If no duplicates are found, return true.
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
     * Java Implementation:
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
    /**
     * Time Complexity:
     * - Best Case: O(1) (if duplicate found at start)
     * - Worst Case: O(n^2)
     * - Average Case: O(n^2)
     */

    // --- 4. Matrix Multiplication ---
    /**
     * Algorithm (Step by Step):
     * 1. For each row i of matrix A and each column j of matrix B:
     * 2. Initialize C[i][j] to 0.
     * 3. For each k from 0 to n-1, multiply A[i][k] by B[k][j] and add to C[i][j].
     * 4. Repeat for all i and j.
     * 5. Return the resulting matrix C.
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
     * Java Implementation:
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
    /**
     * Time Complexity:
     * - Best Case: O(n^3)
     * - Worst Case: O(n^3)
     * - Average Case: O(n^3)
     */

    // --- 5. Count Binary Digits (Iterative) ---
    /**
     * Algorithm (Step by Step):
     * 1. If n <= 0, return 0.
     * 2. Initialize count to 1.
     * 3. While n > 1, increment count and divide n by 2.
     * 4. When n <= 1, return count.
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
     * Java Implementation:
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
    /**
     * Time Complexity:
     * - Best Case: O(1) (n = 1)
     * - Worst Case: O(log n)
     * - Average Case: O(log n)
     */

    // --- 6. Factorial (Recursive) ---
    /**
     * Algorithm (Step by Step):
     * 1. If n < 0, throw an error (undefined).
     * 2. If n == 0, return 1.
     * 3. Otherwise, return n multiplied by the factorial of (n-1).
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
     * Java Implementation:
     */
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    /**
     * Time Complexity:
     * - Best Case: O(1) (n = 0)
     * - Worst Case: O(n)
     * - Average Case: O(n)
     */

    // --- 7. Count Binary Digits (Recursive) ---
    /**
     * Algorithm (Step by Step):
     * 1. If n <= 0, return 0.
     * 2. If n == 1, return 1.
     * 3. Otherwise, return 1 plus the result of the function called with n/2.
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
     * Java Implementation:
     */
    public static int countBinaryDigitsRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) {
            return 1;
        } else {
            return countBinaryDigitsRecursive(n / 2) + 1;
        }
    }
    /**
     * Time Complexity:
     * - Best Case: O(1) (n = 1)
     * - Worst Case: O(log n)
     * - Average Case: O(log n)
     */

    // --- 8. Gaussian Elimination ---
    /**
     * Algorithm (Step by Step):
     * 1. For each row i from 0 to n-2:
     * 2. If the pivot A[i][i] is zero, warn and continue.
     * 3. For each row j below i, compute the factor for elimination.
     * 4. Subtract factor times the i-th row from the j-th row for all columns.
     * 5. Repeat for all rows to form upper triangular (row-echelon) form.
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
     * Java Implementation:
     */
    public static void gaussianElimination(double[][] A) {
        if (A == null || A.length == 0) return;
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i][i] == 0) {
                System.out.println("Warning: Zero pivot encountered at A[" + i + "][" + i + "]. Algorithm may fail.");
            }
            for (int j = i + 1; j < n; j++) {
                if (A[i][i] == 0) continue;
                double factor = A[j][i] / A[i][i];
                for (int k = i; k < n + 1; k++) {
                    A[j][k] -= factor * A[i][k];
                }
            }
        }
    }
    /**
     * Time Complexity:
     * - Best Case: O(n^3)
     * - Worst Case: O(n^3)
     * - Average Case: O(n^3)
     */

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
                    case 1: demoSequentialSearch(scanner); break;
                    case 2: demoMaxElement(scanner); break;
                    case 3: demoUniqueElements(scanner); break;
                    case 4: demoMatrixMultiplication(scanner); break;
                    case 5: demoBinaryDigitsIterative(scanner); break;
                    case 6: demoFactorial(scanner); break;
                    case 7: demoBinaryDigitsRecursive(scanner); break;
                    case 8: demoGaussianElimination(scanner); break;
                    case 0: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice. Please try again.");
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

        // Best Case: key at index 0
        long bestStart = System.nanoTime();
        sequentialSearch(arr, arr.length > 0 ? arr[0] : key);
        long bestEnd = System.nanoTime();

        // Average Case: key at middle
        long avgStart = System.nanoTime();
        sequentialSearch(arr, arr.length > 0 ? arr[arr.length / 2] : key);
        long avgEnd = System.nanoTime();

        // Worst Case: key not present
        long worstStart = System.nanoTime();
        sequentialSearch(arr, Integer.MIN_VALUE);
        long worstEnd = System.nanoTime();

        long startTime = System.nanoTime();
        int result = sequentialSearch(arr, key);
        long endTime = System.nanoTime();

        if (result != -1) {
            System.out.println("Key found at index: " + result);
        } else {
            System.out.println("Key not found.");
        }
        System.out.println("Run time: " + (endTime - startTime) + " ns");
        System.out.println("Best Case Time: " + (bestEnd - bestStart) + " ns (O(1))");
        System.out.println("Average Case Time: " + (avgEnd - avgStart) + " ns (O(n))");
        System.out.println("Worst Case Time: " + (worstEnd - worstStart) + " ns (O(n))");
    }

    private static void demoMaxElement(Scanner scanner) {
        System.out.print("Enter number of elements in array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();

        // Best, Average, Worst are all O(n) for this algorithm
        long bestStart = System.nanoTime();
        findMaxElement(arr);
        long bestEnd = System.nanoTime();

        long avgStart = System.nanoTime();
        findMaxElement(arr);
        long avgEnd = System.nanoTime();

        long worstStart = System.nanoTime();
        findMaxElement(arr);
        long worstEnd = System.nanoTime();

        long startTime = System.nanoTime();
        int max = findMaxElement(arr);
        long endTime = System.nanoTime();

        System.out.println("The maximum element is: " + max);
        System.out.println("Run time: " + (endTime - startTime) + " ns");
        System.out.println("Best/Average/Worst Case Time: " + (bestEnd - bestStart) + " ns (O(n))");
    }

    private static void demoUniqueElements(Scanner scanner) {
        System.out.print("Enter number of elements in array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();

        // Best Case: duplicate at start
        int[] bestArr = Arrays.copyOf(arr, n);
        if (n > 1) bestArr[1] = bestArr[0];
        long bestStart = System.nanoTime();
        areElementsUnique(bestArr);
        long bestEnd = System.nanoTime();

        // Average Case: all unique
        int[] avgArr = new int[n];
        for (int i = 0; i < n; i++) avgArr[i] = i;
        long avgStart = System.nanoTime();
        areElementsUnique(avgArr);
        long avgEnd = System.nanoTime();

        // Worst Case: duplicate at end
        int[] worstArr = Arrays.copyOf(avgArr, n);
        if (n > 1) worstArr[n - 1] = worstArr[0];
        long worstStart = System.nanoTime();
        areElementsUnique(worstArr);
        long worstEnd = System.nanoTime();

        // User run
        System.out.print("Re-enter array elements for your run:\n");
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        long startTime = System.nanoTime();
        boolean isUnique = areElementsUnique(arr);
        long endTime = System.nanoTime();

        if (isUnique) {
            System.out.println("All elements are unique.");
        } else {
            // Find and display unique and duplicate elements
            java.util.Set<Integer> seen = new java.util.HashSet<>();
            java.util.Set<Integer> duplicates = new java.util.HashSet<>();
            java.util.Set<Integer> uniques = new java.util.LinkedHashSet<>();
            for (int value : arr) {
                if (!seen.add(value)) {
                    duplicates.add(value);
                } else {
                    uniques.add(value);
                }
            }
            // Remove duplicates from uniques set
            uniques.removeAll(duplicates);

            System.out.print("Unique elements: ");
            for (int value : uniques) {
                System.out.print(value + " ");
            }
            System.out.println();
            System.out.print("Duplicate elements: ");
            for (int value : duplicates) {
                System.out.print(value + " ");
            }
            System.out.println();
            System.out.println("Therefore, the array contains duplicate elements.");
        }
        System.out.println("Run time: " + (endTime - startTime) + " ns");
        System.out.println("Best Case Time: " + (bestEnd - bestStart) + " ns (O(1))");
        System.out.println("Average Case Time: " + (avgEnd - avgStart) + " ns (O(n^2))");
        System.out.println("Worst Case Time: " + (worstEnd - worstStart) + " ns (O(n^2))");
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

        // All cases O(n^3)
        long bestStart = System.nanoTime();
        matrixMultiply(A, B);
        long bestEnd = System.nanoTime();

        long avgStart = System.nanoTime();
        matrixMultiply(A, B);
        long avgEnd = System.nanoTime();

        long worstStart = System.nanoTime();
        matrixMultiply(A, B);
        long worstEnd = System.nanoTime();

        long startTime = System.nanoTime();
        double[][] C = matrixMultiply(A, B);
        long endTime = System.nanoTime();

        System.out.println("Result Matrix C = A * B:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(C[i]));
        }
        System.out.println("Run time: " + (endTime - startTime) + " ns");
        System.out.println("Best/Average/Worst Case Time: " + (bestEnd - bestStart) + " ns (O(n^3))");
    }

    private static void demoBinaryDigitsIterative(Scanner scanner) {
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        // Best Case: n = 1
        long bestStart = System.nanoTime();
        countBinaryDigitsIterative(1);
        long bestEnd = System.nanoTime();

        // Average/Worst Case: n large
        long avgStart = System.nanoTime();
        countBinaryDigitsIterative(n);
        long avgEnd = System.nanoTime();

        long worstStart = System.nanoTime();
        countBinaryDigitsIterative(Integer.MAX_VALUE);
        long worstEnd = System.nanoTime();

        long startTime = System.nanoTime();
        int count = countBinaryDigitsIterative(n);
        long endTime = System.nanoTime();

        System.out.println("Number of binary digits (iterative): " + count);
        System.out.println("Run time: " + (endTime - startTime) + " ns");
        System.out.println("Best Case Time: " + (bestEnd - bestStart) + " ns (O(1))");
        System.out.println("Average/Worst Case Time: " + (avgEnd - avgStart) + "/" + (worstEnd - worstStart) + " ns (O(log n))");
    }

    private static void demoFactorial(Scanner scanner) {
        System.out.print("Enter a non-negative integer (e.g., 0-20): ");
        int n = scanner.nextInt();

        // Best Case: n = 0
        long bestStart = System.nanoTime();
        factorial(0);
        long bestEnd = System.nanoTime();

        // Average/Worst Case: n large
        long avgStart = System.nanoTime();
        factorial(n);
        long avgEnd = System.nanoTime();

        long worstStart = System.nanoTime();
        factorial(20);
        long worstEnd = System.nanoTime();

        long startTime = System.nanoTime();
        long result = factorial(n);
        long endTime = System.nanoTime();

        System.out.println("Factorial of " + n + " is: " + result);
        System.out.println("Run time: " + (endTime - startTime) + " ns");
        System.out.println("Best Case Time: " + (bestEnd - bestStart) + " ns (O(1))");
        System.out.println("Average/Worst Case Time: " + (avgEnd - avgStart) + "/" + (worstEnd - worstStart) + " ns (O(n))");
    }

    private static void demoBinaryDigitsRecursive(Scanner scanner) {
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        // Best Case: n = 1
        long bestStart = System.nanoTime();
        countBinaryDigitsRecursive(1);
        long bestEnd = System.nanoTime();

        // Average/Worst Case: n large
        long avgStart = System.nanoTime();
        countBinaryDigitsRecursive(n);
        long avgEnd = System.nanoTime();

        long worstStart = System.nanoTime();
        countBinaryDigitsRecursive(Integer.MAX_VALUE);
        long worstEnd = System.nanoTime();

        long startTime = System.nanoTime();
        int count = countBinaryDigitsRecursive(n);
        long endTime = System.nanoTime();

        System.out.println("Number of binary digits (recursive): " + count);
        System.out.println("Run time: " + (endTime - startTime) + " ns");
        System.out.println("Best Case Time: " + (bestEnd - bestStart) + " ns (O(1))");
        System.out.println("Average/Worst Case Time: " + (avgEnd - avgStart) + "/" + (worstEnd - worstStart) + " ns (O(log n))");
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

        // All cases O(n^3)
        long bestStart = System.nanoTime();
        gaussianElimination(A);
        long bestEnd = System.nanoTime();

        long avgStart = System.nanoTime();
        gaussianElimination(A);
        long avgEnd = System.nanoTime();

        long worstStart = System.nanoTime();
        gaussianElimination(A);
        long worstEnd = System.nanoTime();

        long startTime = System.nanoTime();
        gaussianElimination(A);
        long endTime = System.nanoTime();

        System.out.println("Matrix in Row-Echelon Form:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.printf("%8.2f ", A[i][j]);
            }
            System.out.println();
        }
        System.out.println("Run time: " + (endTime - startTime) + " ns");
        System.out.println("Best/Average/Worst Case Time: " + (bestEnd - bestStart) + " ns (O(n^3))");
    }
}