package exercises

class N1480PrefixSum {

    //can be used to solve problems like
    //sum between elements in array
    fun calculatePrefixSum(arr: IntArray): IntArray {
        for (i in 1..<arr.size) {
            arr[i] = arr[i - 1] + arr[i]
        }

        return arr
    }

}

private fun main() {
    val n1480PrefixSum = N1480PrefixSum()

    //[1, 2, 3, 4]
    println(n1480PrefixSum.calculatePrefixSum(intArrayOf(1,2,3,4)).toList())
}