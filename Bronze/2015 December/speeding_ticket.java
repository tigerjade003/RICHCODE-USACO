//problem link: https://usaco.org/index.php?page=viewproblem2&cpid=568
//youtube link: https://www.youtube.com/watch?v=Av09X_rCoBo
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class speedingticket {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer ln = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(ln.nextToken());
        int M = Integer.parseInt(ln.nextToken());
        int[] speed = new int[100];
        int[] limit = new int[100];
        int last = 0;
        for(int i = 0; i<N; i++){
            ln = new StringTokenizer(in.readLine());
            int a  = Integer.parseInt(ln.nextToken());
            int b = Integer.parseInt(ln.nextToken());
            for(int j = last; j<a + last; j++){
                speed[j] = b;
            }
            last += a;
        }
        last = 0;
        for(int i = 0; i<M; i++){
            ln = new StringTokenizer(in.readLine());
            int a  = Integer.parseInt(ln.nextToken());
            int b = Integer.parseInt(ln.nextToken());
            for(int j = last; j<a + last; j++){
                limit[j] = b;
            }
            last += a;
        }
        int max = 0;
        for(int i = 0; i < 100; i++){
            max = Math.max(max, speed[i] - limit[i]);
        }
        out.println(max);
        out.close();
    }
}
