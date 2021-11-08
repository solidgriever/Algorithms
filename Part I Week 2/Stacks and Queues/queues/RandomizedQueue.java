/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private Item[] randomQ;

    // construct an empty randomized queue
    public RandomizedQueue() {
        // noinspection unchecked
        randomQ = (Item[]) new Object[10];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("null arg");
        if (size == randomQ.length) {
            // noinspection unchecked
            Item[] temp = (Item[]) new Object[randomQ.length * 2];
            for (int i = 0; i < size; i++)
                temp[i] = randomQ[i];
            randomQ = temp;
        }
        randomQ[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("queue empty");
        int rnd = StdRandom.uniform(size);
        Item item = randomQ[rnd];
        randomQ[rnd] = randomQ[--size];
        randomQ[size] = null;
        if (size > 0 && size == randomQ.length / 4) {
            // noinspection unchecked
            Item[] temp = (Item[]) new Object[randomQ.length / 2];
            for (int i = 0; i < size; i++)
                temp[i] = randomQ[i];
            randomQ = temp;
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("queue empty");
        return randomQ[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // implementation for RandomizedQueueIterator
    private class RandomizedQueueIterator implements Iterator<Item> {
        private final Item[] temp;
        private int szTemp;

        public RandomizedQueueIterator() {
            // noinspection unchecked
            temp = (Item[]) new Object[size];
            for (int i = 0; i < temp.length; i++)
                temp[i] = randomQ[i];
            StdRandom.shuffle(temp);
            szTemp = 0;
        }

        public boolean hasNext() {
            return szTemp < temp.length;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("last item");
            return temp[szTemp++];
        }

        public void remove() {
            throw new UnsupportedOperationException("illegal");
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> randQ = new RandomizedQueue<String>();
        randQ.enqueue("first");
        randQ.enqueue("second");
        randQ.enqueue("third");
        System.out.println(randQ.dequeue());
        System.out.println(randQ.dequeue());
        System.out.println(randQ.dequeue());
    }
}
