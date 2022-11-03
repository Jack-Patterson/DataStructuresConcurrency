package CA1;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest<E extends Comparable>
{

    @Test
    void keySet()
    {
        BinarySearchTreeMap<Integer, String> bstm1 = new BinarySearchTreeMap<>();
        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            bstm1.put(i, "test " + i);
            testData.add(i);
        }

        keySetSub((Set<E>) bstm1.keySet(), (ArrayList<E>) testData); // Have to cast it to make it work

        BinarySearchTreeMap<String, String> bstm2 = new BinarySearchTreeMap<>();
        ArrayList<String> testData2 = new ArrayList<>();

        bstm2.put("fizz", "buzz");
        bstm2.put("buzz", "fizz");
        bstm2.put("buzzy", "fizz");
        bstm2.put("fizzy", "fizz");
        bstm2.put("buzziest", "fizz");
        bstm2.put("fizzyest", "fizz");

        testData2.add("buzziest"); // Flipped due to the tree
        testData2.add("fizzyest");
        testData2.add("fizzy");
        testData2.add("buzzy");
        testData2.add("fizz");
        testData2.add("buzz");

        keySetSub((Set<E>) bstm2.keySet(), (ArrayList<E>) testData2);
    }

    private void keySetSub(Set<E> keys, ArrayList<E> testAgainstData){
        int i = 0;

        for (E key : keys)
        {
            assertEquals(key, testAgainstData.get(i));
            i++;
        }
    }
}