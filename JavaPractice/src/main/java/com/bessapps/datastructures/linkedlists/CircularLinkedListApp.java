package com.bessapps.datastructures.linkedlists;

class CircularList {

    int nodeCount = 0;
    List root = null;
    List tail = null;

    class List {
        int data;
        List next;
        List prev;

        public List(int data, List next, List prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public List getRoot() {
        return root;
    }

    public List getTail() {
        return tail;
    }

    // Adding means it adds to the Tail
    public void add(int val) {
        if(tail == null) {
            root = tail = new List(val, null, null);
        } else {
            tail.next = new List(val, null, tail);
            tail = tail.next;
        }
    }

    public void addFist(int val) {
        if(root == null) {
            add(val);
        } else {
            root = new List(val, root, null);
            root.next.prev = root;
        }
    }

    public void printList() {
        System.out.print("Printing the List forward: ");
        printList(root);
        System.out.println();
    }
    private void printList(List current) {
        if(current == null) {
            return;
        } else {
            System.out.print(current.data + " ");
            printList(current.next);
        }
    }

    public void printListBackWords() {
        System.out.print("Printing the List backward: ");
        printListBack(tail);
        System.out.println();
    }
    private void printListBack(List cur) {
        //Print in reverse
        if(cur == null) {
            return;
        } else {
            System.out.print(cur.data + " ");
            printListBack(cur.prev);
        }
    }
}

public class CircularLinkedListApp {
    public static void main(String[] args) {
        CircularList cList = new CircularList();

        cList.add(1000);
        cList.add(900);
        cList.add(300);
        cList.add(9240);
        cList.add(210);
        cList.add(10);
        cList.add(230);
        cList.printList();
        cList.addFist(555);
        cList.add(777);
        cList.printList();
        cList.addFist(304);

        cList.printList();
        cList.printListBackWords();

        System.out.println(cList.getRoot().data);
        System.out.println(cList.getTail().data);
    }
}
