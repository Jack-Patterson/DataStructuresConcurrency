package Lab7;

import java.util.*;

public class MatrixGraph extends AbstractGraph {
    //entries in matrix are 1.0 or 0.0
    //1.0 indicates an edge.
    //0.0 indicates no edge
    
    private double[][] matrix;
    
    public MatrixGraph(int nV, boolean direct){
        super(nV, direct);
        matrix = new double[nV][nV];
        for (int row = 0; row < nV; row++)
            for (int col = 0; col < nV; col++)
                    matrix[row][col] = 0.0;        
    }

    public boolean isEdge(int source, int dest) {
        return matrix[source][dest] == 1;
    }

    public void addEdge(int s, int d) {
        if (s < 0 || s > getNumVertices() - 1 || d < 0 || d > getNumVertices() - 1) throw new IllegalArgumentException();
        matrix[s][d] = 1.0;

        if (!isDirected()){
            matrix[d][s] = 1.0;
        }
    }

    public void removeEdge(int s, int d) {
        if (s < 0 || s > getNumVertices() - 1 || d < 0 || d > getNumVertices() - 1) throw new IllegalArgumentException();
        matrix[s][d] = 0.0;

        if (!isDirected()){
            matrix[d][s] = 0.0;
        }
    }

    @Override
    public void bfs(int start) {
        enum states {notVisited, visited, waiting}
        states[] visited = new states[getNumVertices()];
        Arrays.fill(visited, states.notVisited);
        visited[start] = states.waiting;

        List<Integer> q = new LinkedList<>();
        q.add(start);

        int vis;
        while (!q.isEmpty())
        {
            vis = q.get(0);

            System.out.print(vis + " ");
            q.remove(q.get(0));

            for(int i = 0; i < getNumVertices(); i++)
            {
                if (matrix[vis][i] == 1 && visited[i] == states.notVisited)
                {

                    q.add(i);

                    visited[i] = states.waiting;
                }
            }
        }
    }
}
