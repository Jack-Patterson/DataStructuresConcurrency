package Lab7;

import java.util.*;

public class ListGraph extends AbstractGraph {
    private ArrayList<LinkedList<Integer>> listGraph;

    public ListGraph(int nV, boolean direct) {
        super(nV, direct);
        listGraph = new ArrayList<>(nV);
        for (int i = 0; i < nV; i++) {
            listGraph.add(new LinkedList<>());
        }
    }

    public boolean isEdge(int source, int dest) {
        return listGraph.get(source).contains(dest);
    }

    public void addEdge(int s, int d) {
        if (s < 0 || s > getNumVertices() - 1 || d < 0 || d > getNumVertices() - 1)
            throw new IllegalArgumentException();

        listGraph.get(s).add(d);

        if (!isDirected()) {
            listGraph.get(d).add(s);
        }
    }

    public void removeEdge(int s, int d) {
        if (s < 0 || s > getNumVertices() - 1 || d < 0 || d > getNumVertices() - 1)
            throw new IllegalArgumentException();

        listGraph.get(s).removeFirstOccurrence(d);

        if (!isDirected()) {
            listGraph.get(d).removeFirstOccurrence(s);
        }
    }

    public void bfs(int start) {
        enum states {notVisited, visited, waiting}
        states[] visited = new states[getNumVertices()];
        Arrays.fill(visited, states.notVisited);
        visited[start] = states.waiting;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);

        int visit;
        while (!queue.isEmpty()) {
            int queueItem = queue.poll();
            System.out.print(queueItem + " ");
            visited[queueItem] = states.visited;

            for (int i = 0; i < listGraph.get(queueItem).size(); i++) {
                visit = listGraph.get(queueItem).get(i);

                if (visited[visit] == states.notVisited){
                    visited[visit] = states.waiting;
                    queue.add(visit);
                }
            }

        }
    }

}
