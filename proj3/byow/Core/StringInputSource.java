package byow.Core;

/**
 * Created by Carson Crow on 9/2/2022
 *
 * A class for handling string inputs given to the program from the command line arguments.
 */
public class StringInputSource implements InputSource{
    private int index;
    private String input;

    public StringInputSource(String s) {
        this.index = 0;
        this.input = s;
    }

    /**
     * Returns the next character in the user's input string (command line argument), converted to
     * lower case.
     */
    @Override
    public char next() {
        char c = input.charAt(index);
        index += 1;
        return Character.toLowerCase(c);
    }

    @Override
    public String nextAsString() {
        String c = "" + input.charAt(index);
        index += 1;
        return c.toLowerCase();
    }

    /**
     * Returns true if there exists another character in the user's input string.
     */
    @Override
    public boolean hasNext() {
        return (index < input.length());
    }
}
