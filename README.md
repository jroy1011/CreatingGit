# CreatingGit
Initalizing Repo: 
- To initalize Repo just run the InitalizeRepo() method and only that method. When you run the InitlaizeRepo()
method it should run all the other methods: createGitFolder(), createObjectsFolder(), createIndexFile(), and 
createHeadFile()
   - the createGiFolder() makes a new directory called git
   - the createObjectsFolder() makes a new directory called objects inside the git folder which was created in the createGitFolder()
   - the createIndexFile() makes a new file called Index in the git folder
   - the createHeadFile() makes a new file called HEAD in the git folder 

// testing 
First, I used the Files.notExist() method on the git folder, objects folder, index file, and the HEAD file to see if those files existed or not, given the path they were supposed to exist in. 
Then, I wrote some remove methods in the CodingGit class and put all those methods into one big RemoveStuff() method in the CodingGit class. I then called that RemoveStuff() method in the CodingGit class into my tester class and then tested if those things were actually removed by using the Files.notExist() method mentioned before. 
Finally, I created a for loop that iterates 4 times. The loop first removes all the files, checks to see if they are removed using the Files.notExist() method, and then recreates them. After this is done for the fourth time, the Files.notExist() method is run to see if the files exist (they should exist).

// creating hash function 
in the generateSHA1HASH(Path file) method: first I used the java.nio.Files class to put all the bytes of the file's contents into a byte array 
second, I imported the MessageDigest class so that I could create an object (in this case called SHA1) that could hash things like Sha-1 can 
third, I used the digest() method to hash what was in the byte array and I put this content into a new array called hashedBytes. 
I then created a helper method called hexadecimalOfHash that takes the hash just created and returns a hexadecimal version of it. 
HexadecimalOfHash helper method: I had to use the internet to figure out how to do this. Essentially, I use String Builder and the .format() method as well as "%02x" to get a hexadecimal version of what has been hasehd 

Sydney's add-ons: Staging Trees
The SavedFile class is essentially just a File class that stores the file itself, sha1, type (blob or tree), and path of the file. This is especially helpful because you can call getSha1 on a folder and get the value returned to you. This is because the constructor calls the treeFileToOnjHelper(root) method which returns the sha1 of the folder it is staging
makeIndexTree(index) reads index and adds COPIES all files in the same structure all within a folder called root
treeFileToObj(index) calls treeFileToObjHelper(index,root), using the root folder made by makeIndexTree(index)
treeFileToObjHelper(index,root) calls the fileArray(root) method and BOTH ARE RECURSIVE which is hard to see, but when a SavedFile obj is initialized in fileArray(root), the SavedFile constructor calls treeFileToObjHelper, which calls fileArray(root). This recursion only happens when dealing with folders, so files are basically the base case
