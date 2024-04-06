package chap_01;

import java.util.Scanner;
import java.util.Stack;

/**
 * 문제
 * 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
 * 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가
 * 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
 * <p>
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
 * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
 * 이를 계산하는 프로그램을 작성하라.
 * <p>
 * 입력
 * 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
 * 물론 같은 정수가 두 번 나오는 일은 없다.
 * <p>
 * 출력
 * 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.
 */
public class P1874_스택으로오름차순수열만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer buffer = new StringBuffer();
        int num = 1;    // 오름차순 수
        boolean result = true;
        for (int i = 0; i < A.length; i++) {
            int su = A[i];  // 현재 수열의 수
            if (su >= num) {    // 현재 수열 값 >= 오름차순 자연수: 값이 같아질 때까지 push()
                while (su >= num) {
                    stack.push(num++);
                    buffer.append("+\n");
                }
                stack.pop();
                buffer.append("-\n");
            } else {  // 현재 수열 값 < 오름차순 자연수: pop()을 수행해 수열 원소를 꺼냄
                int n = stack.pop();
                // 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    buffer.append("-\n");
                }
            }
        }
        if (result) System.out.println(buffer.toString());
    }
}
