import java.util.Stack;

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
    private boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // do a traversal


        if (root == null && subRoot == null){
            return false;
        }
        if (root == null || subRoot == null){
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        
        while (
            !stack.isEmpty()
        ){

            TreeNode node = stack.pop();
            
            if (isSameTree(node, subRoot)){
                return true;
            }

            if (node.left !=null){
                stack.add(node.left);
            }
            if (node.right !=null){
                stack.add(node.right);
            }
        }
        return false;
    }

}

class SolutionRecursive {
    private boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // do a traversal
        if (root == null && subRoot == null) return true;
        
        if (isSameTree(root, subRoot)) return true;

        return isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);
    }

}
public class SubtreeOfAnotherTree {
    public static void main (String[] args){
        TreeNode[] treenodes = {
            new TreeNode(3), 
            new TreeNode(4),
            new TreeNode(5), 
            new TreeNode(1), 
            new TreeNode(2),
            new TreeNode(0)
        };
            
        treenodes[0].left = treenodes[1];
        treenodes[0].right = treenodes[2];

        treenodes[1].left = treenodes[3];
        treenodes[1].right = treenodes[4];

        treenodes[4].left = treenodes[5];


        TreeNode[] treenodes2 = {
            new TreeNode(4), 
            new TreeNode(1), 
            new TreeNode(2)
        };
        treenodes2[0].left = treenodes2[1];
        treenodes2[0].right = treenodes2[2];
        Solution solution = new Solution();
        System.out.println(solution.isSubtree(treenodes[0],treenodes2[0]));
};
}

