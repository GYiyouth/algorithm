package algorithm.tree;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/cha-ru-nullzhi-zuo-wei-biao-zhi-by-vulka-6x9a/
 */
public class 二叉树层序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        root.left = root2;
        root2.left = root3;
        levelOrder(root);

    }

    /**
     * 破坏树的结构， 但是好理解
     * @param root
     * @return
     */
    public static List<Integer> levelOrder(TreeNode root) {

// 判空
        if(root == null){
            return new ArrayList();
        }
        // 保存最后的输出顺序
        List<Integer> resultList = new ArrayList();

        // 先进后出的栈
        Stack<TreeNode> stack = new Stack();
        // 头结点放进栈里去
        stack.push(root);

        TreeNode current = root;

        while(!stack.empty()){

            if(current.left != null){
                stack.add(current.left);
                current = current.left;
            } else {
                // 从栈里 取出
                current = stack.pop();
                current.left = null;
                // 访问这个值：加到结果数组里
                resultList.add(current.val);

                if(current.right != null){
                    stack.push(current.right);
                    current = current.right;
                }
            }
        }
        return resultList;
    }
}
