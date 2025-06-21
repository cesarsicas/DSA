package structures.binarytree.heaps


/*
* De trás pra frente, para cada elemento, verifica se os filhos são maiores.
* Se for maior, substitui e vai descendo até o final
* */
class Heapfy {
    fun heapfy(list: List<Int>): List<Int> {
        val heap = list.toMutableList()
        heap.add(0,0)

        //0, 50, 80, 40, 30, 10, 70, 20, 90, 60
        //cur inicializa no ultimo node que tem filhos (1 ou 2 filhos)
        var cur = (heap.size - 1) / 2

        while (cur > 0) {

            var i = cur

            //i pode ir ate o ultimo item da arvore que tem filho
            while (2 * i < heap.size) {
                val leftNodeIndex = 2 * i
                val rightNodeIndex = 2 * i + 1

                if (
                    rightNodeIndex < heap.size &&
                    heap[rightNodeIndex] < heap[leftNodeIndex] &&
                    heap[i] > heap[rightNodeIndex]
                ) {
                    var temp = heap[i]
                    heap[i] = heap[rightNodeIndex]
                    heap[rightNodeIndex] = temp
                    i = rightNodeIndex


                } else {
                    if (heap[i] > heap[leftNodeIndex]) {
                        var temp = heap[i]
                        heap[i] = heap[leftNodeIndex]
                        heap[leftNodeIndex] = temp
                        i = leftNodeIndex
                    } else {
                        break
                    }
                }
            }

            cur--
        }

        return heap

    }
}
