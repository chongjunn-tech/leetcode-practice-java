import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return res;

        q.offer(root);

        while (!q.isEmpty()){

            // number of elements in this level
            int eleminALevel = q.size();
            List<Integer> subLevels = new ArrayList<>();

            // looping through the number of elements in the level
            for (int i = 0 ;i < eleminALevel;i++){
                TreeNode node = q.poll();
                subLevels.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

            }
            res.add(subLevels);
        }
        return res;
    }
}

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args){
        TreeNode[] treenodes = {
            new TreeNode(3), 
            new TreeNode(9), 
            new TreeNode(20),
            new TreeNode(15),
            new TreeNode(7),
    };
    treenodes[0].left = treenodes[1];
    treenodes[0].right = treenodes[2];
    treenodes[2].left = treenodes[3];
    treenodes[2].right = treenodes[4];

    Solution solution = new Solution();
    List<List<Integer>> res = solution.levelOrder(treenodes[0]);

    System.out.println(res);

    }
}
