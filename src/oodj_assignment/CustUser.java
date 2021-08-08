/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;


import java.io.IOException;
import java.util.Scanner;


public class CustUser extends User
{
    String filePath = "C:\\Users\\wongj\\OneDrive - Asia Pacific University\\Desktop\\User.txt";
    String role = "Customer"; //This role can change
    public boolean login(String username, String password) throws IOException
    {
        return verifyLogin(filePath, role, username, password);
    }
    
    public void addCust() throws IOException
    {
        addUser(filePath, role);
    }
    
    public void deleteCust() throws IOException
    {   
        String newUsername = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username of the user to delete: ");
        newUsername = sc.nextLine();
        while(!checkUserExist(filePath, role, newUsername))
        {
            System.out.println("User not found! Please try again");
            System.out.println("Enter username of the user to delete: ");
            newUsername = sc.nextLine();
        }
        deleteUser(filePath, role, newUsername); 
    }
    
    public void editCust() throws IOException
    {   
        /*String newUsername = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username of the user to edit: ");
        newUsername = sc.nextLine();
        while(!checkUserExist(filePath, role, newUsername))
        {
            System.out.println("User not found! Please try again");
            System.out.println("Enter username of the user to edit: ");
            newUsername = sc.nextLine();
        }
        editUser(filePath, role, newUsername);*/
        String newUsername = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username of the user to edit: ");
        newUsername = sc.nextLine();
        while(!checkUserExist(filePath, role, newUsername))
        {
            System.out.println("User not found! Please try again");
            System.out.println("Enter username of the user to edit: ");
            newUsername = sc.nextLine();
        }
        editUser(filePath, role, newUsername);
         
    }
    
    public void viewCust() throws IOException
    {   
        viewUser(filePath, role);   
    }
    public void searchCust() throws IOException
    {   
        String newUsername = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username of the user: ");
        newUsername = sc.nextLine();
        searchUser(filePath, role, newUsername);      
    }
}
