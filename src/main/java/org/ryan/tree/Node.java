package org.ryan.tree;

/**
 * @ClassName Node
 * @Description
 * @Author Administrator
 * @Date 2021/4/14 0014 21:23
 * @Version 1.0
 */
public class Node {

    /** 存放的数据 */
    private int data;

    /**左子节点*/
    private Node leftNode;

    /** 右子节点 */
    private Node rightNode;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
