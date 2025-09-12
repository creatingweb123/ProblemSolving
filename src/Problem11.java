import java.io.*;
import java.util.*;

public class Problem11 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 섬 개수
        int M = Integer.parseInt(st.nextToken()); // 다리 개수
        int K = Integer.parseInt(st.nextToken()); // 최대 이동 가능 다리 수

        // 인접 리스트 초기화
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 다리 데이터 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            addEdge(graph, x, y);
        }

        // 결과 출력
        System.out.println(canReachWithin(graph, 1, N, K) ? "YES" : "NO");
    }

    // 다리 추가 (양방향)
    private static void addEdge(List<List<Integer>> graph, int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    // BFS로 최소 거리 ≤ maxLength 인지 확인
    private static boolean canReachWithin(List<List<Integer>> graph, int start, int end, int maxLength) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.dist > maxLength)
                return false;
            if (cur.id == end)
                return true;

            for (int next : graph.get(cur.id)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, cur.dist + 1));
                }
            }
        }
        return false; // 도달 불가
    }

    // BFS 노드 표현 (id: 섬 번호, dist: 이동 다리 수)
    private record Node(int id, int dist) {
    }
}
