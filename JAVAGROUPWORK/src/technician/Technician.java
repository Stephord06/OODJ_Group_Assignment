/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package technician;

/**
 *
 * @author wongj
 */

import GeneralTools.*;
import technician.*;


public class Technician extends User{

    private User currentUser;
   
    public Technician(User currentUser){
        super(
              currentUser.getID(),
              currentUser.getName(),
              currentUser.getContact(),
              currentUser.getEmail(),
              currentUser.getPassword(),
              currentUser.getRole()
        );
    }
    
    public void EnterClassMessage(){
        // To Ensure system may read users' inputs, then print out the message, and ensure the value of parameters come from Technician.java 
        System.out.println("Entered to Technician.java");
        System.out.println("====== DEBUGGING START ======" + "\n" +
                           "User ID: " + this.getID()+ "\n" +
                           "User Name: " + this.getName() + "\n" +
                           "Role: " + this.getRole() + "\n" +
                           "======= DEBUGGING END =======\n");
    }
    
    public void Appointments(){
        Appointments apd = new Appointments(this);
        apd.AppointList();
    }
    
    public void AppointmentTable(){
        AppointmentTable apt = new AppointmentTable(this);
        apt.AppointRecordTable();
    }
    
    public void Profile(){
        Profile pf = new Profile(this);
        pf.Profile();
    }
    
    public void ProfileEdit(){
        ProfileEdit pfe = new ProfileEdit(this);
        pfe.EditPage();
    }
    
    public void Feedbacks(){
        Feedbacks fdb = new Feedbacks(this);
        fdb.FeedbackPage();
    }
}
