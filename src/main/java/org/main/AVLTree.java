package org.main;

public class AVLTree {
    class Node {
        int value;

        int height;
        Node left;
        Node right;

        Node parent;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
            parent = null;
            height = 1;
        }
    }

    Node root;

    int totalNode = 0;

    private int height(Node node) {
        return node==null ? 0 : node.height;
    }

    private void updateHeight(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    int getBalance(Node node) {
        return node == null ? 0 : height(node.right) - height(node.left);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node z = x.right;

        x.right = y;
        y.left = z;

        updateHeight(y);
        updateHeight(x);
//        y.height = Math.max(height(y.left), height(y.right)) + 1;
//        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node z = y.left;

        y.left = x;
        x.right = z;

        updateHeight(x);
        updateHeight(y);
//        x.height = Math.max(height(x.left), height(x.right)) + 1;
//        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private Node rebalance(Node current) {
        updateHeight(current);
        int balance = getBalance(current);
        if (balance > 1) {
            if (height(current.right.right) > height(current.right.left)) {
                current = leftRotate(current);
            } else {
                current.right = rightRotate(current.right);
                current = leftRotate(current);
            }
        } else if (balance < -1) {
            if (height(current.left.left) > height(current.left.right))
                current = rightRotate(current);
            else {
                current.left = leftRotate(current.left);
                current = rightRotate(current);
            }
        }
        return current;
    }

    private Node insert(Node current, int value) {

        if (current == null){
            totalNode++;
            return new Node(value);
        }else if (value < current.value) {
            current.left = insert(current.left, value);
        }else if (value > current.value){
            current.right = insert(current.right, value);
        }
        else{
            return current;
        }

        return rebalance(current);
    }


    public void insert(int value) {
        root = insert(root, value);
    }

    private Node findSmallestNode(Node current){
        return root.left != null ? findSmallestNode(root.left) : root;
    }

    private Node delete(Node current, int value) {
        if (current == null) {
            return current;
        } else if(current.value==value) {
            if (current.left == null || current.right == null) {
                current = (current.left == null) ? current.right : current.left;
            } else {
                Node smallestChild = findSmallestNode(current.right);
                current.value = smallestChild.value;
                current.right = delete(current.right, current.value);
            }
            totalNode--;
        } else if (current.value > value) {
            current.left = delete(current.left, value);
        } else if (current.value < value) {
            current.right = delete(current.right, value);
        }
        if (current != null) {
            current = rebalance(current);
        }
        return current;
    }

    public void delete(int value) {
        root = delete(root, value);
    }
    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    private void traversePostOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public boolean valueExists(int value) {
        Node current = root;
        while(current!=null) {
            if(value<current.value) {
                current = current.left;
            }else if(value>current.value) {
                current = current.right;
            }else if(value==current.value) {
                return true;
            }
        }

        return false;
    }

    private boolean isBalanced(Node node)
    {
        int lh;

        int rh;

        if (node == null)
            return true;

        lh = height(node.left);
        rh = height(node.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(node.left)
                && isBalanced(node.right))
            return true;

        return false;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    public int totalNode() {
        return totalNode;
    }
}
