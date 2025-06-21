package structures.binarytree.heaps

import structures.binarytree.TreeConverter
import structures.binarytree.Visualizer
import BinaryTreeNode


fun heapArrayToTreeRecursive(list:List<Int>): BinaryTreeNode<Int>? {
    if (list.size <= 1) { // Handle empty or single-element lists
        return null
    }
    val root = BinaryTreeNode(list[1]) // Start with the first actual element (index 1)
    createTreeRecursive(root, list, 1) // Start recursion from the root's position
    return root
}

private fun createTreeRecursive(
    currentNode: BinaryTreeNode<Int>?, // Renamed 'root' to 'currentNode' for clarity in recursion
    list: List<Int>,
    position: Int
) {
    if (currentNode == null) {
        return
    }

    val leftIndex = position * 2
    val rightIndex = position * 2 + 1

    // Check if left child exists within the list bounds
    if (leftIndex < list.size) {
        currentNode.left = BinaryTreeNode(list[leftIndex])
        createTreeRecursive(currentNode.left, list, leftIndex) // Recurse for the left child
    }

    // Check if right child exists within the list bounds
    if (rightIndex < list.size) {
        currentNode.right = BinaryTreeNode(list[rightIndex])
        createTreeRecursive(currentNode.right, list, rightIndex) // Recurse for the right child
    }
}

fun heapArrayToTree(list: List<Int>): BinaryTreeNode<Int>? {

    if (list.isEmpty() || list.size < 2) {
        return null
    }

    val arrayOfNodes = arrayListOf<BinaryTreeNode<Int>>()


    list.forEach {
        arrayOfNodes.add(BinaryTreeNode(it))
    }


    //beginning of the heap array, 0 is discarded
    var i = 1

    while (i < (list.size / 2)) {

        val leftNodeIndex = i * 2
        val rightNodeIndex = i * 2 + 1

        val rootValue = list[i]
        val rooNode = arrayOfNodes[i]

        var rightvalue: Int? = null
        var rightNode: BinaryTreeNode<Int>? = null

        val leftValue = list[leftNodeIndex]
        val leftNode = arrayOfNodes[leftNodeIndex]

        if (rightNodeIndex < list.size) {
            rightvalue = list[rightNodeIndex]
            rightNode = arrayOfNodes[rightNodeIndex]

        }


        println("root $rootValue left: $leftValue right: $rightvalue")

        rooNode.left = leftNode
        rooNode.right = rightNode

        i = i * 2

    }
    return arrayOfNodes[1]
}


fun printArrayOnTreeNodes(list: List<Int>){
    val root = heapArrayToTreeRecursive(list)
    val tree = TreeConverter.fromRoot(root)
    val visualizer = Visualizer(tree)
    visualizer.visualize()
}

fun printHeapArray(list: List<Int>){

    //beginning of the heap array, 0 is discarded
    var i = 1

    while (i <= ((list.size-1) / 2)) {

        val leftNodeIndex = i * 2
        val rightNodeIndex = i * 2 + 1

        val rootValue = list[i]

        var rightvalue: Int? = null
        val leftValue = list[leftNodeIndex]

        if (rightNodeIndex < list.size) {
            rightvalue = list[rightNodeIndex]
        }
        println("root $rootValue left: $leftValue right: $rightvalue")
        i++

    }
}

