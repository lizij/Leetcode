package Odd_Even_Linked_List;

import Others.ListNode;
import Others.NodeList;
import edu.princeton.cs.algs4.StdOut;

public /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.oddEvenList(new NodeList(new int[]{1, 2, 3, 4, 5}).head));
        StdOut.println(s.oddEvenList(new NodeList(new int[]{}).head));
        StdOut.println(s.oddEvenList(new NodeList(new int[]{1, 2, 3}).head));
        StdOut.println(s.oddEvenList(new NodeList(new int[]{1, 2}).head));
        StdOut.println(s.oddEvenList(new NodeList(new int[]{1, 2, 3, 4}).head));
	}
}