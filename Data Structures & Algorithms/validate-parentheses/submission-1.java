class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char elem : s.toCharArray()) {
            if (elem == '(' || elem == '[' || elem == '{')
                stack.push(elem);
            else if (elem == '}' && !stack.isEmpty()) {
                if (stack.peek() != '{')
                    return false;
                stack.pop();
            } else if (elem == ']' && !stack.isEmpty()) {
                if (stack.peek() != '[')
                    return false;
                stack.pop();
            } else if (elem == ')' && !stack.isEmpty()) {
                if (stack.peek() != '(')
                    return false;
                stack.pop();
            } else {
                return false;
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }
}
