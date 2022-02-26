package unionFind;

public class Main {

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.find(1, 5)); // true
        System.out.println(uf.find(5, 7)); // true
        System.out.println(uf.find(4, 9)); // false
        System.out.println();
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.find(4, 9)); // true
    }
}
