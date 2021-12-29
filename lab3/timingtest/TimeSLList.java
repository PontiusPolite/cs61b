package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> test_sizes = new AList<>();
        AList<Integer> op_counts = new AList<>();
        for (int i = 0; i < 8; i += 1) {
            test_sizes.addLast((int) Math.pow(2, i) * 1000);
            op_counts.addLast(10000);
        }
        // Time the creation of lists with our test sizes
        AList<Double> test_times = new AList<>();

        for (int j = 0; j < test_sizes.size(); j += 1) {
            SLList<Integer> current_list = new SLList<>();
            for (int i = 0; i < test_sizes.get(j); i += 1) {
                current_list.addLast(i);
            }
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < op_counts.get(0); i += 1) {
                current_list.getLast();
            }
            double t = sw.elapsedTime();
            test_times.addLast(t);
        }

        printTimingTable(test_sizes, test_times, op_counts);
    }

}
