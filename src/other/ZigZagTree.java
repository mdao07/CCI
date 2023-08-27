package other;


import java.util.LinkedList;
import java.util.Stack;

public class ZigZagTree {

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void zigZagTree(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        Node curNode;

        while(!s1.isEmpty()) {

            do {
                curNode = s1.pop();
                System.out.print(curNode.data + " ");

                if (curNode.right != null) {
                    s2.push(curNode.right);
                }

                if (curNode.left != null) {
                    s2.push(curNode.left);
                }
            } while(!s1.isEmpty());

            System.out.println();

            while(!s2.isEmpty()) {
                curNode = s2.pop();
                System.out.print(curNode.data + " ");

                if (curNode.left != null) {
                    s1.push(curNode.left);
                }

                if (curNode.right != null) {
                    s1.push(curNode.right);
                }
            }

            System.out.println();
        }

    }

    public static void main(String [] args) {

        Node n41 = new Node(8);
        Node n42 = new Node(9);
        Node n43 = new Node(10);
        Node n44 = new Node(11);

        Node n45 = new Node(12);
        Node n46 = new Node(13);
        Node n47 = new Node(14);
        Node n48 = new Node(15);

        Node n31 = new Node(4, n41, n42);
        Node n32 = new Node(5, n43, n44);
        Node n33 = new Node(6, n45, n46);
        Node n34 = new Node(7, n47, n48);

        Node n21 = new Node(2, n31, n32);
        Node n22 = new Node(3, n33, n34);

        Node n11 = new Node(1, n21, n22);

        zigZagTree(n11);
    }
}
