package com.algorithm.greedy;

import java.util.Scanner;

/*
문제
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)

둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

출력
첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.

test case :
10 4790
1
5
10
50
100
500
1000
5000
10000
50000

답 : 12
 */

public class BOJ11047 {
    public static void main(String[] args) {
        System.out.println("## baekjoon11047");
        Scanner sc = new Scanner(System.in);
        int i, m = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];

        for (i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (i = n-1; i >= 0; i--) {
            m += k / a[i];
            k %= a[i];
        }
        sc.close();
        System.out.println("## 답 : ");
        System.out.println(m);
    }

}
