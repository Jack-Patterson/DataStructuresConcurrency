package Lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest
{
    @Test
    void isEmptyTest(){
        BinarySearchTree<String> bstNotEmpty = new BinarySearchTree<>();
        bstNotEmpty.insertRecur("January");

        assertFalse(bstNotEmpty.isEmpty());
        assertTrue(new BinarySearchTree<>().isEmpty());
    }

    @Test
    void containsIterTest()
    {
        // Test Empty
        assertFalse(new BinarySearchTree<>().containsIter("Test"));

        BinarySearchTree<String> bstIterCont = new BinarySearchTree<>();
        bstIterCont.insertIterative("January");
        bstIterCont.insertIterative("February");
        bstIterCont.insertIterative("March");
        bstIterCont.insertIterative("April");
        bstIterCont.insertIterative("May");
        bstIterCont.insertIterative("June");
        bstIterCont.insertIterative("July");
        bstIterCont.insertIterative("August");

        // Test First Value
        assertTrue(bstIterCont.containsIter("January"));

        // Test Right Value
        assertTrue(bstIterCont.containsIter("June"));

        // Test Left Value
        assertTrue(bstIterCont.containsIter("August"));

        // Test value not in it
        assertFalse(bstIterCont.containsIter("December"));
    }

    @Test
    void containsRecurTest()
    {
        // Test Empty
        assertFalse(new BinarySearchTree<>().containsIter("Test"));

        BinarySearchTree<String> bstRecurCont = new BinarySearchTree<>();
        bstRecurCont.insertRecur("January");
        bstRecurCont.insertRecur("February");
        bstRecurCont.insertRecur("March");
        bstRecurCont.insertRecur("April");
        bstRecurCont.insertRecur("May");
        bstRecurCont.insertRecur("June");
        bstRecurCont.insertRecur("July");
        bstRecurCont.insertRecur("August");

        // Test First Value
        assertTrue(bstRecurCont.containsRecur("January"));

        // Test Right Value
        assertTrue(bstRecurCont.containsRecur("June"));

        // Test Left Value
        assertTrue(bstRecurCont.containsRecur("August"));

        // Test value not in it
        assertFalse(bstRecurCont.containsRecur("December"));
    }
}