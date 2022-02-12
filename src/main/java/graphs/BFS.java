package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/*
V is the number of nodes in our graph
adjacency list is the graph representation that we follow in this case

Steps -
1) Iterate over every node to avoid missing unconnected components.
2) if the node is not visited, perform BFS on it
3) add the element to your queue, and while the queue is not empty perform step 4
4) de-queue your element and add its adj nodes to the queue and add the de-queued element
   to your bfs output, mark it as visited.
5) return your BFS array
 */
public class BFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList =  new ArrayList<>();
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(0,2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(1,0)));
        System.out.println(BFSForGraph(3, adjList));
    }


    public static ArrayList<Integer> BFSForGraph( int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++ ) {
            if(!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;

                while(!queue.isEmpty()) {
                    Integer start = queue.poll();
                    bfs.add(start);
                    for(Integer node: adjacencyList.get(start)) {
                        if(!visited[node]) {
                            visited[node] = true;
                            queue.add(node);
                        }
                    }
                }
            }
        }
        return bfs;
    }
}
