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
public class NonFragile_Packaging extends Packaging_Fee{

    @Override
    public double packFee(double totalOrder) {
        double packaging = 2;
        return totalOrder+packaging;
    }
    
}
