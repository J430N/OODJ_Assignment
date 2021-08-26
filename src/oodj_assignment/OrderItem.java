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
abstract class OrderItem {
    protected String role;
    protected String adminId;
    protected String orderId;
    protected String orderItemID;
    protected String category;
    protected String producID;
    protected String productName;
    protected String type;
    protected double price;
    protected int quantity;
    protected double weight;
    
    //abstraction method
    public abstract double fees();
    
}
