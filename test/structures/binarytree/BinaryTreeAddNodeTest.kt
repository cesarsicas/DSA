package structures.binarytree

import BinaryTreeNode
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BinaryTreeAddNodeTest {

    private lateinit var binaryTreeAddNode: BinaryTreeAddNodeExercise

    // This function runs before each test to set up a fresh instance of BinaryTreeAddNode
    @Before
    fun setUp() {
        binaryTreeAddNode = BinaryTreeAddNodeExercise()
    }

    // Test case 1: Adding a node to an empty tree.
    // As per the provided `addNode` function's logic, if the root is initially null,
    // it returns null because it cannot attach the new node.
    @Test
    fun `addNode returns null when root is initially null`() {
        val newNode = BinaryTreeNode(10)
        val result = binaryTreeAddNode.addNode(null, newNode)
        assertNull(result)
    }

    // Test case 2: Adding a node larger than the root, filling the right child.
    @Test
    fun `addNode adds node to the right when root right is null and newValue is greater`() {
        val root = BinaryTreeNode(50)
        val newNode = BinaryTreeNode(75)
        val result = binaryTreeAddNode.addNode(root, newNode)

        assertNotNull(result)
        assertEquals(50, result?.value)
        assertNotNull(result?.right, )
        assertEquals(75, result?.right?.value)
        assertNull(result?.left)
    }

    // Test case 3: Adding a node smaller than the root, filling the left child.
    @Test
    fun `addNode adds node to the left when root left is null and newValue is less`() {
        val root = BinaryTreeNode(50)
        val newNode = BinaryTreeNode(25)
        val result = binaryTreeAddNode.addNode(root, newNode)

        assertNotNull(result, )
        assertEquals(50, result?.value)
        assertNotNull(result?.left)
        assertEquals(25, result?.left?.value)
        assertNull(result?.right)
    }

    // Test case 4: Adding a node when the right child already exists, requiring recursive call.
    @Test
    fun `addNode recursively adds node to the right when root right already exists`() {
        val root = BinaryTreeNode(50, right = BinaryTreeNode(70))
        val newNode = BinaryTreeNode(80)
        val result = binaryTreeAddNode.addNode(root, newNode)

        assertNotNull(result)
        assertEquals(50, result?.value)
        assertNotNull(result?.right)
        assertEquals(70, result?.right?.value)
        assertNotNull(result?.right?.right)
        assertEquals(80, result?.right?.right?.value)
        assertNull(result?.left)
    }

    // Test case 5: Adding a node when the left child already exists, requiring recursive call.
    @Test
    fun `addNode recursively adds node to the left when root left already exists`() {
        val root = BinaryTreeNode(50, left = BinaryTreeNode(30))
        val newNode = BinaryTreeNode(20)
        val result = binaryTreeAddNode.addNode(root, newNode)

        assertNotNull(result)
        assertEquals(50, result?.value)
        assertNotNull(result?.left)
        assertEquals(30, result?.left?.value)
        assertNotNull(result?.left?.left)
        assertEquals(20, result?.left?.left?.value)
        assertNull(result?.right)
    }


    // Test case 7: Building a small tree with multiple insertions.
    @Test
    fun `addNode builds a correct small binary search tree`() {
        var root: BinaryTreeNode<Int>? = BinaryTreeNode(50) // Initialize with a non-null root
        root = binaryTreeAddNode.addNode(root, BinaryTreeNode(25))
        root = binaryTreeAddNode.addNode(root, BinaryTreeNode(75))
        root = binaryTreeAddNode.addNode(root, BinaryTreeNode(10))
        root = binaryTreeAddNode.addNode(root, BinaryTreeNode(30))
        root = binaryTreeAddNode.addNode(root, BinaryTreeNode(60))
        root = binaryTreeAddNode.addNode(root, BinaryTreeNode(90))

        assertNotNull(root)
        assertEquals(50, root?.value)

        // Check left subtree
        assertEquals(25, root?.left?.value)
        assertEquals(10, root?.left?.left?.value)
        assertEquals(30, root?.left?.right?.value)

        // Check right subtree
        assertEquals(75, root?.right?.value)
        assertEquals(60, root?.right?.left?.value)
        assertEquals(90, root?.right?.right?.value)

        // Ensure no unexpected nodes
        assertNull(root?.left?.left?.left)
        assertNull(root?.left?.left?.right)
        assertNull(root?.left?.right?.left)
        assertNull(root?.left?.right?.right)
        assertNull(root?.right?.left?.left)
        assertNull(root?.right?.left?.right)
        assertNull(root?.right?.right?.left)
        assertNull(root?.right?.right?.right)
    }

    // Test case 8: Adding a node to a deeper level on the left.
    @Test
    fun `addNode adds node to a deeper left position`() {
        val root = BinaryTreeNode(50,
            left = BinaryTreeNode(30,
                left = BinaryTreeNode(20)))
        val newNode = BinaryTreeNode(15) // Should go left of 20
        val result = binaryTreeAddNode.addNode(root, newNode)

        assertNotNull(result)
        assertEquals(50, result?.value)
        assertEquals(30, result?.left?.value)
        assertEquals(20, result?.left?.left?.value)
        assertEquals(15, result?.left?.left?.left?.value)
    }

    // Test case 9: Adding a node to a deeper level on the right.
    @Test
    fun `addNode adds node to a deeper right position`() {
        val root = BinaryTreeNode(50,
            right = BinaryTreeNode(70,
                right = BinaryTreeNode(80)))
        val newNode = BinaryTreeNode(85) // Should go right of 80
        val result = binaryTreeAddNode.addNode(root, newNode)

        assertNotNull(result)
        assertEquals(50, result?.value)
        assertEquals(70, result?.right?.value)
        assertEquals(80, result?.right?.right?.value)
        assertEquals(85, result?.right?.right?.right?.value)
    }

}
