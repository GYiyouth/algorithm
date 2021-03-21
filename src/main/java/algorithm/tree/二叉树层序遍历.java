package algorithm.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/cha-ru-nullzhi-zuo-wei-biao-zhi-by-vulka-6x9a/
 */
public class 二叉树层序遍历 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentLayer = new ArrayList<>();
        resultList.add(currentLayer);
        while (!queue.isEmpty()){

            TreeNode node = queue.poll();
            if (node != null){
                if (currentLayer == null){
                    currentLayer = new ArrayList<>();
                    resultList.add(currentLayer);
                }
                currentLayer.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                TreeNode next = queue.peek();
                if (next == null){
                    // 需要换层了
                    queue.add(null);
                }
            }else {
                currentLayer = null;

            }
        }
        return resultList;
    }
}
