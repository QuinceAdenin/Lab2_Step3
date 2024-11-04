package LinkedList;

import java.util.Iterator;

public class MyLinkedListIterator<T> implements Iterator<T> {
    private Node<T> cur;

    public MyLinkedListIterator(Node<T> head) {
        this.cur = head;
    }

    @Override
    public boolean hasNext() {
        return cur != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        T data = cur.data;
        cur = cur.next;
        return data;
    }
}
