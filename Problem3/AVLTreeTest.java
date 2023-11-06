package Problem3;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        // Test adding elements
        avlTree.add(10);
        avlTree.add(20);
        avlTree.add(5);
        avlTree.add(10); // Duplicate
        avlTree.add(25);
        avlTree.add(15);

        // Test contains function
        System.out.println("Contains 15: " + avlTree.contains(15)); // Should be true
        System.out.println("Contains 30: " + avlTree.contains(30)); // Should be false

        // Test max and min functions
        System.out.println("Max: " + avlTree.max()); // Should be 25
        System.out.println("Min: " + avlTree.min()); // Should be 5

        // Test removing elements
        avlTree.remove(10);
        avlTree.remove(30); // Trying to remove a non-existing element

        // Test contains function after removal
        System.out.println("Contains 10: " + avlTree.contains(10)); // Should be true
        System.out.println("Contains 30: " + avlTree.contains(30)); // Should be false

        // Test max and min functions after removal
        System.out.println("Max: " + avlTree.max()); // Should be 25
        System.out.println("Min: " + avlTree.min()); // Should be 5
    }
}
