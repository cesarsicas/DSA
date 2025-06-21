package structures.binarytree.heaps

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


// HeapTest.kt
class HeapTest {

    private lateinit var heap: HeapExercise

    // This function will be executed before each test, ensuring a fresh Heap instance
    @Before
    fun setup() {
        heap = HeapExercise()
    }

    // Helper function to verify the min-heap property
    private fun verifyMinHeapProperty(heapList: List<Int>) {
        if (heapList.size <= 1) {
            return // Empty or only dummy element, property holds
        }
        // Start from index 1 (skipping the dummy at 0)
        for (i in 1 until heapList.size) {
            val leftChildIndex = 2 * i
            val rightChildIndex = 2 * i + 1

            if (leftChildIndex < heapList.size) {
                // If left child exists, parent must be less than or equal to it
                assertTrue(heapList[i] <= heapList[leftChildIndex])
            }
            if (rightChildIndex < heapList.size) {
                // If right child exists, parent must be less than or equal to it
                assertTrue(heapList[i] <= heapList[rightChildIndex])
            }
        }
    }

    @Test
    fun testInitialHeapState() {
        // The heap should initially contain only the dummy element (0)
        assertEquals(listOf(0), heap.getHeap())
        verifyMinHeapProperty(heap.getHeap())
    }

    @Test
    fun testPushSingleElement() {
        heap.push(10)
        // Expected: [0, 10]
        assertEquals(listOf(0, 10), heap.getHeap())
        verifyMinHeapProperty(heap.getHeap())
    }

    @Test
    fun testPushAscendingOrder() {
        heap.push(10)
        heap.push(20)
        heap.push(30)
        // Expected: [0, 10, 20, 30] (no reordering needed)
        assertEquals(listOf(0, 10, 20, 30), heap.getHeap())
        verifyMinHeapProperty(heap.getHeap())
    }

    @Test
    fun testPushDescendingOrder() {
        heap.push(30)
        heap.push(20) // 20 should bubble up above 30
        heap.push(10) // 10 should bubble up above 20
        // Expected: [0, 10, 30, 20]
        assertEquals(listOf(0, 10, 30, 20), heap.getHeap())
        verifyMinHeapProperty(heap.getHeap())
    }

    @Test
    fun testPushMultipleSwaps() {
        heap.push(50)
        heap.push(40)
        heap.push(30)
        heap.push(20)
        heap.push(10) // This should cause multiple swaps to reach the root
        // Expected: [0, 10, 20, 30, 50, 40]
        assertEquals(listOf(0, 10, 20, 40, 50, 30), heap.getHeap())
        verifyMinHeapProperty(heap.getHeap())
    }

    @Test
    fun testPeekEmptyHeap() {
        // Only dummy element exists
        assertNull(heap.peek())
    }

    @Test
    fun testPeekWithElements() {
        heap.push(5)
        heap.push(1)
        heap.push(10)
        // Smallest element should be 1
        assertEquals(1, heap.peek())
        verifyMinHeapProperty(heap.getHeap())
    }

    @Test
    fun testPopSingleElement() {
        heap.push(100)
        assertEquals(listOf(0, 100), heap.getHeap())
        heap.pop()
        // After popping, only the dummy element remains
        assertEquals(listOf(0), heap.getHeap())
        verifyMinHeapProperty(heap.getHeap())
    }

    @Test
    fun testPopMultipleElements() {
        val initialElements = listOf(10, 20, 5, 30, 15)
        for (element in initialElements) {
            heap.push(element)
        }
        // Current state: [0, 5, 15, 10, 30, 20] after pushes
        assertEquals(5, heap.peek())
        verifyMinHeapProperty(heap.getHeap())

        heap.pop() // Removes 5
        // Expected heap after pop: [0, 10, 15, 20, 30] (structure might vary based on rebalancing)
        // The exact order for internal elements can be tricky, but the smallest should be 10 now
        assertEquals(10, heap.peek())
        verifyMinHeapProperty(heap.getHeap())

        heap.pop() // Removes 10
        assertEquals(15, heap.peek())
        verifyMinHeapProperty(heap.getHeap())

        heap.pop() // Removes 15
        assertEquals(20, heap.peek())
        verifyMinHeapProperty(heap.getHeap())

        heap.pop() // Removes 20
        assertEquals(30, heap.peek())
        verifyMinHeapProperty(heap.getHeap())

        heap.pop() // Removes 30
        assertNull(heap.peek()) // Heap should be empty (only dummy remains)
        assertEquals(listOf(0), heap.getHeap())
        verifyMinHeapProperty(heap.getHeap())
    }

    @Test
    fun testPopEmptyHeap() {
        // Heap has only the dummy element [0]
        heap.pop()
        // Should remain [0]
        assertEquals(listOf(0), heap.getHeap())
        verifyMinHeapProperty(heap.getHeap())
    }

    @Test
    fun testSetNewElementsEmptyList() {
        heap.setNewElements(emptyList())
        assertEquals(listOf(0), heap.getHeap()) // Still only the dummy
        verifyMinHeapProperty(heap.getHeap())
    }

    @Test
    fun testSetNewElementsWithValues() {
        heap.setNewElements(listOf(1, 5, 2, 8, 3))
        // setNewElements just adds to the end, it doesn't heapify the new elements.
        // The push method is responsible for maintaining the heap property.
        // So, this test verifies it merely adds them.
        assertEquals(listOf(0, 1, 5, 2, 8, 3), heap.getHeap())
        // After setNewElements, the heap property is not guaranteed unless push is used for each.
        // So, no verifyMinHeapProperty here.
    }

    @Test
    fun testGetHeap() {
        heap.push(7)
        heap.push(3)
        heap.push(9)
        // Expected: [0, 3, 7, 9]
        assertEquals(listOf(0, 3, 7, 9), heap.getHeap())
    }
}
