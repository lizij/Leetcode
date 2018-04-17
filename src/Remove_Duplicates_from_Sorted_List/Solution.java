package Remove_Duplicates_from_Sorted_List;

import Others.ListNode;
import Others.NodeList;


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = head;
        while (tmp.next != null){
            if (tmp.val == tmp.next.val) tmp.next = tmp.next.next;
            else tmp = tmp.next;
        }
        return head;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.deleteDuplicates(new NodeList(new int[]{1, 1, 2}).head));
        System.out.println(s.deleteDuplicates(new NodeList(new int[]{1, 1, 2, 3, 3}).head));
	}
}