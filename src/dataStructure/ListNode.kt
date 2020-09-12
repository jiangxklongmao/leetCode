package dataStructure

import simple.string.Simple_Number_19

class ListNode(val `val`: Int) {
    var next: ListNode? = null
}

fun createListNode(array: IntArray): ListNode? {
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

 fun printListNode(head: ListNode?) {
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