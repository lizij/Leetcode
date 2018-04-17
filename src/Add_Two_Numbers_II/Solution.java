package Add_Two_Numbers_II;

import Others.ListNode;
import Others.NodeList;


import java.util.Stack;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        //reverse digits
        for (ListNode tmp = l1; tmp != null; tmp = tmp.next) s1.push(tmp.val);
        for (ListNode tmp = l2; tmp != null; tmp = tmp.next) s2.push(tmp.val);

        Stack<Integer> res = new Stack<>();
        boolean carry = false;
        while (!s1.isEmpty() || !s2.isEmpty()){
            //get digit
            int value = 0;
            if (!s1.isEmpty()) value += s1.pop();
            if (!s2.isEmpty()) value += s2.pop();

            //add carry
            if (carry){
                value += 1;
                carry = false;
            }

            //carry exist?
            if (value >= 10){
                value -= 10;
                carry = true;
            }

            //add value to res
            res.push(value);
        }
        if (carry) res.push(1);

        //store res in NodeList
        ListNode resNode = null;
        for (ListNode tmp = resNode; !res.isEmpty();){
            if (tmp == null){
                resNode = tmp = new ListNode(res.pop());
            }
            else{
                tmp.next = new ListNode(res.pop());
                tmp = tmp.next;
            }
        }
        return resNode;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        NodeList l1 = new NodeList(new int[]{7, 2, 4, 3});
        NodeList l2 = new NodeList(new int[]{5, 6, 4});
        ListNode res = s.addTwoNumbers(l1.head, l2.head);
        while (res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
	}
}