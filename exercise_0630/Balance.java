package exercise.exercise_0630;

/*
二叉树平衡检查
实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
public class Balance {
    public boolean isBalance(TreeNode root) {
        if((root.left != null && (root.left.left!= null
                ||root.left.right!= null ) && root.right == null)||
                (root.right != null && (root.right.left!= null
                        ||root.right.right!= null ) && root.left == null)){
            return false;
        }
        if(root.left != null){
            isBalance(root.left);
        }
        if(root.right != null){
            isBalance(root.right);
        }
        return true;
    }
}