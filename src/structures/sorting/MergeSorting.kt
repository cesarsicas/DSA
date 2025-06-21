package structures.sorting

fun main() {
    val array = intArrayOf(1,5,3,2,4)
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
}

private fun sort(array: IntArray): IntArray {
    // Create a copy of the array for merge sort to avoid modifying the original during recursive calls
    // and for use in the auxiliary array within mergeArrayParts.
    // However, the current problem structure implies modifying the original array in place.
    // So, we'll proceed with direct modification as per the problem's implied design.
    mergeSort(array, 0, array.size - 1)
    return array
}

private fun mergeSort(array: IntArray, start: Int, end: Int): IntArray {
    if (start >= end) { // Base case: if the array has 0 or 1 element, it's already sorted.
        return array
    }

    val mid = (start + end ) / 2 // Calculate mid

    mergeSort(array, start, mid)
    mergeSort(array, mid + 1, end)
    mergeArrayParts(array, start, mid, end)

    return array
}

fun mergeArrayParts(array: IntArray, start: Int, mid: Int, end: Int) {
    // Create a temporary array to hold the merged elements.
    // The size of this temporary array is the size of the subarray being merged (from start to end).
    val tempArray = IntArray(end - start + 1)

    var i = start // Pointer for the first sorted subarray (from start to mid)
    var j = mid + 1 // Pointer for the second sorted subarray (from mid + 1 to end)
    var k = 0 // Pointer for the tempArray

    // Compare elements from both subarrays and place the smaller one into tempArray
    while (i <= mid && j <= end) {
        if (array[i] <= array[j]) {
            tempArray[k] = array[i]
            i++
        } else {
            tempArray[k] = array[j]
            j++
        }
        k++
    }

    // Copy any remaining elements from the first subarray (if any)
    while (i <= mid) {
        tempArray[k] = array[i]
        i++
        k++
    }

    // Copy any remaining elements from the second subarray (if any)
    while (j <= end) {
        tempArray[k] = array[j]
        j++
        k++
    }

    // Copy the merged elements from tempArray back to the original array
    // starting from the 'start' index.
    for (l in 0 until tempArray.size) {
        array[start + l] = tempArray[l]
    }
}

//
//fun main() {
//    val array = intArrayOf(1,5,3,2,4)
//    println(sort(array).toList())
//
//}
//
//private fun sort(array: IntArray): IntArray {
//    return mergeSort(array, 0, array.size-1)
//
//}
//
//private fun mergeSort(array: IntArray, start:Int, end:Int): IntArray {
//    if((start-end+1)<=1){
//        return array
//    }
//
//    val mid = array.size/2
//    mergeSort(array,  start,mid)
//    mergeSort(array,  mid + 1, end)
//    mergeArrayParts(array, start,mid, end)
//
//    return array
//
//}
//
//fun mergeArrayParts(array: IntArray, start: Int, mid: Int, end: Int) {
//    // Create a temporary array to hold the merged elements.
//    // The size of this temporary array is the size of the subarray being merged (from start to end).
//    val tempArray = IntArray(end - start + 1)
//
//    var i = start // Pointer for the first sorted subarray (from start to mid)
//    var j = mid + 1 // Pointer for the second sorted subarray (from mid + 1 to end)
//    var k = 0 // Pointer for the tempArray
//
//    // Compare elements from both subarrays and place the smaller one into tempArray
//    while (i <= mid && j <= end) {
//        if (array[i] <= array[j]) {
//            tempArray[k] = array[i]
//            i++
//        } else {
//            tempArray[k] = array[j]
//            j++
//        }
//        k++
//    }
//
//    // Copy any remaining elements from the first subarray (if any)
//    while (i <= mid) {
//        tempArray[k] = array[i]
//        i++
//        k++
//    }
//
//    // Copy any remaining elements from the second subarray (if any)
//    while (j <= end) {
//        tempArray[k] = array[j]
//        j++
//        k++
//    }
//
//    // Copy the merged elements from tempArray back to the original array
//    // starting from the 'start' index.
//    for (l in 0 until tempArray.size) {
//        array[start + l] = tempArray[l]
//    }
//}
//
