package CA2.graph;

import java.util.List;

public interface Graph {
    //returns the number of vertices
    int getNumVertices(); 
    
    // determine if this is a directed graph
    boolean isDirected(); 
    
   // determine if an edge exists between source and destination
    boolean isEdge(int source, int dest);
    
    void addEdge(int s, int d);
    
    void removeEdge(int s, int d);

    List<Integer> bfs(int startVertex);

    List<Integer> dfs(int startVertex);
}