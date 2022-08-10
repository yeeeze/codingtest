package BJ;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

// 각 알파벳을 0~9 숫자 중 하나로 바꾼다

/**
 * 반례 : 10
 * ABB
 * BB
 * BB
 * BB
 * BB
 * BB
 * BB
 * BB
 * BB
 * BB
 *
 * A : 8, B : 9가 최댓값인데 내가 생각한 대로 하면 자릿수가 큰 A가 9, B = 8 반대로 할당됨
 */
public class BJ1339 {

    private static Map<String, Integer> map = new HashMap<>();
    private static int n;
    private static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        word = new String[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
            max = Math.max(max, word[i].length());
        }

        int cnt = 9;
        for (int i = max - 1; i >= 0; i--) {
            for (int j = 0; j < word.length; j++) {
                if (word[j].length() - 1 < i) {
                    continue;
                } else {
                    String w = String.valueOf(word[j].charAt(word[j].length() - 1 - i));
                    if (map.containsKey(w)) {
                        continue;
                    } else {
                        map.put(w, cnt);
                        cnt--;
                    }
                }
            }
        }

        long result = 0;
        for (int i = 0; i < word.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word[i].length(); j++) {
                sb.append(map.get(String.valueOf(word[i].charAt(j))));
            }
            result += Integer.parseInt(String.valueOf(sb));
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
