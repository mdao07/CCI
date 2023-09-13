package chapter4;

import java.util.LinkedList;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */

public class Ex2 {

    private static Node arrayToBST(int [] array, int a, int b) {
        if (a > b) {
            return null;
        }

        int mid = (a + (b - a) / 2);
        Node node = new Node(array[mid]);
        node.left = arrayToBST(array, a, mid - 1);
        node.right = arrayToBST(array, mid + 1, b);

        return node;
    }

    public static Node arrayToBST(int [] array) {
        return arrayToBST(array, 0, array.length - 1);
    }

    public static void main(String [] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        LinkedList<Node> nodes = new LinkedList<>();
        LinkedList<Node> nextNodes = new LinkedList<>();
        LinkedList<Node> aux;
        nodes.add(arrayToBST(arr));

        while (!nodes.isEmpty()) {

            do {
                Node curNode = nodes.removeFirst();

                if (curNode == null) {
                    System.out.print("x ");
                    continue;
                } else {
                    System.out.print(curNode.data + " ");
                }

                //if (curNode.left != null) {
                    nextNodes.add(curNode.left);
                //}

                //if (curNode.right != null) {
                    nextNodes.add(curNode.right);
                //}
            } while (!nodes.isEmpty());

            System.out.println();
            aux = nodes;
            nodes = nextNodes;
            nextNodes = aux;
        }

    }
}
