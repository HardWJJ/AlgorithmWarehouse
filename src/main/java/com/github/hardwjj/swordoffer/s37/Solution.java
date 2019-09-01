package com.github.hardwjj.swordoffer.s37;

/**
 * 题： 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 *  解题思路：
 *       1 2 # # 3 # #
 *      使用前序遍历实现方式进行序列化和反序列化
 *
 */
public class Solution {

    private String deserializeStr;

    // 序列化
    public String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    // 反序列化
    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    public TreeNode Deserialize() {
        if(deserializeStr.length() == 0){
            return null;
        }
        int index = deserializeStr.indexOf(" ");
        // 获取当前根节点
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ?  "" : deserializeStr.substring(index + 1);
        // 空节点不要
        if("#".equals(node)){
            return null;
        }
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
