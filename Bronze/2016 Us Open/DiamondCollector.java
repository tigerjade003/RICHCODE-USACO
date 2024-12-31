//problem link: https://usaco.org/index.php?page=viewproblem2&cpid=639
//video link: TBA
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class diamondcollector {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));/*
        StringTokenizer ln = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(ln.nextToken());
        int K = Integer.parseInt(ln.nextToken());
        int[] diamonds = new int[N];
        for(int i = 0; i<N; i++){
            diamonds[i] = Integer.parseInt(in.readLine());
        }
        int maximum = 0;
        for(int i = 0; i<N; i++){
            int cur = 0;
            for(int j = 0; j<N; j++){
                if(diamonds[j] - diamonds[i] <= K && diamonds[j] >= diamonds[i]){
                    cur++;
                }
            }
            maximum = Math.max(maximum, cur);
        }
        out.println(maximum);
        out.close();
    }
}
