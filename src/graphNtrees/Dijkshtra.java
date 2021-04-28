//https://youtu.be/smHnz2RHJBY

package graphNtrees;

import java.util.ArrayList;
import java.util.Arrays;

class Dijkshtra
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        int d[] = new int[V];
        boolean visited[] = new boolean[V];
        Arrays.fill(d, Integer.MAX_VALUE);

        d[S] = 0;
        // visited[S] = true;
        // int nextS = S;
        for(int j = 0;j < adj.size(); j++){

            for (int i = 0; i < adj.get(S).size(); i++) {
                visited[S] = true;
                int v = adj.get(S).get(i).get(0);
                int w = adj.get(S).get(i).get(1);

                if (!visited[v]) {
                    d[v] = Math.min(d[v], d[S] + w);
                }
            }
            int minDis = Integer.MAX_VALUE;
            for(int i=0;i<V;i++){
                if (minDis >= d[i] && !visited[i] && d[i] != Integer.MAX_VALUE) {
                    S = i;
                    minDis = d[i];
                    // System.out.println("New Source : "+S);}
                }
            }
        }
        return d;

    }
}