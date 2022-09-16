package byow.Core;

/**
 * Created by Carson Crow on 9/2/2022
 *
 * An interface for handling various input sources (usually a keyboard input or command
 * line string).
 */
public interface InputSource {
    /** Returns the next character from the implemented input source. */
    public char next();

    /** Returns the next character as a String from the implemented input source. */
    public String nextAsString();

    /** Returns true if there exists another character from the implemented input source. */
    public boolean hasNext();
}
