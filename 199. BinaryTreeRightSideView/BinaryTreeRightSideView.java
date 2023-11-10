import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
// Solution is make use of level order traversal
// the only difference is adding the last element in the level
// to the list
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root == null) return res;

        q.offer(root);

        while (!q.isEmpty()){

            // number of elements
            int elemsInLevel = q.size();

            for (int i = 0 ; i < elemsInLevel; i++){
                TreeNode node = q.poll();

                if (node.left !=null) q.add(node.left);
                if (node.right != null ) q.add(node.right);

                // adding last element in res
                if (i == elemsInLevel - 1) res.add(node.val);
            }
        }
        return res;

    }
}

class BinaryTreeRightSideView{
    public static void main(String[] args){

        TreeNode[] treenodes = {
            new TreeNode(1), 
            new TreeNode(2),
            new TreeNode(3), 
            new TreeNode(4)
        };
        treenodes[0].left = treenodes[1];
        treenodes[0].right = treenodes[2];

        treenodes[1].left = treenodes[3];
        // treenodes[2].right = treenodes[4];

        Solution solution = new Solution();
        System.out.println(solution.rightSideView(treenodes[0]));
    }
}