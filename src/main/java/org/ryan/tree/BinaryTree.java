package org.ryan.tree;

/**
 * @ClassName Tree
 * @Description
 * @Author Administrator
 * @Date 2021/4/14 0014 21:29
 * @Version 1.0
 */
public class BinaryTree {

    /**根节点*/
    private Node root;

    /**
     * 添加数据
     * @param data
     * @return
     */
    public boolean insert(int data) {
        Node node = new Node(data);
        if (root == null) {//如果没有设置树的根节点
            root = node;
            return true;
        }else {
            Node current = root;
            Node parentNode = null;
            while (current != null) {
                parentNode = current;
                if (current.getData() > data) {
                    current = current.getLeftNode();
                    if (current == null) {
                        parentNode.setLeftNode(node);
                        return true;
                    }
                }else if (current.getData() < data) {
                    current = current.getRightNode();
                    if (current == null) {
                        parentNode.setRightNode(node);
                        return true;
                    }
                }else {//树中已有此数据
                    return false;
                }
            }
            return false;
        }
    }

    /**
     * 查找数据
     * @param data
     * @return
     */
    public Node search(int data) {
        Node current = root;
        while (current != null) {
            if (current.getData() > data) {
                current = current.getLeftNode();
            }else if (current.getData() < data) {
                current = current.getRightNode();
            }else {
                return current;
            }
        }
        return null;//在树中无此数据
    }


    /**
     * 删除数据
     * @param data
     * @return
     */
    public boolean remove(int data) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;//判断删除节点是否为父节点的左子节点
        while (current.getData() != data) {
            parent = current;
            if (current.getData() < data) {
                current = current.getRightNode();
                isLeftChild = false;
            }else if (current.getData() > data) {
                current = current.getLeftNode();
                isLeftChild = true;
            }else {
                break;
            }
            if (current == null) {//没有在树中找到对应的数据
                return false;
            }
        }
        if(current.getLeftNode() == null && current.getRightNode() == null) {//如果要删除节点的左右子节点都为null,直接将其从父节点的引用置为null
            if (isLeftChild) {
                parent.setLeftNode(null);
            }else {
                parent.setRightNode(null);
            }
            return true;
        }else if (current.getLeftNode() != null && current.getRightNode() == null) {//删除节点只有一个子节点
            if (current == root) {
                root = current.getLeftNode();
            }else if (isLeftChild) {
                parent.setLeftNode(current.getLeftNode());
            }else {
                parent.setRightNode(current.getLeftNode());
            }
            return true;
        }else if (current.getRightNode() != null && current.getLeftNode() == null) {
            if (current == root) {
                root = current.getRightNode();
            }else if (isLeftChild) {
                parent.setLeftNode(current.getRightNode());
            }else {
                parent.setRightNode(current.getRightNode());
            }
            return true;
        }else {
            //删除节点有两个子节点
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            }else if (isLeftChild) {
                parent.setLeftNode(successor);
            }else {
                parent.setRightNode(successor);
            }
            return true;
        }
    }

    /**
     * 返回删除节点的后继节点
     * @param delNode
     * @return
     */
    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRightNode();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftNode();
        }
        if (successor != delNode.getRightNode()) {//如果后继节点不是删除节点的右子节点，将后继节点替换
            successorParent.setLeftNode(successor.getRightNode());
            successor.setRightNode(delNode.getRightNode());
            successor.setLeftNode(delNode.getLeftNode());
        }
        return successor;
    }

    /**
     * 前序遍历树
     * @param current
     */
    public void preOrder(Node current) {
        if(current == null) {
            return;
        }
        System.out.println("节点数据: " + current.getData());
        preOrder(current.getLeftNode());
        preOrder(current.getRightNode());
    }

    /**
     * 后序遍历树
     * @param current
     */
    public void postOrder(Node current) {
        if (current == null) {
            return;
        }
        postOrder(current.getLeftNode());
        postOrder(current.getRightNode());
        System.out.println("节点数据: " + current.getData());
    }

    /**
     * 中序遍历树
     * @param current
     */
    public void infixOrder(Node current) {
        if (current == null) {
            return;
        }
        infixOrder(current.getLeftNode());
        System.out.println("节点数据: " + current.getData());
        infixOrder(current.getRightNode());
    }

    /**
     * 寻找最大数据节点
     * @return
     */
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.getRightNode();
        }
        return maxNode;
    }

    /**
     * 寻找最小数据   节点
     * @return
     */
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.getLeftNode();
        }
        return minNode;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
