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
public class TechnicianDashBoard {
    
    // UI Interface Design:
    public void TechDashBoard(){
        
        // Set Frame 
        JFrame dash = new JFrame("Technician Dash Board");
        dash.setSize(500,600);
        dash.setLayout(null);
        
        // Set Label
        JLabel label1 = new JLabel("Welcome to Technician Dash Board");
        
        label1.setBounds(20,50,350,30);
        
        // Set Buttons
        JButton ViewProfile = new JButton("View Personal Profile");
        JButton EditProfile = new JButton("Edit Personal Profile");
        JButton CheckAppointment = new JButton("View & Check Appointment Details");
        JButton ProvideFeedbacks = new JButton("Provide Appointment Feedbacks");
        JButton UpdateAppointment = new JButton("Update Appointment");
        
        // Set Bounds           .setBounds(x, y, width, height);
        ViewProfile.setBounds(20,90,350,30);
        EditProfile.setBounds(20,130,350,30);
        CheckAppointment.setBounds(20,170,350,30);
        ProvideFeedbacks.setBounds(20,210,350,30);
        UpdateAppointment.setBounds(20,250,350,30);
                
        // Set Font             
        label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ViewProfile.setFont(new Font("Times New Roman", Font.BOLD, 18));
        EditProfile.setFont(new Font("Times New Roman", Font.BOLD, 18));
        CheckAppointment.setFont(new Font("Times New Roman", Font.BOLD, 18));
        ProvideFeedbacks.setFont(new Font("Times New Roman", Font.BOLD, 18));
        UpdateAppointment.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        // Display Frame and objects
        dash.setVisible(true);
        dash.add(label1);
        dash.add(ViewProfile);
        dash.add(EditProfile);
        dash.add(CheckAppointment);
        dash.add(ProvideFeedbacks);
        dash.add(UpdateAppointment);
    }
    
    public static void main(String [] args){
        new TechnicianDashBoard().TechDashBoard();
    }
    // Logic Programming
}
