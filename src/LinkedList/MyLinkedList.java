package LinkedList;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        Node<T> node = new Node<>(element);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node<T> node = new Node<>(element);
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            if (tail == null) {
                tail = node;
            }
        } else if (index == size){
            add(element);
        } else {
            Node<T> cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            Node<T> node = new Node<>(element);
            node.prev = cur.prev;
            node.next = cur;
            cur.prev.next = node;
            cur.prev = node;
        }
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        if (cur.prev != null) {
            cur.prev.next = cur.next;
        } else {
            head = cur.next;
        }
        if (cur.next != null) {
            cur.next.prev = cur.prev;
        } else {
            tail = cur.prev;
        }

        size--;

        return cur.data;

    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.data;
    }

    public void print() {
        Node<T> cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator<>(head);
    }

}