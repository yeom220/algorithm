package p_1978;
/**
 * 문제
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * <p>
 * 출력
 * 주어진 수들 중 소수의 개수를 출력한다.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String[] inputs = sc.nextLine().split(" ");
        for (String s : inputs) {
            int count = 0;
            int num = Integer.parseInt(s);
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    count++;
                }
                if (count > 1) {
                    break;
                }
            }
            if (count == 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
