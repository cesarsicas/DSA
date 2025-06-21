package TwoSum


fun main() {

    println(twoSum(intArrayOf(2,7,11,15), 9).contentEquals(intArrayOf(0,1)))

}

fun twoSum(nums: IntArray, target: Int): IntArray {
    var map = hashMapOf<Int, Int>()


    for(i in 0 .. nums.size -1){
        val toFind = target - nums[i]

        if(map.contains(toFind)){
            return intArrayOf(map[toFind]!!, i)
        }
        map[nums[i]]=i
    }

    return nums
}