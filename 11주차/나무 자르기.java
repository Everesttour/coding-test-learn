import java.io.*;

/*

    제목: 나무 자르기
    링크: https://www.acmicpc.net/problem/2805

    풀이:
    - 절단기 높이를 기준으로 잘라서 얻을 수 있는 나무 길이를 계산
    - 높이가 낮을수록 더 많은 나무를 얻고, 높이가 높을수록 더 적은 나무를 얻는다
    - 이 성질을 이용해 조건을 만족하는 절단기 높이의 최댓값을 이진탐색으로 찾는다
 */

class Main {
    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);

        int treeCount = (int) scanner.nextLong();
        long requiredLength = scanner.nextLong();
        long[] trees = new long[treeCount];
        long right = 0;

        for (int i = 0; i < treeCount; i++) {
            trees[i] = scanner.nextLong();
            right = Math.max(right, trees[i]);
        }

        long left = 0;
        long answer = 0;

        while (left <= right) {
            long middle = (left + right) / 2;
            long collected = 0;

            for (long tree : trees) {
                if (tree > middle) {
                    collected += tree - middle;

                    if (collected >= requiredLength) {
                        break;
                    }
                }
            }

            if (collected >= requiredLength) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.print(answer);
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

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);

            long value = 0;

            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }

            return value;
        }
    }
}
