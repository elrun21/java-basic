package sample0201;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        printArrayList(list);

        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        printLinkedList(linkedList);
    }
    public static void printArrayList(ArrayList<Integer> list ){
        for( Integer i : list)  System.out.println(i);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for( int i = 0 ; i < list.size() ; i++ ){
            if( i == 1 || i==3 || i ==5 ) temp.add(0);
            else temp.add(list.get(i));
        }
        System.out.println("=========================================");
        for( Integer i : temp) System.out.println(i);
    }
    public static void  printLinkedList(LinkedList linkedList) {
        for( Object o : linkedList) System.out.println(o);
        linkedList.set(1 , 0);
        linkedList.set(3, 0);
        linkedList.set(5, 0);
        System.out.println("=========================================!!!!");
        for( Object o : linkedList) System.out.println(o);
    }
}
