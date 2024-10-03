package scrollstack;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private Stack<String> stack;

    public Main() {
        stack = new Stack<>();
    }

    // Push scroll
    public void pushScroll(String scroll) {
        stack.push(scroll);
    }

    // Pop scroll
    public String popScroll() {
        return stack.isEmpty() ? "No scrolls left!" : stack.pop();
    }

    // Peek scroll
    public String peekScroll() {
        return stack.isEmpty() ? "No scrolls in stack!" : stack.peek();
    }

    // Check if scroll exists
    public boolean scrollExists(String scroll) {
        return stack.contains(scroll);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main scrollStack = new Main();

        // Adding scrolls to the stack
        scrollStack.pushScroll("Scroll of Wisdom");
        scrollStack.pushScroll("Scroll of Time");
        scrollStack.pushScroll("Scroll of Secrets");

        // Peek at the top scroll
        System.out.println("Top scroll: " + scrollStack.peekScroll());

        // Check if a specific scroll exists
        String searchScroll = "Scroll of Time";
        System.out.println("Does '" + searchScroll + "' exist in the stack? " + scrollStack.scrollExists(searchScroll));

        // Pop a scroll off the stack
        System.out.println("Popping scroll: " + scrollStack.popScroll());

        // Peek again after popping
        System.out.println("Top scroll after popping: " + scrollStack.peekScroll());

        // Pop remaining scrolls
        scrollStack.popScroll(); // Remove another scroll
        scrollStack.popScroll(); // Remove last scroll
        System.out.println("Popping from empty stack: " + scrollStack.popScroll()); // Should indicate no scrolls left

        // Closing scanner
        scanner.close();
    }
}
