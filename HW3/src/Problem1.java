import java.util.Random;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int head = 0, tail = 0, top = -1;
        int[] q = new int[1000000];
        int[] stack = new int[1000000];

        int n = sc.nextInt();
        System.out.print("정렬전 : ");
        for (int i = 0; i < n; i++) {
            q[tail] = rand.nextInt(10000);
            System.out.print(q[tail] + " ");
            tail = (tail+1)%1000000;
        }
        System.out.println();

        while(head != tail) {
            int num = q[head++];
            while (top > -1 && num >= stack[top]) {
                q[tail] = stack[top--];
                tail = (tail+1)%1000000;
            }
            stack[++top] = num;
        }
        System.out.print("정렬후 : ");
        while(top > -1) {
            System.out.print(stack[top--] + " ");
        }
    }
}
