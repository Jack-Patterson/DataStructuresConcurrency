package CA2.index;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvertedIndexTest
{

    // Test Passed
    @Test
    void searchAND()
    {
        InvertedIndex index = new InvertedIndex();

        File f = new File("Files");
        List<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));

        index.buildIndex(files);

        ArrayList<File> filesOutcome = new ArrayList<>();

        // Returns null
        assertEquals(filesOutcome, index.searchAND("Hi", "Hello"));

        filesOutcome.add(new File("Files\\File2.txt"));
        filesOutcome.add(new File("Files\\File3.txt"));

        // Both having files
        assertEquals(filesOutcome, index.searchAND("Deciduous", "Evergreen"));

        // Right having files
        filesOutcome.remove(0);
        assertEquals(filesOutcome, index.searchAND("Hi", "Evergreen"));

        // Left having files
        filesOutcome.remove(0);
        filesOutcome.add(new File("Files\\File2.txt"));
        assertEquals(filesOutcome, index.searchAND("Deciduous", "Hello"));

        // Files with multiple outputs
        filesOutcome = new ArrayList<>();

        filesOutcome.add(new File("Files\\File1.txt"));
        filesOutcome.add(new File("Files\\File2.txt"));
        filesOutcome.add(new File("Files\\File3.txt"));

        assertEquals(filesOutcome, index.searchAND("oak", "Trees"));
    }
}