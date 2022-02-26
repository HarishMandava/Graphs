package unionFind;

public class UnionFind {

    int[] set;

    public UnionFind(int size) {
        set = new int[size];
        for (int i = 0; i < size; i++) {
            set[i] = i;
        }
    }

    public void union(int u, int v) {
        int rootU = set[u];
        int rootV = set[v];
        if(rootU != rootV) {
            for (int i = 0; i < set.length; i++) {
                if (set[i] == rootV) {
                    set[i] = rootU;
                }
            }
        }
    }

    public boolean find(int u, int v) {
        if(u >= set.length || v >= set.length) {
            return false;
        }
        return  set[u] == set[v];
    }
}
