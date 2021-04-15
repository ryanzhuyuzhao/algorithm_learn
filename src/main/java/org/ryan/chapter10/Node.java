package org.ryan.chapter10;

/**
 * 树的节点
 */
public class Node {

    /** 存放的数据 */
    private int data;

    /**左子节点*/
    private Node leftNode;

    /** 右子节点 */
    private Node rightNode;

    /**当前节点父节点*/
    private Node parentNode;

    public Node(int data) {
        this.data = data;
    }

    /**
     * 插入数据
     * @param num
     * @return
     */
    public boolean insert(int num) {
        Node node = new Node(num);
        Node current = this;
        while (current != null) {
            if (current.data > node.getData()) {
                if (current.leftNode != null) {
                    current = current.leftNode;
                    continue;
                }else {
                    current.leftNode = node;
                    node.parentNode = current;
                    return true;//二叉树插入数据成功，插入到左叶子节点
                }
            }else if (current.data < node.getData()) {
                if (current.getRightNode() != null) {
                    current = current.rightNode;
                }else {
                    current.rightNode = node;
                    node.parentNode = current;
                    return true;//二叉树插入数据成功，插入到右叶子节点
                }
            }else {//二叉树中已有此数据
                return false;
            }
        }
        return false;
    }

    /**
     * 查找数据
     * @param num
     * @return
     */
    public Node search(int num) {
        Node current = this;
        while (current != null) {
            if (current.data == num) {
                return current;
            }else if (num < current.data) {
                if (current.leftNode != null) {
                    current = current.leftNode;
                    continue;
                }else {
                    return null;//没有在二叉树中找到对应数据
                }
            }else {
                if (current.getRightNode() != null) {
                    current = current.rightNode;
                }else {
                    return null;//没有在二叉树中找到对应数据
                }
            }
        }
        return null;//没有在二叉树中找到对应数据
    }

    /**
     * 删除对应的数据
     * @param num
     * @return
     */
    public boolean remove(int num) {
        Node parent = this;
        Node current = this;
        Node node = search(num);
        if (node != null) {
            //将当前节点的子节点挂载到子节点的节点上
            node.parentNode.leftNode = node.parentNode.rightNode;
            Node currentParentRightNode = node.parentNode.rightNode;
            Node minLeftNode = findMinLeftNode(currentParentRightNode);
            Node currentLeftNode = node.leftNode;
            currentLeftNode.parentNode = minLeftNode;
            return true;//删除成功
        }else {
            return false;//没有找到对应数据，无法删除
        }
    }

    /**
     * 查找当前节点最小左节点
     * @param node
     * @return
     */
    public Node findMinLeftNode(Node node) {
        Node currentNode = node;
        while (currentNode != null) {
            if (currentNode.leftNode != null) {
                currentNode = currentNode.leftNode;
            }else {
                return currentNode;
            }
        }
        return null;
    }

    /**
     * 查找当前节点的最大右节点
     * @param node
     * @return
     */
    public Node findMaxRightNode(Node node) {
        Node currentNode = node;
        while (currentNode != null) {
            if (currentNode.rightNode != null) {
                currentNode = currentNode.rightNode;
            }else {
                return currentNode;
            }
        }
        return null;
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

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }
}
