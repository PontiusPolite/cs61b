package gitlet;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author Carson Crow
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    /** The commits folder within .gitlet. */
    public static final File COMMITS_DIR = join(GITLET_DIR, "commits");
    /** The location of our refs directory, which contains file pointers to the branches and HEAD. */
    public static final File REFS_DIR = join(CWD, ".gitlet", "refs");
    /** The location of our blobs directory, which stores the snapshots of our files pointed to by commits,
     *  named by hash. */
    public static final File BLOBS_DIR = join(CWD, ".gitlet", "blobs");
    /** The location of our blobs that are in the staging area, ready to be committed. */
    public static final File STAGE_DIR = join(CWD, ".gitlet", "stage");

    public static void initRepo() {
        if (GITLET_DIR.exists()) {
            message("A Gitlet version-control system already exists in the current directory.");
            return;
        }
        initDirectories();
        Commit initCommit = new Commit();
        initCommit.saveCommit();
        setRef("HEAD", initCommit.getID());
        setRef("master", initCommit.getID());
    }

    /** Helper method to initRepo() that generates necessary directories. */
    private static void initDirectories() {
        GITLET_DIR.mkdir();
        COMMITS_DIR.mkdir();
        REFS_DIR.mkdir();
        BLOBS_DIR.mkdir();
        STAGE_DIR.mkdir();
    }

    /** Adds the specified file in our repository to the staging area .gitlet/stage. */
    public static void stageFile(String fileName) {
        File fileToStage = new File(fileName);
        if (!fileToStage.exists()) {
            message("File does not exist.");
            return;
        }
        createFileWithContents(join(STAGE_DIR, fileName), readContentsAsString(fileToStage));
    }

    /** Moves the files in .gitlet/stage to .gitlet/blobs, and creates a new Commit pointing to these
     * blobs with the given commitMessage.
     */
    public static void commitStagedFiles(String commitMessage) {
        String lastCommitID = getRef("HEAD");
        Commit lastCommit = readCommitFromFile(lastCommitID);
        List<String> stagedFileNames = plainFilenamesIn(STAGE_DIR);
        List<String> newBlobs = new ArrayList<>();
        for (String name : stagedFileNames) {
            newBlobs.add(createBlob(name));
        }
        // Combine new blob IDs to commit with parent blob IDs, don't include duplicates
        for (String parentBlob : lastCommit.getBlobs()) {
            if (!newBlobs.contains(parentBlob)) {
                newBlobs.add(parentBlob);
            }
        }
        //Commit newCommit = new Commit(lastCommitID, )

        /* TODO:
        - create blobs from staged files and move them to blobs folder
        - create a new commit
            - blobs equal to combined parent blobs and new blobs
            - message
            - parent
        - set head pointer
         */
    }

    /** Creates a blob in .gitlet/blobs with the contents of .gitlet/stage/fileName and named by
     * the sha1 hash of the file, removes fileName from .gitlet/stage, and returns the blob name.
     */
    private static String createBlob(String fileName) {
        File stagedFile = join(STAGE_DIR, fileName);
        String blobContents = readContentsAsString(stagedFile);
        String blobName = sha1(blobContents);
        File blob = join(BLOBS_DIR, blobName);
        if (blob.exists()) {
            return blobName;
        }
        createFileWithContents(blob, blobContents);
        return blobName;
    }

    /** Helper method that creates the file f and writes contents to it. */
    private static void createFileWithContents(File f, String contents) {
        try {
            f.createNewFile();
            writeContents(f, contents);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** Returns the commitID contained in .gitlet/refs/fileName. */
    private static String getRef(String fileName) {
        return readContentsAsString(join(REFS_DIR, fileName));
    }

    /** Creates a file at .gitlet/refs/fileName if it doesn't already exist, and sets its
     * contents to be commitID string. */
    private static void setRef(String fileName, String commitID) {
        File f = join(REFS_DIR, fileName);
        if (!f.exists()) {
            try {
                f.createNewFile();
                writeContents(f, commitID);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        writeContents(join(REFS_DIR, fileName), commitID);
    }

    /** Returns the Commit object stored in the file .gitlet/commits/commitID. */
    private static Commit readCommitFromFile(String commitID) {
        if (!join(Repository.COMMITS_DIR, commitID).exists()) {
            throw error("Cannot read commit, no such commitID in .gitlet/commits");
        }
        return readObject(join(Repository.COMMITS_DIR, commitID), Commit.class);
    }

}
