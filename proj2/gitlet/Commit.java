package gitlet;

import java.io.File;
import java.io.Serializable;
import java.util.*;

import static gitlet.Utils.*;

/** Represents a gitlet commit object. Once created, the commit data cannot be changed.
 *
 *  @author Carson Crow
 */
public class Commit implements Serializable {

    /** The message of this Commit. */
    private final String message;

    /** The date and time this Commit was created. */
    private final Date timestamp;

    /** The parent IDs of this Commit, where the ID at index 0 is the historical parent, or an
     * empty ArrayList if this is the initial Commit. */
    private final List<String> parents;

    /** An array of blob IDs that this commit points to. */
    private final List<String> blobs;

    /** The 40 character sha1 hash of this Commit's data. */
    private final String ID;

    /** Creates a new commit with no parent and the init message. */
    public Commit() {
        parents = new ArrayList<>();
        timestamp = new Date(0);
        message = "initial commit";
        blobs = new ArrayList<>();
        ID = generateID();
    }

    public List<String> getParents() {
        return parents;
    }

    /** Creates a new commit with the specified parent and message. */
    public Commit(String parent, String message, List<String> blobs) {
        parents = new ArrayList<>();
        parents.add(parent);
        timestamp = new Date();
        this.message = message;
        this.blobs = blobs;
        ID = generateID();
    }

    /** Creates a new commit with multiple parents. */
    public Commit(List<String> parents, String message, List<String> blobs) {
        this.parents = parents;
        timestamp = new Date();
        this.message = message;
        this.blobs = blobs;
        ID = generateID();
    }

    /** Generates this Commit's ID by hashing its attribute values. */
    private String generateID() {
        List<Object> hashBrowns = new ArrayList<>(parents);
        hashBrowns.add(timestamp.toString());
        hashBrowns.add(message);
        hashBrowns.addAll(blobs);
        return sha1(hashBrowns);
    }

    /** Returns this Commit's ID. */
    public String getID() {
        return ID;
    }

    public List<String> getBlobs() {
        return blobs;
    }
    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void saveCommit() {
        File f = join(Repository.COMMITS_DIR, this.ID);
        writeObject(f, this);
    }

    public String toString() {
        String result = "===" + "\n" + "commit " + ID + "\n";
        if (parents.size() > 1) {
            result += "Merge:";
            for (String p : parents) {
                result += " " + p.substring(0, 7);
            }
        }
        result += "Date: " + timestamp + "\n" + message + "\n";
        return result;
    }


}
