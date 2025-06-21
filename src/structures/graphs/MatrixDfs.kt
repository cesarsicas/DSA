package structures.graphs

import kotlin.math.min


class MatrixDfsExercise {

    fun dfs(matrix: Array<IntArray>, r: Int, c: Int, visit: MutableSet<Pair<Int, Int>>): Int {
        val ROWS = matrix.size
        val COLS = matrix.first().size


        if (
            (min(r, c) < 0) ||
            (r >= ROWS) ||
            (c >= COLS) ||
            visit.contains(Pair(r, c)) ||
            matrix[c][r] == 1
        ) {
            return 0
        }

        if (r == ROWS-1 && c == COLS -1){
            return 1
        }

        visit.add(Pair(r, c))

        var count = 0

        count+= dfs(matrix, r-1, c, visit)
        count+= dfs(matrix, r+1, c, visit)
        count+= dfs(matrix, r, c-1, visit)
        count+= dfs(matrix, r, c+1, visit)

        visit.remove(Pair(r, c))

        return count
    }


}


//deep first search in matrix
class MatrixDfs {

    // Count paths (backtracking)
    fun dfs(grid: Array<IntArray>, r: Int, c: Int, visit: MutableSet<Pair<Int, Int>>): Int {
        val ROWS = grid.size
        val COLS = grid[0].size

        if (minOf(r, c) < 0 ||
            r == ROWS || c == COLS ||
            visit.contains(Pair(r, c)) || grid[r][c] == 1
        ) {
            return 0
        }

        if (r == ROWS - 1 && c == COLS - 1) {
            return 1
        }

        visit.add(Pair(r, c))

        var count = 0
        count += dfs(grid, r + 1, c, visit)
        count += dfs(grid, r - 1, c, visit)
        count += dfs(grid, r, c + 1, visit)
        count += dfs(grid, r, c - 1, visit)

        visit.remove(Pair(r, c))
        return count
    }
}

