import java.util.Random;

public class PercolationStarts {
    private final double[] ArrResult;
    private final int num;

    public PercolationStarts(int N, int T) {
        ArrResult = new double[T];
        num = T;
        final Random randomGenerator = new Random();
        for (int k = 0; k < T; k++) {
            final Percolation p = new Percolation(N);
            int count = 0;
            double prob = 0;
            while (!p.percolates()) {
                int i = 1 + randomGenerator.nextInt(N);
                int j = 1 + randomGenerator.nextInt(N);
                if (!p.isOpen(i, j)) {
                    p.open(i, j);
                    // StdOut.printf(" | T= " + k + "  i  =" + i + " j= " + j + "\n");
                    // StdOut.print(k + "\n");
                    // StdOut.printf(" | T= %s  i = %s  j = %s\n", k, i, j);
                    // StdOut.println(k);
                    count++;
                }
            }
            prob = (double) count/(N*N);
            StdOut.println(prob);
            ArrResult[k] = prob;
        }
    }

    public double mean() {
        return StdStats.mean(ArrResult);
    }

    public double stddev() {

        return StdStats.stddev(ArrResult);
    }

    public double confidenceLo() {

        return mean() - ((1.96 * stddev()) / Math.sqrt(num));
    }

    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(num));
    }

    public static void main(String[] args) {
        final int N = 100;
        final int T = 50;
        final PercolationStarts ps = new PercolationStarts(N, T);
        StdOut.printf("mean                = %s\n", ps.mean());
        StdOut.printf("stddev              = %s\n", ps.stddev());
        StdOut.printf("conf interval       = %s, %s\n", ps.confidenceLo(), ps.confidenceHi());
    }
}
