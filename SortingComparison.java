import java.util.Random;

public class SortingComparison {

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 5000, 10000, 20000, 25000, 30000}; 
        
        for (int size : sizes) {
            int[] array = generateRandomArray(size); 
            
            // selection sort
            int[] selectionSortArray = array.clone();
            Sorting.selectionSort(selectionSortArray);
            int selectionSortComparisons = Sorting.getComparisons();
            
            // merge sort
            int[] mergeSortArray = array.clone();
            Sorting.mergeSort(mergeSortArray);
            int mergeSortComparisons = Sorting.getComparisons();
            
            // heap sort
            int[] heapSortArray = array.clone();
            Sorting.heapSort(heapSortArray);
            int heapSortComparisons = Sorting.getComparisons();
            
            // quick sort with first pivot
            int[] quickSortFirstPivotArray = array.clone();
            Sorting.quickSortRandomPivot(quickSortFirstPivotArray);
            int quickSortFirstPivotComparisons = Sorting.getComparisons();
            
            // quick sort with random pivot
            int[] quickSortRandomPivotArray = array.clone();
            Sorting.quickSortRandomPivot(quickSortRandomPivotArray);
            int quickSortRandomPivotComparisons = Sorting.getComparisons();
            
            System.out.println("Input size: " + size);
            System.out.println("Selection Sort Comparisons: " + selectionSortComparisons);
            System.out.println("Merge Sort Comparisons: " + mergeSortComparisons);
            System.out.println("Heap Sort Comparisons: " + heapSortComparisons);
            System.out.println("Quick Sort with First Pivot Comparisons: " + quickSortFirstPivotComparisons);
            System.out.println("Quick Sort with Random Pivot Comparisons: " + quickSortRandomPivotComparisons);
            System.out.println();
        }
    }

    // Generate a random array of given size
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); 
        }
        return array;
    }
}
