//Problem Link: https://usaco.org/index.php?page=viewproblem2&cpid=641
//Video Link: TBA
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class fieldreduction {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        int N = Integer.parseInt(in.readLine());
        int lowestx = Integer.MAX_VALUE;
        int highestx = 0;
        int lowesty = Integer.MAX_VALUE;
        int highesty = 0;
        ArrayList<Integer> minx = new ArrayList<>();
        ArrayList<Integer> miny = new ArrayList<>();
        ArrayList<Integer> maxx = new ArrayList<>();
        ArrayList<Integer> maxy = new ArrayList<>();
        int[] cowsx = new int[N];
        int[] cowsy = new int[N];
        for(int i = 0; i<N; i++){
            StringTokenizer ln = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(ln.nextToken());
            cowsx[i] = x;
            int y = Integer.parseInt(ln.nextToken());
            cowsy[i] = y;
            if(x < lowestx) {
                minx = new ArrayList<>();
                lowestx = x;
            }
            if(x > highestx){
                maxx = new ArrayList<>();
                highestx = x;
            }
            if(x == lowestx) minx.add(i);
            if(x == highestx) maxx.add(i);
            if(y < lowesty){
                miny = new ArrayList<>();
                lowesty = y;
            }
            if(y > highesty){
                highesty = y;
                maxy = new ArrayList<>();
            }
            if(y == lowesty) miny.add(i);
            if(y == highesty) maxy.add(i);
        }
        boolean[] lookat = new boolean[N];
        int min = (highestx - lowestx) * (highesty-lowesty);
        if(minx.size() == 1){
            lookat[minx.get(0)] = true;
            min = Math.min(min, look(lookat, cowsx, cowsy));
            lookat[minx.get(0)] = false;
        }
        if(miny.size() == 1){
            lookat[miny.get(0)] = true;
            min = Math.min(min, look(lookat, cowsx, cowsy));
            lookat[miny.get(0)] = false;
        }
        if(maxx.size() == 1){
            lookat[maxx.get(0)] = true;
            min = Math.min(min, look(lookat, cowsx, cowsy));
            lookat[maxx.get(0)] = false;
        }
        if(maxy.size() == 1){
            lookat[maxy.get(0)] = true;
            min = Math.min(min, look(lookat, cowsx, cowsy));
            lookat[maxy.get(0)] = false;
        }
        out.println(min);
        out.close();
    }
    public static int look(boolean[] lookat, int[] cowsx, int[] cowsy){
        int lowestx = Integer.MAX_VALUE;
        int highestx = 0;
        int lowesty = Integer.MAX_VALUE;
        int highesty = 0;
        for(int i = 0; i<cowsx.length; i++){
            if(lookat[i]) continue;
            int x = cowsx[i];
            int y = cowsy[i];
            if(x < lowestx) {
                lowestx = x;
            }
            if(x > highestx){
                highestx = x;
            }
            if(y < lowesty){
                lowesty = y;
            }
            if(y > highesty){
                highesty = y;
            }
        }
        return (highestx-lowestx) * (highesty-lowesty);
    }
}
