import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SavedFile {
    
    private String type;
    private String sha1;
    private String path;
    private File f;
   
    
    //Initializes StoreTrees obj which can basically represent the working index
    public SavedFile(File f) throws IOException {
        path = f.getPath();
        type = "";
        this.f = f;
        if (!f.isDirectory()) {
            type = "blob";
            sha1 = CodingGit.generateSHA1Hash(Paths.get(path));
        } else {
            type = "tree";
            File index = new File("git/index");
            if (!index.exists()) {
                index.createNewFile();
            }
            sha1 = CodingGit.treeFileToObjHelper(f);
        }
    }

    public SavedFile(File f, String sha1) throws IOException {
        path = f.getPath();
        type = "";
        this.f = f;
        this.sha1 = sha1;
        if (!f.isDirectory()) {
            type = "blob";
        } else {
            type = "tree";
        }
    }

    public File getFile() {
        return f;
    }

    public void setFile(File f) {
        this.f = f;
    } 

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    


    
    
}
