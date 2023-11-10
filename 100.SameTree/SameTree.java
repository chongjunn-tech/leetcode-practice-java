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



class SolutionRecursive {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        // Recursively compare the left and right subtrees.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
class SolutionIterative {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }

        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        pStack.push(p);
        qStack.push(q);

        // note that right child is pushed first so that left is processed first 
        while (
            !pStack.isEmpty() &&
            !qStack.isEmpty()
            ){
                TreeNode pnode = pStack.pop();
                TreeNode qnode = qStack.pop();



                if (pnode.val != qnode.val){
                    return false;
                }

                // push right and left child of the pop node to the stack
                if (pnode.right !=null && qnode.right !=null){
                    pStack.push(pnode.right);
                    qStack.push(qnode.right);
                }
                else if (
                    pnode.right == null && qnode.right == null
                ){}
                else{return false;}

                if (pnode.left != null && qnode.left != null){
                    pStack.push(pnode.left);
                    qStack.push(qnode.left);
                }
                else if (pnode.left == null && qnode.left == null){}
                else{return false;}
            }
        return true;
    }
}
class SameTree{
    public static void main(String[] args){
        TreeNode[] t1 = {
            new TreeNode(2), 
            new TreeNode(4),
            // new TreeNode(3)
        };
        TreeNode[] t2 = {
            new TreeNode(2), 
            new TreeNode(3),
            new TreeNode(4)
        };
    
        t1[0].right = t1[1];


        t2[0].left = t2[1];
        t2[0].right = t2[2];

        SolutionIterative solution = new SolutionIterative();
        System.out.println(solution.isSameTree(t1[0],t2[0]));
}
}