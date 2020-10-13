import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack1874 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int s = 1;

        boolean isTrue = true;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (isTrue) {
                if (arr[i] >= s) {
                    while (arr[i] >= s) {
                        stack.push(s++);
                        sb.append("+\n");
                    }
                }
                if (stack.empty()) {
                    isTrue = false;
                    break;
                } else {
                    while (stack.peek() >= arr[i]) {
                        stack.pop();
                        sb.append("-\n");
                        if(stack.empty()) break;
                    }
                }
            }
        }
        if(isTrue) System.out.println(sb.toString());
        else System.out.println("NO");
    }
}
// 꺼낼 숫자가 top 보다 작