package structures.graphs

import java.util.*

class AdjancentListBfsExercise {


    fun bfs(node: String, target: String, adjList: Map<String, List<String>>): Int {

        var queue: Queue<String> = LinkedList()
        var visited: MutableSet<String> = mutableSetOf()

        queue.add(node)
        visited.add(node)
        var count = 0


        while (queue.size > 0) {

            val size = queue.size

            repeat(size){

                val actual = queue.poll()

                if (actual == target) {
                    return count
                }

                var neighbours = adjList[actual] ?: emptyList()

                for (n in neighbours) {
                    if (n !in visited) {
                        queue.add(n)
                        visited.add(n)
                    }
                }

            }

            count++
        }
        return -1
    }

}

class AdjacentListBfs {
    fun bfs(node: String, target: String, adjList: Map<String, List<String>>): Int {
        var length = 0
        val visited = mutableSetOf<String>()
        visited.add(node)

        val queue: Queue<String> = LinkedList()
        queue.add(node)

        while (queue.isNotEmpty()) {
            val size = queue.size

            repeat(size){
                val curr = queue.poll()

                if (curr == target) {
                    return length
                }

                for (neighbor in adjList[curr] ?: emptyList()) {
                    if (neighbor !in visited) {
                        visited.add(neighbor)
                        queue.add(neighbor)
                    }
                }
            }

            length++
        }

        return -1
    }
}