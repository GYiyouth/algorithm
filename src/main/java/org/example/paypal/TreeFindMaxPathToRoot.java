package org.example.paypal;

/**
 * 给定一个二叉树，定义总路径为：2个节点分别到公共子节点的路径 + 公共子节点到根节点路径
 */
public class TreeFindMaxPathToRoot {

    public static void main(String[] args) {

    }

    public static int maxLength = 0;

    /**
     * 思路：遍历整棵树，求他们的高度
     * @param root
     * @return
     */
    public static int findMaxTotalLength(Node root){

        // 遍历整个树，求每个节点的高度、层级
        maxLength = 0;
        getHeight(root, 0);
        System.out.println(maxLength);
        return maxLength;
    }

    private static int getHeight(Node node, int layer){
        if (node == null){
            return 0;
        }
        int leftSonHeight = getHeight(node.left, layer + 1);
        int rightSonHeight = getHeight(node.right, layer +1);
        node.length = Math.max(leftSonHeight, rightSonHeight) + 1;
        node.layer = layer + 1;
        if ( (leftSonHeight + rightSonHeight + layer) > maxLength ){
            maxLength = leftSonHeight + rightSonHeight + layer;
        }
        return node.length;
    }



    public static class Node{
        Node left;
        Node right;
        int layer;
        int length;
    }
}
