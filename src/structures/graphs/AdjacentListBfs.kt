package structures.graphs

import java.util.*

class AdjancentListBfsExercise {


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

            repeat(size) {
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