package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BiPartiteDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList =  new ArrayList<>();
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(0,2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,0)));
        System.out.println(isBipartiteGraph(3, adjList));
    }

    public static boolean isBipartiteGraph(int v, ArrayList<ArrayList<Integer>> adjList) {
        int colored[] = new int[v];
        for(int i = 0; i< v; i++) {
            if(colored[i] == 0 ) {
                colored[i] = 1;
                if (!dfs(i, adjList, colored)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adjList, int colored[] ) {
        for(Integer neigh: adjList.get(node)) {
            if(colored[neigh] == colored[node]) {
                return false;
            } else {
                if(colored[neigh]==0) {
                    colored[neigh] = -(colored[node]);
                    return dfs(neigh, adjList, colored);
                }
            }
        }
        return true;
    }
}
