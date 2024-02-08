import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.main.AVLTree;

public class AVLTreeTest {
    
    AVLTree avlTree = new AVLTree();
    
    @Before
    public void setUp() {
        avlTree.insert(10);
        avlTree.insert(6);
        avlTree.insert(15);
        avlTree.insert(4);
        avlTree.insert(8);
        avlTree.insert(7);
        avlTree.insert(9);
        avlTree.insert(5);
        avlTree.insert(2);
        avlTree.insert(1);
        avlTree.insert(3);
        avlTree.insert(13);
        avlTree.insert(12);
        avlTree.insert(17);
        avlTree.insert(16);
        avlTree.insert(18);
        avlTree.insert(19);
    }

    @After
    public void setUpAfter() {
        avlTree.traversePreOrder();
    }

    @Test
    public void insertTest() {
        avlTree.insert(20);
        Assert.assertEquals(18, avlTree.totalNode());
        Assert.assertEquals(true, avlTree.isBalanced());
    }

    @Test
    public void deleteTest() {
        avlTree.delete(15);
        Assert.assertEquals(16, avlTree.totalNode());
        Assert.assertEquals(true, avlTree.isBalanced());
    }

}
