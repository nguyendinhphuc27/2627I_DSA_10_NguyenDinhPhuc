import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class EqualStacks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());

        Stack<Integer> stack1 = new Stack< >();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++) {
            h1[i] = Integer.parseInt(st.nextToken());
        }
        int sum1 = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            sum1 += h1[i];
            stack1.push(sum1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) {
            h2[i] = Integer.parseInt(st.nextToken());
        }
        int sum2 = 0;
        for (int i = n2 - 1; i >= 0; i--) {
            sum2 += h2[i];
            stack2.push(sum2);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n3; i++) {
            h3[i] = Integer.parseInt(st.nextToken());
        }
        int sum3 = 0;
        for (int i = n3 - 1; i >= 0; i--) {
            sum3 += h3[i];
            stack3.push(sum3);
        }

        while (!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()) {
            int currentSum1 = stack1.peek();
            int currentSum2 = stack2.peek();
            int currentSum3 = stack3.peek();

            if (currentSum1 == currentSum2 && currentSum2 == currentSum3) {
                System.out.println(currentSum1);
                return;
            }

            if (currentSum1 >= currentSum2 && currentSum1 >= currentSum3) {
                stack1.pop();
            } else if (currentSum2 >= currentSum1 && currentSum2 >= currentSum3) {
                stack2.pop();
            } else if (currentSum3 >= currentSum1 && currentSum3 >= currentSum2) {
                stack3.pop();
            }
        }

        System.out.println(0);
    }
}
