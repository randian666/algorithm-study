package com.algorithm.study.demo.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图
 * @Author: liuxun
 * @CreateDate: 2019/2/21 上午10:40
 * @Version: 1.0
 */
public class Mgraph {
    private int v;//顶点的个数
    private LinkedList<Integer> adj[];//邻接表

    public Mgraph(int capaCity){
        v=capaCity;
        adj=new LinkedList[capaCity];
        for (int i=0;i<adj.length;i++){
            adj[i]=new LinkedList<>();
        }
    }

    /**
     * 添加数据
     * @param oSide
     * @param rSide
     */
    private void add(int oSide,int rSide){
        adj[oSide].add(rSide);
        adj[rSide].add(oSide);
    }

    /**
     * 构造一个无向图
     */
    private void createGraph() {
        //  0 -- 1 -- 2
        //  |    |    |
        //  3 -- 4 -- 5
        //  |    |    |
        //  6 -- 7 -- 8
        add(0,1);//add(1,0);
        add(0,3);//add(3,0);

        add(1,2);//add(2,1);
        add(1,4);// add(4,1);

        add(2,5);//add(5,2);

        add(3,4);//add(4,3);
        add(3,6);//add(6,3);

        add(4,5);//add(5,4);
        add(4,7);// add(7,4);

        add(5,8);//add(8,5);

        add(6,7);//add(7,6);

        add(7,8);//add(8,7);
    }
    private void print(int[] prev, int oSide, int rSide) {
        if (prev[rSide] != -1 && oSide != rSide) {
            print(prev, oSide, prev[rSide]);
        }
        System.out.print(rSide + " ");
    }

    /**
     * 广度优先搜索，从字面意思理解，它就是一种“地毯式”的搜索策略，先查找离起始顶点最近的，然后是次近的，依次往外搜索，层层递进。
     *
     * 在这里三个重要的核心辅助变量 visited、queue、prev。
     * visited 记录已经被访问的顶点，避免顶点被重复访问
     * queue 用来存储已经被访问、但相连的顶点还没有被访问的顶点的这样的一个队列。
     * prev 记录搜索路径，它是反向存储，便于后续正向打印输出图的路径。
     * @param oSide
     * @param rSide
     */
    private void bfs(int oSide, int rSide) {
        if (oSide == rSide) return;

        boolean[] visited = new boolean[v];
        visited[oSide] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(oSide);
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int j = 0; j < adj[index].size(); j++) {
                int value = adj[index].get(j);
                if (!visited[value]) {
                    prev[value] = index;
                    if (value == rSide) {
                        print(prev, oSide, rSide);
                    }
                    visited[value] = true;
                    queue.offer(value);
                }
            }
        }
    }

    public static void main(String[] args) {
        int count = 9;
        Mgraph graph = new Mgraph(count);
        //  0 -- 1 -- 2
        //  |    |    |
        //  3 -- 4 -- 5
        //  |    |    |
        //  6 -- 7 -- 8
        graph.createGraph();
        System.out.println("BFS(广度优先搜索)");
        graph.bfs(0,6);
    }
}
