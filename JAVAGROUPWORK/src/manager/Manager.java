/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import GeneralTools.*;

/**
 *
 * @author User
 */
public class Manager extends User implements ManagerStandard_Method{
    
    
    public Manager(String id, String name, String password) {
        super(id, name, password);
        
    }
    
    public void managerDashBoard(){
        ManagerDashBoard mdb = new ManagerDashBoard(this);
        mdb.UI();
    }
    
    
    public void modifyRoles() {
        ModifyRoles mr = new ModifyRoles(this);
        mr.UI();
    }
    
    public void setPrices() {
        SetPrices sp = new SetPrices(this);
        sp.UI();
    }
    
    public void analyzeReport() {
        AnalyzedReport ar = new AnalyzedReport(this);
        ar.UI();
    }
    
    public void viewComments() {
        ViewComment vc = new ViewComment(this);
        vc.UI();
    }
    
}    


    
  
    

