package structures.binarytree

import BinaryTreeNode
import java.util.LinkedList
import java.util.Queue

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

    var root = createTree()

    breathFirstPrinting(root)
}

fun breathFirstPrinting(root: BinaryTreeNode<Int>) {

    var node = root
    var queue: Queue<BinaryTreeNode<Int>> = LinkedList<BinaryTreeNode<Int>>()
    queue.add(node)

    var level = 0
    while (queue.isEmpty().not()){
        print("Level: $level: ")

        val element = queue.poll()

        print(element.value.toString() +" ")

        if (element.left!=null){
            queue.add(element.left)
        }

        if (element.right!=null){
            queue.add(element.right)
        }

        println("")
        level++
    }

}


//fun breathFirstPrinting(root: BinaryTreeNode<Int>) {
//
//    var node = root
//    var structures.queue: Queue<BinaryTreeNode<Int>> = LinkedList<BinaryTreeNode<Int>>()
//    structures.queue.add(node)
//
//    var level = 0
//    while (structures.queue.isEmpty().not()){
//        print("Level: $level: ")
//
//        for (i in 0 .. structures.queue.size-1){
//            val element = structures.queue.poll()
//
//            print(element.value.toString() +" ")
//
//            if (element.left!=null){
//                structures.queue.add(element.left)
//            }
//
//            if (element.right!=null){
//                structures.queue.add(element.right)
//            }
//
//        }
//        println("")
//        level++
//    }
//
//}
