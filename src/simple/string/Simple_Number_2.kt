package simple.string

class Simple_Number_2 {

    //region 2、两数相加

    /* 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

     示例：

     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807*/

    //endregion

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val list1 = arrayToListNode(intArrayOf(2, 4, 3))
            val list2 = arrayToListNode(intArrayOf(5, 6, 4))
            val result = addTwoNumbers2(list1!!, list2!!)
            result?.listToString()
        }

        /**
         * 先遍历获取数据  再求和  再分割数据
         * @param list1 ListNode
         * @param list2 ListNode
         * @return ListNode?
         */
        private fun addTwoNumbers(list1: ListNode, list2: ListNode): ListNode? {
            var head: ListNode? = null
            var sum = 0
            var number = 0
            var decimalism = 1
            var p: ListNode? = list1
            while (p != null) {
                number += decimalism * p.value
                decimalism *= 10
                p = p.next
            }
            sum = number
            number = 0
            decimalism = 1
            p = list2
            while (p != null) {
                number += decimalism * p.value
                decimalism *= 10
                p = p.next
            }
            sum += number

            if (sum == 0) {
                return ListNode(0)
            } else {
                decimalism = 10
                var value = sum % decimalism

                var surplus = sum / decimalism

                head = ListNode(value)
                var p: ListNode? = head
                value = surplus % decimalism
                surplus /= decimalism
                while (surplus != 0 || value != 0) {
                    p?.next = ListNode(value)
                    p = p?.next
                    value = surplus % decimalism
                    surplus /= decimalism
                }
            }
            return head
        }

        /**
         * 根据加法规则  进位特性 按位加
         * @param list1 ListNode?
         * @param list2 ListNode?
         * @return ListNode?
         */
        private fun addTwoNumbers2(list1: ListNode?, list2: ListNode?): ListNode? {
            if (list1 == null && list2 == null) {
                return null
            }
            val dummyNode = ListNode(0)
            var tempNode = dummyNode
            var l1 = list1
            var l2 = list2
            //进位
            var carry = 0
            while (l1 != null || l2 != null || carry != 0) {
                val value1 = l1?.value ?: 0
                val value2 = l2?.value ?: 0
                val sum = value1 + value2 + carry

                tempNode.next = ListNode(sum % 10)
                tempNode = tempNode.next!!
                carry = sum / 10
                l1 = l1?.next ?: null
                l2 = l2?.next ?: null
            }

            return dummyNode.next
        }

        fun arrayToListNode(array: IntArray): ListNode? {
            if (array.isEmpty()) {
                return null
            }

            val head = ListNode(array[0])
            var temp = head
            for (index in 1..array.lastIndex) {
                temp.next = ListNode(array[index])
                temp = temp.next!!
            }
            return head
        }
    }

    class ListNode(val value: Int) {
        var next: ListNode? = null

        fun listToString() {
            var p: ListNode? = this
            while (p != null) {
                print(p.value)
                print("->")
                p = p.next
            }
        }
    }

}