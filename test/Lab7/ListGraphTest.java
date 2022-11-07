package Lab7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListGraphTest
{
    private Graph graphDirected;
    private Graph graphUndirected;

    @BeforeEach
    void instantiateVariables(){
        graphDirected = new ListGraph(5, true);
        graphUndirected = new ListGraph(5, false);
    }

    @Test
    void isEdge()
    {
        // Directed
        assertFalse(graphDirected.isEdge(0,1));

        graphDirected.addEdge(0,1);
        assertTrue(graphDirected.isEdge(0,1));
        assertFalse(graphDirected.isEdge(1,0));

        // Undirected
        assertFalse(graphUndirected.isEdge(0,1));

        graphUndirected.addEdge(0,1);
        assertTrue(graphUndirected.isEdge(0,1));
        assertTrue(graphUndirected.isEdge(1,0));
    }

    @Test
    void addEdge()
    {
        // Directed
        graphDirected.addEdge(1,2);
        assertTrue(graphDirected.isEdge(1,2));
        assertFalse(graphDirected.isEdge(2,1));

        assertThrows(IllegalArgumentException.class, () -> graphDirected.addEdge(-1,0));
        assertThrows(IllegalArgumentException.class, () -> graphDirected.addEdge(1,10));

        // Undirected
        graphUndirected.addEdge(1,2);
        assertTrue(graphUndirected.isEdge(1,2));
        assertTrue(graphUndirected.isEdge(2,1));

        assertThrows(IllegalArgumentException.class, () -> graphUndirected.addEdge(-1,0));
        assertThrows(IllegalArgumentException.class, () -> graphUndirected.addEdge(1,10));
    }

    @Test
    void removeEdge(){
        // Directed
        graphDirected.addEdge(1,2);
        graphDirected.removeEdge(1,2);
        assertFalse(graphDirected.isEdge(1,2));
        assertFalse(graphDirected.isEdge(2,1));

        assertThrows(IllegalArgumentException.class, () -> graphDirected.removeEdge(-1,0));
        assertThrows(IllegalArgumentException.class, () -> graphDirected.removeEdge(1,10));

        // Undirected
        graphUndirected.addEdge(1,2);
        graphUndirected.removeEdge(1,2);
        assertFalse(graphUndirected.isEdge(1,2));
        assertFalse(graphUndirected.isEdge(2,1));

        assertThrows(IllegalArgumentException.class, () -> graphUndirected.removeEdge(-1,0));
        assertThrows(IllegalArgumentException.class, () -> graphUndirected.removeEdge(1,10));
    }
}