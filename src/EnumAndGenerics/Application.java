package EnumAndGenerics;

import java.util.ArrayList;

public class Application implements Runnable{
    @Override
    public void run() {
        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add("First");
        stringArrayList.add("Second");

        ArrayList<Integer> integerArrayList = new ArrayList<>();

        integerArrayList.add(98743598);

        for(String string:stringArrayList) {
            //loop content
        }

        for(int i=0;i<stringArrayList.size();i++) {
            String string = stringArrayList.get(i);

            //loop content
        }

        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.pushFront("A");
        stringLinkedList.pushFront("B");
        stringLinkedList.pushFront("C");
        System.out.println(stringLinkedList.toString());

        stringLinkedList.pushFront("D");
        System.out.println(stringLinkedList.toString());

        stringLinkedList.pushFront("D");

        stringLinkedList.clear();
        System.out.println(stringLinkedList.toString());

        LinkedList<Object> objectLinkedList = new LinkedList<>();
        objectLinkedList.pushFront("String");
        objectLinkedList.pushFront(876234);

        LinkedList generalLinkedList = stringLinkedList;
        generalLinkedList.pushFront(100);

        LinkedList.Node<String> first = stringLinkedList.getFirst();
        while(first != null) {
            System.out.println(first.getData());
            first.getData().substring(1);
            first = first.getNext();
        }
    }
}
