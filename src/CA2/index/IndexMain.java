package CA2.index;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexMain {
    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, "Hit return to continue");//To give time for VisualVM to open

        InvertedIndex index = new InvertedIndex();

        File f = new File("Files");
        List<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));

        index.buildIndex(files);
        
        index.print();  //output index
        long sTime =System.currentTimeMillis();
        index.searchAllWords();
        long eTime =System.currentTimeMillis();
        long duration = eTime-sTime;
        System.out.println("Time: " + duration);
    }
}
