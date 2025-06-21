package structures.binarytree.heaps


/*
* De trás pra frente, para cada elemento, verifica se os filhos são maiores.
* Se for maior, substitui e vai descendo até o final
* */

class HeapfyExercise {
    fun heapfy(list: List<Int>): List<Int> {
        val heap = list.toMutableList()

        heap.add(0,0)

        var current = (heap.size-1)/2

        while (current > 0 ) {
            var i = current

            while (i <= (heap.size - 1) / 2) {
                var leftChildIndex = i * 2
                var rightChildIndex = i * 2 + 1

                if (
                    rightChildIndex < heap.size &&
                    heap[rightChildIndex] < heap[leftChildIndex] &&
                    heap[rightChildIndex] < heap[i]
                ) {

                    val temp = heap[rightChildIndex]
                    heap[rightChildIndex] = heap[i]
                    heap[i] = temp

                    i = rightChildIndex


                } else {
                    if (heap[leftChildIndex] < heap[i]) {

                        val temp = heap[leftChildIndex]
                        heap[leftChildIndex] = heap[i]
                        heap[i] = temp

                        i = leftChildIndex

                    } else {
                        break
                    }
                }


            }




            current--

        }





        return heap


    }
}
