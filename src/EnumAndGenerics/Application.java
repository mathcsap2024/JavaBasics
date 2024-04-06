package EnumAndGenerics;

import java.util.ArrayList;
import java.util.Arrays;

public class Application implements Runnable{

    public <T extends Comparable> int compare(T a, T b) {
        T object = a;
//        object = new T();
//        T[] array = new T[100];
        return a.compareTo(b);
    }

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

        Integer a=10,b=20;
        Double c=0.0;
        this.compare(a,c);

        ArrayList<? extends Number> tempArraylist = null;
        ArrayList<Integer> intList = null;
        ArrayList<Double> doubleList = null;
        ArrayList<Number> numList = null;

        numList = intList;
        numList.add(987.0);

        numList.add(987);
        tempArraylist = numList;
        tempArraylist.get(3);

        ArrayList<? super Integer> aaa = numList;
        ArrayList<? super Integer> bbb = numList;

        Integer n = 100;
        aaa.add(n);

        average(intList);
    }

    void average(ArrayList<? super Integer> list) {
        Integer i = 10;
        list.add(i);
    }
}
