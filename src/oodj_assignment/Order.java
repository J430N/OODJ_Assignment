
package oodj_assignment;
import java.io.IOException;


public class Order extends OrderRead
{
    
    private String filePath = "Order.txt";
    private String OrderName;
    
    public String getOrderName()
    {
        return OrderName;
    }
    
    public void setOrderName(String OrderName)
    {
        this.OrderName = OrderName;
    }

    
    
    
    public String[] searchAllOrderName(String OrderProName) throws IOException
    {
        //Search order in the textfile
        //Return order details
        int x=0;
        int row = 0;
        boolean over = false;
        OrderRead data = new OrderRead();
        String[][] multipleData = data.readTextFile(filePath).clone();
        String[] result = new String[multipleData.length];
        
        
        //Check order exist or not
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (OrderProName.equals(multipleData[row][1]))
                {
                    for(int col =0; col<multipleData[0].length; col++)
                    {
                        
                        if (multipleData[row][col] != null)
                        {
                            //Write all order details into result array
                            result[x] = multipleData[row][col];
                            x++;
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
    
    public String[] searchCustOrderName(String OrderProName) throws IOException
    {
        //Search order in the textfile
        //Return order details
        int x=0;
        int row = 0;
        boolean over = false;
        OrderRead data = new OrderRead();
        String[][] multipleData = data.readTextFile(filePath).clone();
        String[] result = new String[multipleData.length];
        
        
        //Check order exist or not
        while(!over)
        {
            if(multipleData[row][0]!=null)
            {
                if (OrderProName.equals(multipleData[row][1]))
                {
                    for(int col =0; col<multipleData[0].length; col++)
                    {
                        
                        if (multipleData[row][col] != null)
                        {
                            //Write all order details into result array
                            result[x] = multipleData[row][col];
                            x++;
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
}
   

