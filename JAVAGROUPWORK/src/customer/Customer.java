/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import GeneralTools.User;


/**
 *
 * @author User
 */
public class Customer extends User implements CustomerStandard_Method{
    
    
    public Customer(String id, String name, String password) {
        super(id, name, password);
    }
    
    
    
    public void customerDashBoard(){
        CustomerDashBoard cdb = new CustomerDashBoard(this);
        cdb.UI();
    }
    
    
    public void editProfile() {
        EditProfile ep = new EditProfile(this);
        ep.UI();
    }
    
    public void provideComment() {
        ProvideComment pc = new ProvideComment(this);
        pc.UI();
    }
    
    public void viewFeedback() {
        ViewFeedback vf = new ViewFeedback(this);
        vf.UI();
    }
    
    public void viewHistory() {
        ViewHistory vh = new ViewHistory(this);
        vh.UI();
    }
}
