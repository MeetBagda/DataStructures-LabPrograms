import java.util.Scanner;

class Queue {
    private int capacity;
    private int front, rear;
    private String[] queue;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.queue = new String[capacity];
    }

    public boolean isEmpty() {
        return rear < front;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public void enqueue(String item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            queue[++rear] = item;
            System.out.println("Enqueued: " + item);
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
        } else {
            System.out.println("Dequeued: " + queue[front++]);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

public class QueueMenuDriven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        Queue q = new Queue(capacity);

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
                    q.enqueue(item);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
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
