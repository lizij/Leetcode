package Implement_Queue_using_Stacks;



import java.util.Stack;

public class Solution {
    MyQueue myQueue;

    public Solution() {
        myQueue = new MyQueue();
    }

    class MyQueue {
        Stack<Integer> stack;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            Stack<Integer> tmp = new Stack<>();
            while (!stack.empty()) tmp.push(stack.pop());
            stack.push(x);
            while (!tmp.empty()) stack.push(tmp.pop());
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.empty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.myQueue.empty());
		s.myQueue.push(1);
		s.myQueue.push(2);
		s.myQueue.push(3);
		s.myQueue.push(4);
        System.out.println(s.myQueue.empty());
        System.out.println(s.myQueue.pop());
        System.out.println(s.myQueue.pop());
        System.out.println(s.myQueue.pop());
        System.out.println(s.myQueue.pop());
        System.out.println(s.myQueue.empty());
	}
}