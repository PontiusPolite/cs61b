package gh2;

import deque.ArrayDeque;
import deque.Deque;

//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    private Deque<Double> buffer;

    /** Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {

        buffer = new ArrayDeque<>();
        int capacity = (int) (Math.round(SR / frequency));
        for (int i = 0; i < capacity; i += 1) {
            buffer.addLast(0.0);
        }
    }


    /** Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {

        int capacity = buffer.size();
        buffer = new ArrayDeque<>();

        for (int i = 0; i < capacity; i += 1) {
            buffer.addLast(Math.random() - 0.5); // guitar
            //double value = Math.abs((1.0 / capacity) - 0.5);
            //buffer.addLast(value);
        }
    }

    /** Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {

        double new_double = buffer.removeFirst();
        new_double = (new_double + buffer.get(0)) / 2.0 * DECAY;
        buffer.addLast(new_double);
    }

    /** Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}
