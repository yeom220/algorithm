package p_11005;
/**
 * 문제
 * 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * <p>
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 * <p>
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 * <p>
 * 입력
 * 첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.
 * <p>
 * 출력
 * 첫째 줄에 10진법 수 N을 B진법으로 출력한다.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        char[] alphabet = new char[36];
        for (int i = 10; i < 36; i++) {
            alphabet[i] = (char) (i + 55);
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int mod = n % b;
            if (mod >= 10) {
                sb.append(alphabet[mod]);
            } else {
                sb.append(mod);
            }
            n /= b;
        }

        System.out.println(sb.reverse());
    }
}
