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
// recursive implementation
class Solution {
    public int maxDepth(TreeNode root) {
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
            return Math.max(
                maxDepth(root.left) + 1, 
                maxDepth(root.right) + 1
            );
        }
        
    }
}


public class MaxDepthOfBinaryTree {
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

    //     treenodes[1].left = treenodes[3];
    //     treenodes[1].right = treenodes[4];


            TreeNode[] treenodes = {
            new TreeNode(1), 
            new TreeNode(2), 

    };

        treenodes[0].right = treenodes[1];

        Solution solution = new Solution();

        System.out.println(solution.maxDepth(treenodes[0]));
    }
}
