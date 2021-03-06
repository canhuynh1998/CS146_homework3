import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeQueues {
    // Return true if v is less than w and false otherwise.
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Merge and return the two sorted queues as a single sorted queue.
    // Using FIFO principle to merge these 2 queues.
    @SuppressWarnings({"rawtypes"})
    private static Queue<Comparable> merge(Queue<Comparable> q1,
                                           Queue<Comparable> q2) {
        Queue<Comparable> return_queue = new Queue<Comparable>();
        while (!q1.isEmpty() || !q2.isEmpty()) {
            
            // enqueue the not empty queue into the return_queue
            if (q1.isEmpty() && !q2.isEmpty()) {
                return_queue.enqueue(q2.dequeue());
                continue;
            } else if (!q1.isEmpty() && q2.isEmpty()) {
                return_queue.enqueue(q1.dequeue());
                continue;
            }

            // Compare the first element of each queue
            // enqueue into the return_queue
            if (less(q1.peek(), q2.peek())) {
                return_queue.enqueue(q1.dequeue());
            } else if (less(q2.peek(), q1.peek())) {
                return_queue.enqueue(q2.dequeue());
            } else {
                return_queue.enqueue(q1.dequeue());
                return_queue.enqueue(q2.dequeue());
            }
        }
        return return_queue;

    }

    // Test client. [DO NOT EDIT]
    @SuppressWarnings({"rawtypes"})
    public static void main(String[] args) {
        String[] a = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Queue<Comparable> q1 = new Queue<Comparable>();
        Queue<Comparable> q2 = new Queue<Comparable>();
        for (String s : a) {
            if (StdRandom.bernoulli(0.5)) {
                q1.enqueue(s);
            } else {
                q2.enqueue(s);
            }
        }
        int s1 = q1.size(), s2 = q2.size();
        StdOut.println(merge(q1, q2));
        assert q1.size() == s1 && q2.size() == s2;
    }
}
