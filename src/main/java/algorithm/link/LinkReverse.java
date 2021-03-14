package algorithm.link;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表翻转
 */
public class LinkReverse {

    public static void main(String[] args) {
        reverseALink();
    }

    public static void reverseALink(){
        LinkNode root = new LinkNode(){{this.value=0;}};
        LinkNode current = root;
        for (int value = 1; value <= 10; value ++ ){
            LinkNode node = new LinkNode();
            node.value = value;
            current.next = node;
            current = node;
        }
        current = root;
        System.out.print("原始链表顺序：");

        while (current != null){
            System.out.print(current.value + ",");
            current = current.next;
        }
        // 准备翻转
        System.out.println("翻转全部节点");

        root = reverseAllNode(root);
        System.out.print("翻转完毕：");
        current = root;
        while (current != null){
            System.out.print(current.value + ",");
            current = current.next;
        }
        int reverseRange = 5;
        System.out.print("\n翻转前" + reverseRange + "个节点:");
        root = reversPreNNode(root, reverseRange, new ArrayList<>());
        current = root;
        while (current != null){
            System.out.print(current.value + ",");
            current = current.next;
        }
        System.out.print("\n翻转6~8节点:");
        root = reversMiddleNodes(root, 5,8);
        current = root;
        while (current != null){
            System.out.print(current.value + ",");
            current = current.next;
        }
    }

    /**
     * 翻转所有的节点
     * @param root
     * @return
     */
    public static LinkNode reverseAllNode(LinkNode root){
        if (root.next == null){
            return root;
        }
        LinkNode last = reverseAllNode(root.next);
        root.next.next = root;
        root.next = null;
        return last;
    }

    public static LinkNode reversPreNNode(LinkNode root, int preRangeInclude, List<LinkNode> postHead){
        if (root.next == null || preRangeInclude == 1){
            postHead.add(root.next);
            return root;
        }

        LinkNode last = reversPreNNode(root.next, preRangeInclude - 1, postHead);
        root.next.next = root;
        root.next = postHead.get(0);

        return last;
    }

    /**
     * 翻转中间的N个元素
     * @param root
     * @param startIndex
     * @param postIndex
     * @return
     */
    public static LinkNode reversMiddleNodes(LinkNode root, int startIndex, int postIndex){
        if (startIndex == 0){
            return reversPreNNode(root, postIndex, new ArrayList<>());
        }
        root.next = reversMiddleNodes(root.next, startIndex - 1, postIndex - 1);
        return root;
    }
}
