import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.main.Queue;

import java.util.Arrays;

public class QueueTest {

    Queue<Integer> queue = new Queue<>();

    @Before
    public void setUpBefore() {
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(3);
    }

    @After
    public void setUpAfter() {
        System.out.println(Arrays.toString(queue.toArray()));
    }

    @Test
    public void enqueueTest() {
        queue.enqueue(4);

        Assert.assertEquals(Integer.valueOf(4), queue.rear());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertEquals(false, queue.isEmpty());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        Assert.assertEquals(true, queue.isEmpty());
    }

    @Test
    public void isFullTest() {
        Assert.assertEquals(false, queue.isFull());

        queue.enqueue(59);
        queue.enqueue(41);
        queue.enqueue(55);
        queue.enqueue(2);
        queue.enqueue(12);
        queue.enqueue(77);
        queue.enqueue(3);

        Assert.assertEquals(true, queue.isFull());
    }

}
