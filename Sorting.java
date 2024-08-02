import java.util.Random;

public class Sorting {

    private static int comparisons = 0;

    // Selection Sort
    public static void selectionSort(int[] array) {
        comparisons = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                comparisons++;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] array) {
        comparisons = 0;
        mergeSortHelper(array, 0, array.length - 1);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(array, left, mid);
            mergeSortHelper(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
            comparisons++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(array, l, m);
            sort(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    // Heap Sort
    public static void heapSort(int[] array) {
        comparisons = 0;
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heap(array, i, 0);
        }
    }

    private static void heap(int[] array, int n, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < n) {
            comparisons++;
            if (array[left] > array[largest]) {
                largest = left;
            }
        }
        if (right < n) {
            comparisons++;
            if (array[right] > array[largest]) {
                largest = right;
            }
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heap(array, n, largest);
        }
    }

    // Quicksort with first element as pivot
    public static void quickSortFirstPivot(int[] array) {
        comparisons = 0;
        quickSortFirstPivotHelper(array, 0, array.length - 1);
    }

    private static void quickSortFirstPivotHelper(int[] array, int low, int high) {
        if (low < high) {
            int pi = partitionFirstPivot(array, low, high);
            quickSortFirstPivotHelper(array, low, pi - 1);
            quickSortFirstPivotHelper(array, pi + 1, high);
        }
    }

    private static int partitionFirstPivot(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
            comparisons++;
        }
        swap(array, i, low);
        return i;
    }
    
    // Quicksort with random element as pivot
    public static void quickSortRandomPivot(int[] array) {
        comparisons = 0;
        quickSortRandomPivotHelper(array, 0, array.length - 1);
    }
    
    private static void quickSortRandomPivotHelper(int[] array, int low, int high) {
        if (low < high) {
            int pi = randomPartition(array, low, high);
            quickSortRandomPivotHelper(array, low, pi - 1);
            quickSortRandomPivotHelper(array, pi + 1, high);
        }
    }
    
    private static int randomPartition(int[] array, int low, int high) {
        random(array, low, high);
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) { 
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
                }
                comparisons++;
            }
        swap(array, i + 1, high);
        comparisons++;
        return i + 1;
    }
    
    private static void random(int arr[],int low,int high) { 
        Random rand= new Random(); 
        int pivot = rand.nextInt(high - low) + low; 
        int temp1 = arr[pivot];  
        arr[pivot] = arr[high]; 
        arr[high] = temp1; 
    } 
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static int getComparisons() {
        return comparisons;
    }
}
