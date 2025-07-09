package exercises


data class ListNode(var value: Int) {
    var next: ListNode? = null
}

class N141LinkedListCycle{
    //this algorithm is called  Floyd's Tortoise and Hare
    fun hasCycle(head: ListNode?): Boolean {

        var slow = head
        var fast = head


        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                return true
            }
        }

        return false

    }
}

