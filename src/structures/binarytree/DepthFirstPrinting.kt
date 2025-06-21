package structures.binarytree

import BinaryTreeNode

/**functions to traverse and print*/

fun inOrderTraversal(node: BinaryTreeNode<Int>?) {
    if (node == null) {
        return
    }
    inOrderTraversal(node.left) // Traverse left subtree
    print("${node.value} ")     // Visit the current node
    inOrderTraversal(node.right) // Traverse right subtree
}

/**
 * Performs a pre-order traversal of the binary tree.
 * Pre-order traversal visits nodes in the order: Root -> Left -> Right.
 */
fun preOrderTraversal(node: BinaryTreeNode<Int>?) {
    if (node == null) {
        return
    }
    print("${node.value} ")     // Visit the current node
    preOrderTraversal(node.left) // Traverse left subtree
    preOrderTraversal(node.right) // Traverse right subtree
}

/**
 * Performs a post-order traversal of the binary tree.
 * Post-order traversal visits nodes in the order: Left -> Right -> Root.
 */
fun postOrderTraversal(node: BinaryTreeNode<Int>?) {
    if (node == null) {
        return
    }
    postOrderTraversal(node.left)  // Traverse left subtree
    postOrderTraversal(node.right) // Traverse right subtree
    print("${node.value} ")      // Visit the current node
}