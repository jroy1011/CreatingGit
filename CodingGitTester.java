import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class CodingGitTester {
    public static void main(String[] args) {
        CodingGit.InitializeRepo();
        // //    CodingGit.createGitFolder();
        // //    CodingGit.createObjectsFolder();
        // //     CodingGit.createIndexFile();
        // //      CodingGit.createHEADFile();

        // // // Stretch challenge 1: 
        // // // check if stuff exists
        // // String gitlocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git";
        // // Path PathGitLocation = Paths.get(gitlocation);
        // // if (Files.notExists(PathGitLocation)) {
        // //     System.out.println("git folder does not exist!");
        // // }

        // // String objectsLocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\objects";
        // // Path PathObjLoc = Paths.get(objectsLocation);
        // // if (Files.notExists(PathObjLoc)) {
        // //     System.out.println("objects folder does not exist!");
        // // }

        // // String indexLocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\index";
        // // Path PathIndexLoc = Paths.get(indexLocation);
        // // if (Files.notExists(PathIndexLoc)) {
        // //     System.out.println("index file does not exist!");
        // // }

        // // String HEADlocation = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\git\\HEAD";
        // // Path PathHEADLoc = Paths.get(HEADlocation);
        // // if (Files.notExists(PathHEADLoc)) {
        // //     System.out.println("HEAD file does not exist!");
        // // }

        // // // implement remove methods

        // // for (int i = 0; i < 4; i++) {
        // //     CodingGit.RemoveStuff();
        // //     if (Files.notExists(PathGitLocation)) {
        // //         System.out.println("git folder does not exist!");
        // //     }
        // //      if (Files.notExists(PathObjLoc)) {
        // //     System.out.println("objects folder does not exist!");
        // // }
        // //     if (Files.notExists(PathIndexLoc)) {
        // //         System.out.println("index file does not exist!");
        // //     }
        // //     if (Files.notExists(PathHEADLoc)) {
        // //         System.out.println("HEAD file does not exist!");
        // //     }
        // //     CodingGit.InitializeRepo();
        // // }
        // // if (Files.notExists(PathGitLocation)) {
        // //     System.out.println("git folder does not exist!");
        // // }
        // // if (Files.notExists(PathObjLoc)) {
        // //     System.out.println("objects folder does not exist!");
        // // }
        // // if (Files.notExists(PathIndexLoc)) {
        // //     System.out.println("index file does not exist!");
        // // }
        // //  if (Files.notExists(PathHEADLoc)) {
        // //     System.out.println("HEAD file does not exist!");
        // // }

        // // // testing SHA1 hash method 
        // // String fileLOC = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\SampleTest1.txt";
        // // Path pathOfFile = Paths.get(fileLOC);
        // // System.out.println(CodingGit.generateSHA1Hash(pathOfFile));

        // // // testing CreateBlob 
        // //CodingGit.createBLOB(pathOfFile);

        // // // Stretch challenges GP - 2.3.1
        // // // progrmatically confirm that BLOB file exists in Objects folder 

        // // Path BlobFilePath = CodingGit.createBLOB(pathOfFile);
        // // if (Files.notExists(BlobFilePath)) {
        // //     System.out.println("Blob file is NOT in objects folder");
        // // }
        // // //Implement a method to reset the files used in your tester to repeatedly test again.
        // // CodingGit.removeBLOB(BlobFilePath);
        // // if (Files.notExists(BlobFilePath)) {
        // //     System.out.println("Blob file is NOT in objects folder");
        // // }

        // // // repeatedly testing 
        // // for (int i = 0; i < 3; i++) {
        // //     CodingGit.createBLOB(pathOfFile);
        // //     if (Files.notExists(BlobFilePath)) {
        // //         System.out.println("Blob file is NOT in objects folder");
        // //     }
        // //     CodingGit.removeBLOB(BlobFilePath);
        // //     if (Files.notExists(BlobFilePath)) {
        // //         System.out.println("Blob file is NOT in objects folder");
        // //     }
        // // }
        // // System.out.println("Blob file should not be in objects folder:");
        // // if (Files.notExists(BlobFilePath)) {
        // //     System.out.println("Blob file is NOT in objects folder");
        // // }

        // // Stretch challenge 1 for G.P 2.4: creating multiple test files
        // // first, create a set of sample text files with different content 
        // try {
        //     String data = "SampleTest2 content";
        //     Files.write(Paths.get("sampleTest2"), data.getBytes(StandardCharsets.UTF_8));
        //     Path pathOf2 = Paths.get("\\home\\joyar\\HTCS_Projects\\CreatingGit\\sampleTest2");
        //     String data3 = "SampleTest3 content";
        //     Path pathOf3 = Paths.get("\\home\\joyar\\HTCS_Projects\\CreatingGit\\sampleTest3");
        //     Files.write(Paths.get("sampleTest3"), data3.getBytes(StandardCharsets.UTF_8));
        //     String data4 = "SampleTest4 content";
        //     Path pathOf4 = Paths.get("\\home\\joyar\\HTCS_Projects\\CreatingGit\\sampleTest4");
        //     Files.write(Paths.get("sampleTest4"), data4.getBytes(StandardCharsets.UTF_8));
        //     // second, add enteries to the index file for each file... Create Blob
        //     CodingGit.createBLOB(pathOf2);
        //     CodingGit.createBLOB(pathOf3);
        //     CodingGit.createBLOB(pathOf4);
        // } catch (IOException e) {
        // }

        // // third, check if the index entries using the sha1 generator website  match the hash name

        // // for stretch GP 2.4.2
        // CodingGit.removeObjFiles();

        // if (Files.notExists(PathObjLoc)) {
        //     System.out.println("objects folder does not exist!");
        // }
        // if (Files.notExists(PathIndexLoc)) {
        //     System.out.println("index file does not exist!");
        // }
        // if (Files.notExists(PathHEADLoc)) {
        //     System.out.println("HEAD file does not exist!");
        // }
        // CodingGit.InitializeRepo();
        // if (Files.notExists(PathGitLocation))

        // {
        //     System.out.println("git folder does not exist!");
        // }
        // if (Files.notExists(PathObjLoc)) {
        //     System.out.println("objects folder does not exist!");
        // }
        // if (Files.notExists(PathIndexLoc)) {
        //     System.out.println("index file does not exist!");
        // }
        // if (Files.notExists(PathHEADLoc)) {
        //     System.out.println("HEAD file does not exist!");
        // }
        // // testing SHA1 hash method 
        // String fileLOC = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\testOfSHA1Hash.txt";
        // Path pathOfFile = Paths.get(fileLOC);
        // System.out.println(CodingGit.generateSHA1Hash(pathOfFile));
        // // testing CreateBlob 
        // //CodingGit.createBLOB(pathOfFile);
        // // Stretch challenges GP - 2.3.1
        // // progrmatically confirm that BLOB file exists in Objects folder 
        // Path BlobFilePath = CodingGit.createBLOB(pathOfFile);
        // if (Files.notExists(BlobFilePath)) {
        //     System.out.println("Blob file is NOT in objects folder");
        // }
        // //Implement a method to reset the files used in your tester to repeatedly test again.
        // CodingGit.removeBLOB(BlobFilePath);
        // if (Files.notExists(BlobFilePath)) {
        //     System.out.println("Blob file is NOT in objects folder");
        // }
        // // repeatedly testing 
        // for (int i = 0; i < 3; i++) {
        //     CodingGit.createBLOB(pathOfFile);
        //     if (Files.notExists(BlobFilePath)) {
        //         System.out.println("Blob file is NOT in objects folder");
        //     }
        //     CodingGit.removeBLOB(BlobFilePath);
        //     if (Files.notExists(BlobFilePath)) {
        //         System.out.println("Blob file is NOT in objects folder");
        //     }
        // }
        // System.out.println("Blob file should not be in objects folder:");
        // if (Files.notExists(BlobFilePath)) {
        //     System.out.println("Blob file is NOT in objects folder");
        // }

        // tesing 9.26 
        CodingGit.removeObjFiles();
        try{
        File abc = new File("sampleTest2.txt");
        abc.createNewFile();
        String SampleTest2Loc = "sampleTest2.txt";
        Path SampleTest2Path = Paths.get(SampleTest2Loc);
        CodingGit.createBLOB(SampleTest2Path);
        }catch (IOException e) {
            System.out.println(e);

    }
        // String SampleTest3 = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\sampleTest3.txt";
        // Path SampleTest3Path = Paths.get(SampleTest3);
        // CodingGit.createBLOB(SampleTest3Path);
        // String SampleTest4 = "\\home\\joyar\\HTCS_Projects\\CreatingGit\\sampleTest4.txt";
        // Path SampleTest4Path = Paths.get(SampleTest4);
        // CodingGit.createBLOB(SampleTest4Path);


    }
}
    

