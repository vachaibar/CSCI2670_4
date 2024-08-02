import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortDriver {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SortDriver <input_file>");
            System.exit(1);
        }

        int[] array = readInputFile(args[0]);

        System.out.print("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) quick-sort-rp (r)");

        Scanner scanner = new Scanner(System.in);
        System.out.println("");

        while (true) {
            System.out.print("Enter the algorithm: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("exit")) {
                break;
            }

            switch (choice) {
                case "s":
                    Sorting.selectionSort(array);
                    printSortedArray(array, "Selection-sort");                    
                    break;
                case "m":
                    Sorting.mergeSort(array);
                    printSortedArray(array, "Merge-sort");
                    break;
                case "h":
                    Sorting.heapSort(array);
                    printSortedArray(array, "Heap-sort");
                    break;
                case "q":
                    Sorting.quickSortFirstPivot(array);
                    printSortedArray(array, "Quick-sort-fp");
                    break;
                case "r":
                    Sorting.quickSortRandomPivot(array);
                    printSortedArray(array, "Quick-sort-rp");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid sorting algorithm.");
            }

            if (!choice.equals("exit")) {
                break;
            }
        }

        scanner.close();
    }

    private static int[] readInputFile(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            int count = 0;
            while (fileScanner.hasNextInt()) {
                count++;
                fileScanner.nextInt();
            }
            int[] array = new int[count];
            fileScanner.close();
            fileScanner = new Scanner(new File(fileName));
            for (int i = 0; i < count; i++) {
                array[i] = fileScanner.nextInt();
            }
            fileScanner.close();
            return array;
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            System.exit(1);
            return null; // To satisfy the compiler
        }
    }

    private static void printSortedArray(int[] array, String algorithmName) {
        System.out.print("Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("#" + algorithmName + " comparisons: " + Sorting.getComparisons());
    }
}
