package structures.binarytree.heaps

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class HeapfyTest {
    lateinit var heapfy: HeapfyExercise

    @Before
    fun config() {
        heapfy = HeapfyExercise()
    }

    @Test
    fun shouldHeapfyArray() {

        val list = listOf(60, 50, 80, 40, 30, 10, 70, 20, 90, 42, 78)
        val expectedResponse = listOf(0, 10, 20, 60, 40, 30, 80, 70, 50, 90, 42, 78)

        val response = heapfy.heapfy(list)

        printArrayOnTreeNodes(expectedResponse)

        assertEquals(expectedResponse, response)

    }


}