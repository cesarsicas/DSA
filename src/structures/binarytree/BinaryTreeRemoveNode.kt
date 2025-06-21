package structures.binarytree

import BinaryTreeNode

class BinaryTreeRemoveNodeExercise {

    fun removeNode(root: BinaryTreeNode<Int>?, value: Int): BinaryTreeNode<Int>? {

        if (root == null){
            return null
        }

        if (value > root.value){
            root.right = removeNode(root.right, value)

        }
        else{
            if (value < root.value){
                root.left = removeNode(root.left, value)
            }
            else{
                if (root.left == null){
                    return root.right
                }
                else{
                    if (root.right == null){
                        return root.left
                    }
                    else{
                        val minimal = findMinimal(root.right)
                        root.value = minimal!!.value
                        root.right = removeNode(root.right, minimal.value)

                    }
                }
            }
        }





        return root
    }


    fun findMinimal(root: BinaryTreeNode<Int>?): BinaryTreeNode<Int>? {
        var node = root

        while (node?.left != null) {
            node = node.left
        }

        println("Minimal: " + node?.value)
        return node
    }
}










class BinaryTreeRemoveNode {

    fun removeNode(root: BinaryTreeNode<Int>?, value: Int): BinaryTreeNode<Int>? {

        if (root == null) {
            return null
        }

        if (value > root.value) {
            root.right = removeNode(root.right, value)
        } else {

            if (value < root.value) {
                root.left = removeNode(root.left, value)
            } else {

                if (root.right == null) {
                    return root.left
                } else {
                    if (root.left == null) {
                        return root.right
                    } else {
                        val minimal = findMinimal(root.right)

                        root.value = minimal?.value!!

                        root.right = removeNode(root.right, minimal.value)

                    }
                }
            }
        }

        return root
    }

    fun findMinimal(root: BinaryTreeNode<Int>?): BinaryTreeNode<Int>? {
        var node = root

        while (node?.left != null) {
            node = node.left
        }

        println("Minimal: " + node?.value)
        return node
    }
}