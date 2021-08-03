package com.bessapps.datastructures.binarytree;

class Node {
    int key;
    int height;
    Node left;
    Node right;

    public Node(int k, int h, Node le, Node ri) {
        key = k;
        height = h;
        left = le;
        right = ri;
    }
}

public class MyAVLTree {
    private Node root;

    public void updateHeight(Node n) {
        n.height = Math.max(height(n.left), height(n.right));
    }

    public int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    void getNodeWithKey(int k) {
        getNodeWithKey(root, k);
    }

    void getNodeWithKey(Node current, int k) {
        if(current == null) return;
        else {
            if(k < current.key) getNodeWithKey(current.left, k);
            else if(k > current.key) getNodeWithKey(current.right, k);
            else {
                System.out.println("Found it..." + current.key);
            }
        }
    }

    public void rightRotation(int k) {
        getNodeWithKey(k);
    }

    Node rightRotation(Node n) {
        Node x = n.left;
        Node y = x.right;
        x.right = y;
        n.left = y;
        updateHeight(n);
        updateHeight(x);
        return x;
    }

    public void printTree() {
        printTree(root);
        System.out.println();
    }

    private void printTree(Node current) {
        if(current == null) return;
        else {

            printTree(current.left);
            System.out.print(current.key + " ");
            printTree(current.right);

        }
    }

    public void insert(int k) {
        root = insert(root, k);
    }

    private Node insert(Node current, int k) {
        if(current ==  null) {
            current = new Node(k, 0, null, null);
        } else {
            if(k < current.key) {
                current.left = insert(current.left, k);
            } else if(k > current.key) {
                current.right = insert(current.right, k);
            }
        }
        return current;
    }
}

class AVLTreeApplication {
    public static void main(String args[]) {
        MyAVLTree avlTree = new MyAVLTree();

        avlTree.insert(30);
        avlTree.insert(10);
        avlTree.insert(55);
        avlTree.insert(15);
        avlTree.insert(20);
        avlTree.insert(40);
        avlTree.insert(25);
        avlTree.insert(35);
        avlTree.insert(45);
        avlTree.insert(5);
        avlTree.insert(50);
        avlTree.insert(60);
        avlTree.printTree();

        avlTree.rightRotation(52);

    }
}
