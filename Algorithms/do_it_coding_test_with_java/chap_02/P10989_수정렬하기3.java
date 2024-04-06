package chap_02;

import java.io.*;

public class P10989_수정렬하기3 {
    public static int[] A;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        radixSort(A, 5);
        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void radixSort(int[] A, int maxSize) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        while (count != maxSize) {   // 최대 자릿수만큼 반복하기
            int[] bucket = new int[10];
            for (int i = 0; i < A.length; i++) {
                bucket[(A[i] / jarisu) % 10]++; // 일의 자리부터 시작하기
            }
            for (int i = 1; i < 10; i++) {  // 합 배열을 이용해 index 계산하기
                bucket[i] += bucket[i - 1];
            }
            for (int i = A.length - 1; i >= 0; i--) {   // 현재 자릿수를 기준으로 정렬하기
                output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }
            for (int i = 0; i < A.length; i++) {
                // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
                A[i] = output[i];
            }
            jarisu = jarisu * 10;   // 자릿수 증가시키기
            count++;
        }
    }
}
