package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author Carson Crow
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter a command.");
            return;
        }
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: handle the `init` command
                if (!validateNumberOfArgs(args, 1)){
                    return;
                }
                Repository.initRepo();

                break;
            case "add":
                // TODO: handle the `add [filename]` command
                break;
            case "commit":
                // TODO
                break;
            case "rm":
                // TODO
                break;
            case "log":
                // TODO
                break;
            case "global-log":
                // TODO
                break;
            case "find":
                // TODO
                break;
            case "status":
                // TODO
                break;
            case "checkout":
                // TODO
                break;
            case "branch":
                // TODO
                break;
            case "rm-branch":
                // TODO
                break;
            case "reset":
                // TODO
                break;
            case "merge":
                // TODO
                break;
            default:
                System.out.println("No command with that name exists.");
                break;
        }
    }

    /**
     * Checks the number of input arguments with the expected number, and returns false and prints
     * message if they are not equal.
     *
     * @param args Input arguments from command line
     * @param n Expected number of arguments
     * @return A boolean that is false if the validation fails
     */
    private static boolean validateNumberOfArgs(String[] args, int n) {
        if (args.length != n) {
            System.out.println("Incorrect operands.");
            return false;
        }
        return true;
    }

}
