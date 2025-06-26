package structures.graphs

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