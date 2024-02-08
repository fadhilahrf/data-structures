import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.main.ArrayList;

import java.util.Arrays;

public class ArrayListTest {

    ArrayList<Integer> arrayList;

    @After
    public void setUpAfter() {
        System.out.println(Arrays.toString(arrayList.toArray()));
    }

    @Test
    public void addTest() {
        arrayList = new ArrayList<>();

        arrayList.add(1);
        Assert.assertEquals(1, arrayList.size());
        arrayList.add(1);
        Assert.assertEquals(2, arrayList.size());
        arrayList.add(1);
        Assert.assertNotEquals(2, arrayList.size());
    }

    @Test
    public void addArrayTest() {
        Integer[] a = {1,2,3,4,5};
        arrayList = new ArrayList<>(a);

        Assert.assertEquals(5, arrayList.size());
    }

    @Test
    public void getTest() {
        arrayList = new ArrayList<>();

        arrayList.add(1);
        Assert.assertEquals(Integer.valueOf(1), arrayList.get(0));
        arrayList.add(2);
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(1));
        arrayList.add(3);
        Assert.assertNotEquals(Integer.valueOf(2), arrayList.get(2));
    }

    @Test
    public void setTest() {
        Integer[] a = {1,2,3,4,5};
        arrayList = new ArrayList<>(a);
        arrayList.set(0, 66);
        Assert.assertEquals(Integer.valueOf(66), arrayList.get(0));
    }

    @Test
    public void removeTest() {
        arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        arrayList.remove(1);

        Assert.assertEquals(2, arrayList.size());
        Assert.assertEquals(Integer.valueOf(1), arrayList.get(0));
        Assert.assertEquals(Integer.valueOf(3), arrayList.get(1));
    }

}
