package Lab2;

import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CP3LinkedList<E>
{
    private Node first;
    private Node last;

    public CP3LinkedList()
    {
        first = null;
        last = null;
    }

    public E getFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        return first.getData();
    }

    public E getLast()
    {
        if (last == null)
        {
            throw new NoSuchElementException();
        }
        return last.getData();
    }

    public void addFirst(E element)
    {
        Node tempNode = new Node();
        tempNode.setData(element);
        tempNode.setNext(first);
        first = tempNode;

        if (last == null)
        {
            last = tempNode;
        }
    }

    public E removeFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        if (last == first)
        {
            last = null;
        }

        E tempElement = first.getData();
        first = first.getNext();
        if (first.getPrevious() != null){
            first.setPrevious(null);
        }
        return tempElement;
    }

    public void addLast(E element)
    {
        Node tempNode = new Node();
        tempNode.setData(element);
        tempNode.setPrevious(last);
        tempNode.setNext(tempNode);
        last = tempNode;

        if (first == null)
        {
            first = tempNode;
        }
    }

    public E removeLast()
    {
        if (last == null)
        {
            throw new NoSuchElementException();
        }
        if (last == first)
        {
            first = null;
        }

        E tempElement = last.getData();
        last = last.getPrevious();
        if (first.getNext() != null){
            first.setNext(null);
        }
        return tempElement;
    }

    public boolean isEmpty()
    {
        if (first == null && last == null)
        {
            return true;
        }
        return false;
    }

    public void print()
    {
        Node current = first;
        while (current != null)
        {
            System.out.println(current.getData().toString());
            current = current.getNext();
        }
    }

    public int size()
    {
        int size = 0;
        Node current = first;
        while (current != null)
        {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public boolean contains(E element)
    {
        Node current = first;
        while (current != null)
        {
            if (current.getData() == element)
            {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    private class Node
    {
        private E data;
        private Node next;
        private Node previous;

        public E getData()
        {
            return data;
        }

        public void setData(E data)
        {
            this.data = data;
        }

        public Node getNext()
        {
            return next;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }

        public Node getPrevious()
        {
            return previous;
        }

        public void setPrevious(Node previous)
        {
            this.previous = previous;
        }
    }
}