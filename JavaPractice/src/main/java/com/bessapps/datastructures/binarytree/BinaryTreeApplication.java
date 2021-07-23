package com.bessapps.datastructures.binarytree;

class BinaryTree {
    Node root;
    int nodeCount = 0;

    class Node {
        int data;
        Node left;
        Node right;


        public Node(int data, Node left, Node right) {
            this.left = left;
            this.right = right;
            nodeCount++;
        }
    }

    //Inserting / Adding a node
    public void insetNode(int data) {
        root = insertNode_p(root, data);
    }

    private Node insertNode_p(Node current, int data) {
        if(current == null) {
            current = new Node(data, null, null);
        } else {
            if(data < current.data) {
                current.left = insertNode_p(current.left, data);
            } else if (data < current.data) {
                current.right = insertNode_p(current.right, data);
            } else {
                return current;
            }
        }
        return current;
    }

    //Inordr Printing for time being
    public void printBinaryTree() {
        printBinaryTree(root);
    }

    private void printBinaryTree(Node current) {
        if(current ==  null) return;
        printBinaryTree(current.left);
        System.out.println(current.data);
        printBinaryTree(current.right);
    }
}

public class BinaryTreeApplication {
    public static void main(String args[]) {
        /*
        BinaryTree<String> binaryTree = new BinaryTree<>();
        binaryTree.insetNode("Saladi");
        binaryTree.insetNode("Ravi");
        binaryTree.insetNode("Ania");
        binaryTree.printBinaryTree();

         */

        BinaryTree bTree = new BinaryTree();
        bTree.insetNode(10);
    }
}

