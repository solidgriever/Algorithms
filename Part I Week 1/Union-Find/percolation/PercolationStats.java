/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    private int szLattice;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n or trials cannot be ≤ 0");
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        //return StdStats.mean();
        return 0.0; // todo remove
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        //return StdStats.stddev();
        return 0.0; // todo remove
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {

        return 0.0; // todo remove
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {

        return 0.0; // todo remove
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = 1;
        int trails = 1;
        if (args.length >= 2) {
            n = Integer.parseInt(args[0]);
            trails = Integer.parseInt(args[1]);
        }
        PercolationStats lattice = new PercolationStats(n, trails);
        StdOut.println("Hello");// todo remove
    }
}
