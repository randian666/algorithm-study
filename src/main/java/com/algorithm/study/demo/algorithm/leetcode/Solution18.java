package com.algorithm.study.demo.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 给定一个二叉树，找出其最大深度。
 *
 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 说明: 叶子节点是指没有子节点的节点。
 *
 示例：
 给定二叉树 [3,9,20,null,null,15,7]，
 *
     3
    / \
   9  20
     /  \
    15   7
 返回它的最大深度 3 。
 *
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 */
public class Solution18 {
   public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    /**
     * 我们的想法是使用 DFS(深度优先搜索) 策略访问每个结点，同时在每次访问时更新最大深度。
     * 利用队列的方式访问树，每次遍历树的一层。深度就+1。
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (null==root){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        //把当前的第一层添加至队列中
        queue.offer(root);
        //默认深度为0
        int depth=0;
        while (queue.size()>0){
            //获取当前层的节点数量
            int size = queue.size();
            //遍历当前层的节点
            for (int i = 0; i < size; i++) {
                //弹出当前层的节点。获取节点下一层的节点
                TreeNode head = queue.poll();
                if (head.left!=null){
                    queue.offer(head.left);
                }
                if (head.right!=null){
                    queue.offer(head.right);
                }
            }
            //当前层遍历结束后。树的深度+1
            depth++;
        }
        return depth;

    }
    public static void main(String[] args) {
        TreeNode a=new TreeNode(3);
        TreeNode b=new TreeNode(9);
        TreeNode c=new TreeNode(20);
        TreeNode d=new TreeNode(15);
        TreeNode r=new TreeNode(7);
        a.left=b;
        a.right=c;
        c.left=d;
        c.right=r;
        System.out.println(maxDepth(a));
    }
}
