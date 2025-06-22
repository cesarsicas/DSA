package structures.graphs

import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

class MatrixBfsExercise() {


}

class MatrixBfs {

    fun bfs(grid: Array<IntArray>): Int {
        val ROWS = grid.size
        val COLS = grid[0].size

        val visit = mutableSetOf<Pair<Int, Int>>()
        val queue: Queue<Pair<Int, Int>> = LinkedList()

        queue.add(Pair(0, 0))
        visit.add(Pair(0, 0))

        var length = 0

        val directions = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1)
        )

        while (queue.isNotEmpty()) {

            repeat(queue.size) {
                val (r, c) = queue.poll()

                if (r == ROWS - 1 && c == COLS - 1) {
                    return length
                }

                for ((dr, dc) in directions) {
                    val newRow = r + dr
                    val newCol = c + dc

                    val newPos = Pair(newRow, newCol)

                    if (
                        min(newRow, newCol) <0 ||
                        newRow >= ROWS ||
                        newCol >= COLS ||
                        visit.contains(newPos) ||
                        grid[newRow][newCol] == 1
                    ) {
                        continue
                    }

                    queue.add(newPos)
                    visit.add(newPos)
                }
            }
            length++
        }

        return -1 // if there's no path
    }
}