package HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<String, Integer>();

        hashTable.put("1", 1);
        hashTable.put("2", 2);
        hashTable.put("3", 3);

        System.out.println(hashTable.get("2"));

        System.out.println(hashTable.containsKey("2"));

        System.out.println(hashTable.remove("2"));

        System.out.println(hashTable.size());

        System.out.println(hashTable.isEmpty());

        for (Node<String, Integer> node : hashTable) {
            System.out.println(node.key + ": " + node.val);
        }

        hashTable.clear();
        System.out.println(hashTable.size());


    }
}