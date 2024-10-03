package cluetree;

import java.util.Scanner;

public class Main {
    private class Node {
        String clue;
        Node left, right;
        
        Node(String clue) {
            this.clue = clue;
            left = right = null;
        }
    }

    private Node root;

    public Main() {
        root = null;
    }

    // Insert a clue
    public void insert(String clue) {
        root = insertRec(root, clue);
    }

    private Node insertRec(Node root, String clue) {
        if (root == null) {
            root = new Node(clue);
            return root;
        }
        if (clue.compareTo(root.clue) < 0)
            root.left = insertRec(root.left, clue);
        else if (clue.compareTo(root.clue) > 0)
            root.right = insertRec(root.right, clue);
        return root;
    }

    // In-order traversal
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.clue + " ");
            inOrderRec(root.right);
        }
    }

    // Pre-order traversal
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.clue + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Post-order traversal
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.clue + " ");
        }
    }

    // Find a specific clue
    public boolean findClue(String clue) {
        return findClueRec(root, clue);
    }

    private boolean findClueRec(Node root, String clue) {
        if (root == null) {
            return false;
        }
        if (clue.equals(root.clue)) {
            return true;
        }
        return clue.compareTo(root.clue) < 0 ? findClueRec(root.left, clue) : findClueRec(root.right, clue);
    }

    // Count total clues
    public int countClues() {
        return countCluesRec(root);
    }

    private int countCluesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countCluesRec(root.left) + countCluesRec(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main clueTree = new Main();

        // Inserting clues
        clueTree.insert("Treasure Map");
        clueTree.insert("Hidden Chamber");
        clueTree.insert("Ancient Artifact");
        clueTree.insert("Secret Passage");
        clueTree.insert("Lost City");

        // Display clues using different traversals
        System.out.println("In-order traversal:");
        clueTree.inOrder(); // Should print clues in sorted order
        System.out.println("\n");

        System.out.println("Pre-order traversal:");
        clueTree.preOrder(); // Should print clues in pre-order
        System.out.println("\n");

        System.out.println("Post-order traversal:");
        clueTree.postOrder(); // Should print clues in post-order
        System.out.println("\n");

        // Finding a specific clue
        String searchClue = "Secret Passage";
        System.out.println("Finding clue '" + searchClue + "': " + clueTree.findClue(searchClue));

        // Counting total clues
        System.out.println("Total clues in the tree: " + clueTree.countClues());

        scanner.close();
    }
}
