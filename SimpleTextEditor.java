import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SimpleTextEditor {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            switch (type) {
                case 1: // Append W
                    history.push(sb.toString());
                    String w = st.nextToken();
                    sb.append(w);
                    break;

                case 2: // Delete k characters
                    history.push(sb.toString());
                    int k = Integer.parseInt(st.nextToken());
                    sb.delete(sb.length() - k, sb.length());
                    break;

                case 3: // Print k-th character
                    int idx = Integer.parseInt(st.nextToken());
                    System.out.println(sb.charAt(idx - 1));
                    break;

                case 4: // Undo
                    if (!history.isEmpty()) {
                        sb = new StringBuilder(history.pop());
                    }
                    break;
            }
        }
    }
}