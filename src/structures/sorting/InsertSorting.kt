package structures.sorting

fun main() {

    val array = intArrayOf(1, 5, 3, 2, 4)
    println(insertSortTest(array).toList()) // Expected output: [1, 2, 3, 4, 5]

    val array2 = intArrayOf(8, 3, 1, 5, 2, 9, 4, 7, 6)
    println(insertSortTest(array2).toList()) // Expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

    val array3 = intArrayOf(5, 4, 3, 2, 1)
    println(insertSortTest(array3).toList()) // Expected output: [1, 2, 3, 4, 5]

    val array4 = intArrayOf(10)
    println(insertSortTest(array4).toList()) // Expected output: [10]

    val array5 = intArrayOf()
    println(insertSortTest(array5).toList()) // Expected output: []

    val array6 = intArrayOf(1, 2, 3, 4, 5)
    println(insertSortTest(array6).toList()) // Expected output: [1, 2, 3, 4, 5]

    val array7 = intArrayOf(1, 2, 5, 4, 5)
    println(insertSortTest(array7).toList()) // Expected output: [1, 2, 3, 5, 5]

}

private fun insertSortTest(arr: IntArray): IntArray {

    for (i in 0..<arr.size) {
        var j = i - 1

        while (j >= 0 && arr[j + 1] < arr[j]) {

            val temp = arr[j + 1]
            arr[j + 1] = arr[j]
            arr[j] = temp
            j--
        }
    }


    return arr

}


//private fun insertSort(array: IntArray): IntArray {
//
//    for (i in 0..< array.size){
//        var j = i-1
//
//        while ((j>=0) && array[j+1]<array[j]){
//            val temp = array[j]
//            array[j] = array[j+1]
//            array[j+1] = temp
//            j--
//
//        }
//    }
//
//    return array
//}
//
