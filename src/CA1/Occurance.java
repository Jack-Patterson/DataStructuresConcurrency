package CA1;

import java.io.File;
import java.util.*;

public class Occurance
{
    private File file;
    private List<Integer> lineNumbers; // What implementation would you use for this?

    public Occurance(File file, List<Integer> lineNumbers)
    {
        this.file = file;
        this.lineNumbers = lineNumbers;
    }

    public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public List<Integer> getLineNumbers()
    {
        return lineNumbers;
    }

    public void setLineNumbers(List<Integer> lineNumbers)
    {
        this.lineNumbers = lineNumbers;
    }

    @Override
    public String toString()
    {
        return "File: " + file + " Line Numbers: " + lineNumbers.toString();
    }


}
