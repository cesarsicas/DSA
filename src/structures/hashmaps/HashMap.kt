package structures.hashmaps


fun main() {
    firstUniqChar("hashmaps")
}


fun firstUniqChar(s: String): Int {
    val hashMap:HashMap<Char, Int> = hashMapOf()

    s.forEachIndexed{ i, c ->
        hashMap[c] = hashMap.getOrDefault(c,0).plus(1)
    }

    s.forEachIndexed{ index, c ->
       if(hashMap[c] == 1){
           return index
       }
    }


    return -1
}