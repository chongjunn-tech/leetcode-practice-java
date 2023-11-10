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
    int goodNodes = 0;
    
    private void preOrder(TreeNode node, int max){
        if (node == null) return ;

        if (node.val >= max){
            max = node.val;
            goodNodes++;
        }

        preOrder(node.left, max);
        preOrder(node.right, max);
    }
    public int goodNodes(TreeNode root) {

        preOrder(root, root.val);

        return goodNodes;
        
    }
}

public class CountGoodNodesInBinaryTree {
        public static void main(String[] args){
        TreeNode[] treenodes = {
            new TreeNode(3), 
            new TreeNode(1), 
            new TreeNode(4),
            new TreeNode(3),
            new TreeNode(1),
            new TreeNode(5),
    };
    treenodes[0].left = treenodes[1];
    treenodes[0].right = treenodes[2];

    treenodes[1].left = treenodes[3];

    treenodes[2].left = treenodes[4];
    treenodes[2].right = treenodes[5];

    Solution solution = new Solution();
    System.out.println(solution.goodNodes(treenodes[0]));
    
}
}
