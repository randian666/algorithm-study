package com.algorithm.study.demo.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xun2.liu
 * @title: Solution19
 * @projectName algorithm-study
 * @description: 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * @date 2020/5/29 18:31
 */
public class Solution19 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 前序遍历:打印-左-右
     * 中序遍历:左-打印-右
     * 后序遍历:左-右-打印
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty()){
            //首先遍历左子节点
            if (curr!=null){
                //不断往左子树方向走，每走一次就将当前节点保存到栈中
                //这是模拟递归的调用
                stack.push(curr);
                curr=curr.left;
            }else{
                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                //然后转向右边节点，继续上面整个过程
                TreeNode popNode = stack.pop();
                result.add(popNode.val);
                curr=curr.right;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode a=new TreeNode(3);
        TreeNode b=new TreeNode(9);
        TreeNode c=new TreeNode(20);
        TreeNode d=new TreeNode(15);
        TreeNode r=new TreeNode(2);
        a.left=b;
        a.right=c;
        c.left=d;
        c.right=r;
        List<Integer> integers = inorderTraversal(a);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
