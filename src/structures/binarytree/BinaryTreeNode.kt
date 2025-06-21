class BinaryTreeNode<T>(var value: T) {

    // Secondary constructor to set left and right children immediately
    constructor(value: T, left: BinaryTreeNode<T>? = null, right: BinaryTreeNode<T>? = null) : this(value) {
        this.left = left
        this.right = right
    }

    var left: BinaryTreeNode<T>? = null
    var right: BinaryTreeNode<T>? = null
}

class BinarySearchTree<T> {
    var root: BinaryTreeNode<T>? = null

    constructor() // Primary constructor for an empty tree

    constructor(initialRootValue: T) {
        root = BinaryTreeNode(initialRootValue)
    }

    // You might add methods here like insert, delete, search, etc.
    // For this visualization, we only need the root.
}