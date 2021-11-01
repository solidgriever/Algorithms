/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] states;
    private WeightedQuickUnionUF grid;
    private WeightedQuickUnionUF full;
    private int szN;
    private int openSites;
    private int vTop;
    private int vBottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n > 0) {
            szN = n;
            int size = n * n; // n by n grid + virtual
            grid = new WeightedQuickUnionUF(size + 2);
            full = new WeightedQuickUnionUF(size + 1);
            states = new boolean[n][n];
            vBottom = size + 1;
            vTop = size;
        }
        else
            throw new IllegalArgumentException("n < 0");
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (checkBounds(row, col)) {
            if (isOpen(row, col)) return;
            int flattenGrid = (szN * (row - 1) + col) - 1;
            if (row == 1) {
                grid.union(vTop, col - 1);
                full.union(vTop, col - 1);
            }
            if (row == szN) grid.union(vBottom, (szN * (row - 1) + col) - 1);

            states[row - 1][col - 1] = true;
            if (checkBounds(row - 1, col) && isOpen(row - 1, col)) {
                grid.union(flattenGrid, (szN * (row - 2) + col) - 1);
                full.union(flattenGrid, (szN * (row - 2) + col) - 1);
            }
            if (checkBounds(row, col + 1) && isOpen(row, col + 1)) {
                grid.union(flattenGrid, (szN * (row - 1) + col + 1) - 1);
                full.union(flattenGrid, (szN * (row - 1) + col + 1) - 1);
            }
            if (checkBounds(row, col - 1) && isOpen(row, col - 1)) {
                grid.union(flattenGrid, (szN * (row - 1) + col - 1) - 1);
                full.union(flattenGrid, (szN * (row - 1) + col - 1) - 1);
            }
            if (checkBounds(row + 1, col) && isOpen(row + 1, col)) {
                grid.union(flattenGrid, (szN * row + col) - 1);
                full.union(flattenGrid, (szN * row + col) - 1);
            }
        }
        else
            throw new IllegalArgumentException("open illegal arg");
        openSites++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (checkBounds(row, col))
            return states[row - 1][col - 1];
        else
            throw new IllegalArgumentException("isOpen illegal arg");
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row <= 0 || row > szN || col <= 0 || col > szN)
            throw new IllegalArgumentException("isFull illegal arg");
        return full.find(vTop) == full.find((szN * (row - 1) + col) - 1);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return grid.find(vTop) == grid.find(vBottom);
    }

    private boolean checkBounds(int row, int col) {
        return !(row <= 0 || row > szN || col <= 0 || col > szN);
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Percolation perc = new Percolation(n);
        System.out.println(perc.percolates());
        perc.open(1, 1);
        perc.open(2, 1);
        System.out.println(perc.percolates());
        perc.open(3, 1);
        perc.open(3, 2);
        System.out.println(perc.isFull(3, 2));
        perc.open(4, 2);
        System.out.println(perc.percolates());
    }
}