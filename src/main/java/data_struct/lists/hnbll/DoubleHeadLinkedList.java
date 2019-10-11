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
    private int theSize;

    /**
     * 头节点
     */
    private Node<E> theHead;

    /**
     * 尾节点
     */
    private Node<E> theEnd;

    public DoubleHeadLinkedList() {
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
        if (o == null) {
            return false;
        }
        Node<E> eNode = new Node<>();
        eNode.e = o;
        eNode.next = theEnd;
        eNode.pre = theEnd.pre;
        theEnd.pre.next = eNode;
        theEnd.pre = eNode;
        theSize++;
        return true;
    }

    @Override
    public boolean insert(int index, E o) {
        Node<E> node = getNode(index);
        if (node == null) {
            return insert(o);
        }
        Node<E> newNode = new Node<>();
        newNode.e = o;
        node.pre.next = newNode;
        newNode.pre = node.pre;
        newNode.next = node;
        node.pre = newNode;
        theSize++;
        return true;
    }

    @Override
    public boolean delete(E o) {
        return delete(searchFirstIndex(o)) == null;
    }

    @Override
    public E delete(int index) {
        Node<E> node = getNode(index);
        if (node == null) {
            return null;
        }

        node.next.pre = node.pre;
        node.pre.next = node.next;
        theSize--;
        return node.e;
    }


    @Override
    public E update(int index, E newValue) {
        if(newValue == null){
            return null;
        }
        Node<E> node = getNode(index);
        if (node == null) {
            return null;
        }

        E oldE = node.e;
        node.e = newValue;
        return oldE;
    }

    @Override
    public boolean update(E oldValue, E newValue) {
        return update(searchFirstIndex(oldValue), newValue) == null;
    }


    @Override
    public int searchFirstIndex(E o) {
        Node<E> node = theHead.next;
        int count = 0;
        while (node != theEnd) {
            if (node.e.equals(o)) {
                return count;
            }
            count++;
            node = node.next;
        }

        return -1;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= theSize) {
            return null;
        }
        int i = 0;
        Node<E> node = theHead.next;
        while (i < index) {
            if (node == theEnd) {
                return null;
            }
            node = node.next;
            i++;
        }
        return node;
    }

    @Override
    public E getE(int index) {
        Node<E> res = getNode(index);
        if (res == null) {
            return null;
        }

        return res.e;
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
    private static class Node<E> {
        E e;
        Node<E> next;
        Node<E> pre;
    }

    private void print() {
        Node<E> node = theHead.next;

        while (node != theEnd) {
            System.out.println(node.e);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DoubleHeadLinkedList<String> doubleHeadLinkedList = new DoubleHeadLinkedList<String>();
        System.out.println(doubleHeadLinkedList.isEmpty());
        System.out.println(doubleHeadLinkedList.theSize);

        doubleHeadLinkedList.insert("test");
//        doubleHeadLinkedList.print();
        doubleHeadLinkedList.insert("test2");
        System.out.println(doubleHeadLinkedList.theSize);
        doubleHeadLinkedList.insert(0, "test0");
        System.out.println(doubleHeadLinkedList.theSize);
        doubleHeadLinkedList.print();
        System.out.println(doubleHeadLinkedList.searchFirstIndex("test"));
        doubleHeadLinkedList.delete(1);
        System.out.println(doubleHeadLinkedList.size());
        doubleHeadLinkedList.print();
        doubleHeadLinkedList.update(0, "test333");
        doubleHeadLinkedList.update("test2" , "asdtgasfdsf");
        doubleHeadLinkedList.print();
        doubleHeadLinkedList.delete("test333");
        doubleHeadLinkedList.print();
        doubleHeadLinkedList.clean();
        System.out.println(doubleHeadLinkedList.isEmpty());
        System.out.println(doubleHeadLinkedList.size());
        doubleHeadLinkedList.print();
    }
}
