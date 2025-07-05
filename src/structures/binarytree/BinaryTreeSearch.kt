fun createBinaryTree(): BinaryTreeNode<Int> {
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

private fun main() {
    val root = createBinaryTree()

    //for binary search tree
    val result1 = listOf(
        (searchBinarySearch(root, 10)),
        (searchBinarySearch(root, 5)),
        (searchBinarySearch(root, 15)),
        (searchBinarySearch(root, 3)),
        (searchBinarySearch(root, 7)),
        (searchBinarySearch(root, 12)),
        (searchBinarySearch(root, 18)),
        (searchBinarySearch(root, 93)),
        (searchBinarySearch(root, 0)),
        (searchBinarySearch(root, -5)),
    )
    println(result1)

    //for binary tree
    val result2 = listOf(
        (serchDefaulttree(root, 10)),
        (serchDefaulttree(root, 5)),
        (serchDefaulttree(root, 15)),
        (serchDefaulttree(root, 3)),
        (serchDefaulttree(root, 7)),
        (serchDefaulttree(root, 12)),
        (serchDefaulttree(root, 18)),
        (serchDefaulttree(root, 93)),
        (serchDefaulttree(root, 0)),
        (serchDefaulttree(root, -5)),
    )
    println(result2)
}


private fun searchBinarySearch(node: BinaryTreeNode<Int>?, element: Int): Boolean {

    if (node == null) {
        return false
    }

    return if (element > node.value) {
        searchBinarySearch(node.right, element)
    } else {
        if (element < node.value) {
            searchBinarySearch(node.left, element)
        } else {
            true
        }
    }

}

//can be used for trees that haven't search tree correct order
fun serchDefaulttree(root: BinaryTreeNode<Int>?, value: Int): Boolean {
    if (root == null) {
        return false
    }

    return if (root.value == value) {
        true
    } else {
        if (serchDefaulttree(root.left, value)) {
            true
        } else {
            if (serchDefaulttree(root.right, value)) {
                true
            } else {
                false
            }
        }
    }
}
