/**
 * Created by Carson Crow on 1/20/2022
 */
public class QuickUnionDS implements DisjointSets{
    private int[] parent;
    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i += 1) {
            parent[i] = -1;
        }
    }

    /** Finds the root. */
    private int find(int p) {
        int r = p;
        while (parent[r] >= 0) {
            r = parent[r];
        }
        return r;
    }

    /**
     * Connects two items P and Q.
     */
    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        parent[i] = j;
    }

    /**
     * Checks to see if two items are connected.
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
