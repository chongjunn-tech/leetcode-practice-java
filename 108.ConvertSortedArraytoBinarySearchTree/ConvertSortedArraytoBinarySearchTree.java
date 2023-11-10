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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        int end = nums.length - 1;
        TreeNode root = createTreeNode(nums, 0, end);
        
        return root;

    }
    private TreeNode createTreeNode(int[] nums, int start, int end){
        if (start> end){
            return null;
        }
        int mid = (end + start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = createTreeNode(nums, start, mid - 1);

        root.right = createTreeNode(nums, mid + 1, end);
        return root;
    } 
}
public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args){
        int[] nums = {-10, -3, 0, 5, 9};

        Solution solution = new Solution();
        TreeNode root = solution.sortedArrayToBST(nums);

        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
    
}
