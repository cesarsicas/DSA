package structures.sorting

fun main() {
    val array = intArrayOf(1, 5, 3, 2, 4)
    println(sort(array).toList()) // Expected output: [1, 2, 3, 4, 5]

    val array2 = intArrayOf(8, 3, 1, 5, 2, 9, 4, 7, 6)
    println(sort(array2).toList()) // Expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

    val array3 = intArrayOf(5, 4, 3, 2, 1)
    println(sort(array3).toList()) // Expected output: [1, 2, 3, 4, 5]

    val array4 = intArrayOf(10)
    println(sort(array4).toList()) // Expected output: [10]

    val array5 = intArrayOf()
    println(sort(array5).toList()) // Expected output: []

    val array6 = intArrayOf(1, 2, 3, 4, 5)
    println(sort(array6).toList()) // Expected output: [1, 2, 3, 4, 5]

    val array7 = intArrayOf(1, 2, 5, 4, 5)
    println(sort(array7).toList()) // Expected output: [1, 2, 3, 5, 5]
}

private fun sort(array: IntArray): IntArray {
    quickSortTest(array, 0, array.size - 1)
    return array
}

fun quickSortTest(array: IntArray, start: Int, end: Int): IntArray {

    if (start >= end) {
        return array
    }

    val pivot = array[end]
    var left = start

    for (i in start..end) {

        if (array[i] < pivot) {
            var temp = array[left]
            array[left] = array[i]
            array[i] = temp
            left++
        }

    }

    array[end] = array[left]
    array[left] = pivot


    quickSortTest(array, start, left - 1)
    quickSortTest(array, left + 1, end)


    return array
}


//
//
//fun quickSort(array: IntArray, start: Int, end: Int): IntArray {
//
//    if (start >= end) {
//        return array
//    }
//
//    val pivot = array[end]
//
//    var left = start
//
//    for (i in start..end) {
//        if (array[i] < pivot) {
//            val temp = array[left]
//            array[left] = array[i]
//            array[i] = temp
//            left++
//
//        }
//    }
//
//    array[end] = array[left]
//    array[left] = pivot
//
//    quickSort(array, start, left - 1)
//    quickSort(array, left + 1, end)
//
//
//    return array
//}
