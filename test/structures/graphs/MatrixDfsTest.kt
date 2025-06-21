package structures.graphs

import org.junit.Assert.*
import org.junit.Test

class MatrixDfsTest {


    @Test
    fun defaultTest() {
        var array =
            arrayOf(
                intArrayOf(0, 0, 0, 0),
                intArrayOf(1, 1, 0, 0),
                intArrayOf(0, 0, 0, 1),
                intArrayOf(0, 1, 0, 0)
            )

        val matrixDfs = MatrixDfsExercise()

        val paths = matrixDfs.dfs(array, 0, 0, mutableSetOf())
        assertEquals( 2, paths)

    }
}