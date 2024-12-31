import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class milkpail {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("pails.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer ln = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(ln.nextToken());
        int y = Integer.parseInt(ln.nextToken());
        int z = Integer.parseInt(ln.nextToken());
        boolean[] seen = new boolean[1001];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        int max = 0;
        while(!queue.isEmpty()){
            int q = queue.removeFirst();
            if(seen[q]) continue;
            seen[q] = true;
            max = Math.max(q, max);
            if(q + x <= z) {
                if(!seen[q+x]){
                    queue.addLast(q+x);
                }
            }
            if(q + y <= z){
                if(!seen[q+y]){
                    queue.add(q+y);
                }
            }
        }
        out.println(max);
        out.close();
    }
}
