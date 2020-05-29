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
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty()){
            //先遍历左子树
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            //取出栈顶的节点并且赋给指针
            curr=stack.pop();
            result.add(curr.val);
            //然后取出右子树节点
            curr=curr.right;
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
