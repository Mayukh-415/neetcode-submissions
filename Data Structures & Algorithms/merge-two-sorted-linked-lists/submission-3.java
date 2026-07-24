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
// 2 5 6 7
// 1 1 3 4 8 9 

// (1)->(2)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null && list2 == null) return null;
        // if(list1== null && list2 != null) return list2;
        // if(list2== null && list1 != null) return list1;

        ListNode dummy = new ListNode(0);
        ListNode current_node = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                current_node.next = list1;
                list1 = list1.next;
            } else {
                current_node.next = list2;
                list2 = list2.next;
            }

            current_node = current_node.next;
        }

        if(list1 != null) {
            current_node.next = list1;
            list1 = list1.next;
        }
        else {
            current_node.next = list2;
            list2 = list2.next;
        }
        return dummy.next;
    }
}