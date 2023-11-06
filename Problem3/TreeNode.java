package Problem3;

class TreeNode {
    int val;
    int count; // To keep track of duplicate elements
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
        this.count = 1;
    }
}

