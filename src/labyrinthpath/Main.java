package labyrinthpath;

import java.util.Scanner;

public class Main {
    private Node head;

    private class Node {
        String location;
        Node next;

        Node(String location) {
            this.location = location;
            this.next = null;
        }
    }

    // Add new location
    public void addLocation(String location) {
        Node newNode = new Node(location);
        newNode.next = head;
        head = newNode;
    }

    // Remove last visited location
    public void removeLastLocation() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("No locations to remove!");
        }
    }

    // Check if path contains a loop
    public boolean containsLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Print entire path
    public void printPath() {
        Node current = head;
        while (current != null) {
            System.out.print(current.location + " -> ");
            current = current.next;
        }
        System.out.println("End");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main labyrinthPath = new Main();

        // Adding locations
        labyrinthPath.addLocation("Start");
        labyrinthPath.addLocation("Room 1");
        labyrinthPath.addLocation("Room 2");
        labyrinthPath.addLocation("Room 3");

        // Print current path
        System.out.println("Current path:");
        labyrinthPath.printPath();

        // Check for loop
        System.out.println("Does the path contain a loop? " + labyrinthPath.containsLoop());

        // Remove the last visited location
        labyrinthPath.removeLastLocation();
        System.out.println("Path after removing the last location:");
        labyrinthPath.printPath();

        // Try to remove from an empty path
        labyrinthPath.removeLastLocation();
        labyrinthPath.removeLastLocation();
        labyrinthPath.removeLastLocation(); // This should empty the path
        labyrinthPath.removeLastLocation(); // This should indicate no locations

        // Final path
        System.out.println("Final path:");
        labyrinthPath.printPath();

        // Check for loop again
        System.out.println("Does the path contain a loop? " + labyrinthPath.containsLoop());

        scanner.close();
    }
}
