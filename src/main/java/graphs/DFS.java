package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList =  new ArrayList<>();
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(0,2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,0)));
        System.out.println(DFSForGraphs(3, adjList));
    }

    public static ArrayList<Integer> DFSForGraphs(int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        ArrayList<Integer> dfs = new ArrayList<Integer>();
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs(i, visited, dfs, adjacencyList);
            }
        }
        return dfs;
    }

    public static void dfs(Integer node, boolean[] visited,
                           ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adjacencyList) {
        if(!visited[node]) {
            dfs.add(node);
            visited[node] = true;
            for(Integer neigh: adjacencyList.get(node)) {
                dfs(neigh, visited, dfs, adjacencyList);
            }
        }
    }
}
