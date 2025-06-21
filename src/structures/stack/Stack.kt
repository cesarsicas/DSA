package structures.stack

import java.util.*

fun main() {
    val stack = Stack<Int>()

    stack.add(0)
    stack.add(1)
    stack.add(2)

    println(stack)

    stack.pop() //remove o 2 porque Last IN First OUT LIFO
    println(stack)


}