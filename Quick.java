
import java.util.Random;

public class Quick {
    // Method to sort the array
    public static void sort(Car[] a) {
        shuffleArray(a); // Apply a random shuffle to the array
        sort(a, 0, a.length - 1); // Call the overloaded sort method to start sorting
    }

    // Method to shuffle the array
    public static void shuffleArray(Car[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap the elements at index and i
            Car temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // Recursive method to sort the array within a specified range
    private static void sort(Car[] a, int lo, int hi) {
        if (hi <= lo) return; // Base case: if the array has one or fewer elements, it's already sorted
        int j = partition(a, lo, hi); // Partition the array and get the partitioning index
        sort(a, lo, j - 1); // Sort the left part of the partitioned array
        sort(a, j + 1, hi); // Sort the right part of the partitioned array
    }

    // Method to partition the array
    private static int partition(Car[] a, int lo, int hi) {
        // Partition the array into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1; // Initialize left and right scan indices
        Car v = a[lo]; // Choose the partitioning element as the first element
        while (true) {
            // Move the right pointer to the left until it finds an element smaller than the partitioning element
            while (less(a[--j].getModelYear(), v.getModelYear())) if (j == lo) break;
            // Move the left pointer to the right until it finds an element greater than the partitioning element
            while (less(v.getModelYear(), a[++i].getModelYear())) if (i == hi) break;
            // If the pointers cross, break the loop
            if (i >= j) break;
            // Exchange the elements at i and j
            exch(a, i, j);
        }
        // Place the partitioning element at its correct position
        exch(a, lo, j);
        // Return the partitioning index
        return j;
    }

    // Helper method to compare two long values and return true if the first is less than the second
    private static boolean less(long v, long w) {
        return v < w;
    }

    // Helper method to exchange two elements in the array
    private static void exch(Car[] a, int i, int j) {
        Car temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

