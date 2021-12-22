import java.util.Comparator;

/**
 * Created by Carson Crow on 12/22/2021
 * Used for showcasing polymorphism with OurComparable interface.
 */
public class ComparableDog implements Comparable<ComparableDog>{
    private String name;
    private int size;

    public ComparableDog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    /** Returns negative if this dog is less than o (and so forth) */
    public int compareTo(ComparableDog uddaDog) {
        return this.size - uddaDog.size;
    }

    /** A Comparator that compares ComparableDog names */
    private static class NameComparator implements Comparator<ComparableDog> {
        public int compare(ComparableDog a, ComparableDog b) {
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<ComparableDog> getNameComparator() {
        return new NameComparator();
    }


}


