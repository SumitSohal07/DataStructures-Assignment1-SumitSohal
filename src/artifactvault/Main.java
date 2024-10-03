package artifactvault;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private String[] artifacts;
    private int size;

    public Main(int capacity) {
        artifacts = new String[capacity];
        size = 0;
    }

    // Add artifact
    public void addArtifact(String artifact) {
        if (size < artifacts.length) {
            artifacts[size] = artifact;
            size++;
        } else {
            System.out.println("Vault is full!");
        }
    }

    // Remove artifact by name
    public void removeArtifact(String artifact) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i].equals(artifact)) {
                artifacts[i] = artifacts[size - 1]; // Replace with last artifact
                artifacts[size - 1] = null;
                size--;
                break;
            }
        }
    }

    // Linear search
    public boolean findArtifactLinear(String artifact) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i].equals(artifact)) {
                return true;
            }
        }
        return false;
    }

    // Binary search (array should be sorted by age)
    public boolean findArtifactBinary(String artifact) {
        Arrays.sort(artifacts, 0, size);
        return Arrays.binarySearch(artifacts, 0, size, artifact) >= 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main vault = new Main(5); // Initialize vault with a capacity of 5

        // Adding artifacts
        vault.addArtifact("Ancient Vase");
        vault.addArtifact("Golden Idol");
        vault.addArtifact("Old Scroll");
        vault.addArtifact("Mysterious Stone");
        vault.addArtifact("Rare Coin");

        // Try adding one more artifact (should be full)
        vault.addArtifact("Lost Relic");

        // Displaying artifacts
        System.out.println("Artifacts in the vault:");
        for (int i = 0; i < vault.size; i++) {
            System.out.println(vault.artifacts[i]);
        }

        // Removing an artifact
        vault.removeArtifact("Golden Idol");
        System.out.println("\nAfter removing 'Golden Idol':");
        for (int i = 0; i < vault.size; i++) {
            System.out.println(vault.artifacts[i]);
        }

        // Linear search
        String searchArtifact = "Old Scroll";
        System.out.println("\nSearching for '" + searchArtifact + "' using linear search: "
                + vault.findArtifactLinear(searchArtifact));

        // Binary search (array should be sorted by age)
        Arrays.sort(vault.artifacts, 0, vault.size); // Sort before binary search
        System.out.println("Searching for '" + searchArtifact + "' using binary search: "
                + vault.findArtifactBinary(searchArtifact));

        scanner.close();
    }
}
