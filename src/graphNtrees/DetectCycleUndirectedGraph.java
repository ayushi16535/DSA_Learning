package graphNtrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class DetectCycleUndirectedGraph {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int visited[] = new int[V];
        Arrays.fill(visited,-1);
        for(int i = 0; i < V; i++){
            if(checkCycleBfs(i,adj,visited)){
                return true;
            }
        }

        return false;
    }

    boolean checkCycleBfs(int source, ArrayList<ArrayList<Integer>> adj, int visited[])
    {
        Queue<Integer> q = new ArrayDeque<Integer>();
        visited[source] = 0;
        q.add(source);

        while(!q.isEmpty())
        {
            source = q.poll();
            visited[source] = 1;
            for(int v : adj.get(source))
            {
                if(visited[v] == 0){
                    return true;
                }
                else if(visited[v] == -1)
                {
                    q.add(v);
                    visited[v] = 0;
                }
            }
        }

        return false;
    }
}
