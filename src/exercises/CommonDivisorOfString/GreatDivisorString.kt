package exercises.CommonDivisorOfString

//Example 1:
//
//Input: str1 = "ABCABC", str2 = "ABC"
//Output: "ABC"
//Example 2:
//
//Input: str1 = "ABABAB", str2 = "ABAB"
//Output: "AB"

fun gcdOfStrings(str1: String, str2: String): String {
    if(str1+str2 != str2+str1){
        return ""
    }

    var size1 = str1.length
    var size2 = str2.length


    var index = 0

//    if (l1 > l2) l1 -= l2
//    else l2 -= l1
//
    while (size1!=size2){
        if (size1>size2){
            size1 -= size2
        }else{
            size2 -= size1
        }
    }

    println( str1.substring(0, size1))

    return  str1.substring(0, size1)



}


fun main() {
    //println(gcdOfStrings("ABCABC", "ABC").equals("ABC"))
    println(gcdOfStrings("ABABAB", "ABAB").equals("AB"))
}
//"ABABAB", "ABAB"
//"AB", "ABAB"
//"AB", "AB"

