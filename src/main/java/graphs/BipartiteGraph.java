package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
A Bipartite Graph is a graph where its possible for coloring the graph with 2 colors
 */
public class BipartiteGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList =  new ArrayList<>();
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(0,2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,0)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,0)));
        System.out.println(isBipartiteGraph(3, adjList));
    }

    public static boolean isBipartiteGraph(int V, ArrayList<ArrayList<Integer>> adjList) {
        int[] colored = new int[V];
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i< V; i++) {
            if(colored[i]==0) {
                queue.add(i);
                colored[i] = 1;
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    int color = colored[node];
                    for(Integer neigh: adjList.get(node)) {
                        if(colored[neigh]== 0) {
                            colored[neigh] = -(color);
                            queue.add(neigh);
                        } else {
                            if(colored[neigh] == color) {
                                return false;
                            }
                        }
                    }
                }
            }


        }

        return true;
    }
}
