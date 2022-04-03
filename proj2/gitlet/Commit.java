package gitlet;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static gitlet.Utils.*;
import static gitlet.Utils.readObject;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String message;

    /** The date and time this Commit was created. */
    private Date timestamp;

    /** The parent of this Commit, null if this is the initial Commit. */
    private Commit parent;

    /** A mapping of filenames and blobs that the commit points to. */
    private Map<String, Blob> blobs;

    private String ID;

    /** Creates a new commit with no parent and the init message. */
    public Commit() {
        parent = null;
        timestamp = new Date(0);
        message = "initial commit";
        blobs = new HashMap<>();
        // TODO: make ID the sha1 hash of everything
        ID = "test-commit-please-ignore";
    }

    /** Creates a new commit with the specified parent and message. */
    public Commit(Commit parent, String message) {
        this.parent = parent;
        timestamp = new Date(0);
        this.message = message;
        blobs = new HashMap<>();
        // TODO: make ID the sha1 hash of everything
        ID = "another-test-commit";
    }

    /** Returns the sha1 hash that will serve as this Commit's ID. */
    public String getID() {
        return ID;
    }

    public void saveCommit() {
        File new_commit = join(Repository.COMMITS_DIR, this.ID);
        writeObject(new_commit, this);
    }

    public static Commit readCommitFromFile(String commitID) {
        if (!join(Repository.COMMITS_DIR, commitID).exists()) {
            throw error("Cannot read commit, no such commitID in .gitlet/commits");
        }
        return readObject(join(Repository.COMMITS_DIR, commitID), Commit.class);
    }

    public String toString() {
        return "commit " + this.ID + "\n" +
                "Date: " + this.timestamp + "\n" +
                this.message;
    }


}
