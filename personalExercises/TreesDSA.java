package personalExercises;

public class TreesDSA {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        Node search(Node root, int item) {
            // Base case: if the root is null or the root's data matches the item, return the root
            if (root == null || root.data == item) {
                return root;
            }

            // If the item is smaller than the root's data, search in the left subtree
            if (item < root.data) {
                return search(root.left, item);
            } else { // Otherwise, search in the right subtree
                return search(root.right, item);
            }
        }

        public static void main(String[] args) {
            BinarySearchTree bst = new BinarySearchTree();

            // Create a sample Binary Search Tree
            bst.root = new Node(50);
            bst.root.left = new Node(30);
            bst.root.right = new Node(70);
            bst.root.left.left = new Node(20);
            bst.root.left.right = new Node(40);
            bst.root.right.left = new Node(60);
            bst.root.right.right = new Node(80);

            // Test cases
            Node result = bst.search(bst.root, 20);
            if (result != null) {
                System.out.println("Item found: " + result.data);
            } else {
                System.out.println("Item not found in the Binary Search Tree.");
            }

            result = bst.search(bst.root, 90);
            if (result != null) {
                System.out.println("Item found: " + result.data);
            } else {
                System.out.println("Item not found in the Binary Search Tree.");
            }
        }
    }
}
