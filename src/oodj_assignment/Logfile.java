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
public class Logfile{

    public String role;
    public String id;
    public String username;
    public String password;
    public String dateTime;
    
    RWTextFile wrtie = new RWTextFile();
    
    public void getAndWriteLogfile(String role, String id, String username, String password)
    {
        this.role = role;
        this.id = id;
        this.username = username;
        this.password = password;
        
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
            pwr.println(role + ":" + id + ":" + username + ":" + password + ":" + dateTime);
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
        System.out.println(result);
        return result;
        
    }
    
}
