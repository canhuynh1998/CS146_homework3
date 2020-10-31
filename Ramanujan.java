// Ramanujan.java: Prints the integers <= N (command-line argument) that can be
// expressed as the sum of two distinct cubes.

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Ramanujan {
    // A data type that encapsulates a pair of numbers (i, j)
    // and the sum of their cubes, ie, i^3 + j^3.
    private static class Pair implements Comparable<Pair> {
        private int i;          // first element of the pair
        private int j;          // second element of the pair
        private int sumOfCubes; // i^3 + j^3

        // Construct a pair (i, j).
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
            sumOfCubes = i * i * i + j * j * j;
        }

        // Compare this pair to the other by sumOfCubes.
        public int compareTo(Pair other) {
            return sumOfCubes - other.sumOfCubes;
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        MinPQ<Pair> result = new MinPQ<Pair>();

        for (int i = 1; i * i * i < N; i++) {
            result.insert(new Pair(i, i + 1));
        }
        Pair previous_pair = new Pair(0, 0);      // dummy previous_pair for the first check
        while (!result.isEmpty()) {
            Pair current_pair = result.delMin();
            if (previous_pair.sumOfCubes == current_pair.sumOfCubes && previous_pair.sumOfCubes <= N) {
                StdOut.println(previous_pair.sumOfCubes + " = " + current_pair.i + "^3 + " + current_pair.j + "^3 = " + previous_pair.i + "^3 + " + previous_pair.j + "^3");
            }

            previous_pair = current_pair;   // update previous_pair
            if ((current_pair.j) < Math.cbrt(N)) {
                result.insert(new Pair(current_pair.i, current_pair.j + 1));
            }
        }


    }
}
