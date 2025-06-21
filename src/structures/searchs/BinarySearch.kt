package structures.searchs

fun main() {
    println(search(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10))
}

fun search(array: IntArray, element: Int): Int {

    var left = 0
    var right = array.size - 1

    while (left <= right) {
        val mid = (right + left) / 2

        if (array[mid] < element) {
            left = mid+1

        } else {
            if (array[mid] > element) {
                right = mid-1
            } else {
                return mid
            }
        }
    }

    return -1
}