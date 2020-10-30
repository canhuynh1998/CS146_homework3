import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CertifyHeap {
    // Return true of v is less than w and false otherwise.
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // Return true if a[] represents a maximum-ordered heap and false
    // otherwise. Remember to index from 1.
    @SuppressWarnings({"rawtypes"})
    private static boolean maxOrderedHeap(Comparable[] a) {
        // Start at 2 since MaxHeap ignores 0th index.
        // 1st index is assumed to be the largest.
        for (int i = 2; i < a.length; i++) {
            // a[i/2] is a parent node, a[i] is child node
            // MaxHeap property: parent > child
            if (!less(a[i], a[i / 2])) {
                StdOut.println(i / 2);
                return false;
            }
        }
        return true;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        StdOut.println(maxOrderedHeap(a));
    }
}
