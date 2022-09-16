package byow.Core;

/**
 * Created by Carson Crow on 9/16/2022
 */
public interface Graph<T> {

    /** Creates an edge between v and w. */
    public void addEdge(T v, T w);

    public Iterable<T> adj(T v);

    public int V();

    public int E();

}
