package com.huaxing.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 示例 1：输入：root = [1,null,2,3]     输出：[1,2,3]
 * 示例 2：输入：root = []   输出：[]
 * 示例 3：输入：root = [1]  输出：[1]
 * leetcode 地址：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author: 姚广星
 * @time: 2020/12/8 22:14
 */
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
}
