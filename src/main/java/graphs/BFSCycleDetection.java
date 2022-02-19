package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BFSCycleDetection {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList =  new ArrayList<>();
        adjList.add(new ArrayList<Integer>(Arrays.asList(1)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(0)));
        System.out.println(hasCycle(3, adjList));
    }

    public static boolean hasCycle(int v, ArrayList<ArrayList<Integer>> adjList) {
        boolean visited[] = new boolean[v];
        for(int i = 0; i < v; i++) {
            LinkedList<ArrayList> queue = new LinkedList();
            queue.add(new ArrayList<Integer>(Arrays.asList(i, -1)));
            visited[i] = true;

            while(!queue.isEmpty()) {
                ArrayList<Integer> node = queue.poll();
                Integer prev = node.get(1);
                Integer curr = node.get(0);
                for(Integer adj: adjList.get(curr)) {
                    if(visited[adj] && adj != prev && prev!=-1) {
                        return true;
                    } else {
                        if(!visited[adj]) {
                            queue.add(new ArrayList<Integer>(Arrays.asList(adj, curr)));
                            visited[adj] = true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
