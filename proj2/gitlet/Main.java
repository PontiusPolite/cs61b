package gitlet;

import static gitlet.Utils.*;

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
                if (validateNumberOfArgs(args, 1)){
                    Repository.initRepo();
                }
                break;
            case "add":
                if (validateNumberOfArgs(args, 2)){
                    Repository.stageFileForAddition(args[1]);
                }
                break;
            case "commit":
                if (validateNumberOfArgs(args, 2)){
                    Repository.commitStagedFiles(args[1]);
                }
                break;
            case "rm":
                if (validateNumberOfArgs(args, 2)) {
                    Repository.stageFileForRemoval(args[1]);
                }
                break;
            case "log":
                if (validateNumberOfArgs(args, 1)) {
                    Repository.printHeadLog();
                }
                break;
            case "global-log":
                if (validateNumberOfArgs(args, 1)) {
                    Repository.printGlobalLog();
                }
                break;
            case "find":
                if (validateNumberOfArgs(args, 2)) {
                    Repository.printCommitsWithMessage(args[1]);
                }
                break;
            case "status":
                if (validateNumberOfArgs(args, 1)) {
                    Repository.printStatus();
                }
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
     * Checks that the number of args equals expected; if not, prints a message
     * and returns false.
     */
    private static boolean validateNumberOfArgs(String[] args, int expected) {
        if (args.length != expected) {
            message("Incorrect operands.");
            return false;
        }
        return true;
    }

    /**
     * Checks that the number of args is between min and max (inclusive); if not, prints a message
     * and returns false.
     */
    private static boolean validateNumberOfArgs(String[] args, int min, int max) {
        if (args.length < min || args.length > max) {
            message("Incorrect operands.");
            return false;
        }
        return true;
    }

}
