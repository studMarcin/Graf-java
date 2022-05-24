package com.example.grafjava;

import java.util.LinkedList;

public class BFS {
    public boolean BFS(Graph g, int node, Node[] buttons){
        GraphMenager gm = new GraphMenager();
        int size = g.cols *g.rows;
        int n;
        int[] color = new int[size];
        LinkedList<Integer> q= new LinkedList<Integer>();
        for(int i =0; i<size;i++){
            color[i] = 0;
        }
        color[node] = 1;
        q.push(node);
        while(!q.isEmpty()){
            n = q.poll();
            for(GraphEdge x: g.neighbours[n]){
                if(color[x.node] == 0){
                    color[x.node] = 1;
                    q.push(x.node);
                }
            }
            color[n] = 2;
        }
        for(int i = 0; i<size;i++){
            gm.setColor(buttons[i], 14);
            if (color[i] != 2) {
                return false;
            }
        }
        return true;
    }
}