package exercises

class N287DuplicateElementOnArray {

    fun findDuplicate(nums: IntArray): Int {

        var slow = 0
        var fast = 0

        do {
            slow = nums[slow]

            fast = nums[fast]
            fast = nums[fast]
        } while (slow != fast)


        var slow2 = 0

        do {
            slow = nums[slow]
            slow2 = nums[slow2]

        } while (slow != slow2)

        return slow
    }

}