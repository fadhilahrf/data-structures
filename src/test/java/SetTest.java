import org.junit.Assert;
import org.junit.Test;
import org.main.Set;

import java.util.Arrays;

public class SetTest {

    @Test
    public void addTest() {
        Set<Integer> set = new Set<>();

        set.add(5);
        set.add(5);
        set.add(6);

        Assert.assertEquals(2, set.size());

        System.out.println(Arrays.toString(set.toArray()));
    }
    @Test
    public void removeTest() {
        Integer[] a = { 1,1,2,5,6,3,4 };
        Set<Integer> set = new Set<>(a);

        Assert.assertEquals(6, set.size());

        set.remove(5);

        Assert.assertEquals(5, set.size());

        System.out.println(Arrays.toString(set.toArray()));
    }

    @Test
    public void containsTest() {
        Integer[] a = { 1,1,2,5,6,3,4 };
        Set<Integer> set = new Set<>(a);

        Assert.assertEquals(6, set.size());

        set.remove(5);

        Assert.assertEquals(true, set.contains(1));
        Assert.assertEquals(false, set.contains(5));

        System.out.println(Arrays.toString(set.toArray()));
    }

}
