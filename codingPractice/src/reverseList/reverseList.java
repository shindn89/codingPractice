package reverseList;

import AddTwoNumber.ListNode;

public class reverseList {
	public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
	
	//recursion version
	public ListNode reverseList1(ListNode head) {
		//base case check header or next header
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

}
