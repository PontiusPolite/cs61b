package byow.Core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carson Crow on 9/16/2022
 */
public class WeightedGraph<T> implements Graph<T>{

    // An array of all vertices in the graph.
    private T[] vertices;
    // An adjacency list representing all edges in the graph.
    private Map<T, List<T>> edges;

    public WeightedGraph(int numVertices) {
        //vertices = new T[numVertices];
        edges = new HashMap<T, List<T>>();
    }


    /**
     * Creates an edge between v and w.
     *
     * @param v
     * @param w
     */
    @Override
    public void addEdge(T v, T w) {

    }

    @Override
    public Iterable<T> adj(T v) {
        return null;
    }

    @Override
    public int V() {
        return 0;
    }

    @Override
    public int E() {
        return 0;
    }
}
