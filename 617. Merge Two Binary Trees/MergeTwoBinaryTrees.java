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
    private TreeNode merge( TreeNode node1, TreeNode node2){
        
        TreeNode mergedNode;
        if (node1 != null && node2 != null){
            mergedNode = new TreeNode(node1.val + node2.val);
        }
        else if (node1 != null){
            mergedNode = new TreeNode(node1.val);
        }
        else if (node2!=null){
            mergedNode = new TreeNode(node2.val);
        }
        else{
            mergedNode = null;
        }
    
        // node not null then will have left and right pointer
        if (mergedNode != null){
            TreeNode n1Left = (node1 != null) ? node1.left: null;
            TreeNode n1Right = (node1 != null) ? node1.right: null;
            TreeNode n2Left = (node2 != null) ? node2.left: null;
            TreeNode n2Right = (node2 != null) ? node2.right: null;

            mergedNode.left = merge(n1Left, n2Left);
            mergedNode.right = merge(n1Right, n2Right);
        }
        return mergedNode;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        TreeNode  root = merge(root1, root2);
        return root;
    }
}
public class MergeTwoBinaryTrees {
    public static void main(String[] args){
        TreeNode[] nodes1 = {
            new TreeNode(1),
            new TreeNode(3), 
            new TreeNode(2),
            new TreeNode(5) 
        };
        TreeNode[] nodes2 = {
            new TreeNode(2),
            new TreeNode(1),
            new TreeNode(3), 
            new TreeNode(4), 
            new TreeNode(7)
        };

        nodes1[0].left = nodes1[1];
        nodes1[0].right = nodes1[2];
        nodes1[1].left = nodes1[3];
        
        nodes2[0].left = nodes2[1];
        nodes2[1].right = nodes2[3];
        nodes2[2].right = nodes2[4];

        Solution solution= new Solution();

        TreeNode newRoot = solution.mergeTrees(nodes1[0], nodes2[0]);
        System.out.println(newRoot.val);
        System.out.println(newRoot.left.val);
        System.out.println(newRoot.right.val);
    }
}

// Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
// Output: [3,4,5,5,4,null,7]
// Example 2:

// Input: root1 = [1], root2 = [1,2]
// Output: [2,2]
