/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class AdminUser extends User
{
    String filePath = "D:\\APU\\Degree Year 2 Sem 1\\OODJ\\Assignment\\AdminUser.txt";
    String role = "Admin"; //This role can change
    public boolean login(String username, String password) throws IOException
    {
        return verifyLogin(filePath, "Admin", username, password);
    }
    
    public void addAdmin() throws IOException
    {
        addUser(filePath, role);
    }
    
    public void deleteAdmin() throws IOException
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
    
    public void editAdmin() throws IOException
    {   
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
    
    public void viewAdmin() throws IOException
    {   
        viewUser(filePath, role);   
    }
    public void searchAdmin() throws IOException
    {   
        String newUsername = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username of the user: ");
        newUsername = sc.nextLine();
        searchUser(filePath, role, newUsername);      
    }
}
