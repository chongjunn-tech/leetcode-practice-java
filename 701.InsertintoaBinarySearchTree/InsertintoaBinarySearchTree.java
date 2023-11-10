class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){this.val=val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // empty--> the place to insert
        if (root == null) return new TreeNode(val);
        // more: go to right
        else if (val > root.val){
            root.right = insertIntoBST(root.right, val);
        }
        // less: go to left
        else if (val < root.val){
            root.left = insertIntoBST(root.left, val);
        }
        return root;

    }
}
public class InsertintoaBinarySearchTree {
    public static void main(String[] args){


        TreeNode[] treenodes = {
            new TreeNode(4), 
            new TreeNode(2),
            new TreeNode(7), 
            new TreeNode(1), 
            new TreeNode(3)
        };

        treenodes[0].left = treenodes[1];
        treenodes[0].right = treenodes[2];

        treenodes[1].left = treenodes[3];
        treenodes[1].right = treenodes[4];

        Solution solution = new Solution();
        TreeNode treenode = solution.insertIntoBST(treenodes[0], 5);
        System.out.println(treenode.val);
        System.out.println(treenode.right.val);
        System.out.println(treenode.right.left.val);
    }
}
