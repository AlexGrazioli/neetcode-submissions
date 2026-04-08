/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode reversedSecondHalf = null;

        while (secondHalf != null) {
            ListNode temp = secondHalf.next;
            secondHalf.next = reversedSecondHalf;
            reversedSecondHalf = secondHalf;
            secondHalf = temp;
        }

        while (head != null && reversedSecondHalf != null) {
            ListNode next1 = head.next;
            ListNode next2 = reversedSecondHalf.next;

            head.next = reversedSecondHalf;
            reversedSecondHalf.next = next1;

            head = next1;
            reversedSecondHalf = next2;
        }
    }
}
