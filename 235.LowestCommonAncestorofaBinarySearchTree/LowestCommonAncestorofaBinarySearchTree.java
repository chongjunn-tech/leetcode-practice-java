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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // LCA: Value will be in between p and q
        //  p.val<=LCA.val<=q.val
        if (root == null) return null;

        // value is higher
        if (
            p.val > root.val && 
            q.val > root.val
        ) return lowestCommonAncestor(root.right, p, q);

        // value is lower
        else if (
            p.val < root.val &&
            q.val < root.val
        ) return lowestCommonAncestor(root.left, p, q);

        else return root;
    }
}


public class LowestCommonAncestorofaBinarySearchTree {
    public static void main(String[] args){
        TreeNode[] treenodes = {
            new TreeNode(6), 
            new TreeNode(2),
            new TreeNode(8), 
            new TreeNode(0), 
            new TreeNode(4),
            new TreeNode(7), 
            new TreeNode(9),
            new TreeNode(3),
            new TreeNode(5),   
    };
    treenodes[0].left = treenodes[1];
    treenodes[0].right = treenodes[2];
    
    treenodes[1].left = treenodes[3];
    treenodes[1].right = treenodes[4];

    treenodes[2].left = treenodes[5];
    treenodes[2].right = treenodes[6];

    treenodes[4].left = treenodes[7];
    treenodes[4].right = treenodes[8];


    Solution solution = new Solution();

    TreeNode p = treenodes[1];
    TreeNode q = treenodes[2];
    TreeNode newNode = solution.lowestCommonAncestor(treenodes[0], p , q);
    System.out.println(newNode.val);
    }
}
