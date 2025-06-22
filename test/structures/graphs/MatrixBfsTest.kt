package structures.graphs

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MatrixBfsTest {
    lateinit var matrixBfs:MatrixBfs

    @Before
    fun configure(){
        matrixBfs = MatrixBfs()
    }

    @Test
    fun testShortestPathExists() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 0)
        )
        val result = matrixBfs.bfs(grid)
        assertEquals(4, result) // Expected length of shortest path
    }

    @Test
    fun testNoPathAvailable() {
        val grid = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
        val result = matrixBfs.bfs(grid)
        assertEquals(-1, result)
    }

    @Test
    fun testOneCellGrid() {
        val grid = arrayOf(
            intArrayOf(0)
        )
        val result = matrixBfs.bfs(grid)
        assertEquals(0, result)
    }

    @Test
    fun testBlockedEnd() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 0, 1)
        )
        val result = matrixBfs.bfs(grid)
        assertEquals(-1, result)
    }

    @Test
    fun testStraightPath() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0)
        )
        val result = matrixBfs.bfs(grid)
        assertEquals(3, result)
    }
}