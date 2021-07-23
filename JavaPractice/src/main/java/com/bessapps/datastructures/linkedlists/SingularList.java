package com.bessapps.datastructures.linkedlists;

public class SingularList {

    List root = null;
    int index = 0;

    class List {
        int data;
        List next;

        public List(int data) {
            next = null;
            this.data = data;
        }

        public List(List next, int data) {
            this.next = next;
            this.data = data;
        }
    }

    public int getIndex() {
        return index;
    }

    public void insert(int val) {
        root = insert(root, val);
        index++;
    }
    private List insert(List cur, int val) {
        if(cur == null) {
            cur = new List(val);
        } else {
            cur.next = insert(cur.next, val);
        }
        return cur;
    }

    public void printNode(String msg) {
        System.out.print(msg);
        printNode(root);
        System.out.println();
    }

    private void printNode(List cur) {
        if(cur == null) {
            return;
        } else {
            System.out.print(cur.data + " ");
            printNode(cur.next);
        }
    }

    public void insertFirst(int val) {
        root = new List(root, val);
        index++;
    }

    public void removeLast() {
        root = removeLast(root);
    }

    public List removeLast(List cur) {
        if(cur.next ==  null) {
            cur = null;
            index--;
        } else {
            cur.next = removeLast(cur.next);
        }
        return cur;
    }

    public void removeFist() {
        root = root.next;
        index--;
    }

    public boolean isEmpty() {
        if(index == 0) return true;
        else return false;
    }

    public void remove(int val) {
        removeRecursive(root, val);
    }
    // Recursive way..
    private void removeRecursive(List cur, int val) {
        if (cur == null) {
            return;
        } else {
            if (cur.next != null) {
                if (cur.next.data == val) {
                    cur = cur.next.next;
                    return;
                } else {
                    removeRecursive(cur.next, val);
                }
            }
        }
    }

}

class SingularListApp {
    public static void main(String[] args) {
        SingularList sList = new SingularList();

        if(sList.isEmpty()) {
            System.out.println("It is an empty list...");
        } else {
            System.out.println("It is not an empty list...");
        }

        sList.insert(20);
        sList.insert(345);
        sList.insert(235);
        sList.insert(23);
        sList.insert(3);
        sList.insert(54);
        sList.insertFirst(100);
        sList.insert(32);
        sList.printNode("List : ");
        System.out.println("Total nodes in the List: " + sList.getIndex());

        /*
        sList.removeLast();
        sList.removeLast();
        sList.removeLast();
        sList.printNode("Ater removing last : ");
        System.out.println("Total nodes in the List: " + sList.getIndex());

        sList.removeFist();
        sList.removeFist();
        sList.printNode("Ater removing first : ");
        System.out.println("Total nodes in the List: " + sList.getIndex());

        if(sList.isEmpty()) {
            System.out.println("It is an empty list...");
        } else {
            System.out.println("It is not an empty list...");
        }
        */

        sList.remove(345);
        sList.printNode("Ater removing mid : ");
        System.out.println("Total nodes in the List: " + sList.getIndex());

    }
}
