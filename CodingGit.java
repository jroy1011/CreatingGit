import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.*;


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
        System.out.println(e);
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

    public static Path createBLOB(Path file) {
        // calculate SHA1 Hash of file & create a new file in the objects folder with the hash as its filename ad the content of that file 
        String fileName = generateSHA1Hash(file);
        String data = "";

        String ogLocOfFile = Paths.get("").toAbsolutePath().toString() + "\\" + fileName;
        Path PathOgLocOFFile = Paths.get(ogLocOfFile);

        String DestinOfFile = Paths.get("").toAbsolutePath().toString() + "\\git\\objects\\" + fileName;
        Path PathDestinOfFile = Paths.get(DestinOfFile);

        try {
            Files.write(Paths.get(fileName), data.getBytes(StandardCharsets.UTF_8));
            Files.move(PathOgLocOFFile, PathDestinOfFile);
            Files.copy(file, PathDestinOfFile, StandardCopyOption.REPLACE_EXISTING); // copy method should copy content of file at PathOGLocOFFile
            updateIndexFile(file);
            Files.delete(PathOgLocOFFile); // deletes File created in first line
        } catch (IOException e) {
            //System.out.println(e);
        }
        return PathDestinOfFile;
    }

    public static void removeBLOB(Path BlobLOC) {
        try {
            Files.delete(BlobLOC);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static void updateIndexFile(Path filePath) {
        String nameOfFile = filePath.getFileName().toString();
        String hashOfFile = generateSHA1Hash(filePath);
        String indexFileLoc = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\index";
        String data = "";
        try {
            if (Files.size(Paths.get(indexFileLoc)) == 0) {
                // data = hashOfFile + " " + nameOfFile;
                data = hashOfFile + " " + filePath.toString();
            } else {
                //data = "\n" + hashOfFile + " " + nameOfFile;
                data = "\n" + hashOfFile + " " + filePath.toString();
            }
            Files.write(Paths.get(indexFileLoc), data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    // for stretch GP 2.4.2:
    public static ArrayList<Path> AllJavaFilesInObj() {
        // first, reading all files name in Objects folder using Files.list() method and Stream class
        // putting all content into an array list 
        Path objectsFolder = Paths.get("\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\objects");
        ArrayList<Path> fileLocations = new ArrayList<Path>();
        try {
            Stream<Path> filesInsideObjFolder = Files.list(objectsFolder);
            filesInsideObjFolder.forEach(line -> {
                fileLocations.add(line);
            });
            filesInsideObjFolder.close();
            //return fileLocations;
        } catch (IOException e) {
            System.out.println(e);
        }
         return fileLocations;
    }

    public static void removeAllIndexContent() {
        String indexFileLoc = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\index";
        try{
        // first delete index file 
        Files.delete(Paths.get(indexFileLoc));
        // second create a new index file 
        createIndexFile();
    } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void removeObjFiles() {
        ArrayList<Path> filesInObj = CodingGit.AllJavaFilesInObj();
        for (int i = 0; i < filesInObj.size(); i++) {
            removeBLOB(filesInObj.get(i));
        }
        removeAllIndexContent();
    }

}