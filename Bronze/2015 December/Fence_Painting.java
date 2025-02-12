//problem link: https://usaco.org/index.php?page=viewproblem2&cpid=567
//video link: https://www.youtube.com/watch?v=WHmgMC9RM78
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class fencepainting {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("paint.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        int a, b, c, d;
        StringTokenizer ln = new StringTokenizer(in.readLine());
        a = Integer.parseInt(ln.nextToken());
        b = Integer.parseInt(ln.nextToken());
        ln = new StringTokenizer(in.readLine());
        c = Integer.parseInt(ln.nextToken());
        d = Integer.parseInt(ln.nextToken());
        boolean[] painted = new boolean[101];
        for(int i = a; i<b; i++){
            painted[i] = true;
        }
        for(int i = c; i<d; i++){
            painted[i] = true;
        }
        int answer = 0;
        for(int i = 0; i<101; i++){
            if(painted[i]){
                answer++;
            }
        }
        out.println(answer);
        out.close();
    }
}
