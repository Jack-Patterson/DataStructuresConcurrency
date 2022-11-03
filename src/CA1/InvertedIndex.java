package CA1;

import java.io.File;
import java.io.IOException;
import java.util.*;

/*
 * Class to build an index.
 */
public class InvertedIndex {
    // Properties
    //private BinarySearchTreeMap<String, List<Occurance>> index;
    private Map<String, List<Occurance>> index;

    private Set<String> allWords;  //set of all unique words in the index
    //used in profiling the search method
    int lineNo = -1;

    // Methods
    public InvertedIndex() {
        //index = new BinarySearchTreeMap<>();
        index = new HashMap<>(); // Use HashMap in a separate run

        allWords = new HashSet<>();
    }

    public void buildIndex(List<File> files) {
        for (File file : files) {
            try {

                List<Integer> lineNoList = new ArrayList<>();

                Scanner in = new Scanner(file);

                String line;
                String[] words;

                while (in.hasNextLine()) {
                    lineNo++;
                    //read a line
                    line = in.nextLine();
                    // parse line into words
                    // the character pattern that separates words is any sequence of
                    // characters other than letters, numbers and apostrophe
                    // This strips off punctuation marks
                    words = line.split("[^A-Za-z0-9']+");

                    //add words and filename to index
                    for (String word : words) {
                        if (!word.equals("")) {
                            if (!index.containsKey(word)) {
                                List<Occurance> list = new ArrayList<>();
                                lineNoList.add(lineNo);
                                list.add(new Occurance(file, lineNoList));
                                index.put(word, list);
                                allWords.add(word);
                            } else {
                                // word already in index - check if fileName there
                                List<Occurance> list = index.get(word);

                                ArrayList<File> filesList = new ArrayList<>();
                                for (Occurance o: list){
                                    filesList.add(o.getFile());
                                }
                                if (!filesList.contains(file)) {
                                    lineNoList.add(lineNo);
                                    list.add(new Occurance(file, lineNoList));
                                }
                            }
                        }
                    }
                }
                lineNo = -1;
            } catch (IOException exc) {
                System.out.println("File does not exist");
                exc.printStackTrace();
                System.exit(1);
            }
        }
    }

    public void print() {
        // Print all keys and values in the map
        Set<String> keySet = index.keySet();
        for (String key : keySet) {
            List<Occurance> value = index.get(key);
            System.out.println(key + " : " + value);
        }
        //System.out.println("\nMap Height: " + index.height());
        //System.out.println("\nSize: " + index.size());
    }

    public List<Occurance> search(String s) {
        List<Occurance> keyOccur = new ArrayList<>();
        for (Occurance o: index.get(s)){
            keyOccur.add(o);
        }
        return keyOccur;
    }

    //method to profile search: call search method with all words in inverted index 
    public void searchAllWords() {
        int reps = 1000; // increase this if necessary
        for (int i = 1; i < reps; i++)

            for (String s : allWords) {
                search(s);
            }
    }
}