package offer;

import dataStructure.ListNode;
import dataStructure.ListNodeKt;

import java.util.Arrays;

public class Offer_06 {

    //region 剑指 Offer 06. 从尾到头打印链表  难度:简单
    /*输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

             

    示例 1：

    输入：head = [1,3,2]
    输出：[2,3,1]
             

    限制：

            0 <= 链表长度 <= 10000*/
    //endregion

    public static void main(String[] args) {
        ListNode listNode = ListNodeKt.createListNode(new int[]{1, 3, 2});
        int[] result = reversePrint(listNode);

        for (int value : result) {
            System.out.println(value);
        }
    }

    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        ListNode newHead = null;
        ListNode p = null;
        int size = 0;

        while (head != null) {
            p = head;
            head = head.getNext();

            p.setNext(newHead);
            newHead = p;
            size++;
        }

        int[] result = new int[size];
        int k = 0;
        p = newHead;
        while (p != null) {
            result[k++] = p.getVal();
            p = p.getNext();
        }

        return result;
    }


}
