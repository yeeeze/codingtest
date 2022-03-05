package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<n; i++) {
            stringBuilder.append(i+1).append("\n");
        }

        bufferedReader.close();
        System.out.println(stringBuilder);
    }
}
