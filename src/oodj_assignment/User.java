/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class User 
{
    protected String username;
    protected String password;
    
    public boolean verifyLogin(String filePath, String role, String username, String password) throws UnsupportedEncodingException, IOException
    {
        boolean match = false;
        RWTextFile data = new RWTextFile();
        if(data.readTextFile(filePath)!= null)
        {
            String[][] multipleData = data.readTextFile(filePath).clone();
            int row = 0;
            boolean over = false;
            
            //as long as no username is match, keep looking else end
            //as long as array is not null, keep looking else end
            //if username is match, check password , else end
            while(match!=true || over != true)
            {
                if(multipleData[row][0]!=null)
                {
                    if(role.equals(multipleData[row][0]) && username.equals(multipleData[row][2]))
                    {
                        if(password.equals(multipleData[row][3]))
                        {
                            match = true;
                            break;
                        }
                        else
                        {
                            over = true;
                            break;
                        }
                    }
                }
                else
                {
                    over = true;
                    break;
                }
                row++;
            }
        }    
        return match;
    }
    
    public void addUser(String filePath, String role) throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        int row = 0;
        int id = 0;
        String newUsername = null;
        String newPassword = null;
        boolean over = false;
        Integer[] idFromArray = new Integer[multipleData.length];
        while(over == false) //Problem only can run when have many data
        {
            if(multipleData[row][0]!=null)
            {
                for(int i =0; i<multipleData.length;i++)
                {
                    if (multipleData[row][1] != null)
                    {
                    idFromArray[i] = Integer.parseInt(multipleData[row][1]);// Parsing from string to int
                    }
                    else
                    {
                        break;
                    }
                }
            }
            else
            {                
                over = true;
                break;
            }
            row++;
        }
        //Create next id value
        for(int i =0; i<idFromArray.length;i++)
        {
            id = 0;
            if (idFromArray[i] > id) //find the biggest id
            {
                id = idFromArray[i];
            }
            else
            {
                break;
            }
            id++;
        }
        //Check user exist or not
        System.out.println("Enter new username: ");
        newUsername = sc.nextLine();
        while(checkUserExist(filePath, role, newUsername))
        {
            System.out.println("User found! Please try again");
            System.out.println("Enter new username: ");
            newUsername = sc.nextLine();
        }
        System.out.println("Enter new password: ");
        newPassword = sc.nextLine();
        //Write new user into textfile
        data.writeTextFile(filePath, role, String.valueOf(id), newUsername, newPassword); 
        System.out.println("User successfully added!");
    }
    
    public boolean checkUserExist(String filePath, String role) throws IOException
    {
        //Check for login only
        //Check using current username
        //return true when user exist
        if (username.equals(searchUsername(filePath, role, username)[2]))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean checkUserExist(String filePath, String role, String newUsername) throws IOException
    {
        //Check for add, edit or delete user
        //Check using new username
        //return true when user exist
        if (newUsername.equals(searchUsername(filePath, role, newUsername)[2]))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String[] searchUsername(String filePath, String role, String newUsername) throws IOException
    {
        //Search user in the textfile
        //Return user details
        int row = 0;
        boolean over = false;
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        String[] result = new String[multipleData.length];
        
        //Check user exist or not
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (role.equals(multipleData[row][0]) && newUsername.equals(multipleData[row][2]))
                {
                    for(int col =0; col<multipleData[0].length; col++)
                    {
                        if (multipleData[row][col] != null)
                        {
                            //Write all user details into result array
                            result[col] = multipleData[row][col];
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
            else
            {
                over = true;
                break;
            }
            row++;
        }
        return result;
    }
    
    public void deleteUser(String filePath, String role, String newUsername) throws IOException
    {   
        int row = 0;
        boolean over = false;
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        searchUser(filePath, role, newUsername);
        //Emtpy the file
        data.clearTextFile(filePath);
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (role.equals(multipleData[row][0]) && newUsername.equals(multipleData[row][2]))
                {
                    //Ignore match line
                    System.out.println("User deleted");
                }
                else
                {
                    //Write unaffected line back to the file
                    if (multipleData[row][0] != null)
                    {
                        data.writeTextFile(filePath, multipleData[row][0], multipleData[row][1], multipleData[row][2], multipleData[row][3]);
                    }
                    else
                    {
                        break;
                    }
                } 
            }
            else
            {
                over = true;
                break;
            }
            row++;
        }
    }

    public void editUser(String filePath, String role, String newUsername) throws IOException
    {   
        //Display user details before edit
        Scanner sc = new Scanner(System.in);
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        System.out.println("Before edit:");
        searchUser(filePath, role, newUsername);
        int row = 0;
        boolean over = false;
        String editUsername=null;
        String editPassword=null;
        System.out.println("Choose one\n1. Change username \n2. Change password\n3. Change username and password\nEnter your choice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch(choice)
                    {
                        case 1:
                        {
                            //Replace username
                            System.out.println("Enter new username: ");
                            editUsername = sc.nextLine();
                            while(checkUserExist(filePath, role, editUsername))
                            {
                                System.out.println("User found! Please try again");
                                System.out.println("Enter new username: ");
                                editUsername = sc.nextLine();
                            }
                            break;
                        }
                        case 2:
                        {
                            //Replace password
                            System.out.println("Enter new password: ");
                            editPassword = sc.nextLine();
                            break;
                        }
                        case 3:
                        {
                            System.out.println("Enter new username: ");
                            editUsername = sc.nextLine();
                            //Replace username and password
                            while(checkUserExist(filePath, role, editUsername))
                            {
                                System.out.println("User found! Please try again");
                                System.out.println("Enter new username: ");
                                editUsername = sc.nextLine();
                            }
                            System.out.println("Enter new password: ");
                            editPassword = sc.nextLine();
                            break;
                        }
                        default:
                        {
                            System.out.println("ERROR: Invalid Input\nPlease re-enter your choice\n");
                        }
                    }
        //Empty the file
        data.clearTextFile(filePath);
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (role.equals(multipleData[row][0]) && newUsername.equals(multipleData[row][2]))
                {
                    if(editPassword==null)
                    {
                        //Write back the updated data
                        data.writeTextFile(filePath, multipleData[row][0], multipleData[row][1], editUsername, multipleData[row][3]);
                        System.out.println("After edit:");
                        System.out.println("Role: " + multipleData[row][0] + "\nID: " + multipleData[row][1] + "\nUsername: " + editUsername + "\nPassword: " + multipleData[row][3]);
                    }
                    else if(editUsername==null)
                    {
                        //Write back the updated data
                        data.writeTextFile(filePath, multipleData[row][0], multipleData[row][1], newUsername, editPassword);
                        System.out.println("After edit:");
                        System.out.println("Role: " + multipleData[row][0] + "\nID: " + multipleData[row][1] + "\nUsername: " + multipleData[row][2] + "\nPassword: " + editPassword);
                    }
                    else
                    {
                        //Write back the updated data
                        data.writeTextFile(filePath, multipleData[row][0], multipleData[row][1], newUsername, editPassword);
                        System.out.println("After edit:");
                        System.out.println("Role: " + multipleData[row][0] + "\nID: " + multipleData[row][1] + "\nUsername: " + editUsername + "\nPassword: " + editPassword);
                    }
                }
                else
                {
                    //Write unaffected line back to the file
                    if (multipleData[row][0] != null)
                    {
                        data.writeTextFile(filePath, multipleData[row][0], multipleData[row][1], multipleData[row][2], multipleData[row][3]);
                    }
                    else
                    {
                        break;
                    }
                }
            }
            else
            {
                over = true;
                break;
            }
            row++;
        }
    }
 
    public void searchUser(String filePath, String role, String newUsername) throws IOException
    {   
        //Search user using username
        Scanner sc = new Scanner(System.in);
        //Print user details
        if (searchUsername(filePath, role, newUsername)[2]==null)
        {
            System.out.println("User not Found!");
        }
        else
        {
            System.out.println("Role: " + searchUsername(filePath, role, newUsername)[0] + "\nID: " + searchUsername(filePath, role, newUsername)[1] + "\nUsername: " + searchUsername(filePath, role, newUsername)[2] + "\nPassword: " + searchUsername(filePath, role, newUsername)[3]);
        }
    }
    
    public void viewUser(String filePath, String role) throws IOException
    {
        //Search user in the textfile
        //Return user details
        int row = 0;
        boolean over = false;
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        String[][] result = new String[multipleData.length][multipleData[0].length];
        System.out.println("Role\tID\tUsername\tPassword");
        //Check user exist or not
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (role.equals(multipleData[row][0]))
                {
                    if (multipleData[row] != null)
                        {
                            //Print user details
                            System.out.println(multipleData[row][0] + "\t" + multipleData[row][1] + "\t" + multipleData[row][2] + "\t\t" + multipleData[row][3]);
                        }
                        else
                        {
                            break;
                        } 
                }
            }
            else
            {
                over = true;
                break;
            }
            row++;
        }
    }
}
