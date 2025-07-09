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

    //a variation using do while
    fun hasCycle2(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        // Handle empty list or single node case
        if (head == null || head.next == null) {
            return false
        }

        do {
            slow = slow?.next
            fast = fast?.next?.next

            if (slow == fast) {
                return true
            }
        } while (fast?.next != null)

        return false
    }
}

