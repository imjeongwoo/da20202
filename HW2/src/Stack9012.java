import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        String[] command;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            stack.clear();
            command = br.readLine().split("");
            for(int j = 0; j < command.length; j++) {
                if(stack.empty()) stack.push(command[j]);
                else {
                    if (stack.peek().equals("(") && command[j].equals(")")) stack.pop();
                    else stack.push(command[j]);
                }
            }
            if(stack.empty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
