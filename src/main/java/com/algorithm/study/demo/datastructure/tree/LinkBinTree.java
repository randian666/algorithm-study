package com.algorithm.study.demo.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树链表存储
 前序遍历：根节点->左子树->右子树
 中序遍历：左子树->根节点->右子树
 后序遍历：左子树->右子树->根节点
 * Created by liuxun on 2017/6/29.
 */
public class LinkBinTree {
    public static class TreeNode{
        Integer data;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(Integer data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public TreeNode(Integer data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;
    /**初始化空的二叉树**/
    public LinkBinTree(){
        root=new TreeNode();
    }
    /**指定一个默认的根二叉树**/
    public LinkBinTree(Integer d){
        root=new TreeNode(d);
    }
    /**判断二叉树是否为空**/
    public boolean isEmpty(){
        return root.data==null;
    }
    /**获取根节点**/
    public TreeNode getRoot(){
        if (isEmpty()){
            throw new RuntimeException("树为空，无法获取根节点");
        }
        return root;
    }

    /**获取树的深度**/
    public int getDeep(TreeNode t){
        if (t==null){
            return 0;
        }
        int l=getDeep(t.left);
        int r=getDeep(t.right);
        return l>r?(l+1):(r+1);
    }
    /**获取树的最小深度**/
    public int getMinDeep(TreeNode t){
        if (t==null){
            return 0;
        }
        if (t.left==null && t.right==null){
            return 1;
        }
        int l=getMinDeep(t.left);
        int r=getMinDeep(t.right);
        return l<r?(l+1):(r+1);

    }
    /**获取结点数**/
    public int numOfTreeNode(TreeNode t){
        if (t==null){
            return 0;
        }
        int left = numOfTreeNode(t.left);
        int right = numOfTreeNode(t.right);
        return left + right + 1;
    }
    /**第K层的结点数**/
    int numsOfkLevelTreeNode(TreeNode root,int k){
        if(root == null||k<1){
            return 0;
        }
        if(k==1){
            return 1;
        }
        int numsLeft = numsOfkLevelTreeNode(root.left,k-1);
        int numsRight = numsOfkLevelTreeNode(root.right,k-1);
        return numsLeft + numsRight;
    }
    private void add(TreeNode t,int value){
        if(value>t.data){
            if(t.right!=null){
                add(t.right,value);
            }
            else{
                t.right = new TreeNode(value);
            }
        }
        else{
            if(t.left!=null){
                add(t.left,value);
            }
            else{
                t.left = new TreeNode(value);
            }
        }
    }
    /**
     * 从根节点开始插入数据，大于根节点放在右子树，小于根节点放在左子树
     * @param value
     */
    public void add(int value){
            add(root,value);
    }

    /**
     * 前序遍历
     * 如果树为空返回，如果不为空首先从根节点开始遍历，然后先前序遍历左子树，最后前序遍历右子树。
     */
    public void preOrderTraverse(TreeNode t){
        if (t==null) {
            return;
        }
        System.out.println(t.data);
        preOrderTraverse(t.left);
        preOrderTraverse(t.right);
    }
    public void preOrderTraverse(){
        preOrderTraverse(root);
    }


    /**
     * 中序遍历
     * 如果树为空返回，从根节点开始，中序遍历左子树，然后访问根节点，最后中序遍历右子树。
     */
    public void inOrderTraverse(TreeNode t){
        if (t==null) {
            return;
        }
        inOrderTraverse(t.left);
        System.out.println(t.data);
        inOrderTraverse(t.right);
    }
    public void inOrderTraverse(){
        inOrderTraverse(root);
    }

    /**
     * 后续遍历
     * @param t
     */
    public void postOrderTraverse(TreeNode t){
        if (t==null) {
            return;
        }
        postOrderTraverse(t.left);
        postOrderTraverse(t.right);
        System.out.println(t.data);
    }
    public void postOrderTraverse(){
        postOrderTraverse(root);
    }

    /**
     * 层级遍历
     * @param t
     */
    public void divOrderTraverse(TreeNode t){
        if (t==null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
        queue.add(root);
        while(queue.size() != 0)
        {
            int len = queue.size();
            for(int i=0;i <len; i++)
            {
                TreeNode temp = queue.poll();
                System.out.print(temp.data+" ");
                if(temp.left != null)  queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
    }
    public void divOrderTraverse(){
        divOrderTraverse(root);
    }
    /**区间搜索**/
    private void searchSection(TreeNode t,int k1,int k2,ArrayList<Integer> result){
        if (t==null){
            return;
        }
        if(t.data>k1){
            searchSection(t.left,k1,k2,result);
        }
        if(t.data>=k1&&t.data<=k2){
            result.add(t.data);
        }
        if(t.data<k2){
            searchSection(t.right,k1,k2,result);
        }
    }

    public static void main(String[] args) {
        int[] ls=new int[]{30,9,10,15,11,40};
        LinkBinTree linkBinTree=new LinkBinTree(ls[0]);
        for (int i=1;i<ls.length;i++){
            linkBinTree.add(ls[i]);
        }
        System.out.println("树的深度"+linkBinTree.getDeep(linkBinTree.getRoot()));//返回指定结点的深度
        System.out.println("-----------------------------");
        System.out.println("最小树的深度"+linkBinTree.getMinDeep(linkBinTree.getRoot()));//返回最小树的深度
        System.out.println("-----------------------------");
        System.out.println("节点数"+linkBinTree.numOfTreeNode(linkBinTree.getRoot()));
        System.out.println("-----------------------------");
        System.out.println("第K层的结点数"+linkBinTree.numsOfkLevelTreeNode(linkBinTree.getRoot(),4));
        System.out.println("-----------------------------");
        ArrayList<Integer> list=new ArrayList<Integer>();
        linkBinTree.searchSection(linkBinTree.getRoot(),10,20,list);
        System.out.println("区间查询"+list.toString());
        System.out.println("-----------------------------");
        linkBinTree.preOrderTraverse();//前序遍历 从根节点开始遍历
        System.out.println("-----------------------------");
        linkBinTree.inOrderTraverse();//中序遍历  从根节点开始
        System.out.println("-----------------------------");
        linkBinTree.postOrderTraverse();//后序遍历
        System.out.println("-----------------------------");
        linkBinTree.divOrderTraverse();//层次遍历
        //前序遍历：根节点->左子树->右子树
        //中序遍历：左子树->根节点->右子树
        //后序遍历：左子树->右子树->根节点
    }

}
