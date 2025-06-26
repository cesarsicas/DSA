package structures.graphs


import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DfsPathCounterTest {

    lateinit var adjacentListDfs: AdjacentListDfs

    @Before
    fun config(){
        adjacentListDfs = AdjacentListDfs()
    }

    @Test
    fun testSinglePath() {
        val adjList = mapOf(
            "A" to listOf("B"),
            "B" to listOf("C"),
            "C" to listOf("D"),
            "D" to listOf("E"),
            "E" to emptyList()
        )
        val result = adjacentListDfs.dfs("A", "E", adjList, mutableSetOf())
        assertEquals(1, result)
    }

    @Test
    fun testMultiplePaths() {
        val adjList = mapOf(
            "A" to listOf("B", "C"),
            "B" to listOf("E"),
            "C" to listOf("D", "E"),
            "D" to listOf("E"),
            "E" to emptyList()
        )
        val result = adjacentListDfs.dfs("A", "E", adjList, mutableSetOf())
        assertEquals(3, result)
    }

    @Test
    fun testNoPath() {
        val adjList = mapOf(
            "A" to listOf("B"),
            "B" to listOf("C"),
            "C" to listOf("D"),
            "D" to emptyList(), // No connection to E
            "E" to emptyList()
        )
        val result = adjacentListDfs.dfs("A", "E", adjList, mutableSetOf())
        assertEquals(0, result)
    }

    @Test
    fun testCycleInGraph() {
        val adjList = mapOf(
            "A" to listOf("B"),
            "B" to listOf("C"),
            "C" to listOf("A", "E"), // Cycle here: C -> A
            "E" to emptyList()
        )
        val result = adjacentListDfs.dfs("A", "E", adjList, mutableSetOf())
        assertEquals(1, result)
    }

    @Test
    fun testStartEqualsTarget() {
        val adjList = mapOf(
            "A" to listOf("B"),
            "B" to listOf("C")
        )
        val result = adjacentListDfs.dfs("A", "A", adjList, mutableSetOf())
        assertEquals(1, result) // Reaching itself with no moves
    }
}
