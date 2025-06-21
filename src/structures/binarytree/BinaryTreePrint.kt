package structures.binarytree

import BinaryTreeNode

private fun createTree(): BinaryTreeNode<Int> {
    // 1. Create the nodes with Integer values
    val root = BinaryTreeNode(10)

    val node5 = BinaryTreeNode(5)
    val node15 = BinaryTreeNode(15)
    val node3 = BinaryTreeNode(3)
    val node7 = BinaryTreeNode(7)
    val node12 = BinaryTreeNode(12)
    val node18 = BinaryTreeNode(18)

    // 2. Assemble the tree by linking the nodes
    // Root and its immediate children
    root.left = node5
    root.right = node15

    // Left subtree
    node5.left = node3
    node5.right = node7

    // Right subtree
    node15.left = node12
    node15.right = node18

    /*
      The tree structure will look like this:
              10
             /  \
            5    15
           / \  /  \
          3  7 12  18
    */

    return root
}


fun main() {
    val root = createTree()
    printTreeAsc(root)
    println()
    printTreeDesc(root)

}


fun printTreeDesc(root: BinaryTreeNode<Int>?):BinaryTreeNode<Int>? {
    if (root == null){
        return null
    }

    printTreeDesc(root.right)
    print(" "+root.value)
    printTreeDesc(root.left)

    return root
}


fun printTreeAsc(root: BinaryTreeNode<Int>?):BinaryTreeNode<Int>? {
    if (root == null){
        return null
    }

    printTreeAsc(root.left)
    print(" "+root.value)
    printTreeAsc(root.right)

    return root
}
