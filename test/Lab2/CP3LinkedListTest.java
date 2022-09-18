package Lab2;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CP3LinkedListTest
{
    @Test
    void getFirstNull()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        assertThrows(NoSuchElementException.class, () ->
        {
            list.getFirst();
        });
    }

    // Works for regular getFirst() and for addFirst()
    @Test
    void getAddFirst(){
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        list.addFirst("Test");
        assertEquals("Test", list.getFirst());
    }

    @Test
    void getLastNull()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        assertThrows(NoSuchElementException.class, () ->
        {
            list.getLast();
        });
    }

    @Test
    void removeFirstNull()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        assertThrows(NoSuchElementException.class, () ->
        {
            list.removeFirst();
        });
    }

    @Test
    void removeFirst()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        list.addFirst("Test");
        list.addFirst("Test2");
        assertEquals("Test", list.getFirst());
    }

    @Test
    void isEmpty()
    {
    }

    @Test
    void print()
    {
    }

    @Test
    void size()
    {
    }

    @Test
    void contains()
    {
    }
}