class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String elem : tokens) {
            switch (elem) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                }

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                    break;
                }

                default:
                    stack.push(Integer.parseInt(elem));
            }

        }
        return stack.peek();
    }
}
