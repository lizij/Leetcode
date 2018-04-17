package Linked_List_Components;

import Others.ListNode;
import Others.NodeList;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int numComponents(ListNode head, int[] G) {
	    if (head == null || G == null || G.length == 0) {
	        return 0;
        }
        /**
         * Set solution
         * 20ms
         */

        Set<Integer> set = new HashSet<>();
	    for (int g: G) set.add(g);

	    ListNode cur = head;
	    int res = 0;
	    while (cur != null) {
	        if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))) {
	            res++;
            }
            cur = cur.next;
        }

		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numComponents(new NodeList(new int[] { 0, 1, 2, 3 }).head, new int[] { 0, 1, 3 })); // 2
		System.out.println(s.numComponents(new NodeList(new int[] { 0, 1, 2, 3, 4 }).head, new int[] { 0, 3, 1, 4 })); // 2
	}
}