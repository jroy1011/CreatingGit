import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class CodingGitTester {
    public static void main(String[] args) {
        //CodingGit.InitializeRepo();
    //    CodingGit.createGitFolder();
    //    CodingGit.createObjectsFolder();
    //     CodingGit.createIndexFile();
    //      CodingGit.createHEADFile();

    // Stretch challenge 1: 
    // check if stuff exists
    String gitlocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git";
    Path PathGitLocation = Paths.get(gitlocation);
    if (Files.notExists(PathGitLocation)) {
        System.out.println("git folder does not exist!");
    }

    String objectsLocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\objects";
    Path PathObjLoc = Paths.get(objectsLocation);
    if (Files.notExists(PathObjLoc)) {
        System.out.println("objects folder does not exist!");
    }

    String indexLocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\index";
    Path PathIndexLoc = Paths.get(indexLocation);
    if (Files.notExists(PathIndexLoc)) {
        System.out.println("index file does not exist!");
    }

    String HEADlocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\HEAD";
    Path PathHEADLoc = Paths.get(HEADlocation);
    if (Files.notExists(PathHEADLoc)) {
        System.out.println("HEAD file does not exist!");
    }
    // implement remove methods
    // to-do: is it okay if these methods are in the CodingGit class?
    for (int i = 0; i < 4; i++) {
        CodingGit.RemoveStuff();
        if (Files.notExists(PathGitLocation)) {
            System.out.println("git folder does not exist!");
        }
         if (Files.notExists(PathObjLoc)) {
        System.out.println("objects folder does not exist!");
    }
        if (Files.notExists(PathIndexLoc)) {
            System.out.println("index file does not exist!");
        }
        if (Files.notExists(PathHEADLoc)) {
            System.out.println("HEAD file does not exist!");
        }
        CodingGit.InitializeRepo();
    }
    if (Files.notExists(PathGitLocation)) {
        System.out.println("git folder does not exist!");
    }
    if (Files.notExists(PathObjLoc)) {
        System.out.println("objects folder does not exist!");
    }
    if (Files.notExists(PathIndexLoc)) {
        System.out.println("index file does not exist!");
    }
     if (Files.notExists(PathHEADLoc)) {
        System.out.println("HEAD file does not exist!");
    }
    // testing SHA1 hash method 
    String fileLOC = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\testOfSHA1Hash.txt";
    Path pathOfFile = Paths.get(fileLOC);
    System.out.println(CodingGit.generateSHA1Hash(pathOfFile));

    }
}
