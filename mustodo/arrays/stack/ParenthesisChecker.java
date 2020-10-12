package mustodo.arrays.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {
        String s  = "[()]{}{[()()]()}";
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        boolean isBalanced = isBalanced(s,map);
        System.out.println(isBalanced);
    }

    private static boolean isBalanced(String s, Map<Character, Character> map) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c == '{' || c=='['||c=='('){
                stack.push(c);
            }
            else{
                switch (c) {
                    case '}':
                        if (stack.isEmpty() || stack.peek() != '{') {
                            return false;
                        } else {
                            stack.pop();
                        }
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[') {
                            return false;
                        } else {
                            stack.pop();
                        }
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(') {
                            return false;
                        } else {
                            stack.pop();
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + c);
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }


}
