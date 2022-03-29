package gitlet;

import java.io.File;
import static gitlet.Utils.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carson Crow on 3/29/2022
 *
 * A Branches object keeps track of the repo's branches as well as its HEAD pointer in a persistent
 * file located at .gitlet/branches.
 */


public class Branches implements Serializable {

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The location of our persistent branches file. */
    public static final File BRANCHES_FILE = join(CWD, ".gitlet", "branches");

    /** A reference to our current HEAD commit. */
    public String HEAD;
    /** A map between branch names and Commit hashes. */
    private Map<String, String> branches;

    /** Creates a Pointers instance with only one branch (master) that
     * points at the initial commit of the repo.
     * @param initialCommit The commit created when repo is initialized
     */
    public Branches(String initialCommit) {
        branches = new HashMap<>();
        branches.put("master", initialCommit);
        HEAD = initialCommit;
    }

    /** Returns a Branches object read from the contents of BRANCHES_FILE. */
    public static Branches readBranches() {
        if (!BRANCHES_FILE.exists()) {
            throw error("Cannot read branches, no branches file exists in .gitlet.");
        }
        return readObject(join(BRANCHES_FILE, "pointers"), Branches.class);
    }

    /** Saves the Branches object to BRANCHES_FILE. */
    public void saveBranches() {
        File f = BRANCHES_FILE;
        writeObject(f, this);
    }

    /** Returns the commit ID that is pointed to by branch. */
    public String getCommit(String branch) {
        return branches.get(branch);
    }

    /** Deletes the given branch and returns the commit ID it points to. */
    public String deleteBranch(String branch) {
        return branches.remove(branch);
    }

    /** Adds the given branch pointing to the given commit ID. */
    public void addBranch(String branch, String commit) {
        branches.put(branch, commit);
    }
}
