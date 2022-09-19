package Lab2;

import org.junit.jupiter.api.*;
import java.util.*;
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
        list.removeFirst();
        assertEquals("Test", list.getFirst());
    }

    @Test
    void removeFirstTestFirstLastSame()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        list.addFirst("Test");
        assertThrows(NullPointerException.class, () ->
        {
            list.removeFirst();
        });
        assertThrows(NoSuchElementException.class, () ->
        {
            list.getFirst();
        });
    }

    @Test
    void removeLastNull()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        assertThrows(NoSuchElementException.class, () ->
        {
            list.removeLast();
        });
    }

    @Test
    void removeLast()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        list.addLast("Test");
        list.addLast("Test2");
        list.removeLast();
        assertEquals("Test", list.getLast());
    }

    @Test
    void removeLastTestFirstLastSame()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        list.addLast("Test");
        assertThrows(NullPointerException.class, () ->
        {
            list.removeLast();
        });
        assertThrows(NoSuchElementException.class, () ->
        {
            list.getLast();
        });
    }

    @Test
    void isEmptyTrue()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        assertTrue(list.isEmpty());
    }

    @Test
    void isEmptyFalse()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        list.addFirst("Test");
        assertFalse(list.isEmpty());
    }

    @Test
    void print()
    {

    }

    @Test
    void sizeEmpty()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        assertEquals(0, list.size());
    }

    @Test
    void size()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        list.addFirst("Test");
        assertEquals(1, list.size());
    }

    @Test
    void containsTrue()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        list.addFirst("Test");
        assertTrue(list.contains("Test"));
    }

    @Test
    void containsFalse()
    {
        CP3LinkedList<String> list = new CP3LinkedList<String>();
        list.addFirst("Test");
        assertFalse(list.contains("Test2"));
    }


}