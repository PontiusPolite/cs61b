public class AListSpeedTest {
    public static void main(String[] args) {
        AList<Integer> a = new AList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            a.addLast(1);
        }
        System.out.println("Done");
    }
}
