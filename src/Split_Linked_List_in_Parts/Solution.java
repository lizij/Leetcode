package Split_Linked_List_in_Parts;

import Others.ListNode;
import Others.NodeList;


public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) return res;
        int len = 0;
        for (ListNode node = root; node != null; len++, node = node.next);
        int basic = len / k, plus = len % k;
        ListNode node = root;
        int pos = 0;
        while (node != null) {
            res[pos] = node;
            ListNode tail = node;
            for (int i = 0; i < basic - 1;i++) {
                tail = tail.next;
            }
            if (basic > 0 && plus > 0) {
                tail = tail.next;
                plus--;
            }
            node = tail.next;
            tail.next = null;
            pos++;
        }
        return res;
    }

    static void printListNodes(ListNode[] listNode) {
        System.out.print("[");
        for (ListNode node: listNode) {
            System.out.print("[" + node + "]");
        }
        System.out.println("]");
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        printListNodes(s.splitListToParts(new NodeList(new int[]{1,2,3}).head, 5));//[[1],[2],[3],[],[]]
        printListNodes(s.splitListToParts(new NodeList(new int[]{1,2,3,4,5,6,7,8,9,10}).head, 3));//[[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
        printListNodes(s.splitListToParts(new NodeList(new int[]{1,2,3,4,5,6,7,8,9,10}).head, 7));//[[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
	}
}