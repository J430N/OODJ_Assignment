/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class User 
{
    private String username;
    private String password;
    private String newUsername;
    private String newPassword;
    private String role;
    private String ID;
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
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
    
    public String getRole()
    {
        return role;
    }
    
    public void setRole(String role)
    {
        this.role = role;
    }
    
    public String getID()
    {
        System.out.println(this.ID);
        return ID;
    }
    
    public void setID(String ID)
    {
        this.ID = ID;
    }
    
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
                            setRole(multipleData[row][0]);
                            setID(multipleData[row][1]);
                            setUsername(multipleData[row][2]);
                            setPassword(multipleData[row][3]);
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
        //Scanner sc = new Scanner(System.in);
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        int row = 0;
        int id = 0;
        boolean over = false;
        Integer[] idFromArray = new Integer[multipleData.length];
        while(over == false) //Problem only can run when have many data
        {
            if(multipleData[row][0]!=null)
            {
                for(int i =0; i<multipleData.length;i++)
                {
                    if (role.equals(multipleData[row][0]))
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
        data.writeTextFile(filePath, role, String.valueOf(id), newUsername, newPassword); 
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
    
    public void editUserDetails(String filePath, String role, String newUsername, String editUsername, String editPassword) throws IOException
    {
        int row = 0;
        boolean over = false;
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        //Emtpy the file
        data.clearTextFile(filePath);
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (role.equals(multipleData[row][0]) && newUsername.equals(multipleData[row][2]))
                {
                    //Write back the updated data
                    data.writeTextFile(filePath, multipleData[row][0], multipleData[row][1], editUsername, editPassword);
                    System.out.println("After edit:");
                    System.out.println("Role: " + multipleData[row][0] + "\nID: " + multipleData[row][1] + "\nUsername: " + editUsername + "\nPassword: " + editPassword);
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
    
    public void editUserDetails(String filePath, String role, String newUsername, String editUsername) throws IOException
    {
        int row = 0;
        boolean over = false;
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        //Emtpy the file
        data.clearTextFile(filePath);
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (role.equals(multipleData[row][0]) && newUsername.equals(multipleData[row][2]))
                {
                    //Write back the updated data
                    data.writeTextFile(filePath, multipleData[row][0], multipleData[row][1], editUsername, multipleData[row][3]);
                    System.out.println("After edit:");
                    System.out.println("Role: " + multipleData[row][0] + "\nID: " + multipleData[row][1] + "\nUsername: " + editUsername + "\nPassword: " + multipleData[row][3]);
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
    
    public String searchUser(String filePath, String role, String newUsername) throws IOException
    {   
        //Search user using username
        Scanner sc = new Scanner(System.in);
        String searchResult = null;
        //Print user details
        if (searchUsername(filePath, role, newUsername)[2]==null)
        {
            searchResult = null;
        }
        else
        {
            searchResult = (searchUsername(filePath, role, newUsername)[0] + " : " + searchUsername(filePath, role, newUsername)[1] + " : " + searchUsername(filePath, role, newUsername)[2] + " : " + searchUsername(filePath, role, newUsername)[3]);
        }
        return searchResult;
    }
    
    public String[] viewUser(String filePath, String role) throws IOException
    {
        //Search user in the textfile
        //Return user details
        int row = 0;
        boolean over = false;
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        //Check user exist or not
        String[] result = new String[multipleData.length];
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (role.equals(multipleData[row][0]))
                {
                    if (multipleData[row] != null)
                        {
                            result[row] = multipleData[row][0] + " : " + multipleData[row][1] + " : " + multipleData[row][2] + " : " + multipleData[row][3];
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
        return result;
    }
}
