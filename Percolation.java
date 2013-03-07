public class Percolation {
    private final boolean[] sites;
    private final int size;
    private WeightedQuickUnionUF uf;


    public Percolation(int N) {
        uf = new WeightedQuickUnionUF(N * N);
        sites = new boolean[N * N];
        size = N;
        for (int i = 0; i < N * N; i++) {
            sites[i] = false;
        }
    }

    private int getIdx(final int i, final int j) {
        if (i < 1 || i > size || j < 1 || j > size) {
            throw new IndexOutOfBoundsException();
        }
        final int idx = size * (i - 1) + (j - 1);
        return idx;
    }

    public void open(int i, int j) {
        if (i < 1 || i > size || j < 1 || j > size) {
           throw new IndexOutOfBoundsException();
        }
        final int idx = getIdx(i, j);
        if (!sites[idx]) {
            sites[idx] = true;
            if (i - 2 >= 0) {
                int idx1 = size * (i - 2) + (j - 1);
                if (sites[idx1]) {
                    uf.union(idx, idx1);
                }
            }
            if (i + 1 <= size) {
                int idx2 = size * (i) + (j - 1);
                if (sites[idx2]) {
                    uf.union(idx, idx2);
                }
            }
            if (j - 2 >= 0) {
                int idx3 = size * (i - 1) + (j - 2);
                if (sites[idx3]) {
                    uf.union(idx, idx3);
                }
            }
            if (j + 1 <= size) {
                int idx4 = size * (i - 1) + (j);
                if (sites[idx4]) {
                    uf.union(idx, idx4);
                }
            }
        }
    }

    public boolean isOpen(int i, int j) {

        return sites[getIdx(i, j)];
    }

    public boolean isFull(int i, int j) {
        if (i < 1 || i > size || j < 1 || j > size) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 1 && !isOpen(i, j)) {
            return false;
        }
        for (int q = 0; q < size; q++) {
            if (uf.connected(getIdx(i, j), q)) {
                return true;
            }
        }
        return false;
    }

    public boolean percolates() {
        int i = size;
        for (int j = 1; j <= size; j++) {
            if (isFull(i, j)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final Percolation p = new Percolation(4);
        p.open(1, 1);
        p.open(1, 2);

        StdOut.println(p.isOpen(1, 2));
        StdOut.println(p.isOpen(1, 3));
        StdOut.println("Hello world");
        try {
            p.open(0, 10);
        } catch (final IndexOutOfBoundsException e) {
            StdOut.println("Get an exception");
            StdOut.println(e);
        }
        StdOut.println("No hello world");
    }
}
