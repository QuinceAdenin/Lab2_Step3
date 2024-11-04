package HashTable;

import java.util.Iterator;

public class HashTable<K, V>  implements Iterable<Node<K, V>> {
    private static final int defCapacity = 10;
    private static final float loadFactor = 0.7f;

    private Node<K, V>[] buckets;
    private int size;

    public HashTable() {
        this(defCapacity);
    }

    public HashTable(int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    public V put(K key, V val) {
        int index = getIndex(key);
        Node<K, V> cur = buckets[index];

        while (cur != null) {
            if (cur.key.equals(key)) {
                V oldVal = cur.val;
                cur.val = val;
                return oldVal;
            }
            cur = cur.next;
        }

        Node<K, V> node = new Node<K, V>(key, val);
        node.next = buckets[index];
        buckets[index] = node;
        size++;

        if (size > loadFactor * buckets.length) {
            resize();
        }

        return null;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> cur = buckets[index];

        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }

        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> cur = buckets[index];
        Node<K, V> prev = null;

        while (cur != null) {
            if (cur.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return cur.val;
            }
            prev = cur;
            cur = cur.next;
        }

        return null;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> cur = buckets[index];

        while (cur != null) {
            if (cur.key.equals(key)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        buckets = new Node[defCapacity];
        size = 0;
    }

    private void resize() {
        Node<K, V>[] oldBuckets = buckets;
        buckets = new Node[oldBuckets.length * 2];
        size = 0;

        for (Node<K, V> node : oldBuckets) {
            while (node != null) {
                put(node.key, node.val);
                node = node.next;
            }
        }

    }

    private int getIndex(K key) {
        int hash = key.hashCode();
        return (hash & 0x7fffffff) % buckets.length;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new MyHashTableIterator<K, V>(buckets);
    }
}