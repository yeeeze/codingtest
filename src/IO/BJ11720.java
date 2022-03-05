package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(bf.readLine());
        int result = 0;
        String input = bf.readLine();

        for(int i=0; i<line; i++) {
            int sum = input.charAt(i) - 48;
            result += sum;

            System.out.println(String.valueOf(input.charAt(i)));
        }
        System.out.println(result);
    }
}
