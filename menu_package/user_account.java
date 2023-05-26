package menu_package;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class user_account{
    private String username, password;

    //-- optional constructor
    
    // user_account(String con_username, String con_password){
    //     username = con_username;
    //     password = con_password;
    // }

    public boolean set_signup(String set_username, String set_password){
        username = set_username; password = set_password;
        boolean stat;

        char_limit();
        stat = do_signup();
        if(!stat){return false;}

        return true;
    }

    private boolean do_signup(){
        String folder;
        boolean file_stat;

        try{
            folder = "C:\\Users\\PC\\Desktop\\VS_code\\learning_java\\OOP_creation\\" + username + ".txt";

            File create = new File(folder);
            file_stat = create.createNewFile();
            if(file_stat){
                //System.out.print("\ntrue\n");
                FileWriter edit = new FileWriter(create);
                edit.write(username + "\n" + password);
                
                edit.close();

                System.out.print("\n\n|| Congrats! The account has been created! ||\n\n");
            }
            else{
                return false;
            }
            

        }catch(IOException e){}

        return true;
    }

    private boolean char_limit(){
        Scanner inputs = new Scanner(System.in);
         username.length(); password.length();

         if(username.length() > 10 && password.length() > 16){
            while(true){
                System.out.print("\n\n| Username and Password Exceeds char limit! |\nusername : ");
                username = inputs.next();
                System.out.print("password : ");
                password = inputs.next();

                if(username.length() <= 10 || password.length() <= 16){
                    break;
                }
            }

            inputs.close();
        }

        while(username.length() > 10){
            System.out.print("\n\n| Username Exceeds 10 char limit! |\nusername : ");
            username = inputs.next();
        }

        while(password.length() > 16){
            System.out.print("\n\n| Password Exceed 16 char limit! |\nusername : " + username + "\npassword : ");
            password = inputs.next();
        }

        return true;
    }
}