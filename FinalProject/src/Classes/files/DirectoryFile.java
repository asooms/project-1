package Classes.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;


public class DirectoryFile {

   public final String name = "src/Files/";


    private ArrayList<File> filesList = new ArrayList<File>();
    
    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
    
    File Dfiles = path.toFile();

    public ArrayList<File> getAllFiles() {
    	
        File[] directoryFiles = Dfiles.listFiles();

        filesList.clear();
    	for (int i = 0; i < directoryFiles.length; i++) {
    		if (directoryFiles[i].isFile()) {
                filesList.add(directoryFiles[i]);
    		}
    	}
    	
    	Collections.sort(filesList);
    	
    	return filesList;
    }
    public void newFile(String fileName) {
        try {
            Path path = FileSystems.getDefault().getPath(name + fileName).toAbsolutePath();
            File file = new File(name + fileName);

            if (file.createNewFile()) {
                System.out.println("File created successful: " + file.getName());
                filesList.add(file);
            } else {
                System.out.println("This File Already Exits, no need to add another");
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public void removeFile(String fileName) {

        Path path = FileSystems.getDefault().getPath(name + fileName).toAbsolutePath();
        File file = path.toFile();
        if (file.delete()) {
            System.out.println("Deleted File: " + file.getName());
            filesList.remove(file);
        } else {
            System.out.println("!! Failed to delete file: " + fileName + ", file was not found.");
        }
    }
    public void printFiles() {
        getAllFiles();

        for (File file : filesList)
        {
            System.out.println(file.getName());
        }
    }

    public ArrayList<File> getFiles() {
        getAllFiles();
    	return filesList;
    }

}
