//https://youtu.be/D21-XVw6nYw
package graphNtrees;

import java.util.*;

public class Graph {

    public static LinkedList<Integer> ad[];
    static Scanner sc = new Scanner(System.in);

    public Graph(int vertices) {
        ad = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            ad[i] = new LinkedList<>();
        }
    }

    //undirected
    public void addEdge(int source, int destination){
        ad[source].add(destination);
        ad[destination].add(source);
    }

    //directed
    public Graph addDirectedEdge(int source, int destination){
        ad[source].add(destination);
        return this;
    }

    //bfs using queue
    public void bfs(int source, int dest){
        Queue<Integer> q = new LinkedList();
        boolean visited[] = new boolean[ad.length];
        int parent[] = new int[ad.length];

        q.add(source);
        visited[source] = true;
        parent[source] = -1;

        while ( !q.isEmpty()) {
            int curr = q.poll();
            if (curr == dest) break;
            for (int neighbour : ad[curr]) {
                if (!visited[neighbour]) {
                    q.add(neighbour);
                    visited[neighbour] = true;
                    parent[neighbour] = curr;
                }
            }
        }
            int curr = dest;
            int distance = 0;
            while (parent[curr] != -1){
                System.out.print(curr+"->");
                curr = parent[curr];
                distance++;
            }
            System.out.print(curr);
            System.out.println("The minimum distance is : "+distance);

        }

        //dfs using recursion
        private boolean dfsUtil(int source, int dest, boolean visited[]){
            if(source == dest)
                return true;
            for (int neighbor : ad[source]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    boolean isConnected = dfsUtil(neighbor,dest,visited);
                    if(isConnected) return true;
                }
            }
            return false;
        }

        public boolean dfs(int source, int destination){
            boolean visited[] = new boolean[ad.length];
            return dfsUtil(source,destination,visited);
        }

        //dfs using stack
        public boolean dfsStack(int source, int destination){
            boolean visited[] = new boolean[ad.length];
            Stack<Integer> stack = new Stack<>();
            stack.push(source);
            visited[source] = true;

            while (!stack.isEmpty()){
                int cur = stack.pop();
                if(cur == destination)
                    return true;
                for (int neighbor : ad[cur]){
                    if(!visited[neighbor]) {
                        visited[neighbor] = true;
                        stack.push(neighbor);
                    }
                }
            }
            return false;
        }

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

    public static void main(String[] args) {
        System.out.println("Enter vertices and edges : ");
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        Graph graph = new Graph(vertices);
        System.out.println("Enter "+edges+" edges :");
        for (int i = 0; i < edges; i++)
        {
            int source = sc.nextInt();
            int dest = sc.nextInt();
            graph.addEdge(source,dest);
        }
        graph.bfs(0,4);
        System.out.println(graph.dfs(1,3) + " "+ graph.dfsStack(1,3));
    }
}
