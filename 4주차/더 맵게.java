import java.util.*;

/*

    제목: 더 맵게
    링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626

    풀이:
    - 가장 맵지 않은 두 음식을 반복해서 섞어야 하므로 최소 힙(PriorityQueue)을 사용
    - 힙의 최솟값이 K 이상이면 모든 음식이 기준을 만족하므로 종료
    - 최솟값이 K 미만인데 원소가 1개뿐이면 더 이상 섞을 수 없으므로 -1 반환
    - 가장 작은 두 값을 꺼내 `첫 번째 + 두 번째 * 2`로 섞은 뒤 다시 힙에 넣고 횟수를 증가
 */

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int value : scoville) {
            pq.offer(value);
        }

        int count = 0;

        while (!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }

            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + second * 2);
            count++;
        }

        return count;
    }
}
