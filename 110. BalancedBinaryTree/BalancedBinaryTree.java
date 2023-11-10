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
    boolean isBalanced = true;

    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        else if (
            root.left == null &&
            root.right == null
        ){
            return 1;
        }
        else{
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            if (Math.abs(leftHeight-rightHeight) > 1){
                isBalanced = false;
            }
            int value = 1 + Math.max(
                leftHeight,
                rightHeight
            );
            return value;
        }

    }
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return isBalanced;

    }
}

public class BalancedBinaryTree {
    public static void main(String[] args){
    //     TreeNode[] treenodes = {
    //         new TreeNode(3), 
    //         new TreeNode(9),
    //         new TreeNode(20), 
    //         new TreeNode(15), 
    //         new TreeNode(7),  

    // };

    //     treenodes[0].left = treenodes[1];
    //     treenodes[0].right = treenodes[2];

    //     treenodes[2].left = treenodes[3];
    //     treenodes[2].right = treenodes[4];


            TreeNode[] treenodes = {
            new TreeNode(1), 
            new TreeNode(2),
            new TreeNode(2), 
            new TreeNode(3), 
            new TreeNode(3),
            new TreeNode(4), 
            new TreeNode(4),   

    };

        treenodes[0].left = treenodes[1];
        treenodes[0].right = treenodes[2];

        treenodes[1].left = treenodes[3];
        treenodes[1].right = treenodes[4];

        treenodes[3].left = treenodes[5];
        treenodes[3].right = treenodes[6];
        Solution solution = new Solution();

        System.out.println(solution.isBalanced(treenodes[0]));
    }
    
}

