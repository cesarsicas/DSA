package exercises

import kotlin.math.max

private fun maxProfit(prices: IntArray): Int {
    var max = 0

    var left = 0
    var right = left+1


    while(right<prices.size){

        if(prices[right]>prices[left]){
            var profit = prices[right] - prices[left]
            max = max(profit, max)
        }
        else{
            //if the price on the right is less than price on left,
            //then make sense the left pointer be updated to right
            left = right
        }

        right++ //right always increase by one

    }

    return max
}
private fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4)) == 5)
    println(maxProfit(intArrayOf(7,6,4,3,1)) == 0)
}