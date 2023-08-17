package org.example.leetcode.intrv;

public class LinkedList {
    Node head;
    Node last;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    void printMiddle() {
        if (head == null || head.next == null)
            return;
        Node slow_ptr = head;
        Node fast_ptr = head.next;
        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        System.out.println("The middle element is [" + slow_ptr.data + "] \n");
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null)
            head = newNode;
        else
            last.next = newNode;

        last = newNode;
    }

    public void printList(Node tnode) {

        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public Node reverseList(Node current) {
        Node prev = null;
        Node nxt = null;
        while (current != null) {
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        for (int i = 1; i < 6; ++i) {
            llist.push(i);
        }
        Node root = llist.head;
        llist.printList(root);
        llist.printMiddle();
        llist.printList(root = llist.reverseList(root));
        llist.printList(root);
    }
}
