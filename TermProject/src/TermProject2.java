import java.util.Random;
import java.util.Scanner;

public class TermProject2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int n = sc.nextInt();  // n의 값 입
        int[] arr = new int[n+1];
        int min, max, sum;

        for (int i = 1; i <= n; i++) {
            arr[i] = rand.nextInt(100) + 1; //  data의 범위 1 ~ 100
            System.out.print(arr[i]+" ");   // data 값 출력
        }
        System.out.println();

        int k = sc.nextInt(); // k 값 입력
        for (int j = 0; j < k; j++) {
            int maxStart = n-1, minSatrt =1, maxEnd = n;
            int start = (int)(Math.random() * (maxStart - minSatrt + 1) + minSatrt);    // start의 범위 1 ~ n-1
            int minEnd = start+1;
            int end = (int)(Math.random() * (maxEnd - minEnd + 1) + minEnd);    // end의 범위 start+1 ~ n

            max = min = arr[start];
            sum = 0;
            for (int i = start; i <= end; i++) {
                if(arr[i] < min) min = arr[i];
                if(arr[i] > max) max = arr[i];
                sum += arr[i];
            }
            System.out.println(j+1 + "구간 = (" + start + ", " + end + ")");
            System.out.println("Min: " + min + " Max: " + max + " Sum: " + sum + "\n");
        }
    }
}
