import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class IndirectSort {
    // Is v < w?
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // Exchange a[i] and a[j] (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // Indirectly sort a[] using insertion sort, ie, not by rearranging a[],
    // but by returning an array perm[] such that perm[i] is the index of
    // the ith smallest entry in a[].
    @SuppressWarnings({"rawtypes"})
    public static int[] indexSort(Comparable[] a) {
        // this array will store the initial index of a[]
        int[] index = new int[a.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        //Insertion sort swap value of []index
        //values of []index are index for a[]
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j--) {
                exch(index, j, j - 1);  // swap index[j] and index[j-1]
            }
        }
        return index;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int[] perm = indexSort(a);
        int i;
        for (i = 0; i < perm.length - 1; i++) {
            StdOut.print(a[perm[i]] + " ");
        }
        StdOut.println(a[perm[i]]);
    }
}
