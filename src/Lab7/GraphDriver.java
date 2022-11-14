package Lab7;

public class GraphDriver
{
    public static void main(String[] args)
    {
        /*Graph graph = new ListGraph(8, true);
        graph.addEdge(0,1);
        System.out.println(graph.isEdge(0,1));
        System.out.println(graph.isEdge(1,0));*/

        Graph graph = new ListGraph(5, true);
        graph.addEdge(0,3);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,4);

        //System.out.println(graph.isEdge(0,4)); System.out.println(graph.isEdge(0,3)); System.out.println(graph.isEdge(3,0));

        /*graph = new ListGraph(5, false);
        graph.addEdge(0,3);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,4);

        //System.out.println(graph.isEdge(0,4)); System.out.println(graph.isEdge(3,0)); System.out.println(graph.isEdge(0,3));

        graph.bfs(0);*/

        graph = new ListGraph(6, true);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);

        System.out.println("BFS ListGraph: ");

        graph.bfs(0);

        graph = new MatrixGraph(6, true);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);

        System.out.println("\nBFS MatrixGraph: ");

        graph.bfs(0);
    }
}
