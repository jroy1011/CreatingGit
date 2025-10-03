import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class CodingGitTester {
    public static void main(String[] args) throws IOException {

        CodingGit.InitializeRepo();

        // first, create a set of sample text files with different content
        //The structure is: files 2 and 3 are on their own, then folder stores folder2 and file 5, and folder2 stores file 4
       
        String data = "Hi, welcome to sampleTest2! The dirty secret is: Sydney brought a snack to class today and is eating it under her desk. DO NOT tell Mr. Theiss ;)";
        Files.write(Paths.get("sampleTest2"), data.getBytes(StandardCharsets.UTF_8));
        Path pathOf2 = Paths.get("sampleTest2");
        String data3 = "This is sampleTest3. I'm only a few minutes old, but some things about me: I love dogs, and ice cream, but absolutely hate cats and frozen yogurt.";
        Path pathOf3 = Paths.get("sampleTest3");
        Files.write(Paths.get("sampleTest3"), data3.getBytes(StandardCharsets.UTF_8));
        String data4 = "SampleTest4 content is not as fun as the others";
        String data5 = "SampleTest5 is the best test!! Or at least that's what Sydney thinks who made this tester :)";
       
        
        File folder = new File("folder");
        if (!folder.exists()) {
            folder.mkdir();
        }
        Path folderpath = Paths.get("folder");

        File folder2 = new File("folder/folder2");
        if (!folder2.exists()) {
            folder2.mkdir();
        }
        Path folderpath2 = Paths.get("folder/folder2");
        
        Path pathOf4 = Paths.get("folder/folder2/sampleTest4");
        Files.write(Paths.get("folder/folder2/sampleTest4"), data4.getBytes(StandardCharsets.UTF_8));
        Path pathOf5 = Paths.get("folder/sampleTest5");
        Files.write(Paths.get("folder/sampleTest5"), data5.getBytes(StandardCharsets.UTF_8));

        // second, add enteries to the index file for each file... Create Blob
       
        CodingGit.createBLOB(pathOf2);
        CodingGit.createBLOB(pathOf2);
        CodingGit.createBLOB(pathOf3);
        CodingGit.createBLOB(pathOf4);
        CodingGit.createBLOB(pathOf5);


        File dir = new File("folder");
        CodingGit.treeFileToObj(dir);

        // Files.delete(pathOf2);
        // Files.delete(pathOf3);
        // Files.delete(pathOf4);
        // Files.delete(pathOf5);
        // Files.delete(folderpath2);
        // Files.delete(folderpath);
        

        // // // for stretch GP 2.4.2
        // CodingGit.removeObjFiles();
        // CodingGit.RemoveStuff();

    }
}