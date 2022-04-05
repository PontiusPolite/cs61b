package gitlet;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static gitlet.Utils.*;

/**
 * Created by Carson Crow on 4/5/2022
 *
 * A Blob allows us to store both a file name and its contents into a serializable object.
 */
public class Blob implements Serializable {

    private final String fileName;
    private final String fileContents;
    private final String ID;

    public Blob(String name, String contents) {
        fileName = name;
        fileContents = contents;
        ID = generateID();
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileContents() {
        return fileContents;
    }

    public String getID() {
        return ID;
    }

    public void saveBlob() {
        File f = join(Repository.BLOBS_DIR, this.ID);
        writeObject(f, this);
    }

    /** Generates this Blob's ID by hashing the file name and contents. */
    private String generateID() {
        List<Object> hashBrowns = new ArrayList<>();
        hashBrowns.add(fileName);
        hashBrowns.add(fileContents);
        return sha1(hashBrowns);
    }
}
