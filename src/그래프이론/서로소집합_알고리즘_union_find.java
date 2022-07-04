package 그래프이론;

import java.util.Scanner;

public class 서로소집합_알고리즘_union_find {

    // V, E
    // 노드의 개수는 최대 100,000개라고 가정
    public static int v, e;
    public static int[] parent = new int[100001];   // 부모 테이블 초기화하기

    // 특정 원소가 속한 집합을 찾기 (find)
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) {
            return x;
        }
//        return findParent(parent[x]);     // 기본 find 연산
        return parent[x] = findParent(parent[x]);   // 경로압축 적용 find 연산
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블 초기화 , 자기 자신으로!
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // Union 연산을 각자 수행
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        // 각 원소가 속한 집합 출력하기
        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
