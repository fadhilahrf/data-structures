import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.main.SingleLinkedList;

import java.util.Arrays;

public class SingleLinkedListTest {
    SingleLinkedList<Integer> singleLinkedList;

    @After
    public void setUpAfter() {
        System.out.println(Arrays.toString(singleLinkedList.toArray()));
    }

    @Test
    public void insertTest() {
        singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.insert(1);
        Assert.assertEquals(1, singleLinkedList.size());
        singleLinkedList.insert(2);
        Assert.assertEquals(2, singleLinkedList.size());
        singleLinkedList.insert(3);
        Assert.assertEquals(3, singleLinkedList.size());
    }

    @Test
    public void insertArrayTest() {
        Integer[] a = {2,3,4,5};
        singleLinkedList = new SingleLinkedList<>(a);
        Assert.assertEquals(4, singleLinkedList.size());
    }

    @Test
    public void insertAfterTest() {
        Integer[] a = {2,3,4,5};
        singleLinkedList = new SingleLinkedList<>(a);
        singleLinkedList.insertAfter(2, 6);

        Assert.assertEquals(5, singleLinkedList.size());

        Assert.assertEquals(Integer.valueOf(6), singleLinkedList.get(3));
    }

    @Test
    public void removeTest() {
        Integer[] a = {2,3,4,5,6};
        singleLinkedList = new SingleLinkedList<>(a);
        singleLinkedList.remove(1);

        Assert.assertEquals(4, singleLinkedList.size());
    }

    @Test
    public void getTest() {
        Integer[] a = {21,34,45,51};
        singleLinkedList = new SingleLinkedList<>(a);

        Assert.assertEquals(Integer.valueOf(34), singleLinkedList.get(1));
    }

    @Test
    public void setTest() {
        Integer[] a = {2,3,4,5};
        singleLinkedList = new SingleLinkedList<>(a);

        singleLinkedList.set(2,5);
        Assert.assertEquals(Integer.valueOf(5), singleLinkedList.get(2));

        singleLinkedList.set(0,66);
        Assert.assertEquals(Integer.valueOf(66), singleLinkedList.get(0));
    }
}
