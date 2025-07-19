package DSA2;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * A Java application that allows users to choose a searching or sorting algorithm,
 * provide a list of items at runtime, and analyze the algorithm's performance.
 */
class SearchAndSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            printMainMenu();
            choice = getIntInput(scanner);
            switch (choice) {
                case 1:
                    showSearchMenu(scanner);
                    break;
                case 2:
                    showSortMenu(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from the menu.");
            }
        }
        scanner.close();
    }

    /**
     * Prints the main menu to choose between algorithm types.
     */
    public static void printMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Searching Algorithms");
        System.out.println("2. Sorting Algorithms");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Displays and handles the searching algorithms menu.
     */
    public static void showSearchMenu(Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n--- Searching Algorithms ---");
            System.out.println("1. Sequential Search");
            System.out.println("2. Binary Search");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = getIntInput(scanner);
            switch (choice) {
                case 1:
                    runSearchingAlgorithm(scanner, "Sequential Search", SearchAndSort::sequentialSearch, "O(1)", "O(n)", "O(n)");
                    break;
                case 2:
                    runSearchingAlgorithm(scanner, "Binary Search", SearchAndSort::binarySearch, "O(1)", "O(log n)", "O(log n)");
                    break;
                case 0:
                    return; // Go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays and handles the sorting algorithms menu.
     */
    public static void showSortMenu(Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n--- Sorting Algorithms ---");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Merge Sort");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = getIntInput(scanner);
            switch (choice) {
                case 1:
                    runSortingAlgorithm(scanner, "Bubble Sort", SearchAndSort::bubbleSort, "O(n)", "O(n^2)", "O(n^2)");
                    break;
                case 2:
                    runSortingAlgorithm(scanner, "Insertion Sort", SearchAndSort::insertionSort, "O(n)", "O(n^2)", "O(n^2)");
                    break;
                case 3:
                    runSortingAlgorithm(scanner, "Merge Sort", (arr) -> mergeSort(arr, 0, arr.length - 1), "O(n log n)", "O(n log n)", "O(n log n)");
                    break;
                case 0:
                    return; // Go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // --- SEARCHING ALGORITHMS ---

    /**
     * 1. Sequential Search
     * Algorithm: Iterates through the array from the beginning and compares each element with the key.
     * Time Complexity:
     * - Best Case: O(1) (key is the first element)
     * - Worst Case: O(n) (key is the last element or not present)
     * - Average Case: O(n)
     */
    public static int sequentialSearch(int[] arr, int key) {
        if (arr == null) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }


    /**
     * 2. Binary Search
     * Algorithm: Repeatedly divides the search interval in half. Requires the array to be sorted.
     * Time Complexity:
     * - Best Case: O(1) (key is the middle element)
     * - Worst Case: O(log n)
     * - Average Case: O(log n)
     */
    public static int binarySearch(int[] arr, int key) {
        if (arr == null) return -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // key not found
    }


    // --- SORTING ALGORITHMS ---

    /**
     * 3. Bubble Sort
     * Algorithm: Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
     * Time Complexity:
     * - Best Case: O(n) (array is already sorted)
     * - Worst Case: O(n^2)
     * - Average Case: O(n^2)
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null) return;
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }


    /**
     * 4. Insertion Sort
     * Algorithm: Builds the final sorted array one item at a time.
     * Time Complexity:
     * - Best Case: O(n) (array is already sorted)
     * - Worst Case: O(n^2)
     * - Average Case: O(n^2)
     */
    public static void insertionSort(int[] arr) {
        if (arr == null) return;
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    /**
     * 5. Merge Sort
     * Algorithm: A divide-and-conquer algorithm that recursively splits the array and merges the sorted halves.
     * Time Complexity:
     * - Best Case: O(n log n)
     * - Worst Case: O(n log n)
     * - Average Case: O(n log n)
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // --- REFACTORED HELPER METHODS ---

    /**
     * Gets an array of integers from user input.
     */
    private static int[] getArrayFromUser(Scanner scanner) {
        System.out.print("Enter number of elements in array: ");
        int n = getIntInput(scanner);
        if (n <= 0) {
            System.out.println("Array size must be positive.");
            return null;
        }
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = getIntInput(scanner);
        }
        return arr;
    }

    /**
     * Generic method to run a sorting algorithm and display its performance.
     */
    private static void runSortingAlgorithm(Scanner scanner, String name, Consumer<int[]> sorter, String best, String avg, String worst) {
        int[] arr = getArrayFromUser(scanner);
        if (arr == null) return;

        long startTime = System.nanoTime();
        sorter.accept(arr);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("\n--- " + name + " Results ---");
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Empirical Running Time: " + duration + " ns");
        System.out.println("Theoretical Time Complexity:");
        System.out.println("  - Best Case: " + best);
        System.out.println("  - Average Case: " + avg);
        System.out.println("  - Worst Case: " + worst);
    }

    /**
     * Generic method to run a searching algorithm and display its performance.
     */
    private static void runSearchingAlgorithm(Scanner scanner, String name, BiFunction<int[], Integer, Integer> searcher, String best, String avg, String worst) {
        int[] arr = getArrayFromUser(scanner);
        if (arr == null) return;

        if (name.equals("Binary Search")) {
            Arrays.sort(arr);
            System.out.println("Note: Binary Search requires a sorted array. The input array has been sorted:");
            System.out.println("Sorted Array: " + Arrays.toString(arr));
        }

        System.out.print("Enter key to search for: ");
        int key = getIntInput(scanner);

        long startTime = System.nanoTime();
        int result = searcher.apply(arr, key);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("\n--- " + name + " Results ---");
        if (result != -1) {
            System.out.println("Value '" + key + "' found at index: " + result + (name.equals("Binary Search") ? " (in the sorted array)" : ""));
        } else {
            System.out.println("Value '" + key + "' not found in the array.");
        }
        System.out.println("Empirical Running Time: " + duration + " ns");
        System.out.println("Theoretical Time Complexity:");
        System.out.println("  - Best Case: " + best);
        System.out.println("  - Average Case: " + avg);
        System.out.println("  - Worst Case: " + worst);
    }

    /**
     * Safely reads an integer from the scanner, handling invalid input.
     */
    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.nextLine(); // Clear the invalid input from the scanner buffer
            }
        }
    }
}
