package exercises

class N347TopKElementsInArray {
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val countMap = mutableMapOf<Int, Int>()

        //+1 is required because none frequency would be '0' times, so
        //0 position is never used
        //ie. an array of 1 element will be [0,1]
        val freq: Array<MutableList<Int>> = Array(nums.size +1) { mutableListOf() }

        //transform into map
        for (n in nums) {
            countMap[n] = countMap.getOrDefault(n, 0) + 1
        }

        //n is the number and c is the total times it appeared on nums
        for ((n, c) in countMap) {
            freq[c].add(n)
        }

        val res = mutableListOf<Int>()

        //from the most frequent to the least frequent
        //add the elements in the list until is less than k then return
        for (i in freq.size-1 downTo  0) {
            for (n in freq[i]) {
                res.add(n)
                if (res.size == k) {
                    return res
                }
            }
        }

        return res
    }

}

fun main() {
    val topK = N347TopKElementsInArray()

    println(topK.topKFrequent(intArrayOf(1),1).toList())

}