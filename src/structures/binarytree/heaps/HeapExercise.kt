package structures.binarytree.heaps

class HeapExercise {
    private val heap = mutableListOf<Int>() // Using a mutable list for the heap

    init {
        heap.add(0)
    }

    fun setNewElements(array: List<Int>) {
        this.heap.addAll(array)
    }

    fun getHeap(): List<Int> {
        return this.heap
    }

    fun peek(): Int? {
        return if (heap.size > 1) heap[1] else null // Return the root (smallest element)
    }

    fun printHeap() {
        println(heap)
    }

    fun push(value: Int) {
        heap.add(value)

        var i = heap.size - 1
        while (heap[i] < heap[i / 2]) {

            val temp = heap[i]
            heap[i] = heap[i / 2]
            heap[i / 2] = temp
            i = i / 2
        }

    }

    fun pop() {

        if (heap.size <= 1) {
            return
        }
        val last = heap.removeLast()

        if (heap.size <= 1) {
            return
        }

        heap[1] = last



        var i = 1

        while (i <= (heap.size - 1) / 2) {

            val leftIndex = i * 2
            val rightIndex = i * 2 + 1

            if (
                rightIndex < heap.size &&
                heap[rightIndex] < heap[leftIndex] &&
                heap[i] > heap[rightIndex]
                ){
                val temp = heap[rightIndex]
                heap[rightIndex] = heap[i]
                heap[i] = temp

                i = rightIndex

            }
            else{
                if (heap[leftIndex]< heap[i]){
                    val temp = heap[leftIndex]
                    heap[leftIndex] = heap[i]
                    heap[i] = temp

                    i = leftIndex
                }
                else{
                    break
                }

            }



        }


    }

}

fun main() {
    val myHeap = HeapExercise()
    myHeap.setNewElements(listOf(14, 19, 16, 21, 26, 19, 68, 65, 30))

    printArrayOnTreeNodes(myHeap.getHeap())

    myHeap.push(88)

    printArrayOnTreeNodes(myHeap.getHeap())
    println(myHeap.getHeap())


}
