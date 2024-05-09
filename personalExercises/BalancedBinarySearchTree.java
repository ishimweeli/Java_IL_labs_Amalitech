package personalExercises;

public class BalancedBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Use the outer class name to access the nested static class
    public static class BalancedBST {
        private TreeNode root;

        public BalancedBST() {
            this.root = null;
        }

        public void insert(int val) {
            root = insertRecursive(root, val);
        }

        private TreeNode insertRecursive(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            if (val < root.val) {
                root.left = insertRecursive(root.left, val);
            } else if (val > root.val) {
                root.right = insertRecursive(root.right, val);
            }

            return root;
        }

        public boolean search(int val) {
            return searchRecursive(root, val);
        }

        private boolean searchRecursive(TreeNode root, int val) {
            if (root == null) {
                return false;
            }

            if (val == root.val) {
                return true;
            } else if (val < root.val) {
                return searchRecursive(root.left, val);
            } else {
                return searchRecursive(root.right, val);
            }
        }

        // In-order traversal to print the tree elements
        public void printInOrder() {
            printInOrderRecursive(root);
        }

        private void printInOrderRecursive(TreeNode root) {
            if (root != null) {
                printInOrderRecursive(root.left);
                System.out.print(root.val + " ");
                printInOrderRecursive(root.right);
            }
        }

    }

    public static void main(String[] args) {
        BalancedBST bst = new BalancedBST();

        // Insert elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Print the BST in-order
        System.out.println("In-order traversal of the BST:");
        bst.printInOrder();

        // Search for elements
        System.out.println("\nSearch for 40: " + bst.search(40));
        System.out.println("Search for 90: " + bst.search(90));
    }
}
