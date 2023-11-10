import java.util.ArrayList;
import java.util.List;



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
    private void preorder(TreeNode root, List<Integer> nums){
        if (root == null) return;

        nums.add(root.val);
        preorder(root.left, nums);
        preorder(root.right, nums);

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        preorder(root, list);
        return list;


    }
}

public class BinaryTreePreorderTraversal{
    
    public static void main(String[] args){
        TreeNode[] t1 = {
            new TreeNode(1), 
            new TreeNode(2),
            new TreeNode(3),
        };

        // t1[0].right = t1[1];
        // t1[1].left = t1[2];

        Solution solution = new Solution();
        System.out.println(solution.preorderTraversal(t1[0]));

    }
}