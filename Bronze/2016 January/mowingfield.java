//problem link: https://usaco.org/index.php?page=viewproblem2&cpid=593
//video link: https://www.youtube.com/watch?v=MZ7iOZkWhLs
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class mowingfield {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
        int[][] mowing = new int[2001][2001];
        for(int i = 0; i<2001; i++){
            for(int j = 0; j<2001; j++){
                mowing[i][j] = -1;
            }
        }
        int maxx = Integer.MAX_VALUE;
        int N = Integer.parseInt(in.readLine());
        int curx = 1000, cury = 1000, curt = 0;
        mowing[curx][cury] = curt;
        for(int i = 0; i<N; i++){
            StringTokenizer ln = new StringTokenizer(in.readLine());
            char dir = ln.nextToken().charAt(0);
            int num = Integer.parseInt(ln.nextToken());
            for(int j = 1; j<=num; j++){
                curt++;
                if(dir == 'N') curx--;
                else if(dir == 'S') curx++;
                else if(dir == 'E') cury++;
                else cury--;
                if(mowing[curx][cury] != -1 ){
                    maxx = Math.min(maxx, curt - mowing[curx][cury]);
                }
                mowing[curx][cury] = curt;

            }
        }
        out.println(maxx == Integer.MAX_VALUE ? -1 : maxx);
        out.close();
    }
}
