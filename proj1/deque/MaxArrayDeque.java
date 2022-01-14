package deque;

import java.util.Comparator;

/**
 * Created by Carson Crow on 1/14/2022
 */
public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> comp;
    public MaxArrayDeque(Comparator<T> c) {
        comp = c;
    }

    /** Returns the maximum item as governed by this.comparator. */
    public T max() {
        if (this.isEmpty()) {
            return null;
        }
        T max = this.get(0);
        for (int i = 0; i < this.size(); i += 1) {
            T current = this.get(i);
            if (comp.compare(current, max) > 0) {
                max = current;
            }
        }
        return max;
    }

    /** Returns the maximum item as governed by the input comparator. */
    public T max(Comparator<T> c) {
        if (this.isEmpty()) {
            return null;
        }
        T max = this.get(0);
        for (int i = 0; i < this.size(); i += 1) {
            T current = this.get(i);
            if (c.compare(current, max) > 0) {
                max = current;
            }
        }
        return max;
    }
}
