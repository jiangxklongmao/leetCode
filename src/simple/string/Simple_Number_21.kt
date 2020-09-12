package simple.string

import dataStructure.ListNode
import dataStructure.createListNode
import dataStructure.printListNode

class Simple_Number_21 {

    //region 21.合并两个有序链表

    /*
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

    示例：

    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4
    */

    //endregion
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val original1 = createListNode(intArrayOf(1, 2, 4))
            val original2 = createListNode(intArrayOf(1, 3, 4))
            val result = mergeTwoLists(original1, original2)
            printListNode(result)
        }

        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            val dummyNode = ListNode(0)

            var list1 = l1
            var list2 = l2
            var temp: ListNode? = dummyNode

            while (list1 != null && list2 != null) {
                if (list1.`val` < list2.`val`) {
                    temp?.next = list1
                    list1 = list1.next
                } else {
                    temp?.next = list2
                    list2 = list2.next
                }
                temp = temp?.next
            }

            while (list1 != null) {
                temp?.next = list1
                list1 = list1.next
                temp = temp?.next
            }

            while (list2 != null) {
                temp?.next = list2
                list2 = list2.next
                temp = temp?.next
            }
            return dummyNode.next
        }
    }
}