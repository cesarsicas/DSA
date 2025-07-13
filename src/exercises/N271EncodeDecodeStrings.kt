package exercises

class N271EncodeDecodeStrings {
    fun encode(strs: List<String>): String {
        val builder = StringBuilder()
        strs.forEach { value ->
            val str = "${value.length}#$value"
            builder.append(str)
        }
        return builder.toString()

    }

    fun decode(str: String): List<String> {
        val arrayList = mutableListOf<String>()
        var i = 0
        while (i < str.length) {

            if (str[i].isDigit()) {
                var j = i

                var numberString = ""

                while (str[j].isDigit() && j < str.length) {
                    numberString += str[j]
                    j++
                }

                println("digit $numberString")
                val stringBegin = j + 1
                val end = stringBegin + numberString.toInt()

                println(str.substring(stringBegin, end))
                arrayList.add(str.substring(stringBegin, end))

                i = end

            } else {
                i++
            }


        }


        return arrayList
    }

}
