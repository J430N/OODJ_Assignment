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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class OrderRead
{
    public String[][] readTextFile(String filePath) throws FileNotFoundException, IOException
    {
        //Import file
        String data[][] = new String[50][7]; //100 Row 3 Column (table)
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

    
}
