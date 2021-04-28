package graphNtrees;

import java.util.ArrayList;

class Solution
{
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        return dfs(0,new boolean[V],adj,new ArrayList<Integer>());

    }

   public  ArrayList<Integer> dfs(int source, boolean visited[],ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> arr){
        {
            visited[source] = true;
            arr.add(source);
            for( int v : adj.get(source))
            {
                if(!visited[v]){
                    dfs(v,visited,adj,arr);
                }
            }
            return arr;
        }
    }

}