import java.io.*;
import java.util.*;

/*

    제목: 최소비용 구하기
    링크: https://www.acmicpc.net/problem/1916

    풀이:
    - 한 도시에서 다른 도시까지의 최소 비용을 구하는 문제이므로 다익스트라를 사용
    - 우선순위 큐에서 현재까지 비용이 가장 작은 도시를 먼저 꺼내며 최단거리를 갱신
    - 더 짧은 비용으로 갈 수 있는 경로를 찾으면 거리 배열을 갱신하고 다시 큐에 추가
 */

class Main {
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);

        int cityCount = scanner.nextInt();
        int busCount = scanner.nextInt();

        List<Edge>[] graph = new ArrayList[cityCount + 1];
        for (int i = 1; i <= cityCount; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < busCount; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int cost = scanner.nextInt();
            graph[from].add(new Edge(to, cost));
        }

        int start = scanner.nextInt();
        int goal = scanner.nextInt();

        int[] distance = new int[cityCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (current.cost > distance[current.to]) {
                continue;
            }

            for (Edge next : graph[current.to]) {
                int nextCost = current.cost + next.cost;

                if (nextCost < distance[next.to]) {
                    distance[next.to] = nextCost;
                    pq.offer(new Edge(next.to, nextCost));
                }
            }
        }

        System.out.print(distance[goal]);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int pointer = 0;
        private int length = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (pointer >= length) {
                length = in.read(buffer);
                pointer = 0;

                if (length <= 0) {
                    return -1;
                }
            }

            return buffer[pointer++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int value = 0;

            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }

            return value;
        }
    }
}
