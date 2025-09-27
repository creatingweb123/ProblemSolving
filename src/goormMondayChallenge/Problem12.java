package goormMondayChallenge;

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Problem12 {

    public static List<List<Integer>> graph;
    public static int start = -1;
    public static boolean[] visited;
    public static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 간선 개수

        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1]; //
        stack = new Stack<>();

        // 간선 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            addEdge(x, y);
        }

        visited[1] = true;
        dfs(1, 0);

        List<Integer> result = new ArrayList<>();
        while (true) {
            int node = stack.pop();
            result.add(node);
            if (node == start)
                break;
        }

        result.sort(null);

        System.out.println(result.size());
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    private static void addEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    private static void dfs(int cur, int prev) {
        stack.add(cur);
        for (int next : graph.get(cur)) {
            if (start != -1)
                return;
            if (next == prev)
                continue;
            if (visited[next]) {
                start = next;
                return;
            }
            visited[next] = true;
            dfs(next, cur);
        }
        if (start != -1)
            return;
        stack.pop();
    }
}
