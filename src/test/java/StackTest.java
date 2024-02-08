import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.main.Stack;

import java.util.Arrays;

public class StackTest {
    Stack<Integer> stack;
    @Before
    public void setUpBefore() {
        stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(7);
    }

    @After
    public void setUpAfter() {
        System.out.println(Arrays.toString(stack.toArray()));
    }
    @Test
    public void pushTest() {
        stack.push(3);

        Assert.assertEquals(Integer.valueOf(3), stack.peek());
    }

    @Test
    public void popTest() {
        stack.push(3);
        stack.push(89);
        stack.push(38);

        stack.pop();

        Assert.assertEquals(Integer.valueOf(89), stack.peek());
        Assert.assertEquals(Integer.valueOf(89), stack.pop());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertEquals(false, stack.isEmpty());

        stack.pop();
        stack.pop();
        stack.pop();

        Assert.assertEquals(true, stack.isEmpty());
    }

    @Test
    public void isFullTest() {
        Assert.assertEquals(false, stack.isFull());

        stack.push(10);
        stack.push(32);
        stack.push(24);
        stack.push(63);
        stack.push(86);
        stack.push(67);
        stack.push(62);

        Assert.assertEquals(true, stack.isFull());
    }

}
