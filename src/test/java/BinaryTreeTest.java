import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.main.BinaryTree;

public class BinaryTreeTest {

    BinaryTree binaryTree = new BinaryTree();
    @Before
    public void setUpBefore() {
        binaryTree.insert(10);
        binaryTree.insert(6);
        binaryTree.insert(15);
        binaryTree.insert(4);
        binaryTree.insert(8);
        binaryTree.insert(7);
        binaryTree.insert(9);
        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(13);
        binaryTree.insert(12);
        binaryTree.insert(17);
        binaryTree.insert(16);
        binaryTree.insert(18);
        binaryTree.insert(19);
    }

    @After
    public void setUpAfter() {
        binaryTree.traversePreOrder();
    }

    @Test
    public void insertTest() {
        binaryTree.insert(20);
        Assert.assertEquals(18, binaryTree.totalNode());
    }

    @Test
    public void deleteIfChildrenAreNotNullTest() {
        binaryTree.delete(8);
        Assert.assertEquals(16, binaryTree.totalNode());
    }

    @Test
    public void deleteIfLeftChildIsNotNullTest() {
        binaryTree.delete(13);
        Assert.assertEquals(16, binaryTree.totalNode());
    }

    @Test
    public void deleteIfRightChildIsNotNullTest() {
        binaryTree.delete(18);
        Assert.assertEquals(16, binaryTree.totalNode());
    }

    @Test
    public void deleteIfChildrenIsNullTest() {
        binaryTree.delete(5);
        Assert.assertEquals(16, binaryTree.totalNode());
    }

    @Test
    public void valueExistTest() {
        Assert.assertEquals(true, binaryTree.valueExists(12));
        Assert.assertEquals(false, binaryTree.valueExists(69));
    }
}
