package HashTable;

public class Node<K, V> {
    final K key;
    V val;
    Node<K, V> next;

    public Node(K key, V val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}