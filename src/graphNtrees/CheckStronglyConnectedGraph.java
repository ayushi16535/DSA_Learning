package graphNtrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StronglyConnectedComponent {
    // adj : adjacency list of the graph
    // V : Number of vertices
    public boolean SCC(int V, LinkedList<Integer>[] adj) {
        // code here
        boolean visited[];
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < V; i++) {
            visited = new boolean[V];
            if (!allConnected(i, adj, visited, q))
                return false;
        }
        return true;


    }

    boolean allConnected(int source, LinkedList<Integer> adj[], boolean visited[], Queue<Integer> q) {
        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            source = q.poll();
            for (int v : adj[source]) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addDirectedEdge(0,2);
        graph.addDirectedEdge(1,0);
        graph.addDirectedEdge(2,1);
        graph.addDirectedEdge(0,3);
        graph.addDirectedEdge(3,4);
        graph.addDirectedEdge(4,4);

        System.out.println(new StronglyConnectedComponent().SCC(V,graph.ad));
    }
}
