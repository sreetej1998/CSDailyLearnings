package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DFSCycleDetection {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList =  new ArrayList<>();
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(0,2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,0)));
        System.out.println(hasCycle(3, adjList));
    }

    public static boolean hasCycle(int v, ArrayList<ArrayList<Integer>> adjList) {
        boolean visited[] = new boolean[v];
        for(int i = 0; i < v; i++) {
            if(dfsCycle(i, -1, adjList, visited)) {
                return true;
            }
        }
        return false;
    }

    public static boolean dfsCycle(int node, int prevNode,
                                   ArrayList<ArrayList<Integer>> adjList, boolean visited[]) {
        if(visited[node]) {
            return true;
        } else {
            visited[node] = true;
            for(Integer neigh: adjList.get(node)) {
                if(neigh != prevNode) {
                    if(dfsCycle(neigh, node, adjList, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
