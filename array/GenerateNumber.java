package array;

import java.util.Stack;

public class GenerateNumber {

    public static void main(String[] args) {

        String input  = "DIDIDIDI";

        generateNumber(input);
    }

    private static void generateNumber(String input) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<=input.length();i++){
            stack.push(i+1);
            if(i== input.length() ||input.charAt(i) == 'I'){
                while (!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
            }
        }

    }
}
