package structures.graphs

class AdjacentListDfsExercise {

    fun dfs(node: String, target: String, adjList: Map<String, List<String>>, visit: MutableSet<String>): Int {

        if (visit.contains(node)){
            return 0
        }
        if (node == target){
            return 1
        }

        var count = 0
        visit.add(node)

        val neighbours = adjList[node]

        neighbours?.forEach {
            count+= dfs(it, target, adjList, visit)
        }

        visit.remove(node)

        return count
    }


}

class AdjacentListDfs {

    fun dfs(
        node: String,
        target: String,
        adjList: Map<String, List<String>>,
        visit: MutableSet<String>
    ): Int {
        if (node in visit) return 0
        if (node == target) return 1

        var count = 0
        visit.add(node)
        for (neighbor in adjList[node] ?: emptyList()) {
            count += dfs(neighbor, target, adjList, visit)
        }
        visit.remove(node)
        return count
    }
}