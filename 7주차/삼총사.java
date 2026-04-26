import java.util.*;

/*

    제목: 삼총사
    링크: https://school.programmers.co.kr/learn/courses/30/lessons/131705

    풀이:
    - 학생 3명을 고르는 모든 조합을 완전탐색으로 확인
    - 세 학생 번호의 합이 0이면 삼총사이므로 경우의 수를 증가
    - number의 길이가 최대 13이므로 3중 반복문으로 충분히 해결 가능
 */

class Solution {
    public int solution(int[] number) {
        int count = 0;

        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
