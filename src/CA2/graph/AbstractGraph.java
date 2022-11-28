package CA2.graph;

import java.util.List;

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

    public List<Integer> bfs (int startVertex){ return null; }

    public List<Integer> dfs (int startVertex){ return null; }
}
