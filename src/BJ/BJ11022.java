package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11022 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        for(int i=0; i<line; i++) {
            st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append("Case #");
            sb.append(i+1);
            sb.append(": ");
            sb.append(a);
            sb.append(" + ");
            sb.append(b);
            sb.append(" = ");
            sb.append(a+b);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
