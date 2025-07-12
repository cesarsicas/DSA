package exercises

class N238ProductArrayExceptSelf {

    fun calculateWithoutExtraMemory(nums: IntArray): IntArray {
        val res = IntArray(nums.size)

        var prefix = 1
        for (i in 0..nums.size - 1) {
            res[i] = prefix
            prefix *= nums[i]
        }

        var postfix = 1
        for (i in nums.size - 1 downTo 0) {
            res[i] *= postfix
            postfix *= nums[i]
        }

        return res
    }

    fun calculateWithExtraMemory(arr: IntArray): IntArray {

        val prefix = IntArray(arr.size)
        val poxFix = IntArray(arr.size)
        val final = IntArray(arr.size)

        prefix[0] = arr[0]

        for (i in 1..<arr.size) {
            prefix[i] = arr[i] * prefix[i - 1]
        }

        poxFix[arr.size - 1] = arr[arr.size - 1]

        for (i in (arr.size - 2) downTo 0) {
            poxFix[i] = arr[i] * poxFix[i + 1]
        }

        for (i in 0..<arr.size) {
            val left = if (i == 0) {
                1
            } else {
                prefix[i - 1]
            }

            val right = if (i == arr.size - 1) {
                1
            } else {
                poxFix[i + 1]
            }

            final[i] = left * right
        }

        return final

    }


}

private fun main() {
    val n238ProductArrayExceptSelf = N238ProductArrayExceptSelf()

    val response =
        n238ProductArrayExceptSelf.calculateWithoutExtraMemory(
            intArrayOf(1, 2, 3, 4)
        )

    println(response.toList())

}