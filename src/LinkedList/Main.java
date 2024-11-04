package LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        myList.add(1);
        myList.add(2);
        myList.add(4);
        myList.add(2, 3);

        myList.print();

        System.out.println(myList.remove(0));

        myList.print();

        System.out.println(myList.get(0));

        System.out.println(myList.size());

        System.out.println(myList.isEmpty());

        for (Integer i : myList) {
            System.out.println(i);
        }
    }
}