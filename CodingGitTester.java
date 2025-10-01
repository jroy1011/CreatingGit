import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class CodingGitTester {
    public static void main(String[] args) {

       

        CodingGit.InitializeRepo();
        // Stretch challenge 1 for G.P 2.4: creating multiple test files
        // first, create a set of sample text files with different content

        try {
            String data = "SampleTest2 content";
            Files.write(Paths.get("sampleTest2"), data.getBytes(StandardCharsets.UTF_8));
            Path pathOf2 = Paths.get("sampleTest2");
            String data3 = "SampleTest3 content";
            Path pathOf3 = Paths.get("sampleTest3");
            Files.write(Paths.get("sampleTest3"), data3.getBytes(StandardCharsets.UTF_8));
            String data4 = "SampleTest4 content";
            Path pathOf4 = Paths.get("sampleTest4");
            Files.write(Paths.get("sampleTest4"), data4.getBytes(StandardCharsets.UTF_8));
            // second, add enteries to the index file for each file... Create Blob
            CodingGit.createBLOB(pathOf2);
            CodingGit.createBLOB(pathOf2);
            CodingGit.createBLOB(pathOf3);
            CodingGit.createBLOB(pathOf4);
            Files.delete(pathOf2);
            Files.delete(pathOf3);
            Files.delete(pathOf4);
        } catch (IOException e) {
        }

        // for stretch GP 2.4.2
        CodingGit.removeObjFiles();
        CodingGit.RemoveStuff();


    }
}