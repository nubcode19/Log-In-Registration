import java.util.Scanner;
import menu_package.user_account;
import menu_package.LogIn;

public class menu{
    public static void main(String[]args){
        Scanner inputs = new Scanner(System.in);
        int input_one;
        boolean log_stat, sign_stat;
        String sign_username, sign_password, log_username, log_password;

        System.out.print("|Press the number|\n|1| - LogIn\n|2| - SignUp\n -: ");
        input_one = inputs.nextInt();

        if(input_one == 1){
            System.out.print("|| LogIn using your acc username and password ||\nusername : ");
            log_username = inputs.next();
            System.out.print("password : ");
            log_password = inputs.next();

            LogIn log = new LogIn();
            log_stat = log.login(log_username, log_password);
            //if(log_stat)

        }
        else if (input_one == 2){
            System.out.print("\n|| Create acc by entering a username and password ||\nusername : ");

            do{
                sign_username = inputs.next();
                System.out.print("password : ");
                sign_password = inputs.next();

                user_account user = new user_account();
                sign_stat = user.set_signup(sign_username, sign_password);

                if(!sign_stat){System.out.print("\n\n|| This account is already registered, Please create a new one ||\nusername : ");}
            } 
            while(!sign_stat);

        }
        else{
            System.out.print("\nInvalid option");
        }
        
        inputs.close();
    }
}