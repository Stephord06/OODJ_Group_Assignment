/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package technician;

/**
 *
 * @author wongj
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AppointmentDetails {
    
    public void AppointDetails(){
        // UI Interface Design:
        
        // JFrame Settings
        JFrame appointDetails = new JFrame("Appointment Details");
        appointDetails.setSize(1920,1080);
        appointDetails.setLayout(null);
        
        // Jlabel Settings
        JLabel label1 = new JLabel("Appointment ID:");
        
        
        // JButton Settings
        
        
        // JPanel Settings
        
        
        // Display objects
        appointDetails.setVisible(true);
    } 
            
    
    public static void main(String [] args){
        new AppointmentDetails().AppointDetails();
    }
}
