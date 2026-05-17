import java.util.*;

/*

    제목: 게임 맵 최단거리
    링크: https://school.programmers.co.kr/learn/courses/30/lessons/1844

    풀이:
    - 시작 지점에서 도착 지점까지의 최단거리를 구해야 하므로 BFS를 사용
    - 상, 하, 좌, 우로 이동하면서 처음 방문한 칸의 거리를 기록
    - BFS는 가까운 칸부터 탐색하므로 도착 지점에 기록된 값이 최단거리
 */

class Solution {
    public int solution(int[][] maps) {
        int rowCount = maps.length;
        int colCount = maps[0].length;

        if (maps[0][0] == 0) {
            return -1;
        }

        int[][] distance = new int[rowCount][colCount];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + dr[direction];
                int nextCol = col + dc[direction];

                if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount) {
                    continue;
                }

                if (maps[nextRow][nextCol] == 0 || distance[nextRow][nextCol] != 0) {
                    continue;
                }

                distance[nextRow][nextCol] = distance[row][col] + 1;
                queue.offer(new int[] {nextRow, nextCol});
            }
        }

        if (distance[rowCount - 1][colCount - 1] == 0) {
            return -1;
        }

        return distance[rowCount - 1][colCount - 1];
    }
}
