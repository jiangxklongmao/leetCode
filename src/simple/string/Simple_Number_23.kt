package simple.string

import dataStructure.ListNode
import dataStructure.createListNode
import dataStructure.printListNode

class Simple_Number_23 {
    //region 23. 合并K个升序链表

    /*给你一个链表数组，每个链表都已经按升序排列。

    请你将所有链表合并到一个升序链表中，返回合并后的链表。

     

    示例 1：

    输入：lists = [[1,4,5],[1,3,4],[2,6]]
    输出：[1,1,2,3,4,4,5,6]
    解释：链表数组如下：
    [
    1->4->5,
    1->3->4,
    2->6
    ]
    将它们合并到一个有序链表中得到。
    1->1->2->3->4->4->5->6
    示例 2：

    输入：lists = []
    输出：[]
    示例 3：

    输入：lists = [[]]
    输出：[]
     

    提示：

    k == lists.length
    0 <= k <= 10^4
    0 <= lists[i].length <= 500
    -10^4 <= lists[i][j] <= 10^4
    lists[i] 按 升序 排列
    lists[i].length 的总和不超过 10^4*/

    //endregion
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lists: Array<ListNode?> = arrayOf(
                createListNode(intArrayOf(1, 4, 5)),
                createListNode(intArrayOf(1, 3, 4)),
                createListNode(intArrayOf(2, 6))
            )
            val result = mergeKLists(lists)
            printListNode(result)
        }

        private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isNullOrEmpty()) {
                return null
            }
            return merge(lists, 0, lists.size - 1)
        }

        private fun merge(lists: Array<ListNode?>, low: Int, high: Int): ListNode? {
            if (low == high) {
                return lists[low]
            }
            val mid = low + (high - low) / 2
            val list1 = merge(lists, low, mid)
            val list2 = merge(lists, mid + 1, high)
            return mergeTwoLists(list1, list2)
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

            temp?.next = list1 ?: list2

            return dummyNode.next
        }

    }
}