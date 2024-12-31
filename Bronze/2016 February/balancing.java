//Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=617
//Video link: TBA

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class balancing {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        StringTokenizer ln = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(ln.nextToken());
        int B = Integer.parseInt(ln.nextToken());
        int[] xpos = new int[N];
        int[] ypos = new int[N];
        TreeSet<Integer> checkx = new TreeSet<>();
        TreeSet<Integer> checky = new TreeSet<>();
        for(int i = 0; i<N; i++){
            ln = new StringTokenizer(in.readLine());
            xpos[i] = Integer.parseInt(ln.nextToken());
            ypos[i] = Integer.parseInt(ln.nextToken());
            checkx.add(xpos[i]+1);
            checky.add(ypos[i]+1);
        }
        ArrayList<Integer> xcheck = new ArrayList<>(checkx);
        ArrayList<Integer> ycheck = new ArrayList<>(checky);
        int minM = Integer.MAX_VALUE;
        for(int a: xcheck){
            for(int b: ycheck){
                int topleft = 0;
                int topright = 0;
                int botleft = 0;
                int botright = 0;
                for(int j = 0; j<N; j++){
                    if(xpos[j] < a && ypos[j] < b){
                        topleft++;
                    }
                    else if(xpos[j] < a && ypos[j] > b){
                        topright++;
                    }
                    else if(xpos[j] > a && ypos[j] < b){
                        botleft++;
                    }
                    else{
                        botright++;
                    }
                }
                minM = Math.min(minM, Math.max(Math.max(topleft, topright), Math.max(botleft, botright)));
            }
        }
        out.println(minM);
        out.close();
    }
}
