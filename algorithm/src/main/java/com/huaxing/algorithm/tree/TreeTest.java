package com.huaxing.algorithm.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 姚广星
 * @time: 2020/12/8 22:14
 */
@Slf4j
public class TreeTest {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * 示例 1：输入：root = [1,null,2,3]     输出：[1,2,3]
     * 示例 2：输入：root = []   输出：[]
     * 示例 3：输入：root = [1]  输出：[1]
     * leetcode 地址：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     */
    static class Solution {
        //思路：使用递归的方式实现
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traversal(root, list);
            return list;
        }

        /**
         * 遍历方式
         *
         * @param root 当前节点
         * @param list 结果存放
         */
        private void traversal(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            //前序的实现方式-->根-左-右
            list.add(root.val);
            traversal(root.left, list);
            traversal(root.right, list);
        }
    }


    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxDepth(TreeNode root) {
        //解题思路：查询左边子树和右边子树的最大深度，然后取最大的+1
        if (root == null) {
            return 0;
        }
        //最左边树的深度；
        int left = maxDepth(root.left);
        //最后边树的深度
        int right = maxDepth(root.right);
        //当前最大深度
        int current = 0;
        if (left > right) {
            current = left + 1;
        }
        if (right > left) {
            current = right + 1;
        }
        return current;
    }
}
