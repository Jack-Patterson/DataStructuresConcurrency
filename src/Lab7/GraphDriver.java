package Lab7;

public class GraphDriver
{
    public static void main(String[] args)
    {
        Graph graph = new ListGraph(8, true);
        graph.addEdge(0,1);
        System.out.println(graph.isEdge(0,1));
        System.out.println(graph.isEdge(1,0));
    }
}
