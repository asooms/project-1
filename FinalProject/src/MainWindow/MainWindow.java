package MainWindow;

import Classes.screens.WelcomeScreen;

public class MainWindow {

    public static void main(String[] args) {
    	WelcomeScreen welcome = new WelcomeScreen();
    	welcome.Show();
    	welcome.GetUserInput();
    	System.out.println("Process finished with exit");
    }
}
