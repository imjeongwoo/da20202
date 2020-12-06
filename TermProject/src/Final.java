import java.util.Random;
import java.util.Scanner;

public class Final {
    static Random rand = new Random(1000);
    static int[] arr, sumArr, minSegTree, maxSegTree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // n의 값 입력
        int k = sc.nextInt(); // k 값 입력

        arr = new int[n+1]; sumArr = new int[n+1];
        minSegTree = new int[4*n]; maxSegTree = new int[4*n];

        makeData(n); // 데이터 생성, 누합 저적
        initMinTree(1, 1, n);
        initMaxTree(1, 1, n);
        findMinMaxSum(k, n);    // 구간 최소, 최대, 합
    }
    // 랜덤 데이터 생성 및 누적합 저장함수
    public static void makeData(int n) {
        for (int i = 1; i <= n; i++) {
            //  data의 범위 1 ~ 1000000
            arr[i] = rand.nextInt(1000000) + 1;
            // 누적 합을 sum배열에 저장
            sumArr[i] = sumArr[i-1] + arr[i];
            System.out.print(arr[i]+" ");   // data 값 출력
        }
        System.out.println();
    }
    // minSegTree init function
    public static int initMinTree(int node, int start, int end) {
        // leafNode
        if(start == end) return minSegTree[node] = arr[start];

        int mid = (start+end)/2;
        int leftChild = initMinTree(2*node, start, mid); // 왼쪽 자식 노드(2 * 현재노드index)
        int rightChild = initMinTree(2*node+1, mid+1, end); // 오른쪽 자식 노드(2 * 현재노드index + 1)
        return minSegTree[node] = (leftChild < rightChild) ? leftChild : rightChild;  // 둘중에 작은값
    }
    // maxSegTree init
    public static int initMaxTree(int node, int start, int end) {
        // leafNode
        if(start == end) return maxSegTree[node] = arr[start];

        int mid = (start+end)/2;
        int leftChild = initMaxTree(2*node, start, mid); // 왼쪽 자식 노드(2 * 현재노드index)
        int rightChild = initMaxTree(2*node+1, mid+1, end); // 오른쪽 자식 노드(2 * 현재노드index + 1)
        return maxSegTree[node] = (leftChild > rightChild) ? leftChild : rightChild; // 둘중에 큰값
    }
    public static int findMin(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return Integer.MAX_VALUE;
        if (left <= start && right >= end) return minSegTree[node];

        int mid = (start+end)/2;
        int leftChild = findMin(2*node, start, mid, left, right);
        int rightChild = findMin(2*node+1, mid+1, end, left, right);
        return (leftChild < rightChild) ? leftChild : rightChild;
    }
    public static int findMax(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return Integer.MIN_VALUE;
        if (left <= start && right >= end) return maxSegTree[node];

        int mid = (start+end)/2;
        int leftChild = findMax(2*node, start, mid, left, right);
        int rightChild = findMax(2*node+1, mid+1, end, left, right);
        return (leftChild > rightChild) ? leftChild : rightChild;
    }
    public static void findMinMaxSum(int k, int n) {
        for(int i=0; i<k; i++) {
            int start = rand.nextInt(n) + 1;
            int end = rand.nextInt(n) + 1;

            if (start > end) {
                int tmp = start;
                start = end;
                end = tmp;
            }
            int min = findMin(1, 1, n, start, end);
            int max = findMax(1, 1, n, start, end);
            int sum = sumArr[end] - sumArr[start-1];

            System.out.println(i+1 + "번째 구간 = (" + start + ", " + end + ")");
            System.out.println("Min: " + min + " Max: " + max + " Sum: " + sum + "\n");
        }
    }
}
