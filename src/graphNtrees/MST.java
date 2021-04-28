package graphNtrees;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

import static graphNtrees.Graph.ad;

public class MST {
//    int flag[];

    public boolean isPossible(int N, int[][] prerequisites) {
        // Your Code goes here
        Graph graph = new Graph(N);
        int edges = prerequisites.length;
        for (int i = 0; i < edges; i++) {
            if(prerequisites[i][0] == prerequisites[i][1])
                return false;
            graph.addDirectedEdge(prerequisites[i][0], prerequisites[i][1]);
        }

//        int flag[] = new int[N];
//        Arrays.fill(flag, -1);
//        Stack<Integer> stack = new Stack<>();

//        for (int i = 0; i < N; i++) {
//            int flag[] = new int[N];
//            Arrays.fill(flag, -1);
//            Stack<Integer> stack = new Stack<>();
//            int source = i;
//            flag[source] = 0;
//            stack.push(source);
//
//            if(detectCycleDFS(source,flag,stack))
//                return false;
//        }
        int flag[] = new int[N];
        Arrays.fill(flag, -1);
        for (int i = 0; i < N ; i++) {
            if (Graph.ad[i].size() > 0) {
                int source = i;
                if (flag[source] == -1) {
                    if (detectCycleDFS2(source, flag))
                        return false;
                    else
                        Arrays.fill(flag, -1);
                }
            }
        }
        return true;

    }

//    public boolean detectCycleDFS(int source, int flag[], Stack<Integer> stack) {
//        if(stack.isEmpty())
//            return false;
//                for (int v : ad[source]) {
//                    if (flag[v] == -1) {
//                        stack.push(v);
//                        flag[v] = 0;
//                        detectCycleDFS(v, flag, stack);
//                    } else if (flag[v] == 0)
//                        return true;
//                }
//                source = stack.pop();
//                flag[source] = 1;
//                detectCycleDFS(source,flag,stack);
//        return false;
//    }


    public boolean detectCycleDFS2(int source,int flag[]) {

                for (int v : Graph.ad[source]) {
                    if (flag[v] == -1) {
                        flag[v] = 0;
                        if(detectCycleDFS2(v,flag))
                            return true;
                    } else if (flag[v] == 0)
                        return true;

                }
        flag[source] = 1;
        return false;
    }


    public static void main(String[] args) {
//        int prerequisites[][] = {{1,0},{2,1},{3,2}};
//        int N = 4;
//        int prerequisites[][] = {{1,1},{2,1},{3,2}};
//        int N = 4;
//        int prerequisites[][] = {{1,0},{1,2},{2,3},{0,1}};
//        int N = 4;
        int prerequisites[][] = {{1,2},{61, 71},{62, 40},{66, 27},{71, 61}};
        int N = 72;
//       int prerequisites[][] = {
//               {0, 11},
//               {5, 10},
//               {7 ,18},
//               {8, 18},
//               {9 ,4},
//               {16 ,0},
//               {17 ,15},
//               {7 ,8},
//               {21, 16}};
//        int N = 23;
        String expected = "true";
//        int prerequisites[][] = {{4,16},{4,26},{26,16}};
//        int N = 30;
//        String expected = "true";
//        int prerequisites[][] = {{66, 30},
//        {66 ,67},
//        {        67, 71},
//        {       68 ,59},
//        {       69 ,60},
//        {       69 ,68},
//        {       71 ,24},
//        {       71 ,66},
//        {       71 ,70},
//        {       72 ,61},
//        {       73 ,64}};
//        int N = 80;
//        String expected = "false";

        System.out.println((new MST().isPossible(N,prerequisites)));
    }

}
