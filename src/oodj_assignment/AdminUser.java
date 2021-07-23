/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class AdminUser extends User
{
    String filePath = "D:\\APU\\Degree Year 2 Sem 1\\OODJ\\Assignment\\User.txt";
    String role = "Admin"; //This role can change
    public boolean login(String username, String password) throws IOException
    {
        User user = new User();
        return user.verifyLogin(filePath, "Admin", username, password);
    }
    
    public void addAdmin() throws IOException
    {
        User user = new User();
        user.addUser(filePath, role);
    }
    
    public void deleteAdmin() throws IOException
    {   
        User user = new User();
        user.deleteUser(filePath, role);   
    }
    
    public void editAdmin() throws IOException
    {   
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username of the user to edit: ");
        user.username = sc.nextLine();
        while(!user.checkUserExist(filePath, username))
        {
            System.out.println("User not found! Please try again");
            System.out.println("Enter username of the user to edit: ");
            user.username = sc.nextLine();
        }
        user.editUser(filePath, role); 
         
    }
    
    public void viewAdmin() throws IOException
    {   
        User user = new User();
        user.viewUser(filePath, role);   
    }
    public void searchAdmin() throws IOException
    {   
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username of the user: ");
        user.username = sc.nextLine();
        user.searchUser(filePath, role);      
    }
}
