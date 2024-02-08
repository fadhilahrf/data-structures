import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.main.Heap;

import java.util.Arrays;

public class HeapTest {

    Heap heap;

    @Before
    public void setUpBefore() {

    }

    @After
    public void setUpAfter() {
        System.out.println(Arrays.toString(heap.toArray()));
    }

    @Test
    public void insertMaxHeapTest() {
        heap = new Heap(Heap.MAX);

        heap.insert(5);
        heap.insert(4);
        heap.insert(6);
        heap.insert(9);
        heap.insert(2);
        heap.insert(3);

        Assert.assertEquals(6, heap.totalNode());
    }

    @Test
    public void insertMinHeapTest() {
        heap = new Heap(Heap.MIN);

        heap.insert(5);
        heap.insert(4);
        heap.insert(6);
        heap.insert(9);
        heap.insert(2);
        heap.insert(3);

        Assert.assertEquals(6, heap.totalNode());
    }

    @Test
    public void deleteMaxHeapTest() {
        heap = new Heap(Heap.MAX);

        heap.insert(5);
        heap.insert(4);
        heap.insert(6);
        heap.insert(9);
        heap.insert(2);
        heap.insert(3);

        heap.delete(3);

        Assert.assertEquals(5, heap.totalNode());
    }

    @Test
    public void deleteMinHeapTest() {
        heap = new Heap(Heap.MIN);

        heap.insert(5);
        heap.insert(4);
        heap.insert(6);
        heap.insert(9);
        heap.insert(2);
        heap.insert(3);

        heap.delete(4);

        Assert.assertEquals(5, heap.totalNode());
    }

}
