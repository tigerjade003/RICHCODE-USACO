package bronze_jan_2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class promotioncounting {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("promote.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
        int[] before = new int[4];
        int[] after = new int[4];
        for(int i = 0; i<4; i++){
            StringTokenizer ln = new StringTokenizer(in.readLine());
            before[i] = Integer.parseInt(ln.nextToken());
            after[i] = Integer.parseInt(ln.nextToken());
        }
        int[] ans = new int[3];
        ans[2] = after[3] - before[3];
        ans[1] = after[2] - before[2] + ans[2];
        ans[0] = after[1] - before[1] + ans[1];
        out.println(ans[0] + "\n" + ans[1] + "\n" + ans[2]);
        out.close();
    }
}
