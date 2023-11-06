package Problem3;

public class AVLTree {
    private TreeNode root;

    public void add(int x) {
        root = insert(root, x);
    }

    public void remove(int x) {
        root = delete(root, x);
    }

    public boolean contains(int x) {
        return search(root, x);
    }

    public int max() {
        TreeNode maxNode = findMax(root);
        return maxNode != null ? maxNode.val : Integer.MIN_VALUE;
    }

    public int min() {
        TreeNode minNode = findMin(root);
        return minNode != null ? minNode.val : Integer.MAX_VALUE;
    }

    // Helper function to get the height of a node.
    private int height(TreeNode node) {
        return (node != null) ? Math.max(height(node.left), height(node.right)) + 1 : 0;
    }

    // Helper function to perform left rotation.
    private TreeNode leftRotate(TreeNode y) {
        TreeNode x = y.right;
        y.right = x.left;
        if (x.left != null) {
            x.left.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        x.left = y;
        y.parent = x;

        return x;
    }

    // Helper function to perform right rotation.
    private TreeNode rightRotate(TreeNode x) {
        TreeNode y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;

        return y;
    }

    // Helper function to balance the AVL tree.
    private TreeNode balance(TreeNode node) {
        int balance = getBalance(node);

        // Left Heavy
        if (balance > 1) {
            // Left-Left Case
            if (getBalance(node.left) >= 0) {
                return rightRotate(node);
            }
            // Left-Right Case
            else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        // Right Heavy
        if (balance < -1) {
            // Right-Right Case
            if (getBalance(node.right) <= 0) {
                return leftRotate(node);
            }
            // Right-Left Case
            else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    // Helper function to insert a node into the AVL tree.
    private TreeNode insert(TreeNode node, int x) {
        if (node == null) {
            return new TreeNode(x);
        }
        if (x < node.val) {
            node.left = insert(node.left, x);
        } else if (x > node.val) {
            node.right = insert(node.right, x);
        } else {
            // Duplicate value, increase the count
            node.count++;
        }

        // Update the height of the current node
        node = balance(node);

        return node;
    }

    // Helper function to delete a node from the AVL tree.
    private TreeNode delete(TreeNode node, int x) {
        if (node == null) {
            return node;
        }
        if (x < node.val) {
            node.left = delete(node.left, x);
        } else if (x > node.val) {
            node.right = delete(node.right, x);
        } else {
            if (node.count > 1) {
                // If it's a duplicate, decrement the count
                node.count--;
            } else {
                if (node.left == null || node.right == null) {
                    TreeNode temp = (node.left != null) ? node.left : node.right;
                    if (temp == null) {
                        temp = node;
                        node = null;
                    } else {
                        node = temp;
                    }
                } else {
                    TreeNode temp = findMin(node.right);
                    node.val = temp.val;
                    node.count = temp.count;
                    node.right = delete(node.right, temp.val);
                }
            }
        }

        if (node != null) {
            node = balance(node);
        }

        return node;
    }

    // Helper function to get the balance factor of a node.
    private int getBalance(TreeNode node) {
        return (node != null) ? height(node.left) - height(node.right) : 0;
    }

    // Helper function to search for an element in the AVL tree.
    private boolean search(TreeNode node, int x) {
        if (node == null) {
            return false;
        }
        if (x < node.val) {
            return search(node.left, x);
        } else if (x > node.val) {
            return search(node.right, x);
        } else {
            return true;
        }
    }

    // Helper function to find the maximum element in the AVL tree.
    private TreeNode findMax(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // Helper function to find the minimum element in the AVL tree.
    private TreeNode findMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}