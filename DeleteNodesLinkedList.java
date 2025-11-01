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
    public ListNode modifiedList(int[] nums, ListNode head) {
        //storing the values and if we find it or not
        HashMap<Integer, Boolean> myMap = new HashMap<>();
        for (int n : nums) {
            myMap.put(n, true);
        }

        //finding the deletions then actually deleting it
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //set the current one to be the dummy. now we find it and remove it.
        ListNode curr = dummy;

        //removal time, keep going until we reach the end.
        while (curr.next != null) {
            //skip it
            if (myMap.containsKey(curr.next.val)) {
                curr.next = curr.next.next; 
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}