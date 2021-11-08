/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first, last;
    private int size;

    private class Node {
        private Item item;
        private Node previous;
        private Node next;
    }

    // construct an empty deque
    public Deque() {
        size = 0;
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("null arg");
        Node oldnew = first;
        first = new Node();
        first.item = item;
        first.previous = null;
        first.next = oldnew;
        if (oldnew == null)
            last = first;
        else
            oldnew.previous = first;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("null arg");
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.previous = oldlast;
        last.next = null;
        if (oldlast == null)
            first = last;
        else
            oldlast.next = last;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("deque empty");
        Item item = first.item;
        first = first.next;
        if (first == null)
            last = null;
        else
            first.previous = null;
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("deque empty");
        Item item = last.item;
        last = last.previous;
        if (last == null)
            first = null;
        else
            last.next = null;
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // implementation of the deque iterator
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("end of deque");
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove is illegal");
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.addFirst("head");
        deque.addLast("tail");
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
    }
}
