package Convert_Sorted_List_to_Binary_Search_Tree;

import Others.ListNode;
import Others.NodeList;
import Others.Tree;
import Others.TreeNode;


import java.util.ArrayList;
import java.util.List;

public /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return generate(head, null);
//        List<Integer> list = new ArrayList<>();
//        for (ListNode tmp = head; tmp != null; tmp = tmp.next) list.add(tmp.val);
//        return generate(list.stream().mapToInt(Integer::intValue).toArray(), 0, list.size() - 1);
    }

    private TreeNode generate(ListNode head, ListNode tail){
        if (head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = generate(head, slow);
        node.right = generate(slow.next, tail);
        return node;
    }

    private TreeNode generate(int[] nums, int lo, int hi){
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = generate(nums, lo, mid - 1);
        node.right = generate(nums, mid + 1, hi);
        return node;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.sortedListToBST(new NodeList(new int[]{1, 2, 3, 4, 5, 6, 7}).head));
	}
}