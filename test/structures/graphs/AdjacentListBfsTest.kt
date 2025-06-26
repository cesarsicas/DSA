package structures.graphs

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AdjacentListBfsTest{

    private val adjList = mapOf(
        "A" to listOf("B", "C"),
        "B" to listOf("A", "D"),
        "C" to listOf("A", "D"),
        "D" to listOf("B", "C", "E"),
        "E" to listOf("D"),
        "F" to listOf() // Disconnected node
    )

    private lateinit var adjacentListBfs: AdjancentListBfsExercise

    @Before
    fun config(){
        adjacentListBfs = AdjancentListBfsExercise()
    }

    @Test
    fun testShortestPath_A_to_E() {
        val result = adjacentListBfs.bfs("A", "E", adjList)
        assertEquals(3, result)
    }

    @Test
    fun testShortestPath_A_to_D() {
        val result = adjacentListBfs.bfs("A", "D", adjList)
        assertEquals(2, result)
    }

    @Test
    fun testShortestPath_A_to_A() {
        val result = adjacentListBfs.bfs("A", "A", adjList)
        assertEquals(0, result)
    }

    @Test
    fun testNoPathExists() {
        val result = adjacentListBfs.bfs("A", "F", adjList)
        assertEquals(-1, result)
    }

    @Test
    fun testDirectConnection() {
        val result = adjacentListBfs.bfs("D", "E", adjList)
        assertEquals(1, result)
    }
}