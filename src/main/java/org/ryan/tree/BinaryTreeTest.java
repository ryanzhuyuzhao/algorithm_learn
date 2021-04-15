package org.ryan.tree;

/**
 * 二叉树数据结构测试
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
//        bt.remove(10);//删除没有子节点的节点
//        bt.remove(30);//删除有一个子节点的节点
//        bt.remove(80);//删除有两个子节点的节点
//        System.out.println(bt.findMax().getData());
//        System.out.println(bt.findMin().getData());
//        System.out.println(bt.search(100));
//        System.out.println(bt.search(200));
        bt.preOrder(bt.getRoot());
    }
}
