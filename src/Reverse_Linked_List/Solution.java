package Reverse_Linked_List;

import Others.ListNode;
import Others.NodeList;


import java.util.Stack;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode res = null, tmp = null;

        Stack<ListNode> stack = new Stack<>();
        for (ListNode t = head; t != null; t = t.next) stack.push(t);
        do{
            if (res == null){
                res = tmp = stack.pop();
            }
            else{
                tmp.next = stack.pop();
                tmp = tmp.next;
            }
        }while (!stack.empty());
        tmp.next = null;
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        NodeList nodeList1 = new NodeList(new int[]{1, 2, 3, 4});
        ListNode output1 = s.reverseList(nodeList1.head);
        while (output1 != null){
            System.out.print(output1.val + "->");
            output1 = output1.next;
        }
	}
}