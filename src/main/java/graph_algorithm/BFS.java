package graph_algorithm;

import java.util.LinkedList;



public class BFS {

    int[] color;

    public boolean BFS(Graph g) {
        GraphMenager gm = new GraphMenager();
        int size = g.cols * g.rows;
        int n;
        color = new int[size];
        int node = g.chosen;
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) {
            color[i] = 0;
        }
        color[node] = 1;
        q.push(node);
        while (!q.isEmpty()) {
            n = q.poll();
            for (GraphEdge x : g.neighbours[n]) {
                if (color[x.node] == 0) {
                    color[x.node] = 1;
                    q.push(x.node);
                }
            }
            color[n] = 2;
        }
        for(int i = 0; i<size; i++){
            if(color[i]!= 2){
                return false;
            }
        }
        return true;
    }
    public void colorBFS(Graph g, Node[] buttons){
        for(int i = 0; i<g.rows*g.cols;i++){
            if(color[i] == 2){
                buttons[i].setStyle("-fx-background-color: #000000");
            }
            else{
                buttons[i].setStyle("-fx-background-color: #FFFFFF");
            }
        }
        buttons[g.chosen].setStyle("-fx-background-color: #666666");
    }
}