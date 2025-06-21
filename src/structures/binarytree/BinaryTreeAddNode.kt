package structures.binarytree

import BinaryTreeNode

class BinaryTreeAddNodeExercise {
    fun addNode(root: BinaryTreeNode<Int>?, newValue: BinaryTreeNode<Int>): BinaryTreeNode<Int>? {
        if (root == null) {
            return null
        }

        if (newValue.value > root.value){

            if (root.right == null){
                root.right = newValue
            }
            else{
                addNode(root.right, newValue)
            }

        }
        else{
            if (root.left == null){
                root.left = newValue
            }
            else{
                addNode(root.left, newValue)
            }
        }


        return root
    }
}

class BinaryTreeAddNode {
    fun addNode(root: BinaryTreeNode<Int>?, newValue: BinaryTreeNode<Int>): BinaryTreeNode<Int>? {
        if (root == null) {
            return null
        }

        if (newValue.value > root.value) {
            if (root.right == null) {
                root.right = newValue
            } else {
                addNode(root.right, newValue)
            }

        } else {
            if (root.left == null) {
                root.left = newValue
            } else {
                addNode(root.left, newValue)
            }

        }
        return root
    }
}



