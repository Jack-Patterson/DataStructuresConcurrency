package Lab7;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListGraph extends AbstractGraph
{
    private ArrayList<LinkedList<Integer>> listGraph;

    public ListGraph(int nV, boolean direct)
    {
        super(nV, direct);
        listGraph = new ArrayList<>(nV);
        for (int i = 0; i < nV; i++)
        {
            listGraph.add(new LinkedList<>());
        }
    }

    public boolean isEdge(int source, int dest)
    {
        return listGraph.get(source).contains(dest);
    }

    public void addEdge(int s, int d)
    {
        if (s < 0 || s > getNumVertices() - 1 || d < 0 || d > getNumVertices() - 1)
            throw new IllegalArgumentException();

        listGraph.get(s).add(d);

        if (!isDirected())
        {
            listGraph.get(d).add(s);
        }
    }

    public void removeEdge(int s, int d)
    {
        if (s < 0 || s > getNumVertices() - 1 || d < 0 || d > getNumVertices() - 1)
            throw new IllegalArgumentException();

        listGraph.get(s).remove(listGraph.get(s).indexOf(d));

        if (!isDirected())
        {
            listGraph.get(d).remove(listGraph.get(d).indexOf(s));
        }
    }
}
