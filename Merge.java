
public class Merge {
    private static Comparable[] aux; // auxiliary array for merges

    // Method to sort the array using mergesort algorithm
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1); // Call the overloaded sort method
    }

    // Recursive method to divide and conquer the array
    private static void sort(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) return; // Base case: if the array has one or zero elements, it's already sorted
        int mid = lo + (hi - lo) / 2; // Calculate the middle index
        sort(a, lo, mid); // Sort left half recursively
        sort(a, mid + 1, hi); // Sort right half recursively
        merge(a, lo, mid, hi); // Merge the two sorted halves
    }

    // Method to merge two sorted subarrays into one sorted array
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        Comparable[] aux = new Comparable[a.length]; // Create a temporary array for merging
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; // Copy to auxiliary array
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++]; // Left half exhausted
            else if (j > hi || less(aux[j], aux[i])) a[k] = aux[i++]; // Right half exhausted or right element smaller
            else a[k] = aux[j++]; // Right element smaller
        }
    }

    // Method to compare two Comparable objects
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) > 0; // Reverse the comparison for descending order
    }
}