//techiedelight.com/check-given-graph-strongly-connected-not/

package graphNtrees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class CheckStronglyConnectedGraph {
    // adj : adjacency list of the graph
    // V : Number of vertices
    public boolean SCAllvertex(int V, LinkedList<Integer>[] adj) {
        // code here
        boolean visited[];
        Queue<Integer> q = new ArrayDeque<Integer>();
        //call bfs from every vertex and check all other can be reached
        for (int i = 0; i < V; i++) {
            visited = new boolean[V];
            if (!allConnected(i, adj, visited, q))
                return false;
        }
        return true;


    }

    boolean allConnected(int source, LinkedList<Integer> adj[], boolean visited[], Queue<Integer> q) {
        //BFS
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

    boolean SCKosaraju(int V, LinkedList<Integer> adj[]){
        boolean visited[];
        Queue<Integer> q = new ArrayDeque<Integer>();
        //call bfs from one vertex and check all can be reached
        visited = new boolean[V];
        if (!allConnected(0, adj, visited, q))
            return false;

        //reverse all edges of graph and call bfs from same vertex above
        LinkedList<Integer> adjReverse[] = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            for (int v : adj[i]){
                if(adjReverse[v] ==null)
                    adjReverse[v] = new LinkedList<>();
                adjReverse[v].add(i);
            }
        }
        q = new ArrayDeque<>();
        visited = new boolean[V];
        if(!allConnected(0,adjReverse,visited,q))
        {
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
        graph.addDirectedEdge(4,2);

        System.out.println(new CheckStronglyConnectedGraph().SCAllvertex(V,graph.ad));
        System.out.println(new CheckStronglyConnectedGraph().SCKosaraju(V,graph.ad));
    }
}
