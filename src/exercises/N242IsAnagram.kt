package exercises

fun isAnagram(s: String, t: String): Boolean {


    if (s.length != t.length) {
        return false
    }

    var builderS = hashMapOf<Char, Int>()
    var builderT = hashMapOf<Char, Int>()

    for (i in 0..<s.length) {

        var result: Int = builderT.getOrDefault(t[i], 0)
        builderT[t[i]] = ++result

        var result2: Int = builderS.getOrDefault(s[i], 0)
        builderS[s[i]] = ++result2

    }

    for (map in builderS) {
        if (builderT[map.key] != map.value) {
            return false
        }
    }
    return true
}

private fun main() {
    println(isAnagram("anagram", "nagaram"))
}

