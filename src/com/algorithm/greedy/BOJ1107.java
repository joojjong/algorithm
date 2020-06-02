package com.algorithm.greedy;

import java.util.*;
/*
문제
수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼을 망가뜨렸다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 망가져있는지 주어졌을 때, N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.

수빈이가 지금 보고 있는 채널은 100번이다.

입력
첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 망가진 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다. 셋째 줄에는 망가진 버튼이 주어지며, 같은 버튼이 중복되서 주어지는 경우는 없다.

출력
첫째 줄에 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.

예제 입력

    5457
    3
    6 7 8
예제 출력

    6

 */

public class BOJ1107 {
        static boolean[] broken = new boolean[10];
        static int possible(int c) {
            if (c == 0) {
                if (broken[0]) {
                    return 0;
                } else {
                    return 1;
                }
            }
            int len = 0;
            while (c > 0) {
                if (broken[c % 10]) {
                    return 0;
                }
                len += 1;
                c /= 10;
            }
            return len;
        }
        public static void main(String args[]) {
            System.out.println("## BOJ1107");

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                broken[x] = true;
            }
            int ans = n - 100;
            if (ans < 0) {
                ans = -ans;
            }
            for (int i = 0; i <= 1000000; i++) {
                int c = i;
                int len = possible(c);
                if (len > 0) {
                    int press = c - n;
                    if (press < 0) {
                        press = -press;
                    }
                    if (ans > len + press) {
                        ans = len + press;
                    }
                }
            }
            System.out.println(ans);
        }
    }