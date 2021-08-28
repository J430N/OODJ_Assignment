/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.time.LocalDateTime;
import java.io.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author asus
 */
public class UserLogin{

    private String role;
    private String Id;
    private String username;
    private String password;
    private String dateTime;
    
    RWTextFile wrtie = new RWTextFile();
    
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
    
    public String getRole()
    {
        return role;
    }
    
    public String getId()
    {
        return Id;
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
                            this.role = multipleData[row][0];
                            this.Id = multipleData[row][1];
                            this.username = multipleData[row][2];
                            this.password = multipleData[row][3];
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
    
    public void getAndWriteLogfile()
    {
        //Date and time
        LocalDateTime now = LocalDateTime.now();  
        DateTimeFormatter formatDT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH.mm.ss");
        String dt = now.format(formatDT);
        dateTime = dt.toString();
        
        try 
        {
            //To avoid empty space in textfile, make sure there is only 1 new line in the textfile
            //Check the blank line after delete the data
            FileWriter writer = new FileWriter("User_Logfile.txt", true); // Write user details into the file 
            BufferedWriter bwr = new BufferedWriter(writer);
            PrintWriter pwr = new PrintWriter(bwr); //Write user into text file and auto print new line
            pwr.println(role + ":" + Id + ":" + username + ":" + password + ":" + dateTime);
            bwr.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Cannot write data into the file");
            e.printStackTrace();
        }
    }
    
    public String[][] viewLogfile() throws IOException 
    {
        //Search user in the textfile
        //Return user details
        int row = 0;
        boolean over = false;
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile("User_Logfile.txt").clone();
        //Check product exist or not
        String[][] result = new String[multipleData.length][multipleData[0].length];
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                result[row] = multipleData[row];
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
