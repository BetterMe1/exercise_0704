package exercise.exercise_0630;

/*
链式A+B

有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
编写函数对这两个整数求和，并用链表形式返回结果。
给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
测试样例：
{1,2,3},{3,2,1}
返回：{4,4,4}
 */
import java.util.*;
public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        ListNode sum = new ListNode(-1);
        ListNode head = sum;
        int c = 0;//进位
        int n1 = 0;
        int n2 = 0;
        while(a!= null || b != null){
            n1 = a==null ? 0 : a.val;
            n2 = b==null ? 0 : b.val;
            sum.next = new ListNode((n1+n2+c)%10);
            c = (n1+n2+c)/10;
            if(a != null){
                a = a.next;
            }
            if(b != null){
                b = b.next;
            }
            sum = sum.next;
        }
        if(c != 0){
            sum.next = new ListNode(c);
        }
        return head.next;
    }
}