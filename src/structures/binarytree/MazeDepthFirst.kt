package structures.binarytree

import BinaryTreeNode
import java.util.Stack


private fun createTree(): BinaryTreeNode<Int> {
    // 1. Create the nodes with Integer values
    val root = BinaryTreeNode(10)

    val node5 = BinaryTreeNode(5)
    val node15 = BinaryTreeNode(15)
    val node3 = BinaryTreeNode(0)
    val node12 = BinaryTreeNode(0)
    val node18 = BinaryTreeNode(18)

    // 2. Assemble the tree by linking the nodes
    // Root and its immediate children
    root.left = node5
    root.right = node15

    // Left subtree
    node5.left = node3

    // Right subtree
    node15.left = node12
    node15.right = node18

    /*
      The tree structure will look like this:
              10
             /  \
            5    15
           /    /  \
          0    0   18
    */

    return root
}


var stack:Stack<Int> = Stack<Int>()

fun main() {
    val root = createTree()

    val tree = TreeConverter.fromRoot(root)
    val visualizer = Visualizer(tree)
    visualizer.visualize()

    //println(findLeaf(root))
    println(findLeafPath(root))
    println(stack)

}

//Check if tree has a path to a leaf without 0

private fun findLeaf(node:BinaryTreeNode<Int>?):Boolean{
    if (node== null || node.value ==0){
        return false
    }


    if (node.left==null && node.right ==null){
        return true
    }
    else{
        if(findLeaf(node.left)){
            return true
        }
        if(findLeaf(node.right)){
            return true
        }
    }

    return false
}



private fun findLeafPath(node:BinaryTreeNode<Int>?):Boolean{
    if (node== null || node.value ==0){
        return false
    }

    stack.add(node.value)


    if (node.left==null && node.right ==null){
        return true
    }
    else{
        if(findLeafPath(node.left)){
            return true
        }
        if(findLeafPath(node.right)){
            return true
        }
    }

    stack.pop()
    return false
}