import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;
import java.security.*;

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
        // second create an objects folder inside git folder
        boolean didItWork = false;

        String newLocation = "git/objects";
        String StringFinalLocation = newLocation;
        Path finalPathDestination = Paths.get(StringFinalLocation);

        try {
            Files.createDirectory(finalPathDestination);
        } catch (IOException e) {
            System.out.println("Git Repository Already Exists.");
            // e.printStackTrace();
            return false;

        }
        didItWork = true;
        return didItWork;
    }

    public static boolean createIndexFile() {
        //// Thrid creates index file called index in git folder
        boolean didItWork = false;
        String indexFileName = "git/index";
        String data = "";

        // String FinalFilesStringPathSource = "git/index";
        // Path FinalFilesPathSource = Paths.get(FinalFilesStringPathSource);

        // String FilesLocation = "git/index";
        // Path FinalFilesPathDestination = Paths.get(FilesLocation);

        try {
            Files.write(Paths.get(indexFileName), data.getBytes(StandardCharsets.UTF_8));
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

        String FinalHeadStringPathSource = "HEAD";
        Path FinalHeadPathSource = Paths.get(FinalHeadStringPathSource);

        String HeadLocation = "git/HEAD";
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
        String HEADlocation = "git/HEAD";
        Path PathHEADLoc = Paths.get(HEADlocation);
        try {
            Files.delete(PathHEADLoc);
        } catch (IOException e) {

        }
    }

    public static void RemoveIndexFile() {
        // removes Index file
        String indexLocation = "git/index";
        Path PathIndexLoc = Paths.get(indexLocation);
        try {
            Files.delete(PathIndexLoc);
        } catch (IOException e) {

        }

    }

    public static void RemoveObjFolder() {
        // removes Object folder
        String objectsLocation = "git/objects";
        Path PathObjLoc = Paths.get(objectsLocation);
        try {
            Files.delete(PathObjLoc);
        } catch (IOException e) {

        }
    }

    public static void RemoveGitFolder() {
        // removes Git folder
        String gitlocation = "git";
        Path PathGitLocation = Paths.get(gitlocation);
        try {
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
        try {
            // first convert all of file's content into bytes and put bytes into an array
            byte[] bytesOfFile = Files.readAllBytes(file);
            // second hash all bytes
            MessageDigest SHA1 = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = SHA1.digest(bytesOfFile); // hashes all the bytes and puts each part of hash into one
                                                           // index of array
            // third convert hash into hexadecimal
            // using helper method
            String hexadecimalOfHash = hexademcialOfHash(hashedBytes);
            return hexadecimalOfHash;
        } catch (IOException e) {
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

    public static Path createBLOB(Path file) throws IOException {
        // calculate SHA1 Hash of file & create a new file in the objects folder with
        // the hash as its filename ad the content of that file
        String fileName = generateSHA1Hash(file);
        // SYDNEY ADDING CODE TO FIX BUGS WITH THEISS' PERMISSION
        File hash = new File("git/objects/" + fileName);
        if (hash.exists()) {
            return Paths.get(hash.getPath());
        }
        Path sourcePath = Paths.get("./" + file); // Replace with your source file path
        Path destinationPath = Paths.get(fileName + ""); // Replace with your desired new file path
        // Copy the file, replacing if the destination exists
        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

        String ogLocOfFile = fileName;
        Path PathOgLocOFFile = Paths.get(ogLocOfFile);

        String DestinOfFile = "git/objects/" + fileName;
        Path PathDestinOfFile = Paths.get(DestinOfFile);

        try {
            Files.move(PathOgLocOFFile, PathDestinOfFile);
            Files.copy(file, PathDestinOfFile, StandardCopyOption.REPLACE_EXISTING); // copy method should copy content
                                                                                     // // of file at PathOGLocOFFile
            updateIndexFile(file);
            Files.delete(PathOgLocOFFile); // deletes File created in first line
        } catch (IOException e) {
            System.out.println(e);
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
        String nameOfFile = filePath.toString();
        String hashOfFile = generateSHA1Hash(filePath);
        String location = "git/index";
        String data = "";
        try {
            if (Files.size(Paths.get(location)) == 0) {
                data = hashOfFile + " " + nameOfFile;
            } else {
                data = "\n" + hashOfFile + " " + nameOfFile;
            }
            Files.write(Paths.get(location), data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // for stretch GP 2.4.2:
    public static ArrayList<Path> AllJavaFilesInObj() {
        // first, reading all files name in Objects folder using Files.list() method and
        // Stream class
        // putting all content into an array list
        Path objectsFolder = Paths.get("git/objects");
        ArrayList<Path> fileLocations = new ArrayList<Path>();
        try {
            Stream<Path> filesInsideObjFolder = Files.list(objectsFolder);
            filesInsideObjFolder.forEach(line -> {
                fileLocations.add(line);
            });
            filesInsideObjFolder.close();
            // return fileLocations;
        } catch (IOException e) {
            System.out.println(e);
        }
        return fileLocations;
    }

    public static void removeAllIndexContent() {
        String indexFileLoc = "git/index";
        try {
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

    public static SavedFile[] fileArray(File root) throws IOException {
        if (root.exists() && root.isDirectory()) {
            File[] files = root.listFiles();
            SavedFile[] savedFiles = new SavedFile[files.length];
            for (int i = 0; i < files.length; i++) {
                savedFiles[i] = new SavedFile(files[i]);
            }
            return savedFiles;
        } else {
            return null;
        }
    }

    // public static SavedFile[] fileArray(File index) throws IOException {
    // String filePath = index + "";
    // BufferedReader reader = new BufferedReader(new FileReader(filePath));
    // Stream<String> lines = Files.lines(Paths.get(filePath));
    // int lineCount = (int) lines.count();
    // lines.close();
    // SavedFile[] savedFiles = new SavedFile[lineCount];
    // String line;
    // int i = 0;
    // while ((line = reader.readLine()) != null) {
    // String sha1 = line.substring(0, 40);
    // String path = line.substring(41);
    // File f = new File(path);
    // savedFiles[i] = new SavedFile(f, sha1);
    // }
    // reader.close();
    // return savedFiles;
    // }

    // returns sha1 of directory being sotred;
    public static String treeFileToObj(File index) throws IOException {
        File f = new File("temp");
        File root = makeIndexTree(index);
        String data = "";
        if (!f.exists()) {
            f.createNewFile();
        }
        int lineCount = 0;
        SavedFile[] fileArray = fileArray(root);
        if (root.isDirectory()) {
            String filePath = f + "";
            FileWriter writer = new FileWriter(filePath, true);
            for (int i = 0; i < fileArray.length; i++) {
                if (lineCount == 0) {
                    // KEY EXPLANATION: This method is recursive
                    // "fileArray[i].getSha1()" calls the getSha1() a method in the SavedFile class
                    // which will actually call back THIS METHOD if the current file is a tree. So
                    // it stores that inner folder automatically and gets the sha1 for thatfolder
                    data = fileArray[i].getType() + " " + fileArray[i].getSha1()
                            + " " + fileArray[i].getFile().getName();
                } else {
                    data = "\n" + fileArray[i].getType() + " " + fileArray[i].getSha1() + " "
                            + fileArray[i].getFile().getName();
                }
                writer.append(data);
                lineCount++;
            }
            writer.close();
        }
        String sha1 = generateSHA1Hash(f.toPath());
        File blob = new File("./git/objects/" + sha1);
        if (!blob.exists()) {
            blob.createNewFile();
        }
        Path sourcePath = Paths.get(f + ""); // Replace with your source file path
        Path destinationPath = Paths.get(blob + ""); // Replace with your desired new file path
        // Copy the file, replacing if the destination exists
        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        f.delete();
        return sha1;
    }

    // public static String treeFileToObj(File index) throws IOException {
    // File f = new File("temp");
    // // File root = makeIndexTree(index);
    // String data = "";
    // if (!f.exists()) {
    // f.createNewFile();
    // }
    // int lineCount = 0;
    // SavedFile[] fileArray = fileArray(index);

    // String filePath = f + "";
    // FileWriter writer = new FileWriter(filePath, true);
    // for (int i = 0; i < fileArray.length; i++) {
    // // KEY EXPLANATION: This method is recursive
    // // "fileArray[i].getSha1()" calls the getSha1() a method in the SavedFile
    // class
    // // which will actually call back THIS METHOD if the current file is a tree.
    // So
    // // it stores that inner folder automatically and gets the sha1 for that
    // folder
    // if (lineCount == 0) {
    // data = fileArray[i].getType() + " " + fileArray[i].getSha1()
    // + " " + fileArray[i].getFile().getName();
    // } else {
    // data = "\n" + fileArray[i].getType() + " " + fileArray[i].getSha1() + " "
    // + fileArray[i].getFile().getName();
    // }
    // writer.append(data);
    // lineCount++;
    // }
    // writer.close();

    // String sha1 = generateSHA1Hash(f.toPath());
    // File blob = new File("./git/objects/" + sha1);
    // if (!blob.exists()) {
    // blob.createNewFile();
    // }
    // Path sourcePath = Paths.get(f + ""); // Replace with your source file path
    // Path destinationPath = Paths.get(blob + ""); // Replace with your desired new
    // file path
    // // Copy the file, replacing if the destination exists
    // Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    // f.delete();
    // return sha1;
    // }

    public static File makeIndexTree(File index) throws IOException {
        File root = new File("root");
        if (!root.exists()) {
            root.mkdir();
        }
        String filePath = "git/index";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String sha1 = line.substring(0, 40);
            String path = line.substring(41);
            int slashInd = path.indexOf("/");
            String above = root.toString();
            while (slashInd > -1) {
                File folder = new File(above + "/" + path.substring(0, slashInd));
                if (!folder.exists()) {
                    folder.mkdir();
                }
                String newPath = path.substring(slashInd + 1);
                slashInd = newPath.indexOf("/");
                above = folder.getPath().toString();
            }
            File f = new File(root + "/" + path);
            if (!f.exists()) {
                f.createNewFile();
            }
            Path sourcePath = Paths.get("git/objects/" + sha1);
            Path destinationPath = Paths.get(f + "");
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

        }
        reader.close();
        return root;
    }

}