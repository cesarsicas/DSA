package structures.binarytree

import BinaryTreeNode

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class BinaryTreeRemoveNodeTest {

    private lateinit var binaryTreeRemoveNode: BinaryTreeRemoveNodeExercise

    // This method runs before each test to set up a fresh instance.
    @Before
    fun setUp() {
        binaryTreeRemoveNode = BinaryTreeRemoveNodeExercise()
    }

    /**
     * Helper function to build a binary tree from a list of values.
     * Assumes a simple insertion order to create a basic tree structure for testing.
     * This is a basic way to construct a tree for tests; for more complex scenarios,
     * a proper BST insertion method would be better.
     */
    private fun buildTree(values: List<Int>): BinaryTreeNode<Int>? {
        if (values.isEmpty()) {
            return null
        }
        var root: BinaryTreeNode<Int>? = null
        for (value in values) {
            root = insertNode(root, value)
        }
        return root
    }

    // Helper to insert a single node into a BST structure
    private fun insertNode(node: BinaryTreeNode<Int>?, value: Int): BinaryTreeNode<Int> {
        if (node == null) {
            return BinaryTreeNode(value)
        }
        if (value < node.value) {
            node.left = insertNode(node.left, value)
        } else if (value > node.value) {
            node.right = insertNode(node.right, value)
        }
        // If value already exists, do nothing or handle as per BST rules.
        return node
    }

    /**
     * Helper function to assert that a tree has a specific structure.
     * This performs a simple deep equality check on values and null branches.
     */
    private fun assertTreeStructure(expected: BinaryTreeNode<Int>?, actual: BinaryTreeNode<Int>?) {
        if (expected == null && actual == null) {
            return
        }
        if (expected == null || actual == null) {
            throw AssertionError("Tree structure mismatch: one is null, the other is not.")
        }
        assertEquals("Node value mismatch", expected.value, actual.value)
        assertTreeStructure(expected.left, actual.left)
        assertTreeStructure(expected.right, actual.right)
    }

    // region Tests for findMinimal

    @Test
    fun testFindMinimal_emptyTree() {
        val root = null
        val minimal = binaryTreeRemoveNode.findMinimal(root)
        assertNull(minimal)
    }

    @Test
    fun testFindMinimal_singleNodeTree() {
        val root = BinaryTreeNode(10)
        val minimal = binaryTreeRemoveNode.findMinimal(root)
        assertEquals(10, minimal?.value)
    }

    @Test
    fun testFindMinimal_leftHeavyTree() {
        // Tree:
        //    10
        //   /
        //  5
        // /
        // 2
        val root = BinaryTreeNode(10)
        root.left = BinaryTreeNode(5)
        root.left?.left = BinaryTreeNode(2)
        val minimal = binaryTreeRemoveNode.findMinimal(root)
        assertEquals(2, minimal?.value)
    }

    @Test
    fun testFindMinimal_rightHeavyTree() {
        // Tree:
        //  10
        //   \
        //    15
        //     \
        //      20
        val root = BinaryTreeNode(10)
        root.right = BinaryTreeNode(15)
        root.right?.right = BinaryTreeNode(20)
        val minimal = binaryTreeRemoveNode.findMinimal(root)
        assertEquals(10, minimal?.value) // Minimal in a right-heavy tree from the root is the root itself
    }

    @Test
    fun testFindMinimal_complexTree() {
        // Tree (from root 50):
        //       50
        //      /  \
        //     30   70
        //    / \   / \
        //   20 40 60  80
        //  /
        // 10
        val root = buildTree(listOf(50, 30, 70, 20, 40, 60, 80, 10))
        val minimal = binaryTreeRemoveNode.findMinimal(root)
        assertEquals(10, minimal?.value)
    }

    // endregion

    // region Tests for removeNode

    @Test
    fun testRemoveNode_emptyTree() {
        val root = null
        val newRoot = binaryTreeRemoveNode.removeNode(root, 10)
        assertNull(newRoot)
    }

    @Test
    fun testRemoveNode_valueNotFound() {
        // Tree:
        //    10
        //   /  \
        //  5    15
        val root = buildTree(listOf(10, 5, 15))
        val expectedRoot = buildTree(listOf(10, 5, 15)) // Should remain unchanged

        val newRoot = binaryTreeRemoveNode.removeNode(root, 99)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_removeLeafNodeLeft() {
        // Tree:
        //    10
        //   /  \
        //  5    15
        val root = buildTree(listOf(10, 5, 15))
        // Expected after removing 5:
        //    10
        //      \
        //       15
        val expectedRoot = buildTree(listOf(10, 15))

        val newRoot = binaryTreeRemoveNode.removeNode(root, 5)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_removeLeafNodeRight() {
        // Tree:
        //    10
        //   /  \
        //  5    15
        val root = buildTree(listOf(10, 5, 15))
        // Expected after removing 15:
        //    10
        //   /
        //  5
        val expectedRoot = buildTree(listOf(10, 5))

        val newRoot = binaryTreeRemoveNode.removeNode(root, 15)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_nodeWithOnlyLeftChild() {
        // Tree:
        //     10
        //    /  \
        //   5    15
        //  /
        // 2
        val root = buildTree(listOf(10, 5, 15, 2))
        // Expected after removing 5:
        //     10
        //    /  \
        //   2    15
        val expectedRoot = buildTree(listOf(10, 2, 15))

        val newRoot = binaryTreeRemoveNode.removeNode(root, 5)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_nodeWithOnlyRightChild() {
        // Tree:
        //     10
        //    /  \
        //   5    15
        //    \
        //     7
        val root = buildTree(listOf(10, 5, 15, 7))
        // Expected after removing 5:
        //     10
        //    /  \
        //   7    15
        val expectedRoot = buildTree(listOf(10, 7, 15))

        val newRoot = binaryTreeRemoveNode.removeNode(root, 5)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_nodeWithTwoChildren() {
        // Tree:
        //       50
        //      /  \
        //     30   70
        //    / \   / \
        //   20 40 60  80
        val root = buildTree(listOf(50, 30, 70, 20, 40, 60, 80))
        // Expected after removing 30 (successor is 40):
        //       50
        //      /  \
        //     40   70
        //    /   / \
        //   20  60  80
        val expectedRoot = buildTree(listOf(50, 40, 70, 20, 60, 80))

        val newRoot = binaryTreeRemoveNode.removeNode(root, 30)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_removeRootNoChildren() {
        // Tree: 10
        val root = BinaryTreeNode(10)
        val newRoot = binaryTreeRemoveNode.removeNode(root, 10)
        assertNull(newRoot)
    }

    @Test
    fun testRemoveNode_removeRootWithOneChildLeft() {
        // Tree:
        //    10
        //   /
        //  5
        val root = buildTree(listOf(10, 5))
        // Expected after removing 10:
        //    5
        val expectedRoot = BinaryTreeNode(5)

        val newRoot = binaryTreeRemoveNode.removeNode(root, 10)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_removeRootWithOneChildRight() {
        // Tree:
        //    10
        //     \
        //      15
        val root = buildTree(listOf(10, 15))
        // Expected after removing 10:
        //    15
        val expectedRoot = BinaryTreeNode(15)

        val newRoot = binaryTreeRemoveNode.removeNode(root, 10)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_removeRootWithTwoChildren() {
        // Tree:
        //       50
        //      /  \
        //     30   70
        //    / \   / \
        //   20 40 60  80
        val root = buildTree(listOf(50, 30, 70, 20, 40, 60, 80))
        // Expected after removing 50 (successor is 60):
        //       60
        //      /  \
        //     30   70
        //    / \     \
        //   20 40     80
        val expectedRoot = buildTree(listOf(60, 30, 70, 20, 40, 80))

        val newRoot = binaryTreeRemoveNode.removeNode(root, 50)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_treeWithOnlyOneNode_removeExisting() {
        val root = BinaryTreeNode(10)
        val newRoot = binaryTreeRemoveNode.removeNode(root, 10)
        assertNull(newRoot)
    }

    @Test
    fun testRemoveNode_treeWithOnlyOneNode_removeNonExisting() {
        val root = BinaryTreeNode(10)
        val expectedRoot = BinaryTreeNode(10) // Should remain unchanged
        val newRoot = binaryTreeRemoveNode.removeNode(root, 20)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_multipleRemovals() {
        // Initial Tree:
        //        50
        //       /  \
        //      30   70
        //     / \   / \
        //    20 40 60  80
        val root = buildTree(listOf(50, 30, 70, 20, 40, 60, 80))

        // Remove 20 (leaf)
        var currentRoot = binaryTreeRemoveNode.removeNode(root, 20)
        // Expected:
        //        50
        //       /  \
        //      30   70
        //       \   / \
        //        40 60  80
        assertTreeStructure(buildTree(listOf(50, 30, 70, 40, 60, 80)), currentRoot)

        // Remove 70 (node with two children, successor is 80)
        currentRoot = binaryTreeRemoveNode.removeNode(currentRoot, 70)
        // Expected:
        //        50
        //       /  \
        //      30   80
        //       \   /
        //        40 60
        assertTreeStructure(buildTree(listOf(50, 30, 80, 40, 60)), currentRoot)

        // Remove 50 (root with two children, successor is 60)
        currentRoot = binaryTreeRemoveNode.removeNode(currentRoot, 50)
        // Expected:
        //        60
        //       /  \
        //      30   80
        //       \
        //        40
        assertTreeStructure(buildTree(listOf(60, 30, 80, 40)), currentRoot)

        // Remove 30 (node with one child)
        currentRoot = binaryTreeRemoveNode.removeNode(currentRoot, 30)
        // Expected:
        //        60
        //       /  \
        //      40   80
        assertTreeStructure(buildTree(listOf(60, 40, 80)), currentRoot)

        // Remove 40 (leaf)
        currentRoot = binaryTreeRemoveNode.removeNode(currentRoot, 40)
        // Expected:
        //        60
        //         \
        //          80
        assertTreeStructure(buildTree(listOf(60, 80)), currentRoot)

        // Remove 80 (leaf)
        currentRoot = binaryTreeRemoveNode.removeNode(currentRoot, 80)
        // Expected:
        //        60
        assertTreeStructure(buildTree(listOf(60)), currentRoot)

        // Remove 60 (root)
        currentRoot = binaryTreeRemoveNode.removeNode(currentRoot, 60)
        assertNull(currentRoot)
    }

    @Test
    fun testRemoveNode_valueGreaterThanRoot() {
        // Tree:
        //    10
        //   /  \
        //  5    15
        val root = buildTree(listOf(10, 5, 15))
        // Expected after removing 15:
        //    10
        //   /
        //  5
        val expectedRoot = buildTree(listOf(10, 5))

        val newRoot = binaryTreeRemoveNode.removeNode(root, 15)
        assertTreeStructure(expectedRoot, newRoot)
    }

    @Test
    fun testRemoveNode_valueLessThanRoot() {
        // Tree:
        //    10
        //   /  \
        //  5    15
        val root = buildTree(listOf(10, 5, 15))
        // Expected after removing 5:
        //    10
        //      \
        //       15
        val expectedRoot = buildTree(listOf(10, 15))

        val newRoot = binaryTreeRemoveNode.removeNode(root, 5)
        assertTreeStructure(expectedRoot, newRoot)
    }

    // endregion
}
