package Reverse_Nodes_in_k_Group;

import Others.ListNode;
import Others.NodeList;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        /**
         * store k nodes in list. If list.size == k, reverse them all, else return head directly.
         * 8ms
         */
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null && list.size() < k) {
            list.add(tmp);
            tmp = tmp.next;
        }
        if (list.size() < k) return head;
        for (int i = list.size() - 1; i >= 1; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = reverseKGroup(tmp, k);
        return list.get(list.size() - 1);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.reverseKGroup(new NodeList(new int[]{1,2,3,4,5}).head, 2));//2->1->4->3->5
        System.out.println(s.reverseKGroup(new NodeList(new int[]{1,2,3,4,5}).head, 3));//3->2->1->4->5
	}
}