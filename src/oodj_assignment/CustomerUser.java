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
public class CustomerUser extends User
{
    private String filePath = "User.txt"; //Make a static file in user class
    private String newUsername;
    private String newPassword;

    public String getNewUsername()
    {
        return newUsername;
    }
    
    public void setNewUsername(String newUsername)
    {
        this.newUsername = newUsername;
    }
    
    public String getNewPassword()
    {
        return newPassword;
    }
    
    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }
    
    //Each method for each function
    public void addNewCustomer(String role) throws IOException
    {
        addUser(filePath, role, newUsername, newPassword);
    }
}