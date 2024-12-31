//problem link: https://usaco.org/index.php?page=viewproblem2&cpid=615
//video link: TBA
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class circularbarn {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int N = Integer.parseInt(in.readLine());
        int[] numof = new int[2*N];
        for(int i = 0; i<N; i++){
            numof[i] = Integer.parseInt(in.readLine());
            numof[i+N] = numof[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<N; i++){
            ans = Math.min(ans, countdist(i, numof));
        }
        out.println(ans);
        out.close();
    }
    public static int countdist(int start, int[] nums){
        int ans = 0;
        for(int i = start; i< start + nums.length/2; i++){
            ans += (i - start) * nums[i];
        }
        return ans;
    }
}
