//problem link: https://usaco.org/index.php?page=viewproblem2&cpid=569
//Video link: https://www.youtube.com/watch?v=xfYj8LbTfrg
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class contaminatedmilk {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("badmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
        StringTokenizer ln = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(ln.nextToken());
        int M = Integer.parseInt(ln.nextToken());
        int D = Integer.parseInt(ln.nextToken());
        int S = Integer.parseInt(ln.nextToken());
        int[] numof = new int[M];
        int[][] earliest = new int[N][M];
        for(int i = 0; i<D; i++){
            ln = new StringTokenizer(in.readLine());
            int person = Integer.parseInt(ln.nextToken())-1;
            int milk = Integer.parseInt(ln.nextToken())-1;
            int time = Integer.parseInt(ln.nextToken());
            if(earliest[person][milk] == 0 || earliest[person][milk] > time){
                if(earliest[person][milk] == 0){
                    numof[milk]++;
                }
                earliest[person][milk] = time;
            }
        }
        boolean[] couldbe = new boolean[M];
        Arrays.fill(couldbe, true);
        for(int i = 0; i<S; i++){
            ln = new StringTokenizer(in.readLine());
            int person = Integer.parseInt(ln.nextToken())-1;
            int time = Integer.parseInt(ln.nextToken());
            for(int j = 0; j<M; j++){
                if(earliest[person][j] == 0 || earliest[person][j] >= time){
                    couldbe[j] = false;
                }
            }
        }
        int max = 0;
        for(int i = 0; i<M; i++){
            if(couldbe[i]){
                max = Math.max(max, numof[i]);
            }
        }
        out.println(max);
        out.close();
    }
}
