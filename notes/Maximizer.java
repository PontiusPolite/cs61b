public class Maximizer {
    public static OurComparable max(OurComparable[] items) {
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }

    public static void main(String[] args) {
        ComparableDog[] dogs = {new ComparableDog("Ted", 3),
                new ComparableDog("Luna", 9),
                new ComparableDog("Porl", 15)};
        //ComparableDog maxDog = ComparableDog max(dogs);
        //maxDog.bark();
    }
}
