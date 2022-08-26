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
import student.TestCase;

/**
 * ArrayQueueTest extends TestCase and it tests the methods in ArrayQueue<T> to
 * make sure they work as intended
 * 
 * @author akhilkamalesh
 * @version 11/10/2020
 */
public class ArrayQueueTest extends TestCase {

    /**
     * private variables used to create ArrayQueue objects
     */
    private ArrayQueue<String> queue;
    private ArrayQueue<String> queue1;

    /**
     * setUp() method that creates two ArrayQueue<String> objects
     */
    public void setUp() {
        queue = new ArrayQueue<String>(5);
        queue1 = new ArrayQueue<String>();
    }


    /**
     * Test the getLength method
     */
    public void testGetLength() {
        assertEquals(6, queue.getLength());

        queue1.enqueue("a");
        queue1.enqueue("b");
        queue1.enqueue("c");
        assertEquals(21, queue1.getLength());
    }


    /**
     * Test the getSize method
     */
    public void testGetSize() {
        assertEquals(0, queue.getSize());
        queue.enqueue("Pizza");
        assertEquals(1, queue.getSize());

        queue1.enqueue("a");
        queue1.enqueue("b");
        queue1.enqueue("c");
        assertEquals(3, queue1.getSize());

    }


    /**
     * Test the clear method
     */
    public void testClear() {
        queue.enqueue("Pizza");
        queue.clear();
        assertEquals(0, queue.getSize());
    }


    /**
     * Test the enqueue method
     */
    public void testEnqueue() {
        queue.enqueue("pizza");
        assertEquals(1, queue.getSize());

        for (int i = 0; i < 160; i++) {
            queue1.enqueue("String" + i);
        }
        assertEquals(161, queue1.getLength());
        Exception exception = null;
        try {
            queue1.enqueue("Can't");
        }
        catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);

    }


    /**
     * Test the dequeue method
     */
    public void testDequeue() {
        queue.enqueue("Pizza");
        assertEquals(1, queue.getSize());
        assertEquals("Pizza", queue.dequeue());
    }


    /**
     * Test the getFront method
     */
    public void testGetFront() {
        queue.enqueue("Pizza");
        assertEquals("Pizza", queue.getFront());

        Exception exception = null;
        try {
            queue1.getFront();
        }
        catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
    }


    /**
     * Test isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue("Pizza");
        assertFalse(queue.isEmpty());
    }


    /**
     * Test toArray method
     */
    public void testToArray() {
        Exception exception = null;
        try {
            queue.toArray();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        queue.enqueue("Pizza");
        queue.enqueue("Pasta");
        assertEquals(2, queue.toArray().length);
    }


    /**
     * test toString method
     */
    public void testToString() {
        assertEquals("[]", queue1.toString());
        queue1.enqueue("Pizza");
        assertEquals("[Pizza]", queue1.toString());
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals("[a, b, c]", queue.toString());

    }


    /**
     * test equals method
     */
    public void testEquals() {
        ArrayQueue<String> nullQueue = null;
        String str = "";
        ArrayQueue<String> equal = new ArrayQueue<String>();
        assertTrue(queue.equals(queue));
        queue.enqueue("Pizza");
        equal.enqueue("Pizza");
        queue1.enqueue("Pasta");
        assertTrue(queue.equals(equal));
        assertFalse(queue.equals(nullQueue));
        assertFalse(queue.equals(str));
        assertFalse(queue.equals(queue1));
    }

}
