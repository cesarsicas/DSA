package structures.binarytree.heaps

class Heap {
    private val heap = mutableListOf<Int>() // Using a mutable list for the heap

    init {
        // Initialize the heap with a dummy value at index 0, similar to the Python example.
        // This is often done to simplify parent/child index calculations (2*i, 2*i+1, i/2).
        heap.add(0)
    }
    fun getHeap() = heap

    //pop always remove the minimum element on this type of Heap / priority structures.queue
    //pega o ultimo elemento, coloca no lugar do primeiro e depois
    //desce ele até embaixo, até chegar numa posição que faz sentido em ordem e estrutura
    //ou seja, o pai é menor que os filhos

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

        //enquanto o leafNode for menor do que o taamanho da array -1
        //ou seja, o leafnode pode ser o ultimo item ou não

        while ((2 * i) < heap.size) {

            val leftChildIndex = i * 2
            val rightChildIndex = i * 2 + 1

            if (
                (rightChildIndex < heap.size) && //tem um filho à direita
                (heap[rightChildIndex] < heap[leftChildIndex]) && // se o filho da direita é menor que o filho da esquerda
                (heap[i] > heap[rightChildIndex]) //o item atual foir maior que o filho da direita
            ) {

                var temp = heap[rightChildIndex]
                heap[rightChildIndex] = heap[i]
                heap[i] = temp

                i = rightChildIndex

            } else {
                if (heap[i] > heap[leftChildIndex]) { //senao se o item atual for maior que o filho da esquerda
                    var temp = heap[leftChildIndex]
                    heap[leftChildIndex] = heap[i]
                    heap[i] = temp

                    i = leftChildIndex
                } else {
                    break
                }
            }
        }
    }


    fun setNewElements(array: List<Int>) {
        this.heap.addAll(array)
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

        while ((heap[i] < heap[i / 2])) {
            var temp = heap[i / 2]
            heap[i / 2] = heap[i]
            heap[i] = temp
            i = i / 2
        }
    }


}


fun main() {
    val myHeap = Heap()
    myHeap.setNewElements(listOf(14, 19, 16, 21, 26, 19, 68, 65, 30))

    printArrayOnTreeNodes(myHeap.getHeap())

    myHeap.pop()
    myHeap.pop()
    myHeap.pop()

    printArrayOnTreeNodes(myHeap.getHeap())
    println(myHeap.getHeap())



}
