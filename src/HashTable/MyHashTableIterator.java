package HashTable;

import java.util.Iterator;

public class MyHashTableIterator<K, V> implements Iterator<Node<K, V>> {
    private Node<K, V>[] buckets;
    private int curBuc;
    private Node<K, V> curNode;

    public MyHashTableIterator(Node<K, V>[] buckets) {
        this.buckets = buckets;
        this.curBuc = 0;
        this.curNode = null;
        findNextNode();
    }

    @Override
    public boolean hasNext() {
        return curNode != null;
    }

    @Override
    public Node<K, V> next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }

        Node<K, V> cur = curNode;
        curNode = curNode.next;
        if (curNode == null) {
            curBuc++;
            findNextNode();
        }
        return cur;
    }

    public void findNextNode() {
        while (curBuc < buckets.length) {
            if (buckets[curBuc] != null) {
                curNode = buckets[curBuc];
                return;
            }
            curBuc++;
        }
        curNode = null;
    }
}