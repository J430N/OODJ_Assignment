
package oodj_assignment;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

class User
{
    protected String username;
    protected String password;
    protected String loginStatus;
    protected LocalDateTime registerDate;
}

class Admin extends User
{
    Scanner sc = new Scanner(System.in);
    private ArrayList<String> adminUserArrayList;
    //private String[] adminUserArray;
    //private String adminUsername;
    
    // String adminPassword;
    public Admin(){}
    
    public boolean verifyLogin()
    {
        System.out.println("Enter username: ");
        username = sc.nextLine();
        System.out.println("Enter password: ");
        password = sc.nextLine();
        
        for (int i = 0; i < adminUserArrayList.size(); i++)
        {
            if (username == adminUserArrayList.get(i)&& password == adminUserArrayList.get(i)) //loop 2 times, password under username
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    
    public void addAdmin()
    {   
        System.out.println("Enter username: ");
        username = sc.nextLine();
        System.out.println("Enter password: ");
        password = sc.nextLine();
        String[] adminUserArray = {username, password};
        //Testing 1234
        //put into text file
        //adminUserArrayList = Arrays.asList(adminUserArray);
        //adminUserArrayList.add(i);
    }
    
    public void deleteAdmin()
    {   
        //adminUserArrayList.remove(i);
    }
    
    public void editAdmin()
    {   
        //adminUserArrayList.set(i, "");
    }
    
    public void viewAdmin()
    {   
        Collections.sort(adminUserArrayList);
        for (String i : adminUserArrayList) 
        {
            System.out.println(i);
        }   
    }
    
    public void searchAdmin()
    {   
        for (String user : adminUserArrayList) 
        {
            if (username == (user)) // need to loop 2 times
            {
                System.out.println(user);
            }
            else
            {
                System.out.println("ERROR: User not found!");
            }
        } 
    }
}

public class OODJ_Assignment {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Admin A1 = new Admin();
        System.out.println("Login Page\n1. Login \n2. Create new Admin\n3. Create new Customer\n4. Exit\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1:
                {
                    if (A1.verifyLogin())
                    {
                        System.out.println("Welcome");
                    }
                    else
                    {
                        System.out.println("ERROR: Invalid Username or Password\nPlease try again\n");
                    }
                    break;
                }
                case 2:
                {
                    A1.addAdmin();
                    break;
                }
                /*
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
                }*/
            }
        
    }
    
}
