package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        for(int i=0; i<input.length(); i++) {
            if((i+1)%10 == 0) {
                System.out.print(input.charAt(i)+"\n");
            } else {
                System.out.print(input.charAt(i));
            }
        }
    }
}
