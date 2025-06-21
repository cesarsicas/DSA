package structures.binarytree


import BinarySearchTree
import BinaryTreeNode
import java.util.LinkedList
import java.util.Queue
import kotlin.math.pow

class Visualizer<T>(
    private val tree: BinarySearchTree<T>,
    private var nodeLength: Int = -1,    // Corresponds to node_length in C++
    private var spaceLength: Int = -1    // Corresponds to space_length in C++
) {

    private val treeRoot: BinaryTreeNode<T>? = tree.root // Corresponds to tree_root_
    private val treeHeight: Int // Corresponds to tree_height_
    private val treeNodes: Int // Corresponds to tree_nodes_ (total nodes in a full binary tree up to treeHeight)

    private lateinit var values: Array<Array<String>> // Corresponds to values_
    private var nodeType: Int = 0 // Corresponds to node_type_ (0 if even, 1 if odd)
    private var nodeShiftFactor: Int = 0 // Corresponds to node_shift_factor_
    private lateinit var emptyNode: String // Corresponds to empty_node_

    private var spaceShiftFactor: Int = 0 // Corresponds to space_shift_factor_

    init {
        // Initialize tree-related variables
        treeHeight = getTreeHeight(treeRoot)
        // tree_nodes_ in C++ is (2^height - 1), which is the number of nodes in a full tree
        // up to that height. Here, it seems to be used as a total count for the BFS loop.
        treeNodes = getNodesCount(treeHeight) - 1 // Total possible nodes in a full binary tree up to treeHeight-1

        val nodesQueue = breadthFirstSearch()

        // Initialize values array
        // In Kotlin, we use Array<Array<String>> for 2D arrays.
        // The size of the outer array is treeHeight (number of levels)
        values = Array(treeHeight) { level ->
            Array(getNodesCount(level)) {
                "" // Initialize with empty strings
            }
        }

        var minNodeLen = 0

        for (level in 0 until treeHeight) {
            for (nodeIndex in 0 until getNodesCount(level)) {
                // Convert node to string and add it to values array
                // also add empty string if node is empty (represented by null in structures.queue)
                val currentNode = nodesQueue.poll() // Use poll() for Queue in Kotlin
                val value = if (currentNode == null) "" else currentNode.value.toString()
                values[level][nodeIndex] = value

                // Calculate minimum required node length
                val length = value.length
                if (minNodeLen < length) minNodeLen = length
            }
        }

        // Initialize node-related variables
        nodeLength = if (nodeLength > minNodeLen) nodeLength else minNodeLen // Choose suitable node length
        nodeType = nodeLength % 2 // ZERO if length is even and ONE if odd
        nodeShiftFactor = nodeLength / 2 // Shifting factor used in visualizing
        emptyNode = " ".repeat(nodeLength) // Represents an empty node

        // Initialize space-related variables
        val minSpaceLen = if (nodeType == 1) 3 else 4 // Calculate minimum required space length
        spaceLength = if (spaceLength > minSpaceLen) spaceLength else minSpaceLen // Choose suitable space length
        spaceShiftFactor = spaceLength / 2 // Shifting factor used in visualizing

        // Make sure that that both values are either even or odd
        // In Kotlin, assert is a function.
        // require() is better for preconditions in constructors/initializers
        require(nodeType == spaceLength % 2) {
            "Node type (even/odd length) must match space length type."
        }
    }

    /**
     * Performs a breadth-first search on the tree, including null placeholders
     * for missing nodes to maintain the complete binary tree structure up to `treeHeight`.
     */
    private fun breadthFirstSearch(): Queue<BinaryTreeNode<T>?> {
        val tempQueue: Queue<BinaryTreeNode<T>?> = LinkedList()
        val nodesQueue: Queue<BinaryTreeNode<T>?> = LinkedList()

        tempQueue.offer(treeRoot) // Add root to the temporary structures.queue

        // Iterate for the total number of theoretical nodes in a full tree up to treeHeight
        for (i in 0 until treeNodes + 1) { // +1 because the C++ loop goes up to tree_nodes_ (not exclusive)
            val current = tempQueue.poll()
            nodesQueue.offer(current) // Add to the result structures.queue

            if (current == null) {
                // If current is null, its children are also null
                tempQueue.offer(null)
                tempQueue.offer(null)
            } else {
                tempQueue.offer(current.left)
                tempQueue.offer(current.right)
            }
        }
        return nodesQueue
    }

    /**
     * Calculates the height of the tree.
     */
    private fun getTreeHeight(root: BinaryTreeNode<T>?): Int {
        if (root == null) return 0
        val leftHeight = getTreeHeight(root.left)
        val rightHeight = getTreeHeight(root.right)
        return if (leftHeight > rightHeight) leftHeight + 1 else rightHeight + 1
    }

    /**
     * Calculates the maximum number of nodes at a given level in a full binary tree.
     */
    private fun getNodesCount(level: Int): Int {
        // pow(2, level) in Kotlin is 2.0.pow(level.toDouble())
        return 2.0.pow(level.toDouble()).toInt()
    }

    /**
     * Calculates the width of a subtree starting from a given level.
     */
    private fun getSubtreeWidth(level: Int): Int {
        val levelsBelow = treeHeight - level - 1
        val nodesCount = getNodesCount(levelsBelow)
        val spacesCount = nodesCount - 1
        return nodeLength * nodesCount + spaceLength * spacesCount
    }

    /**
     * Visualizes the binary tree in the console.
     */
    fun visualize() {
        val lastLevel = treeHeight - 1

        for (level in 0 until treeHeight) {
            val nodesCount = getNodesCount(level)
            val lastNode = nodesCount - 1
            val subtreeWidth = getSubtreeWidth(level)
            val nodeIndentation = subtreeWidth / 2 - nodeShiftFactor
            val nodesSpacing = subtreeWidth - 2 * (nodeShiftFactor - spaceShiftFactor)
            val branchHeight = (subtreeWidth + 1) / 4

            // Print indentation for the current level's nodes
            print(" ".repeat(nodeIndentation))

            // Print nodes
            for (nodeIndex in 0 until nodesCount) {
                val nodeValue = if (values[level][nodeIndex].isEmpty()) emptyNode else values[level][nodeIndex]
                // For fixed-width output like setw and setfill, Kotlin uses String.format or padding methods
                // Using padStart/padEnd to achieve setw equivalent
                print(nodeValue.padStart(nodeLength, ' ')) // Pad left to simulate right-alignment with setfill '0' if '0' were padding char
                if (nodeIndex != lastNode) {
                    print(" ".repeat(nodesSpacing))
                }
            }
            println() // New line after printing all nodes for the current level

            // Print branches (if not the last level)
            for (i in 0 until branchHeight) {
                if (level == lastLevel) break // Don't print branches for the last level

                val branchIndentation = subtreeWidth / 2 - 1 - i
                print(" ".repeat(branchIndentation))

                for (nodeIndex in 0 until nodesCount) {
                    val hasLeftChild = values[level + 1][2 * nodeIndex].isNotEmpty()
                    val hasRightChild = values[level + 1][2 * nodeIndex + 1].isNotEmpty()
                    val branchWidth = nodeType + 2 * i
                    val branchesSpacing = nodesSpacing + 2 * (nodeShiftFactor - 1 - i)

                    print(if (hasLeftChild) "/" else " ")
                    print(" ".repeat(branchWidth))
                    print(if (hasRightChild) "\\" else " ")

                    if (nodeIndex != lastNode) {
                        print(" ".repeat(branchesSpacing))
                    }
                }
                println() // New line after printing a branch row
            }
        }
    }
}

object TreeConverter {

    /**
     * Converts a given BinaryTreeNode (root of a tree) into a BinarySearchTree object.
     *
     * @param root The root node of the tree. Can be null if the tree is empty.
     * @return A BinarySearchTree object containing the provided root.
     */
    fun <T> fromRoot(root: BinaryTreeNode<T>?): BinarySearchTree<T> {
        val tree = BinarySearchTree<T>()
        tree.root = root
        return tree
    }
}