import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] q = new int[n];
        int head = 0, tail = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            if(cmd.equals("push")) {
                q[tail] = Integer.parseInt(input[1]);
                tail = (tail+1)%n;
            }else if(cmd.equals("pop")) {
                if (head == tail) System.out.println(-1);
                else {
                    System.out.println(q[head]);
                    head = (head+1)%n;
                }
            }else if(cmd.equals("size")) {
                System.out.println((tail-head > 0) ? tail-head : head-tail);
            }else if(cmd.equals("empty")) {
                if(head == tail) System.out.println(1);
                else System.out.println(0);
            }else if(cmd.equals("front")) {
                if(head == tail) System.out.println(-1);
                else System.out.println(q[head]);
            }else if(cmd.equals("back")) {
                if(head == tail) System.out.println(-1);
                else System.out.println(q[tail-1]);
            }
        }
    }
}
