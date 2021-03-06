/**
 * 
 */
package AddTwoNumber;

/**
 * @author DN
 *
 */
public class AddTwoNumber {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0; 
        while (p!=null || q !=null)
        {
            int x = (p!=null) ? p.val : 0;
            int y = (q!=null) ? q.val : 0;
            int sum =  carry+x+y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) 
        {
        	curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		System.out.println("test2");
		System.out.println("test3");
		System.out.println("test4");
		System.out.println("test5 - using command");
		System.out.println("test6 - another command");
	}

}
