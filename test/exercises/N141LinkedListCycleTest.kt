package exercises

import org.junit.Assert.*
import org.junit.Test

class N141LinkedListCycleTest {
    @Test
    fun testHasCycle_cyclePresent() {
        // Create a linked list with a cycle: 3 -> 2 -> 0 -> -4 -> (2)
        val head = ListNode(3)
        val node2 = ListNode(2)
        val node0 = ListNode(0)
        val nodeMinus4 = ListNode(-4)

        head.next = node2
        node2.next = node0
        node0.next = nodeMinus4
        nodeMinus4.next = node2 // Creates the cycle

        val detector = N141LinkedListCycle()
        assertTrue(detector.hasCycle(head))
    }

    @Test
    fun testHasCycle_noCycle() {
        // Create a linked list with no cycle: 1 -> 2 -> 3 -> 4
        val head = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)

        head.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = null // No cycle

        val detector = N141LinkedListCycle()
        assertFalse(detector.hasCycle(head))
    }

    @Test
    fun testHasCycle_emptyList() {
        // Test with an empty list
        val detector = N141LinkedListCycle()
        assertFalse(detector.hasCycle(null))
    }

    @Test
    fun testHasCycle_singleNodeNoCycle() {
        // Test with a single node, no cycle
        val head = ListNode(1)
        head.next = null

        val detector = N141LinkedListCycle()
        assertFalse(detector.hasCycle(head))
    }

    @Test
    fun testHasCycle_singleNodeCycle() {
        // Test with a single node pointing to itself (cycle)
        val head = ListNode(1)
        head.next = head // Creates a cycle

        val detector = N141LinkedListCycle()
        assertTrue(detector.hasCycle(head))
    }

    @Test
    fun testHasCycle_twoNodesNoCycle() {
        // Test with two nodes, no cycle
        val head = ListNode(1)
        val node2 = ListNode(2)
        head.next = node2
        node2.next = null

        val detector = N141LinkedListCycle()
        assertFalse(detector.hasCycle(head))
    }

    @Test
    fun testHasCycle_twoNodesCycle() {
        // Test with two nodes, cycle
        val head = ListNode(1)
        val node2 = ListNode(2)
        head.next = node2
        node2.next = head // Creates a cycle

        val detector = N141LinkedListCycle()
        assertTrue(detector.hasCycle(head))
    }
}