package CA1;

import javax.swing.*;
import java.io.File;
import java.util.*;

public class IndexMain {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hit return to continue");

        InvertedIndex index = new InvertedIndex();

        String projPath =  System.getProperty("user.dir") + "\\Files"; // gets the project directory and adds on the files folder
        File f = new File(projPath);
        List<File> files = new ArrayList<>(Arrays.asList(f.listFiles()));

        index.buildIndex(files);
        
        index.print();  //output index
        System.out.println();
        long sTime =System.currentTimeMillis();
        index.searchAllWords();
        long eTime =System.currentTimeMillis();
        long duration = eTime-sTime;
        System.out.println("Time: " + duration);

    }
}
