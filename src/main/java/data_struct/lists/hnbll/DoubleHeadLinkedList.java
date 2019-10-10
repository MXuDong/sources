package data_struct.lists.hnbll;

import data_struct.lists.ListInterface;

/**
 * 带头节点双向链表
 * <p>
 * Header node bidirectional linked list
 *
 * @author Dong
 */

public class DoubleHeadLinkedList<E> implements ListInterface<E> {

    /**
     * the list size
     */
    int theSize;

    /**
     * 头节点
     */
    Node<E> theHead;

    /**
     * 尾节点
     */
    Node<E> theEnd;

    public DoubleHeadLinkedList(){
        clean();
    }

    @Override
    public boolean isEmpty() {
        return theSize == 0;
    }

    @Override
    public int size() {
        return theSize;
    }

    @Override
    public boolean insert(E o) {
        Node<E> eNode = new Node<>();
        eNode.next = theEnd;
        eNode.pre = theEnd.pre;
        theEnd.pre = eNode.pre.next = eNode;
        theSize++;
        return true;
    }

    @Override
    public boolean insert(int index, E o) {
        return false;
    }

    @Override
    public boolean delete(E o) {
        return false;
    }

    @Override
    public E delete(int index) {
        return null;
    }

    @Override
    public int deleteAll(E o) {
        return 0;
    }

    @Override
    public E update(int index, E newValue) {
        return null;
    }

    @Override
    public boolean update(E oldValue, E newValue) {
        return false;
    }

    @Override
    public int updateAll(E oldValue, E newValue) {
        return 0;
    }

    @Override
    public int count(E o) {
        return 0;
    }

    @Override
    public int searchFirstIndex(E o) {
        return 0;
    }

//    private Node<E> getNode(int index){
//
//    }

    @Override
    public E getE(int index) {
        return null;
    }

    @Override
    public void clean() {
        if (theHead == null) {
            theHead = new Node<>();
        }
        if (theEnd == null) {
            theEnd = new Node<>();
        }

        theHead.next = theEnd;
        theHead.pre = null;
        theEnd.pre = theHead;
        theEnd.next = null;

        theSize = 0;
    }

    /**
     * 元素节点
     *
     * @param <E> 类型参数
     */
    private class Node<E> {
        E e;
        Node<E> next;
        Node<E> pre;
    }
}
