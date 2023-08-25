import java.util.Scanner;

public class CircularLL {
    public static void main(String[] args) {
        CLL ll = new CLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.printList();

        ll.addLast(4);
        ll.addLast(6);
        ll.addLast(7);
        ll.printList();
        
        ll.delete(3);
        ll.printList();
    }
}

class CLL {

    class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    Node first;
    Node last;

    // add at first in cll
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            newNode.link = newNode;
            first = newNode;
            last = newNode;

        } else {
            newNode.link = first;
            last.link = newNode;
            first = newNode;
        }
        System.out.println("Added " + data + " at the beginning.");
    }

    // add at last in cll
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            newNode.link = newNode;
            first = newNode;
            last = newNode;
            return;
        } else {
            newNode.link = first;
            last.link = newNode;
            last = newNode;
        }
        System.out.println("Added " + data + " at the end.");
    }

    // delete a node from specified position
    public void delete(int pos) {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }

        if (pos == 1) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                last.link = first.link;
                first = first.link;
            }
            System.out.println("Deleted node at position " + pos);
            return;
        }

        Node current = first;
        Node previous = null;
        int count = 1;

        while (current.link != first && count < pos) {
            previous = current;
            current = current.link;
            count++;
        }

        if (current == first) {
            System.out.println("Position out of range.");
            return;
        }

        previous.link = current.link;
        // after the above execute above line, previous will point to the next node from the given position.
        
        if (current == last) {
            last = previous;
        }
        
        System.out.println("Deleted node at position " + pos);
    }

    // print
    public void printList() {
        if (first == null) {
            System.out.println("List is empty !");
            return;
        }

        Node current = first;
        do {
            System.out.print(current.data + " -> ");
            current = current.link;
        } while (current != first);
        System.out.println(current.data); // Print a new line at the end

    }
}