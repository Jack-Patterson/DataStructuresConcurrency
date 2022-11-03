package CA1;

import org.junit.jupiter.api.*;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvertedIndexTest
{
    @Test
    void search()
    {
        // Reading Files
        JOptionPane.showMessageDialog(null, "Hit return to continue");
        InvertedIndex index = new InvertedIndex();
        String projPath =  System.getProperty("user.dir") + "\\Files"; // gets the project directory and adds on the files folder
        File f = new File(projPath);
        List<File> files = new ArrayList<>(Arrays.asList(f.listFiles()));
        index.buildIndex(files);

        // Actual Test
        String fileEnd = "";
        List<Integer> intCount = new ArrayList<>();

        // Test for 1 element
        intCount.add(0);
        List<Occurance> listOccur = new ArrayList<>();
        fileEnd = "\\File1.txt";
        listOccur.add(new Occurance(new File(projPath + fileEnd), intCount));
        assertEquals(index.search("Ireland").toString(), listOccur.toString());

        // Test for 2/multiple elements
        listOccur = new ArrayList<>();
        intCount = new ArrayList<>();
        intCount.add(0);
        intCount.add(1);
        fileEnd = "\\File1.txt";
        listOccur.add(new Occurance(new File(projPath + fileEnd), intCount));

        intCount = new ArrayList<>();
        intCount.add(0);
        fileEnd = "\\File2.txt";
        listOccur.add(new Occurance(new File(projPath + fileEnd), intCount));

        assertEquals(index.search("oak").toString(), listOccur.toString());

        // Test for a value that doesn't exist
        assertThrows(NullPointerException.class, () ->
        {
            index.search("Irish");
        });

    }
}