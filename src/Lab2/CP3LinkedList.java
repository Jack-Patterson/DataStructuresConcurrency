package Lab2;

import java.util.NoSuchElementException;

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
    }

    public E removeFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        E tempElement = first.getData();
        first = first.getNext();
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
        Node focus = first;
        while (true)
        {
            System.out.println(focus.getData().toString());
            if (focus.getNext() == null){
                break;
            }
            focus = focus.getNext();
        }
    }

    public int size(){
        int size = 0;
        Node focus = first;
        while (true)
        {
            size++;
            if (focus.getNext() == null){
                break;
            }
            focus = focus.getNext();
        }
        return size;
    }

    public boolean contains(E element){
        Node focus = first;
        while (true)
        {
            if (focus.getData() == element){
                return true;
            }
            if (focus.getNext() == null){
                return false;
            }
            focus = focus.getNext();
        }
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