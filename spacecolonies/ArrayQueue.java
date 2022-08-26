// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Akhil Kamalesh (akhilk24)

package spacecolonies;

/**
 * import statements
 */
import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * ArrayQueue<T> implements QueueInterface<T> and ArrayQueue<T> is a circular
 * implementation of a queue that is in the form of an array
 * 
 * @author akhilkamalesh
 * @version 11/09/2020
 * @param <T>
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    /**
     * private variables used to create an ArrayQueue<T> object
     */
    private T[] queue;
    /**
     * DEFAULT_CAPACITY sets the default capacity at 20
     */
    public static final int DEFAULT_CAPACITY = 20;
    /**
     * MAX_CAPACITY sets the max capacity at 160
     */
    public static final int MAX_CAPACITY = 160;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;

    /**
     * Constructor for ArrayQueue<T> that uses the default capacity
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * Overloaded Constructor for the ArrayQueue<T> that uses a specified
     * capacity for its capacity of the ArrayQueue<T>
     * 
     * @param capacity
     *            int
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException();
        }
        else {
            queue = (T[])new Object[capacity + 1];
            dequeueIndex = 0;
            enqueueIndex = queue.length - 1;
            size = 0;
        }

    }


    /**
     * getLength method returns the length of the ArrayQueue<T>
     * 
     * @return queue.length int
     */
    public int getLength() {
        return queue.length;
    }


    /**
     * getSize method returns the size of the ArrayQueue<T>
     * 
     * @return size int
     */
    public int getSize() {
        return size;
    }


    @Override
    public void clear() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
        size = 0;
    }


    @Override
    public T dequeue() {
        T hold = getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return hold;
    }


    @Override
    public void enqueue(T entry) {
        ensureCapacity();
        enqueueIndex = incrementIndex(enqueueIndex);
        queue[enqueueIndex] = entry;
        size++;
    }


    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return queue[dequeueIndex];
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * toArray method returns this ArrayQueue<T> in the form of an Array
     * 
     * @return newArr Object[]
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T[] newArr = (T[])new Object[size];
        int d = dequeueIndex;
        for (int i = 0; i < this.size; i++) {
            newArr[i] = queue[d];
            d = incrementIndex(d);
        }

        return newArr;

    }


    /**
     * toString returns this ArrayQueue<T> in the form of a String
     * 
     * @return s String
     */
    public String toString() {

        StringBuilder s = new StringBuilder();
        int d = dequeueIndex;
        s.append("[");
        for (int i = 0; i < size; i++) {
            s.append(queue[d]);
            if (i < size - 1) {
                s.append(", ");
            }
            d = incrementIndex(d);
        }
        s.append("]");
        return s.toString();
    }


    /**
     * equals checks to see if this ArrayQueue<T> is equals to an object
     * 
     * @param obj
     *            Object
     * @return boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            ArrayQueue<T> otherQueue = (ArrayQueue<T>)obj;
            if (this.getSize() == otherQueue.getSize()) {
                for (int i = 0; i < this.getSize(); i++) {
                    T other = otherQueue.queue[(otherQueue.dequeueIndex + i)
                        % otherQueue.queue.length];
                    T mine = queue[(dequeueIndex + i) % queue.length];
                    if (!mine.equals(other)) {
                        return false;
                    }
                }
                return true;

            }
            return false;

        }

        return false;
    }


    /**
     * ensureCapacity is a private method checks to see if the ArrayQueue<T> is
     * full and if
     * it is, it creates a new queue that is double the length
     */
    private void ensureCapacity() {
        if (size == MAX_CAPACITY) {
            throw new IllegalStateException();
        }
        if (isFull()) {
            T[] oldQueue = queue;
            int sizeOld = queue.length - 1;
            int newLength = (size * 2) + 1;
            queue = (T[])new Object[newLength];

            int d = dequeueIndex;
            for (int i = 0; i < sizeOld; i++) {
                queue[i] = oldQueue[d];
                d = (d + 1) % sizeOld;
            }

            dequeueIndex = 0;
            enqueueIndex = sizeOld - 1;
        }
    }


    /**
     * incrementIndex is a private method used to increment the index whenever
     * using dequeue or enqueue
     * 
     * @param index
     *            int
     * @return index int
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * isFull is a private method that checks to see if the ArrayQueue<T> is
     * full
     * 
     * @return
     */
    private boolean isFull() {
        return (enqueueIndex + 2) % queue.length == dequeueIndex;
    }

}
