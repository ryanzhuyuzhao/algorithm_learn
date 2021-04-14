package org.ryan.chapter10;

/**
 * 二叉树测试
 */
public class NodeTest {

    public static void main(String[] args) {
        Node parentNode = new Node(49);
        parentNode.insert(34);
        parentNode.insert(56);
        Node node56 = parentNode.search(56);
        System.out.println(node56.getData());
        System.out.println(parentNode.getLeftNode().getData());

    }
}
