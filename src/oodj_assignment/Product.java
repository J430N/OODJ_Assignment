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
public class Product 
{
    enum type
    {
        Fragile,
        NonFragile
    }
    
    private String filePath = "Product.txt";
    private String proName;
    
    public String getProName()
    {
        return proName;
    }
    
    public void setProName(String proName)
    {
        this.proName = proName;
    }

    public void addProduct(String cat, String proName, String type, String proPrice, String quantity, String weight) throws IOException
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
                if (cat.equals(multipleData[i][0]))
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
        data.writeTextFile(filePath, cat, String.valueOf(id), proName, type, proPrice, quantity, weight); 
    }
    
    public boolean checkProductExist(String newProName) throws IOException
    {
        //Check for add, edit or delete product
        //Check using newProName
        //return true when product exist
        if (newProName.equals(searchProName(newProName)[2]))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String[] searchProName(String newProName) throws IOException
    {
        //Search product in the textfile
        //Return product details
        int row = 0;
        boolean over = false;
        RWTextFile data = new RWTextFile();
        String[][] multipleData = data.readTextFile(filePath).clone();
        String[] result = new String[multipleData.length];
        
        //Check product exist or not
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (newProName.equals(multipleData[row][2]))
                {
                    for(int col =0; col<multipleData[0].length; col++)
                    {
                        if (multipleData[row][col] != null)
                        {
                            //Write all product details into result array
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
    
    public void deleteProduct(String newProName) throws IOException
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
                if (!newProName.equals(multipleData[row][2]))
                {
                    //Write unaffected line back to the file
                    if (multipleData[row][0] != null)
                    {
                        data.writeTextFile(filePath, multipleData[row][0], multipleData[row][1], multipleData[row][2], multipleData[row][3], multipleData[row][4],multipleData[row][5], multipleData[row][6]);
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
    
    public void editProductDetails(String role, String newUsername, String editUsername, String editPassword) throws IOException
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
    
    public void editProductDetails(String role, String newUsername, String editUsername) throws IOException
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
 
    public String[][] viewProduct(String type) throws IOException
    {
        //Search product in the textfile
        //Return product details
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
                if (type.equals(multipleData[row][3]))
                {
                    if (multipleData[row] != null)
                        {
                            result[row] = multipleData[row];
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
