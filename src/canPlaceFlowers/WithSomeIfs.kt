package canPlaceFlowers

fun main() {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {


        var availableSpaces: Int = 0

        if (flowerbed.size == 1) {
            var actualposition = flowerbed[0]
            return actualposition == 0 && n == 1
        }


        for (i in 0..flowerbed.size - 1) {

            if (i == 0) {

                var actualPostion = flowerbed[i]
                var nextPositon = flowerbed[i + 1]

                if (actualPostion == 0 && nextPositon == 0) {
                    availableSpaces++
                }


            } else {
                if (i == flowerbed.size - 1) {

                    var actualPostion = flowerbed[i]
                    var previousPosition = flowerbed[i - 1]

                    if (actualPostion == 0 && previousPosition == 0) {
                        availableSpaces++
                    }
                } else {
                    var actualPostion = flowerbed[i]
                    var previousPosition = flowerbed[i - 1]
                    var nextPositon = flowerbed[i + 1]

                    if (actualPostion == 0 && previousPosition == 0 && nextPositon == 0){
                        availableSpaces++
                    }

                }
            }

        }
        return availableSpaces >= n

    }

    fun anything(){
        val arraylist = arrayListOf<Int>()
        arraylist.last()


    }

}