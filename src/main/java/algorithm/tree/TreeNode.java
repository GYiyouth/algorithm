package algorithm.tree;

import lombok.Data;

import java.io.Serializable;

@Data
public class TreeNode implements Serializable {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){

    }

    public TreeNode(int val){
        this.val = val;
    }


}
