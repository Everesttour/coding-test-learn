import java.util.*;

/*

    제목: 올바른 괄호
    링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909
    
    풀이:
    - 스택을 사용하여 괄호의 짝을 검사
    - '(' 는 push, ')' 는 pop
    - pop 할 때 스택이 비어 있으면 올바르지 않은 괄호
    - 마지막에 스택이 비어 있어야 올바른 괄호
 */

class Solution {
    boolean solution(String s) {
        // 괄호를 저장할 스택
        ArrayDeque<Character> stack = new ArrayDeque<>();

        // 문자열 순회
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 여는 괄호 → 스택에 추가
            if (c == '(') {
                stack.push(c);
            } else {
                // 닫는 괄호인데 스택이 비어 있으면 실패
                if (stack.isEmpty()) {
                    return false;
                }
                // 짝 맞추기
                stack.pop();
            }
        }

        // 스택이 비어 있어야 성공
        return stack.isEmpty();
    }
}