
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
        CustUser customer = new CustUser();

        boolean match = false;
        while (!match)
        {
            //Login
            System.out.println("Enter username: ");
            String username = sc.nextLine();
            System.out.println("Enter password: ");
            String password = sc.nextLine();
            match = customer.login(username, password);
            if (match)
            {
                //Customer login
                System.out.println("Welcome " + username);
                //customer.addCust(); //Done
                //customer.deleteCust(); //Done
                customer.editCust(); //Done

                //customer.checkUserExist("C:\\Users\\wongj\\OneDrive - Asia Pacific University\\Desktop\\Admin_User.txt", username);

                //customer.searchCust(); //Done
                //customer.viewCust(); //Done

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
                //A2.addCust();
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
