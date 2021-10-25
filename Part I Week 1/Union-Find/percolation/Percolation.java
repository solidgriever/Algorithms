/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Percolation {

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        boolean res = false;

        return res;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        boolean res = false;

        return res;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int res = 0;

        return res;
    }

    // does the system percolate?
    public boolean percolates() {
        boolean res = false;

        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Percolation grid = new Percolation(n);

        StdOut.println("Hello");
    }
}
