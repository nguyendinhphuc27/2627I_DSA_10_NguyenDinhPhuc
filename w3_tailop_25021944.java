    import java.util.Stack;

    public class w3_tailop_25021944 {
        private static int  OperatorPrecedence(char op) {
            switch (op){
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
            }
            return -1;
        }

        public static String infixToPostfix(String expression){
            StringBuilder result = new StringBuilder();
            Stack<Character> stack = new Stack<>();

            for (int i=0;i<expression.length();i++){
                char c = expression.charAt(i);

                if(c==' ') continue;;

                if (Character.isLetterOrDigit(c)){
                    result.append(c);
                }
                else if (c =='('){
                    stack.push(c);
                }
                else if (c == ')'){
                    while(!stack.isEmpty() && stack.peek() != '('){
                        result.append(stack.pop());
                    }
                    if (!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }
                }
                else {
                    while(!stack.isEmpty() && OperatorPrecedence(c) <= OperatorPrecedence(stack.peek())){
                        result.append(stack.peek());
                        stack.pop();
                    }
                    stack.push(c);
                }
            }
            while (!stack.isEmpty()){
                result.append(stack.pop());
            }

            return result.toString();
        }

        static void main() {
            String A = "(3-(4+2)*2)*2-1+3";
            System.out.println("Biểu thức hậu tố:"+infixToPostfix(A));
        }
    }

