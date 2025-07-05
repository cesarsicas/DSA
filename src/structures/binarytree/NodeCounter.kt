package structures.binarytree

import BinaryTreeNode
import createBinaryTree


private fun main() {
    val node = createBinaryTree()
    println(countNodes(node))
}

fun countNodes(node: BinaryTreeNode<Int>?): Int {
    if (node == null) {
        return 0
    }

    return 1 + countNodes(node.right) + countNodes(node.left)
}