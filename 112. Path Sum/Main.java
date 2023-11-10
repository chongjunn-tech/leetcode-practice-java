import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        // Check if the current node is a leaf node and its value matches the targetSum
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        
        // Recursively check the left and right subtrees with updated targetSum
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

public class Main{
    public static void main(String args[]){
        Solution s = new Solution();

        int values [] = {5, 4, 11, 7, 2, 8, 13, 4, 1};
        int targetSum = 22;
        TreeNode nodes [] = new TreeNode[values.length];

        for (int i = 0; i < values.length; i++){
            nodes[i] = new TreeNode(values[i]);
        }
        nodes[0].left = nodes[1];
        nodes[1].left = nodes[2];

        nodes[2].left = nodes[3];
        nodes[2].right = nodes[4];

        nodes[0].right = nodes[5];
        
        nodes[5].left = nodes[6];
        nodes[5].right = nodes[7];
        nodes[7].right = nodes[8];

        System.out.println(s.hasPathSum(nodes[0], targetSum));
    }
}