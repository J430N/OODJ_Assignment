/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.IOException;

public class User 
{
    private String username;
    private String password;
    
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

    public boolean verifyLogin(String filePath, String role, String username, String password) throws IOException
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

    public void addUser(String filePath, String role, String newUsername, String newPassword) throws IOException
    {   
        //Scanner sc = new Scanner(System.in);
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        int row = 0;
        int id = 0;
        boolean over = false;
        Integer[] idFromArray = new Integer[multipleData.length];
        while(over == false)
        {
            for(int i=0; i <multipleData.length; i++)
            {
                if (role.equals(multipleData[i][0]))
                {
                    //Take all same category product to compare the id
                    idFromArray[i] = Integer.parseInt(multipleData[i][1]);// Parsing from string to int
                }
                else
                {
                    over = true;
                    break;
                }
            }
        }
        //Create next id value
        for(int i =0; i<idFromArray.length;i++)
        {
            {
                System.out.println(idFromArray[i]);
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
        //Emtpy the file
        data.clearTextFile(filePath);
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (role.equals(multipleData[row][0]) && newUsername.equals(multipleData[row][2]))
                {
                    //Remove selected user
                    System.out.println(multipleData[row][2]  + "is deleted!");
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
    
    public String[][] viewUser(String filePath, String role) throws IOException
    {
        //Search user in the textfile
        //Return user details
        int row = 0;
        boolean over = false;
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        //Check product exist or not
        String[][] result = new String[multipleData.length][multipleData[0].length];
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (role.equals(multipleData[row][0]))
                {
                    if (multipleData[row] != null)
                    {
                        result[row] = multipleData[row];
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
