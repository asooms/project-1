package Classes.screens;

import Classes.files.DirectoryFile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WelcomeScreen implements Screen {

    private String welcomeText = "Welcome to LockedMe project ^.^ ";
    private String developerText = "Developer: Fares Sultan \n Id: 371100681";

    private ArrayList<String> options = new ArrayList<>();


    public WelcomeScreen() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

        System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("\n");
    }
    
    @Override
    public void Show() {
    	System.out.println("--------------------\n==>> Main Menu <<==\n-------------------- ");
        for (String s : options)  {
            System.out.println(s);
        }
    }

    @Override
    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
        
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
                FileOptionsScreen FileOptionsScreen = new FileOptionsScreen();
                FileOptionsScreen.GetUserInput();
                this.Show();
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {
        DirectoryFile file= new DirectoryFile();
        System.out.println("\n--------------------\nList of Files: \n--------------------");
        file.printFiles();

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;
    }
}
