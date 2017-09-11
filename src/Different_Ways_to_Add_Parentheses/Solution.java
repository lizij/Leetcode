package Different_Ways_to_Add_Parentheses;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        /**
         * separate input into two parts, calculate results of part 1 and part 2, then add them into result in terms of the operator.
         * 284ms
         */
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (c == '+' || c == '-' || c == '*'){
//                String p1 = input.substring(0, i);
//                String p2 = input.substring(i + 1);
//                List<Integer> l1 = diffWaysToCompute(p1);
//                List<Integer> l2 = diffWaysToCompute(p2);
//                for (Integer i1: l1){
//                    for (Integer i2: l2){
//                        switch (c){
//                            case '+':
//                                res.add(i1 + i2);
//                                break;
//                            case '-':
//                                res.add(i1 - i2);
//                                break;
//                            case '*':
//                                res.add(i1 * i2);
//                                break;
//                            default:
//                                break;
//                        }
//                    }
//                }
//            }
//        }
//        if (res.size() == 0){
//            res.add(Integer.parseInt(input));
//        }

        /**
         * generate all expressions then use Calculator to calculate them
         * 43ms
         */

        List<String> expList = generate(input);
        for (String s: expList){
            res.add(new Calculator(s).calculate());
        }
        return res;
    }

    private List<String> generate(String input){
        Calculator c = new Calculator(input);
        List<String> inOrder = c.getInOrder();
        List<String> res = addParenthesis(inOrder, 0, inOrder.size() - 1);
        return res;
    }

    private List<String> addParenthesis(List<String> inOrder, int lo, int hi){
        List<String> res = new ArrayList<>();
        if (lo == hi){
            res.add(inOrder.get(lo));
            return res;
        }
        for (int i = lo; i <= hi; i++) {
            String s = inOrder.get(i);
            if (Character.isDigit(s.charAt(0))) continue;
            List<String> part1 = addParenthesis(inOrder, lo, i - 1);
            List<String> part2 = addParenthesis(inOrder, i + 1, hi);
            for (String p1: part1){
                for (String p2: part2){
                    res.add("(" + p1 + ")" + s + "(" + p2 + ")");
                }
            }
        }
        return res;
    }

    private static class Calculator{
        private String expression;

        public Calculator(String e){
            expression = e;
        }

        public List<String> getInOrder(){
            List<String> res = new ArrayList<>();
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (Character.isDigit(c)){
                    num.append(c);
                }
                else{
                    if (num.length() > 0){
                        res.add(num.toString());
                    }
                    res.add(c + "");
                    num.setLength(0);
                }
            }
            if (num.length() > 0) res.add(num.toString());
            return res;
        }

        private List<String> getPostOrder(List<String> inOrder){
            List<String> res = new ArrayList<>();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < inOrder.size(); i++) {
                String s = inOrder.get(i);
                if (Character.isDigit(s.charAt(0))){
                    res.add(s);
                }
                else{
                    switch (s.charAt(0)){
                        case '(':
                            stack.push(s);
                            break;
                        case ')':
                            while (!stack.peek().equals("(")){
                                res.add(stack.pop());
                            }
                            stack.pop();
                            break;
                        default:
                            while (!stack.isEmpty() && compare(stack.peek(), s)){
                                res.add(stack.pop());
                            }
                            stack.push(s);
                            break;
                    }
                }
            }
            while (!stack.isEmpty()){
                res.add(stack.pop());
            }
            return res;
        }

        private boolean compare(String peek, String cur){
            if (peek.equals("*") && (cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/"))) return true;
            if (peek.equals("/") && (cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/"))) return true;
            if (peek.equals("+") && (cur.equals("+") || cur.equals("-"))) return true;
            if (peek.equals("-") && (cur.equals("+") || cur.equals("-"))) return true;
            return false;
        }
        
        public int calculate(){
            List<String> inOrder = getInOrder();
            List<String> postOrder = getPostOrder(inOrder);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < postOrder.size(); i++) {
                String s = postOrder.get(i);
                if (Character.isDigit(s.charAt(0))){
                    stack.push(Integer.parseInt(s));
                }
                else{
                    Integer back = stack.pop();
                    Integer front = stack.pop();
                    Integer res = 0;
                    switch (s.charAt(0)){
                        case '+':
                            res = front + back;
                            break;
                        case '-':
                            res = front - back;
                            break;
                        case '*':
                            res = front * back;
                            break;
                        case '/':
                            res = front / back;
                            break;
                        default:
                            break;
                    }
                    stack.push(res);
                }
            }
            return stack.pop();
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		StdOut.println(s.diffWaysToCompute("2*3-4*5"));
	}
}