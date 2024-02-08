package org.main;

public class BinaryTree {
    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    private Node root;

    private int totalNode = 0;

    public void insert(int value) {
        Node newNode = new Node(value);

        if(root == null) {
            root = newNode;
        }else {
            Node current = root;
            Node prevNode = current;
            while(current!=null) {
                prevNode = current;
                if(value<current.value) {
                    current = current.left;
                }else if(value>current.value) {
                    current = current.right;
                }else if(value==current.value) {
                    return;
                }
            }
            current = newNode;
            if(value<prevNode.value) {
                prevNode.left = current;
            }else if(value>prevNode.value) {
                prevNode.right = current;
            }
        }
        totalNode++;
    }

    public void delete(int value) {
        Node current = root;
        Node prevNode = current;
        while(current!=null) {
            if(value<current.value) {
                prevNode = current;
                current = current.left;
            }else if(value>current.value) {
                prevNode = current;
                current = current.right;
            }else if(value==current.value) {
                if(current.left!=null && current.right!=null) {
                    if(current.value<prevNode.value){
                        Node tempNode = current.left;
                        prevNode.left = current.right;
                        Node tempCurrent = prevNode.left;
                        Node prevTempCurrent = tempCurrent;
                        while(tempCurrent!=null) {
                            prevTempCurrent = tempCurrent;
                            if(tempNode.value<tempCurrent.value) {
                                tempCurrent = tempCurrent.left;
                            }else if(tempNode.value>tempCurrent.value) {
                                tempCurrent = tempCurrent.right;
                            }
                        }
                        if(tempNode.value<prevTempCurrent.value) {
                            prevTempCurrent.left = tempNode;
                        }else if(tempNode.value>prevTempCurrent.value) {
                            prevTempCurrent.right = tempNode;
                        }
                    }else if(current.value>prevNode.value){
                        Node tempNode = current.right;
                        prevNode.right = current.left;
                        Node tempCurrent = prevNode.right;
                        Node prevTempCurrent = tempCurrent;
                        while(tempCurrent!=null) {
                            prevTempCurrent = tempCurrent;
                            if(tempNode.value<tempCurrent.value) {
                                tempCurrent = tempCurrent.left;
                            }else if(tempNode.value>tempCurrent.value) {
                                tempCurrent = tempCurrent.right;
                            }
                        }
                        if(tempNode.value<prevTempCurrent.value) {
                            prevTempCurrent.left = tempNode;
                        }else if(tempNode.value>prevTempCurrent.value) {
                            prevTempCurrent.right = tempNode;
                        }
                    }
                }else if(current.left!=null){
                    if(current.value<prevNode.value){
                        prevNode.left = current.left;
                    }else if(current.value>prevNode.value){
                        prevNode.right = current.left;
                    }
                }else if(current.right!=null){
                    if(current.value<prevNode.value){
                        prevNode.left = current.right;
                    }else if(current.value>prevNode.value){
                        prevNode.right = current.right;
                    }
                }else if(current.left==null && current.right==null){
                    if(current.value<prevNode.value){
                        prevNode.left = null;
                    }else if(current.value>prevNode.value){
                        prevNode.right = null;
                    }
                }
                totalNode--;
                break;
            }
        }
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

    public int totalNode() {
        return totalNode;
    }
}
