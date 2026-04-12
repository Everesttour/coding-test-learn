import java.util.*;

/*

    제목: 블랙잭
    링크: https://www.acmicpc.net/problem/2798

    풀이:
    - 카드 3장을 고르는 모든 조합을 완전탐색으로 확인
    - 세 장의 합이 M 이하이면서 현재 최댓값보다 크면 정답 갱신
    - N의 범위가 크지 않으므로 3중 반복문으로 충분히 해결 가능
 */

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int best = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = numbers[i] + numbers[j] + numbers[k];

                    if (sum <= m && sum > best) {
                        best = sum;
                    }
                }
            }
        }

        System.out.print(best);
        scanner.close();
    }
}
