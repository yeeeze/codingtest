package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ18406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int front = 0;
        for (int i = 0; i < n.length() / 2; i++) {
            front += n.charAt(i) - '0';
        }

        int back = 0;
        for (int i = n.length() / 2; i < n.length(); i++) {
            back += n.charAt(i) - '0';
        }

        if (front == back) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
