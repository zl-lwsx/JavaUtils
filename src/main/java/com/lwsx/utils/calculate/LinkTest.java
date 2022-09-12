package com.lwsx.utils.calculate;

public class LinkTest {
    class Node<Object>{
        private Object item;
        private Node<Object> next;
        private Node<Object> prev;
        Node(Object item, Node<Object> next, Node<Object> prev){
            this.item =item;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node<Object> first;
    private Node<Object> last;
    private int size = 0;
    public void add(Object obj){
        if (first == null){
            addObject(obj);
        }else {
            addObject2(obj);
        }
        size++;
    }

    private void addObject2(Object obj) {
        Node<Object> temp = last;
        Node<Object> node = new Node<>(obj,null,temp);
        last = node;
        temp.next = node;
    }

    private void addObject(Object obj) {
        Node<Object> node = new Node<>(obj,null,null);
        first = node;
        last = node;
    }

    private Object get(int i){
        if (size<i || i<0  )
            return null;

        Node<Object> node;
        if (size/2 < i){
            node = first;
            for(int ii =0; ii < i; ii++){
                node = node.next;
            }
        }else {
            node = last;
            for (int ii = size -1 ; ii> i ; ii--){
                node = node.prev;
            }

        }

        return node.item;
    }

}
