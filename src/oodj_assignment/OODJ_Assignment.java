
package oodj_assignment;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Collections;
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class OODJ_Assignment {

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        AdminUser admin = new AdminUser();

        boolean match = false;
        while (!match)
        {
            //Login
            System.out.println("Enter username: ");
            String username = sc.nextLine();
            System.out.println("Enter password: ");
            String password = sc.nextLine();
            match = admin.login(username, password);
            if (match)
            {
                //Admin login
                System.out.println("Welcome " + username);
                //admin.addAdmin(); //Done
                //admin.deleteAdmin(); //Done
                //admin.editAdmin(); //Done
//<<<<<<< HEAD
                //admin.checkUserExist("C:\\Users\\wongj\\OneDrive - Asia Pacific University\\Desktop\\Admin_User.txt", username);
//=======
//>>>>>>> origin/JasonTeo
                //admin.searchAdmin(); //Done
                //admin.viewAdmin(); //Done

                break;
            }
            System.out.println("ERROR: Invalid Username or Password\nPlease try again\n");
        }
    
        /*System.out.println("Login Page\n1. Login \n2. Create new Admin\n3. Create new Customer\n4. Exit\nEnter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice)
        {
            case 1:
            {
                
            }
            case 2:
            {
                //A1.addAdmin();
                break;
            }
            case 3:
            {
                performCustomerAction();
                break;
            }
            case 4:
            {
                break;
            }
            default:
            {
                System.out.println("ERROR: Invalid Input\nPlease re-enter your choice\n");
            }
        }*/
        
    }
    
}
