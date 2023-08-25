import java.util.Scanner;

class CircularQueue {
    private int capacity;
    private int front, rear;
    private String[] queue;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.queue = new String[capacity];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == capacity - 1) || (rear == front - 1);
    }

    public void enqueue(String item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (rear == capacity - 1 && front != 0) {
                rear = 0;
            } else {
                rear++;
            }
            queue[rear] = item;
            System.out.println("Enqueued: " + item);
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
        } else {
            System.out.println("Dequeued: " + queue[front]);
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (front == capacity - 1) {
                front = 0;
            } else {
                front++;
            }
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            int i = front;
            if (front <= rear) {
                while (i <= rear) {
                    System.out.print(queue[i] + " ");
                    i++;
                }
            } else {
                while (i < capacity) {
                    System.out.print(queue[i] + " ");
                    i++;
                }
                i = 0;
                while (i <= rear) {
                    System.out.print(queue[i] + " ");
                    i++;
                }
            }
            System.out.println();
        }
    }
}

public class CircularQueueMenuDriven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the circular queue: ");
        int capacity = scanner.nextInt();
        CircularQueue cq = new CircularQueue(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    String item = scanner.next();
                    cq.enqueue(item);
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    cq.display();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
