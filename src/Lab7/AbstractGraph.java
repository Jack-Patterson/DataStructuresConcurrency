package Lab7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstractGraph implements Graph {
    private int numVertices;
    private boolean directed;
       
    public AbstractGraph(int nV, boolean direct){
        numVertices = nV;
        directed = direct;      
    }

    public int getNumVertices() {
        return numVertices;
    }

    public boolean isDirected() {
        return directed;
    }


}
