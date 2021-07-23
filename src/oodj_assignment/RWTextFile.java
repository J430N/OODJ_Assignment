/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class RWTextFile
{
    public String[][] readTextFile(String filePath) throws FileNotFoundException, IOException
    {
        //Import file
        String data[][] = new String[100][4]; //100 Row 3 Column (table)
        //Put the whole file into memory
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
        //Read line by line from file in memory
        BufferedReader bufReader = new BufferedReader(reader);
        String line;
        int count = 0;

        //Read each line in file
        while((line = bufReader.readLine()) != null)
        {
            //Split the data with : and pass into array
            //Word keep override
            String word[] = line.split(":");

            //Put each line data in word array into the data array after reading each line
            for(int i = 0; i < word.length;i++)
            {
                data[count][i] = word[i];
            }
            //After each line put into data array, move to next line
            count++;
        }
        reader.close();
      
        return data;

    }
    
    public void writeTextFile(String filePath, String role, String id, String username, String password)
    {
        try 
        {
            //To avoid empty space in textfile, make sure there is only 1 new line in the textfile
            //Check the blank line after delete the data
            FileWriter writer = new FileWriter(filePath, true); // Write user details into the file 
            BufferedWriter bwr = new BufferedWriter(writer);
            PrintWriter pwr = new PrintWriter(bwr); //Write user into text file and auto print new line
            pwr.println(role + ":" + id + ":" + username + ":" + password);
            bwr.close();
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void clearTextFile(String filePath) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(filePath);
        writer.print("");
        writer.close();
    }
}
