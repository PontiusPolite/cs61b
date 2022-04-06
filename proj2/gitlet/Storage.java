package gitlet;

import java.io.File;

import static gitlet.Utils.*;

/**
 * Created by Carson Crow on 4/6/2022
 *
 * Utility class responsible for storing, retrieving, and deleting blobs and commits from
 * the .gitlet/objects directory.
 *
 * When a commit/blob is saved, it is stored in a directory identified by the first
 * two characters of its ID (and thus filename).
 *
 */
class Storage {

    /** Stores the given Commit as a file in the objects directory, returns false if the file
     * already exists.
     */
    static boolean storeCommit(Commit c) {
        String dir_shortcut = c.getID().substring(0, 2);
        File dir_map = join(Repository.OBJECTS_DIR, dir_shortcut);
        if (!dir_map.exists()) {
            dir_map.mkdir();
        }
        File f = join(dir_map, c.getID());
        if (f.exists()) {
            return false;
        }
        writeObject(f, c);
        return true;
    }
    /** Stores the given Blob as a file in the objects directory, returns false if the file
     * already exists.
     */
    static boolean storeBlob(Blob b) {
        String dir_shortcut = b.getID().substring(0, 2);
        File dir_map = join(Repository.OBJECTS_DIR, dir_shortcut);
        if (!dir_map.exists()) {
            dir_map.mkdir();
        }
        File f = join(dir_map, b.getID());
        if (f.exists()) {
            return false;
        }
        writeObject(f, b);
        return true;
    }

    static boolean exists(String ID) {
        String dir_shortcut = ID.substring(0, 2);
        File f = join(Repository.OBJECTS_DIR, dir_shortcut, ID);
        if (f.exists()) {
            return true;
        }
        return false;
    }

    /** Returns the specified commit from storage. Throws an error if no such commit exists. */
    static Commit retrieveCommit(String ID) {
        String dir_shortcut = ID.substring(0, 2);
        File f = join(Repository.OBJECTS_DIR, dir_shortcut, ID);
        if (!f.exists()) {
            throw new IllegalArgumentException("No object with given ID exists: " + ID);
        }
        return readObject(f, Commit.class);
    }

    static Blob retrieveBlob(String ID) {
        String dir_shortcut = ID.substring(0, 2);
        File f = join(Repository.OBJECTS_DIR, dir_shortcut, ID);
        if (!f.exists()) {
            throw new IllegalArgumentException("No object with given ID exists: " + ID);
        }
        return readObject(f, Blob.class);
    }

}
