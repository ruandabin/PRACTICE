package top.ruandb.leetcode;
/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @author rdb
 *
 */
public class LeetCode2 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x ;
        }
    }

    public ListNode addTwoNubers(ListNode l1, ListNode l2){
        boolean temp = false ;
        ListNode current = new ListNode(0) ;
        ListNode head = current ;
        while(l1 != null || l2 != null){
            int t1 = l1==null ? 0: l1.val ;
            int t2 = l2==null ? 0: l2.val ;
            if(temp){
                current.next = new ListNode((t1+t2+1)%10);
                //判断是否进位
                temp = (t1+t2+1)/10 > 0 ? true:false;
            }else{
                current.next = new ListNode((t1+t2)%10);
                //判断是否进位
                temp = (t1+t2)/10 > 0 ? true:false;
            }
            current = current.next ;
            if(l1 != null){l1 = l1.next ;}
            if(l2 != null){l2 = l2.next ;}
        }
        //最后一位可能进位
        if(temp){
            current.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        //l1
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4) ;
        l1.next.next = new ListNode(3);
        //l2
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6) ;
        l2.next.next = new ListNode(4);

        LeetCode2 lc = new LeetCode2();
        ListNode head = lc.addTwoNubers(l1, l2);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next ;
        }

    }
}
