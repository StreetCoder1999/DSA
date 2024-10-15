import java.util.*;

public class BinaryHeap {
    static int capacity; /* Maximum elements that can be stored in heap */
    static int size; /* Current no of elements in heap */
    static int arr[]; /* array for storing the keys */

    BinaryHeap(int cap) {
        capacity = cap; /* Assigning the capacity */
        size = 0; /* Intailly size of hepa is zero */
        arr = new int[capacity]; /* Creating a array */
    }

    /* returns the parent of ith Node */
    static int parent(int i) {
        return (i - 1) / 2;
    }

    /* returns the left child of ith Node */
    static int left(int i) {
        return 2 * i + 1;
    }

    /* Returns the right child of the ith Node */
    static int right(int i) {
        return 2 * i + 2;
    }

    /* Insert a new key x */
    static void Insert(int x) {
        if (size == capacity) {
            System.out.println("Binary Heap Overflown");
            return;
        }
        arr[size] = x; /* Insert new element at end */
        int k = size; /* store the index ,for checking heap property */
        size++; /* Increase the size */

        /* Fix the min heap property */
        while (k != 0 && arr[parent(k)] > arr[k]) {
            int temp = arr[parent(k)];
            arr[parent(k)] = arr[k];
            arr[k] = temp;
            k = parent(k);
        }
    }

    static void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int getMin() {
        return arr[0];
    }

    public static void main(String args[])

    {
        BinaryHeap h = new BinaryHeap(20);
        h.Insert(4);
        h.Insert(1);
        h.Insert(2);
        h.Insert(6);
        h.Insert(7);
        h.Insert(3);
        h.Insert(8);
        h.Insert(5);
        System.out.println("Min value is " + h.getMin());
        h.Insert(-1);
        System.out.println("Min value is " + h.getMin());
        h.print();

    }
}
