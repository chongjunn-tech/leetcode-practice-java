import java.lang.Math;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        else{
            return hMinDepth(root);
        }
        

    }
    private int hMinDepth(TreeNode node){

        if (node.left == null && node.right == null){
            return 1;
        }
        
        if (node.left == null){
            return 1 + hMinDepth(node.right);
        }
        else if (node.right == null){
            return 1 + hMinDepth(node.left);
        }
        return 1 + Math.min(hMinDepth(node.left),hMinDepth(node.right));

    }

};
public class Main{
    public static void main(String[] args){
        
        Solution s = new Solution();
        int values [] = {2,3,4,5,6};
        TreeNode nodes [] = new TreeNode[values.length];

        for (int i = 0; i < values.length; i++){
            nodes[i] = new TreeNode(values[i]);
        }
        // nodes[0].left = nodes[1];
        // nodes[0].right = nodes[2];

        // nodes[2].left = nodes[3];
        // nodes[3].right = nodes[4];
        nodes[0].right = nodes[1];

        System.out.println(s.minDepth(nodes[0]));
    }
}