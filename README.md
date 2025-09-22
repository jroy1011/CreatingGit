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


