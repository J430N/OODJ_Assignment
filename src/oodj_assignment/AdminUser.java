/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.IOException;

/**
 *
 * @author asus
 */
public class AdminUser extends User
{
    private String filePath = "User.txt"; //Make a static file in user class
    private String newUsername;
    private String newPassword;
    UserLogin login = new UserLogin();

    public AdminUser(UserLogin login)
    {
        this.login = login;
    }
    
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
    
    public String getUsername()
    {
        return login.getUsername();
    }
    
    public String getPassword()
    {
        return login.getPassword();
    }

    public String getRole()
    {
        return login.getRole();
    }
 
    public String getId()
    {
        return login.getId();
    }
    //Each method for each function
    public void addNewUser(String role) throws IOException
    {
        addUser(filePath, role, newUsername, newPassword);
    }
    
    public void deleteOneUser(String role, String targetUsername) throws IOException
    {   
        deleteUser(filePath, role, targetUsername); 
    }
    
    public void editOneUser(String role, String targetUsername, String editUsername, String editPassword) throws IOException
    {   
        editUserDetails(filePath, role, targetUsername, editUsername, editPassword); 
    }
    
    public void editOneUser(String role, String targetUsername, String editUsername) throws IOException
    {   
        editUserDetails(filePath, role, targetUsername, editUsername); 
    }
    
    public String[][] viewAllUser(String role) throws IOException
    {   
        return viewUser(filePath, role);   
    }
    
    public String[] searchOneUser(String role, String targetUsername) throws IOException
    {   
        return searchUsername(filePath, role, targetUsername);      
    }
}
