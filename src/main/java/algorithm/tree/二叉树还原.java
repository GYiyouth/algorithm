package algorithm.tree;

import java.util.Arrays;

/**
 * 对二叉树进行还原
 */
public class 二叉树还原 {

    public static void main(String[] args) {
        rebuildByPreAndMidArray();
    }

    /**
     * 根据前序、中序数组，遍历
     */
    public static void rebuildByPreAndMidArray(){
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        /**
         * 对二叉树进行还原，了解前序遍历、中序遍历的原理就可得知，
         * preOrder[0] 就是二叉树的root元素
         * 它在inOrder的位置，是左右孩子结点的分水岭
         */

        TreeNode root = findRootNode(preOrder, inOrder);
        System.out.println(root);
    }

    public static TreeNode findRootNode(int[] preOrder, int[] inOrder){
        if (preOrder.length == 0 || inOrder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode();
        root.setVal(preOrder[0]);
        int rootIndex = 0;
        for (; rootIndex < inOrder.length ; rootIndex++){
            if (inOrder[rootIndex] == preOrder[0]){
                break;
            }
        }


        TreeNode leftChild = findRootNode(
                Arrays.copyOfRange(preOrder, 1, rootIndex + 1),
                Arrays.copyOfRange(inOrder, 0, rootIndex)
                );
        TreeNode rightChild = findRootNode(
                Arrays.copyOfRange(preOrder, rootIndex + 1, preOrder.length),
                Arrays.copyOfRange(inOrder, rootIndex + 1, inOrder.length)
        );
        root.setLeft(leftChild);
        root.setRight(rightChild);
        return root;
    }
}
