
public class Insertion {
    // Method to sort the array in descending order
    public static void sort(Float[] a) { // Change Comparable[] to Float[]
        int N = a.length;
        for (int i = N - 2; i >= 0; i--) { // Start sorting from right to left
            for (int j = i; j < N - 1 && less(a[j + 1], a[j]); j++) // Reverse the comparison
                exch(a, j, j + 1); // Exchange the elements if they are in the wrong order
        }
    }

    // Method to compare two Float values
    private static boolean less(Float v, Float w) { // Change Comparable to Float
        return v.compareTo(w) > 0; // Reverse the comparison for descending order
    }

    // Method to exchange two elements in the array
    private static void exch(Float[] a, int i, int j) { // Change Comparable[] to Float[]
        Float temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

