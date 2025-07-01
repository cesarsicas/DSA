package exercises

import java.util.*
import kotlin.math.max

private class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//with recursion
private fun maxDepthRecursive(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val left = maxDepthRecursive(root.left)
    val right = maxDepthRecursive(root.right)

    return 1 + max(left, right)
}

//with loop
private fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    var queue: Queue<TreeNode> = LinkedList()
    var counter = 0

    queue.add(root)

    while (queue.size > 0) {
        val size = queue.size

        repeat(size) {
            var current = queue.poll()

            if (current.left != null) {
                queue.add(current.left)
            }
            if (current.right != null) {
                queue.add(current.right)
            }

        }

        counter++

    }

    return counter

}