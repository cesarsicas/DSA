package structures.queue

import java.util.Deque
import java.util.LinkedList
import java.util.Queue

fun main() {
    val queue:Queue<Int> = LinkedList<Int>()

    queue.add(0)
    queue.add(1)
    queue.add(2)

    println(queue)

    queue.poll() //remove 0, because FIRST IN FIRST OUT
    //structures.queue.pop // nao tem esse metodo

    println(queue)


}