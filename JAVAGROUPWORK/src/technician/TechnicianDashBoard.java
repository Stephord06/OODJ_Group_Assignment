/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package technician;

/**
 *
 * @author wongj
 */
import GeneralTools.Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JButton LogOut = new JButton("Log Out");
        
        // Set Bounds           .setBounds(x, y, width, height);
        ViewProfile.setBounds(20,90,350,30);
        EditProfile.setBounds(20,130,350,30);
        CheckAppointment.setBounds(20,170,350,30);
        ProvideFeedbacks.setBounds(20,210,350,30);
        UpdateAppointment.setBounds(20,250,350,30);
        LogOut.setBounds(20,290,350,30);
                
        
        // Set the Action Events for JButtons
        ViewProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dash.setVisible(false);
                Profile vf = new Profile();
                vf.Profile();
            }
        });
        
        EditProfile.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dash.setVisible(false);
                ProfileEdit pe = new ProfileEdit();
                pe.EditPage();
            }
        });
        
        CheckAppointment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dash.setVisible(false);
                Appointments ap = new Appointments();
                ap.AppointList();
            }
        });
        
        ProvideFeedbacks.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dash.setVisible(false);
                Feedbacks fbs = new Feedbacks();
                
            }
        });
        
        UpdateAppointment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dash.setVisible(false);
                AppointmentTable at = new AppointmentTable();
                at.AppointRecordTable();
            }
        });
        
        LogOut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dash.dispose();
                Login lg = new Login();
                lg.LoginPage();
            }
        });
        
        // Set Font             
        label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ViewProfile.setFont(new Font("Times New Roman", Font.BOLD, 18));
        EditProfile.setFont(new Font("Times New Roman", Font.BOLD, 18));
        CheckAppointment.setFont(new Font("Times New Roman", Font.BOLD, 18));
        ProvideFeedbacks.setFont(new Font("Times New Roman", Font.BOLD, 18));
        UpdateAppointment.setFont(new Font("Times New Roman", Font.BOLD, 18));
        LogOut.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        // Display Frame and objects
        dash.setVisible(true);
        dash.add(label1);
        dash.add(ViewProfile);
        dash.add(EditProfile);
        dash.add(CheckAppointment);
        dash.add(ProvideFeedbacks);
        dash.add(UpdateAppointment);
        dash.add(LogOut);
        
    }
    
    public static void main(String [] args){
        new TechnicianDashBoard().TechDashBoard();
    }
    // Logic Programming
    
    // Methods
    
   
}
