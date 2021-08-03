package com.bessapps.datastructures.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTreeApplication {
    public static void main(String args[]) {

        Random rand = new Random();

        BinaryTree bTree = new BinaryTree();
        /*
        for(int i = 0; i < 20; i++) {
            int x = rand.nextInt(100);
            System.out.print(x + " ");
            bTree.insetNode(x);
        }
        */

        int[] arr = {34, 49, 11, 28, 98, 20, 41, 38, 80, 17};
        for(int x: arr) bTree.insetNode(x);

        System.out.println();
        System.out.println("Root: " + bTree.getRoot().data);
        //bTree.print_node();

        System.out.println("Breadth First search.. ");
        bTree.searchBreadthFirst();
        bTree.breadethFirstLevelSumAverage();
        System.out.println("Total nodes: " + bTree.getNodeCount());

        bTree.delete_node(49);

        System.out.println();
        System.out.println("Root: " + bTree.getRoot().data);
        //bTree.print_node();

        System.out.println("Breadth First search.. ");
        bTree.searchBreadthFirst();
        bTree.breadethFirstLevelSumAverage();
        System.out.println("Total nodes: " + bTree.getNodeCount());

        bTree.delete_node(80);

        System.out.println();
        System.out.println("Root: " + bTree.getRoot().data);
        //bTree.print_node();

        System.out.println("Breadth First search.. ");
        bTree.searchBreadthFirst();
        bTree.breadethFirstLevelSumAverage();
        System.out.println("Total nodes: " + bTree.getNodeCount());
    }
}

class BinaryTree {
    Node root;
    int nodeCount = 0;

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
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
            } else if (data > current.data) {
                current.right = insertNode_p(current.right, data);
            }
        }
        return current;
    }

    //Inordr Printing for time being
    public void print_node() {

        System.out.println("-----------------------------------------");
        // Print in pre order
        System.out.println("Pre order...");
        print_node_preorder(root);
        System.out.println();

        // Print in Asending order
        System.out.println("Inorder order...");
        print_node_inorder(root);
        System.out.println();

        // Print in post order
        System.out.println("Post order...");
        print_node_postorder(root);
        System.out.println();

        System.out.println("-----------------------------------------");

    }

    private void print_node_inorder(Node cur) {
        if(cur == null) return;
        else {
            print_node_inorder(cur.left);
            System.out.print(cur.data + " ");
            print_node_inorder(cur.right);
        }
    }

    // post order
    private void print_node_postorder(Node cur) {
        if(cur == null) return;
        else {
            print_node_postorder(cur.left);
            print_node_postorder(cur.right);
            System.out.print(cur.data + " ");

        }
    }

    // pre order
    private void print_node_preorder(Node cur) {
        if(cur == null) return;
        else {
            System.out.print(cur.data + " ");
            print_node_preorder(cur.left);
            print_node_preorder(cur.right);

        }
    }

    public Node getRoot() {
        return root;
    }

    // Breadth First traversal
    public void searchBreadthFirst() {
        if(root == null) return;
        Queue<Node> tQueue = new LinkedList<>();
        tQueue.add(root);

        while(!tQueue.isEmpty()) {
            Node temp = tQueue.poll();
            if(temp.left != null) tQueue.add(temp.left);
            if(temp.right != null) tQueue.add(temp.right);
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public void breadethFirstLevelSumAverage() {

        Queue<Node> myQueue = new LinkedList<>();
        myQueue.add(root);

        while(!myQueue.isEmpty()) {
            int count = myQueue.size();
            int sum = 0;
            int averageCount = count;

            while(count-- > 0) {
                Node temp = myQueue.poll();
                if(temp.left != null) myQueue.add(temp.left);
                if(temp.right != null) myQueue.add(temp.right);
                System.out.print("( " + temp.data + " ) ");
                sum += temp.data;
            }

            System.out.println("Sum by level: " + sum);
            System.out.println("Average Count (" + averageCount + ") " + sum/averageCount);

        }

    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void delete_node(int data) {
        root = delete_node(root, data);
    }

    private Node delete_node(Node cur, int data) {
        if(cur == null) return null;
        else if( data < cur.data ) {
            cur.left = delete_node(cur.left, data);
        } else if(data > cur.data) {
            cur.right = delete_node(cur.right, data);
        } else {
            // If data is equal case
            // If no children
            if(cur.left == null && cur.right == null) return null;
            // if only one child is null..
            if(cur.left == null) return cur.right;
            if(cur.right == null) return cur.left;

            // if both are not null,
            // find the smallest value..
            int smallestValue = findSmallestValue(cur.right);
            cur.data = smallestValue;
            cur.right = delete_node(cur.right, smallestValue);

        }
        return cur;
    }

    private int findSmallestValue(Node cur) {
        return cur.left == null ? cur.data : findSmallestValue(cur.left);
    }

}

