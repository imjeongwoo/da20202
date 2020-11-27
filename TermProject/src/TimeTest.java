import java.util.Random;
import java.util.Scanner;

public class TimeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random(100);

        int n = sc.nextInt();  // n의 값 입력
        int[] arr = new int[n+1];
        int min, max, sum;

        for (int i = 1; i <= n; i++) {
            arr[i] = rand.nextInt(1000000) + 1; //  data의 범위 1 ~ 100000
//            System.out.print(arr[i]+" ");   // data 값 출력
        }
//        System.out.println();

        int k = sc.nextInt(); // k 값 입력

        long total_time = 0;
        for (int j = 0; j < k; j++) {
            int start = rand.nextInt(n) + 1;
            int end = rand.nextInt(n) + 1;

            if (start > end) {
                int tmp = start;
                start = end;
                end = tmp;
            }

            max = min = arr[start];
            sum = 0;

            long t = System.currentTimeMillis();
            for (int i = start; i <= end; i++) {
                if(arr[i] < min) min = arr[i];
                if(arr[i] > max) max = arr[i];
                sum += arr[i];
            }
            long elapsed = System.currentTimeMillis() - t;
            total_time += elapsed;
//            System.out.println(j+1 + "구간 = (" + start + ", " + end + ")");
//            System.out.println("Min: " + min + " Max: " + max + " Sum: " + sum + "\n");
        }
        System.out.println("Elapsed : " + total_time + "ms");
    }
}
