package Lab2;

import java.util.NoSuchElementException;

public class LinkedListDriver
{
    public static void main(String[] args)
    {
        CP3LinkedList<String> linkedList = new CP3LinkedList<String>();



        linkedList.addFirst("Test");
        linkedList.addFirst("Test2");
        linkedList.print();

        System.out.println(linkedList.size());
        System.out.println(linkedList.contains(""));
        System.out.println(linkedList.contains("Test"));


    }
}
