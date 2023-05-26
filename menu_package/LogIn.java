package menu_package;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
//import java.io.FileNotFoundException;

public class LogIn{
    public boolean login (String log_user, String log_pass){
        Scanner inputs = new Scanner(System.in);
        String read_file, folder = "C:\\Users\\PC\\Desktop\\VS_code\\learning_java\\OOP_creation\\" + log_user + ".txt";
        boolean stat;
        int guesses = 0;

        try{
            File make_file = new File(folder);
            stat = make_file.createNewFile();
            if(stat){
                System.out.print("\n|| Sorry, but this user is not registered ||");

                inputs.close();
                make_file.delete();
                return false;
            }
            else{
                Scanner read = new Scanner(make_file);
                read.hasNextLine();
                read_file = read.nextLine();
                read.hasNextLine();
                read_file = read.nextLine();

                if(read_file.equals(log_pass)){
                    System.out.print("\n|| username - valid || password - valid ||\n-: Logged in successfully!\n");
                }
                else{
                    while (true){
                        System.out.print("\n|| username - valid || password - Invalid ||\npassword : ");
                        log_pass = inputs.next();
                        guesses++;

                        if(read_file.equals(log_pass)){
                            System.out.print("\n|| username - valid || password - valid ||\n-: Logged in successfully!\n");
                            break;
                        }

                        else if(guesses > 5){
                            System.out.print("\n|| WARNING: your failed guesses exceeded 5 times ||\n\nExiting Terminal...\n\n");

                            inputs.close();
                            read.close();
                            return false;
                        }
                    }
                }
                read.close();
            }
            
        } 
        catch(IOException e){}
        inputs.close();
        return true;
    }
}