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
    int maxDiam;
    // helper function
    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        else if ( 
            root.left == null && root.right == null
        ){
            return 0;
        }
        else{
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int height = Math.max(leftHeight,rightHeight) + 1;

            maxDiam = Math.max(maxDiam,height);
            //if left and right is a Node
            if (root.left != null && root.right != null){
                //   O
                //  /  \
                // O    O
                // eg above: need to add 2 (for the 2 edges)
                maxDiam = Math.max(
                    maxDiam, 
                    leftHeight+ rightHeight + 2
                );
            }

            
            return height;
        }


    }
    public int diameterOfBinaryTree(TreeNode root) {
        //The diameter of a binary tree is the length of the longest path 
        // between any two nodes in a tree. 
        // This path may or may not pass through the root.
        height(root);
        return maxDiam;

        
    }
}
public class DiameterOfABinaryTree {

    public static void main(String[] args){
        TreeNode[] treenodes = {
            new TreeNode(1), 
            new TreeNode(2),
            // new TreeNode(3), 
            // new TreeNode(4), 
            // new TreeNode(5),  

    };

        treenodes[0].left = treenodes[1];
        // treenodes[0].right = treenodes[2];

        // treenodes[1].left = treenodes[3];
        // treenodes[1].right = treenodes[4];

        Solution solution = new Solution();

        System.out.println(solution.diameterOfBinaryTree(treenodes[0]));
    }
    
}
