package exercises

fun containsDuplicate(nums: IntArray): Boolean {
    val myset = mutableSetOf<Int>()


    nums.forEach { n ->
        if (myset.contains(n)) {
            return true
        } else {
            myset.add(n)
        }
    }

    return false

}