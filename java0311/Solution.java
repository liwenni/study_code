package java0311;

import java.util.Stack;

class Solution {
    public static boolean backspaceCompare(String S, String T) {

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        char[] c1 = S.toCharArray();
        char[] c2 = T.toCharArray();


            for(int i = 0;i < c1.length;i++){
                if(c1[i] != '#'){
                    stack1.push(c1[i]);

                }else {
                    if(!stack1.isEmpty()) {
                    stack1.pop();
                }
                }
            }


            for(int i = 0;i < c2.length;i++){

                if(c2[i] != '#'){
                    stack2.push(c2[i]);
                }else {
                    if(!stack2.isEmpty()) {
                    stack2.pop();
                }
                }
            }
        if(stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }
        if((stack1.isEmpty() && !stack2.isEmpty()) ||(!stack1.isEmpty() && stack2.isEmpty())){
            return false;
        }
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            Character ch1 = stack1.peek();
            Character ch2 = stack2.peek();
            if (ch1 != ch2) {
                return false;
            }
            else{
                stack1.pop();
                stack2.pop();
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();

    }

    public static void main(String[] args) {
        String s = "bxj##tw";

        String t = "bxj###tw";
        System.out.println(backspaceCompare(s,t));
    }
}
