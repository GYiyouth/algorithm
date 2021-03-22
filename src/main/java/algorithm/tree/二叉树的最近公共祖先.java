package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 二叉树的最近公共祖先 {

    public static void main(String[] args) {

    }

    /**
     * 使用DFS的方法来遍历每个路径，并使用queue来存下来路径
     * 未完成
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stackForTraverse = new Stack<>();
        stackForTraverse.push(root);
        Stack<TreeNode> stackForPath = new Stack<>();

        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        while (!stackForTraverse.isEmpty()) {
            TreeNode node = stackForTraverse.pop();
            if (node.right != null) {
                stackForTraverse.push(node.right);
            }
            if (node.left != null) {
                stackForTraverse.push(node.left);
            }
            stackForPath.push(node);
            if (node.val == p.val){
                while (!stackForPath.isEmpty()){
                    pQueue.add(stackForPath.pop());
                }
            }
            if (node.val == q.val){
                while (!stackForPath.isEmpty()){
                    qQueue.add(stackForPath.pop());
                }
            }
            if (node.left == null && node.right == null){

            }
        }
        return null;
    }

    /**
     * 一个非常聪明的解法：
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor2(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor2(root.right, p, q);
        if (leftNode != null && rightNode != null){
            return root;
        }
        if (leftNode != null){
            return leftNode;
        }
        if (rightNode != null){
            return rightNode;
        }
        return null;
    }
}
