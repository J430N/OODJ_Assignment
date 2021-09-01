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
    
    @Override
    public void addUser(String role, String newUsername, String newPassword) throws IOException
    {   
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        int id = 0;
        boolean over = false;
        Integer[] idFromArray = new Integer[multipleData.length];
        while(over == false)
        {
            for(int i=0; i <multipleData.length; i++)
            {
                if (role.equals(multipleData[i][0]))
                {
                    //Take all same role user to compare the id
                    idFromArray[i] = Integer.parseInt(multipleData[i][1]);// Parsing from string to int
                }
            }
            over = true;
        }
        //Create next id value
        for(int i =0; i<idFromArray.length;i++)
        {
            while (idFromArray[i] != null)
            {
                if (idFromArray[i] > id) //find the biggest id
                {
                    id = idFromArray[i];
                }
                else
                {
                    break;
                }
            }
            
        }
        id++;
        data.writeTextFile(filePath, role, String.valueOf(id), newUsername, newPassword); 
    }
}