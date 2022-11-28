package CA2.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatrixGraphTest
{
    Graph graph;
    @BeforeEach
    void createGraph(){
        graph = new MatrixGraph(7, true);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(3,6);
        graph.addEdge(1,6);
        graph.addEdge(1,4);
        graph.addEdge(4,5);
    }

    // Test failed as there is no completed bfs method
    @Test
    void bfs(){
        List<Integer> bfsOut = new ArrayList<>();

        bfsOut.add(1);
        bfsOut.add(2);
        bfsOut.add(3);
        bfsOut.add(4);
        bfsOut.add(6);
        bfsOut.add(5);

        assertEquals(bfsOut, graph.bfs(0));
    }

    // Test failed as there is no completed dfs method
    @Test
    void dfs(){
        List<Integer> dfsOut = new ArrayList<>();

        dfsOut.add(0);
            dfsOut.add(1);
                dfsOut.add(4);
                    dfsOut.add(5);
                dfsOut.add(6);
            dfsOut.add(2);
            dfsOut.add(3);

        assertEquals(dfsOut, graph.dfs(0));
    }
}