/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

/**
 *
 * @author asus
 */
public class NonFragileItem extends OrderItem{

    public double fees() {
        double packFee = 0.5;
        double defShipFee = 5;
        double totalFee = 0;
        
        if (super.weight < 5)
        {
            totalFee = packFee*super.quantity + defShipFee;
        }
        else
        {
            totalFee = packFee*super.quantity + defShipFee + 5;
        }
        return totalFee;
    }
}
