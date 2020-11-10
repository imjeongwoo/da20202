import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int start, end, min, max, sum;

        for (int i = 1; i <= n; i++) {
            arr[i] = rand.nextInt(100) + 1; // rand  범위 1 ~ 100
            System.out.print(arr[i]+" ");   // random 값 출력
        }
        System.out.println();

        int[] range = new int[2];
            for (int i = 0; i < 2; i++) {
                range[i] = sc.nextInt(); // 구간 입력
            }
            start = range[0]; end = range[1];
            max = min = arr[start];
            sum = 0;
            for (int i = start; i <= end; i++) {
                if(arr[i] < min) min = arr[i];
                if(arr[i] > max) max = arr[i];
                sum += arr[i];
            }
            System.out.println(min + " " + max + " " + sum);
    }
}