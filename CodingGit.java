import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class CodingGit {
    // first create InitalizeRepo method 
    public static void InitializeRepo() {

        if (createGitFolder() == true) {
            if (createObjectsFolder() == true) {
                if (createIndexFile() == true) {
                    if (createHEADFile() == true) {
                        System.out.println("Git Repository Created");
                    }
                }
            }
        }        
        //// first, create a folder called git 
        // String GitdirectoryName = "git";
        // Path GitPathDirName = Paths.get(GitdirectoryName);
        // try {
        //     Files.createDirectory(GitPathDirName);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        //// second create an objects folder inside git folder 
        // Path pathSource = Paths.get("").toAbsolutePath();
        // String pathSourceString = pathSource.toString() + "\\objects";
        // Path finalPathSource = Paths.get(pathSourceString);

        // String newLocation = "\\git\\objects";
        // String StringFinalLocation = pathSource.toString() + newLocation;
        // Path finalPathDestination = Paths.get(StringFinalLocation);

        // String ObjectsDirectoryName = "objects";
        // Path ObjectPathDirName = Paths.get(ObjectsDirectoryName);
        // try{
        //     Files.createDirectory(ObjectPathDirName);
        //     Files.move(finalPathSource, finalPathDestination);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        //// Thrid creates index file called index in git folder
        // String indexFileName = "index";
        // String data = "";

        // String FilesPathSource = Paths.get("").toAbsolutePath().toString();
        // String FinalFilesStringPathSource = FilesPathSource  + "\\index";
        // Path FinalFilesPathSource = Paths.get(FinalFilesStringPathSource);

        // String FilesLocation = FilesPathSource + "\\git\\index";
        // Path FinalFilesPathDestination = Paths.get(FilesLocation);

        //  try {
        //      Files.write(Paths.get(indexFileName), data.getBytes(StandardCharsets.UTF_8));
        //      Files.move(FinalFilesPathSource, FinalFilesPathDestination);
        //  } catch (IOException e) {
        //      e.printStackTrace();
        //  }

        //// Fourth creates HEAD file in git folder 
        // String headFileName = "HEAD";

        // String HeadPathSource = Paths.get("").toAbsolutePath().toString();
        // String FinalHeadStringPathSource = HeadPathSource + "\\HEAD";
        // Path FinalHeadPathSource = Paths.get(FinalHeadStringPathSource);

        // String HeadLocation = HeadPathSource + "\\git\\HEAD";
        // Path FinalHeadPathDestination = Paths.get(HeadLocation);

        // try{
        //     Files.write(Paths.get(headFileName), data.getBytes(StandardCharsets.UTF_8));
        //     Files.move(FinalHeadPathSource, FinalHeadPathDestination);
        //     System.out.println("Hello");
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
    
    public static boolean createGitFolder() {
        // first, create a folder called git 
        boolean didItWork = false;
        String GitdirectoryName = "git";
        Path GitPathDirName = Paths.get(GitdirectoryName);
        try {
            Files.createDirectory(GitPathDirName);
        } catch (IOException e) {
            System.out.println("Git Repository Already Exists.");
           // e.printStackTrace();
            return false;
        }
        didItWork = true;
        return didItWork;
    }

    public static boolean createObjectsFolder() {
        //// second create an objects folder inside git folder
        boolean didItWork = false;
        Path pathSource = Paths.get("").toAbsolutePath();
        String pathSourceString = pathSource.toString() + "\\objects";
        Path finalPathSource = Paths.get(pathSourceString);

        String newLocation = "\\git\\objects";
        String StringFinalLocation = pathSource.toString() + newLocation;
        Path finalPathDestination = Paths.get(StringFinalLocation);

        String ObjectsDirectoryName = "objects";
        Path ObjectPathDirName = Paths.get(ObjectsDirectoryName);
        try {
            Files.createDirectory(ObjectPathDirName);
            Files.move(finalPathSource, finalPathDestination);
        } catch (IOException e) {
            System.out.println("Git Repository Already Exists.");
            //e.printStackTrace();
            return false;
            
        }
        didItWork = true;
        return didItWork;
    }
    
    public static boolean  createIndexFile() {
        //// Thrid creates index file called index in git folder 
         boolean didItWork = false;
        String indexFileName = "index";
        String data = "";

        String FilesPathSource = Paths.get("").toAbsolutePath().toString();
        String FinalFilesStringPathSource = FilesPathSource + "\\index";
        Path FinalFilesPathSource = Paths.get(FinalFilesStringPathSource);

        String FilesLocation = FilesPathSource + "\\git\\index";
        Path FinalFilesPathDestination = Paths.get(FilesLocation);

        try {
            Files.write(Paths.get(indexFileName), data.getBytes(StandardCharsets.UTF_8));
            Files.move(FinalFilesPathSource, FinalFilesPathDestination);
        } catch (IOException e) {
            System.out.println("Git Repository Already Exists.");
           // e.printStackTrace();
            return false;
        }
        didItWork = true;
        return didItWork;
    }
    
    public static boolean createHEADFile() {
        //// Fourth creates HEAD file in git folder 
        boolean didItWork = false;
        String headFileName = "HEAD";
        String data = "";

        String HeadPathSource = Paths.get("").toAbsolutePath().toString();
        String FinalHeadStringPathSource = HeadPathSource + "\\HEAD";
        Path FinalHeadPathSource = Paths.get(FinalHeadStringPathSource);

        String HeadLocation = HeadPathSource + "\\git\\HEAD";
        Path FinalHeadPathDestination = Paths.get(HeadLocation);

        try {
            Files.write(Paths.get(headFileName), data.getBytes(StandardCharsets.UTF_8));
            Files.move(FinalHeadPathSource, FinalHeadPathDestination);
        } catch (IOException e) {
            System.out.println("Git Repository Already Exists.");
            // e.printStackTrace();
            return false;
        }
        didItWork = true;
        return didItWork;
    }
    
    public static void RemoveHeadFile() {
        // removes HEAD file 
        String HEADlocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\HEAD";
        Path PathHEADLoc = Paths.get(HEADlocation);
        try{
            Files.delete(PathHEADLoc);
        }catch  (IOException e){

        }
    }
    
    public static void RemoveIndexFile() {
        // removes Index file 
        String indexLocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\index";
        Path PathIndexLoc = Paths.get(indexLocation);
        try{
             Files.delete(PathIndexLoc);
         } catch (IOException e) {
            
        }
       
    }
    
    public static void RemoveObjFolder() {
        // removes Object folder
        String objectsLocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\objects";
        Path PathObjLoc = Paths.get(objectsLocation);
        try{
        Files.delete(PathObjLoc);
    } catch (IOException e) {
            
        }
    }

    public static void RemoveGitFolder() {
        // removes Git folder
        String gitlocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git";
        Path PathGitLocation = Paths.get(gitlocation);
        try{
        Files.delete(PathGitLocation);
    } catch (IOException e) {
            
        }
    }
    
    public static void RemoveStuff() {
        CodingGit.RemoveHeadFile();
        CodingGit.RemoveIndexFile();
        CodingGit.RemoveObjFolder();
        CodingGit.RemoveGitFolder();
    }

    public static String generateSHA1Hash(Path file) {
        try{
        // first convert all of file's content into bytes and put bytes into an array 
        byte[] bytesOfFile = Files.readAllBytes(file);
        // second hash all bytes 
        MessageDigest SHA1 =  MessageDigest.getInstance("SHA-1");
        byte[] hashedBytes = SHA1.digest(bytesOfFile); // hashes all the bytes and puts each part of hash into one index of array 
        // third convert hash into hexadecimal 
        //using helper method
        String hexadecimalOfHash = hexademcialOfHash(hashedBytes);
         return hexadecimalOfHash;
    }   
    catch (IOException e) {
        return "error encountered";
            
    } catch (NoSuchAlgorithmException e) {
        return "error encountered";
    }

    }

    public static String hexademcialOfHash(byte[] byteArray) {
        StringBuilder hexOfHash = new StringBuilder();
        for (byte b : byteArray) {
            hexOfHash.append(String.format("%02x", b));
        }
        return hexOfHash.toString();

    }
}