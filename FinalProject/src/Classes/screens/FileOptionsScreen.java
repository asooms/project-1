package Classes.screens;


import Classes.files.DirectoryFile;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;




public class FileOptionsScreen implements Screen {
	
	private DirectoryFile dirFiles = new DirectoryFile();
	
	private ArrayList<String> options = new ArrayList<>();

    public FileOptionsScreen() {
    	
    	options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
        
    }

    @Override
    public void Show() {
    	System.out.println("\n-----------------\nFile Options Menu\n-----------------");
        for (String s : options) {
            System.out.println(s);
        }
    }

    @Override
    public void GetUserInput() {
        this.Show();
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
        
    }

    @Override
    public void NavigateOption(int option) {
        
    	switch(option) {

            case 1: // Add File
                this.AddFile();
                
                this.Show();
                break;
            case 2: // Delete File
                this.DeleteFile();
                
                this.Show();
                break;
            case 3: // Search File
                this.SearchFile();
                this.Show();
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }

    }

    public void AddFile() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are adding a new file named: " + fileName);
        dirFiles.newFile(fileName);

	}
        
    
    
    public void DeleteFile() {
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);

        dirFiles.removeFile(fileName);

    }
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);

        ArrayList<File> files = dirFiles.getFiles();

        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("File not found");
        }
    }
    
    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return (in.nextLine());

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("Invalid input");
        }
        return returnOption;

    }

}
