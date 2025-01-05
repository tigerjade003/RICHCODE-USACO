//problem link:https://usaco.org/index.php?page=viewproblem2&cpid=592
//video link: https://www.youtube.com/watch?v=7xTjVU5xfbk
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;

public class angrycows {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        int N = Integer.parseInt(in.readLine());
        int[] bales = new int[N];
        for(int i = 0; i<N; i++){
            bales[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(bales);
        int maxexp = 1;
        for(int i = 0; i<N; i++){
            maxexp = Math.max(maxexp, count(i, bales));
        }
        out.println(maxexp);
        out.close();
    }
    public static int count(int start, int[] bales){
        boolean[] exploded = new boolean[bales.length];
        ArrayDeque<Integer> tocheck = new ArrayDeque<>();
        ArrayDeque<Integer> size = new ArrayDeque<>();
        tocheck.addFirst(start);
        size.addFirst(1);
        int ans = 0;
        while(!tocheck.isEmpty()){
            int cur = tocheck.removeFirst();
            int rad = size.removeFirst();
            if(exploded[cur]) continue;
            ans++;
            exploded[cur] = true;
            for(int i = 0; i<bales.length; i++){
                if(cur != i && Math.abs(bales[i]- bales[cur]) <= rad && !exploded[i]){
                    tocheck.addLast(i);
                    size.addLast(rad+1);
                }
            }
        }
        return ans;
    }
}
