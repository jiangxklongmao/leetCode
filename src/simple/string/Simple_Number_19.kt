package simple.string

class Simple_Number_19 {

    //region 19. 删除链表的倒数第N个节点

    /*给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

    示例：

    给定一个链表: 1->2->3->4->5, 和 n = 2.

    当删除了倒数第二个节点后，链表变为 1->2->3->5.
    说明：

    给定的 n 保证是有效的。

    进阶：

    你能尝试使用一趟扫描实现吗？*/

    //endregion

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val original = createListNode(intArrayOf(1, 2, 3, 4, 5))
            print(original)
            val result = removeNthFromEnd(original, 2)
            print(result)
        }

        /**
         * 双指针法
         * @param head ListNode?
         * @param n Int
         * @return ListNode?
         */
        private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            if (head == null || n < 0) {
                return head
            }
            val dummy = ListNode(0)
            dummy.next = head
            var n = n
            var fast: ListNode? = dummy
            var slow: ListNode? = dummy

            while (n > 0) {
                if (fast?.next != null) {
                    fast = fast.next
                    n--
                } else {
                    println("N 不合法")
                }
            }

            while (fast?.next != null) {
                fast = fast.next
                slow = slow?.next
            }

            slow?.next = slow?.next?.next

            return dummy.next
        }


        private fun createListNode(array: IntArray): ListNode? {
            if (array.isEmpty()) {
                return null
            }
            val dummyNode = ListNode(0)
            var node: ListNode? = ListNode(array[0])
            dummyNode.next = node
            for (index in 1 until array.size) {
                node!!.next = ListNode(array[index])
                node = node!!.next
            }

            return dummyNode.next
        }

        private fun print(head: ListNode?) {
            if (head == null) {
                return
            }
            println()
            var p = head
            while (p != null) {
                print("${p.`val`}->")
                p = p.next
            }
        }

        class ListNode(val `val`: Int) {
            var next: ListNode? = null
        }
    }

}