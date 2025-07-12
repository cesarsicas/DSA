package exercises

class N36ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { mutableSetOf<Char>() }
        val cols = Array(9) { mutableSetOf<Char>() }
        val squares = Array(9) { mutableSetOf<Char>() }  // index = (r / 3) * 3 + (c / 3)

        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val value = board[r][c]
                if (value == '.') continue

                val squareIndex = (r / 3) * 3 + (c / 3)

                if (value in rows[r] || value in cols[c] || value in squares[squareIndex]) {
                    return false
                }

                rows[r].add(value)
                cols[c].add(value)
                squares[squareIndex].add(value)
            }
        }
        return true
    }
}