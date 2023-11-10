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
    public TreeNode invertTree(TreeNode root) {
        if (root != null){
            TreeNode tmp = invertTree(root.left);

            root.left = invertTree(root.right);
            root.right = tmp;
        }

        return root;
    }
}
public class InvertBinaryTree {
    public static void main(String[] args){
    TreeNode[] treenodes = {
            new TreeNode(4), 
            new TreeNode(2), 
            new TreeNode(7),
            new TreeNode(1),
            new TreeNode(3),
            new TreeNode(6),
            new TreeNode(9),
    };

    treenodes[0].left = treenodes[1];
    treenodes[0].right = treenodes[2];

    treenodes[1].left = treenodes[3];
    treenodes[1].right = treenodes[4];

    treenodes[2].left = treenodes[5];
    treenodes[2].right = treenodes[6];

    Solution solution = new Solution();
    TreeNode newTreeNode = solution.invertTree(treenodes[0]);

    
    System.out.println(newTreeNode.left.left.val);
    System.out.println(newTreeNode.right.left.val);
}
}
