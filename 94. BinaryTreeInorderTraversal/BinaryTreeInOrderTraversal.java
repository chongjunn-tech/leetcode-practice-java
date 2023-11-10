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
    
    private void inorder(TreeNode root, List<Integer> nums){
        if (root == null) return;

        inorder(root.left, nums);

        nums.add(root.val);

        inorder(root.right, nums);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
            
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list);

        return list;
    }   
}
public class BinaryTreeInOrderTraversal {
    public static void main(String[] args){
        TreeNode[] t1 = {
            new TreeNode(1), 
            new TreeNode(2),
            new TreeNode(3),
        };

        t1[0].right = t1[1];
        t1[1].left = t1[2];

        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(t1[0]));

    }
}
