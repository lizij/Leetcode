package Min_Stack;

import java.util.Stack;

public class Solution {
    /**
     * One stack solution:
     * push [data, the current min] in one operation
     * 108ms
     */
    class MinStack {
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        public void push(int x) {
            // only push the old minimum value when the current
            // minimum value changes after pushing the new value x
            if(x <= min){
                stack.push(min);
                min=x;
            }
            stack.push(x);
        }

        public void pop() {
            // if pop operation could result in the changing of the current minimum value,
            // pop twice and change the current minimum value to the last minimum value.
            if(stack.pop() == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }


    /**
     * Two stack solution:
     * use one stack to store data and another one to store every min data
     * 125ms
     */
//    class MinStack {
//        Stack<Integer> stack;
//        Stack<Integer> min;
//        /** initialize your data structure here. */
//        public MinStack() {
//            stack = new Stack<>();
//            min = new Stack<>();
//        }
//
//        public void push(int x) {
//            stack.push(x);
//            if (min.isEmpty() || x < min.peek()) {
//                min.push(x);
//            } else {
//                min.push(min.peek());
//            }
//        }
//
//        public void pop() {
//            if (stack.isEmpty()) {
//                throw new IllegalArgumentException("Empty");
//            }
//            min.pop();
//            stack.pop();
//        }
//
//        public int top() {
//            if (stack.isEmpty()) {
//                throw new IllegalArgumentException("Empty");
//            }
//            return stack.peek();
//        }
//
//        public int getMin() {
//            if (stack.isEmpty()) {
//                throw new IllegalArgumentException("Empty");
//            }
//            return min.peek();
//        }
//    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}