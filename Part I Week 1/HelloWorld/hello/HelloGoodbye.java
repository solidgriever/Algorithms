/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {
    public static void main(String[] args) {
        StdOut.printf("Hello %s and %s. \n", args[0], args[1]);
        StdOut.printf("Goodbye %s and %s. \n", args[1], args[0]);
    }
}
