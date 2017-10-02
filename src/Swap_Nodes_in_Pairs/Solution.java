package Swap_Nodes_in_Pairs;

import Others.ListNode;
import Others.NodeList;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        /**
         * exchange vals
         * 4ms
         */
//        if (head == null) return null;
//        for (ListNode tmp = head; tmp != null && tmp.next != null; tmp = tmp.next) {
//            int val = tmp.val;
//            tmp.val = tmp.next.val;
//            tmp.next.val = val;
//        }
        /**
         * exchange nodes
         */
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.swapPairs(new NodeList(new int[]{1,2,3,4}).head));
//        StdOut.println(s.swapPairs(new NodeList(new int[]{1,2}).head));
	}
}