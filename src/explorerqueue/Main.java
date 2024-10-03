package explorerqueue;

import java.util.Scanner;

public class Main {
    private String[] queue;
    private int front, rear, size, capacity;

    public Main(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue explorer
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = explorer;
            size++;
            System.out.println(explorer + " has entered the queue.");
        }
    }

    // Dequeue explorer
    public String dequeue() {
        if (isEmpty()) {
            return "Queue is empty!";
        } else {
            String explorer = queue[front];
            front = (front + 1) % capacity;
            size--;
            return explorer + " has entered the temple.";
        }
    }

    // Display next explorer
    public String nextExplorer() {
        return isEmpty() ? "No explorers in line!" : queue[front];
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main explorerQueue = new Main(5); // Initialize queue with a capacity of 5

        // Enqueuing explorers
        explorerQueue.enqueue("Explorer 1");
        explorerQueue.enqueue("Explorer 2");
        explorerQueue.enqueue("Explorer 3");
        explorerQueue.enqueue("Explorer 4");
        explorerQueue.enqueue("Explorer 5");

        // Try to enqueue one more explorer (should be full)
        explorerQueue.enqueue("Explorer 6");

        // Display next explorer
        System.out.println("\nNext explorer in line: " + explorerQueue.nextExplorer());

        // Dequeue explorers and display the result
        System.out.println("\nDequeueing explorers:");
        System.out.println(explorerQueue.dequeue());
        System.out.println(explorerQueue.dequeue());
        
        // Check next explorer after dequeuing
        System.out.println("Next explorer in line: " + explorerQueue.nextExplorer());

        // Enqueue a new explorer after some have exited
        explorerQueue.enqueue("Explorer 7");
        
        // Display the state of the queue
        System.out.println("\nNext explorer in line: " + explorerQueue.nextExplorer());

        // Check if queue is full or empty
        System.out.println("Is the queue full? " + explorerQueue.isFull());
        System.out.println("Is the queue empty? " + explorerQueue.isEmpty());

        scanner.close();
    }
}
