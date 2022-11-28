package CA2.index;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeMapTest
{

    // Passed
    @Test
    void size()
    {
        BinarySearchTreeMap<String, String> bstMap = new BinarySearchTreeMap();

        // 0 inputs
        assertEquals(0, bstMap.size());

        bstMap.put("Jack", "0871231231");
        bstMap.put("Jill", "0877654321");
        bstMap.put("Bob", "0871234567");
        bstMap.put("Rob", "0851212121");

        // 4 inputs
        assertEquals(4, bstMap.size());


    }
}