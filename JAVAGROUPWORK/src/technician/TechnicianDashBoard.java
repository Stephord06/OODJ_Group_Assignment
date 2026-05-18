/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package technician;

/**
 *
 * @author wongj
 */
import GeneralTools.User;
import GeneralTools.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TechnicianDashBoard {
    
    private Technician currentTechnician;
    
    public TechnicianDashBoard(Technician currentTechnician){
        this.currentTechnician = currentTechnician;
    }
    
    // UI Interface Design:
    public void TechDashBoard(){
        
        System.out.println("ENTERED TO TECHNICIAN DASHBOARD");
        
        // Set Frame 
        JFrame dash = new JFrame("Technician Dash Board");
        dash.setSize(500,600);
        dash.setLayout(null);
        dash.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Set Label
        JLabel label1 = new JLabel("Welcome back, " + currentTechnician.getName() + "!");
        
        label1.setBounds(20,50,350,30);
        
        // Set Buttons
        JButton ViewProfile = new JButton("View Personal Profile");
        JButton EditProfile = new JButton("Edit Personal Profile");
        JButton CheckAppointment = new JButton("View & Check Appointment Details");
        JButton UpdateAppointment = new JButton("Update Appointment");
        JButton LogOut = new JButton("Log Out");
        
        // Set Bounds           .setBounds(x, y, width, height);
        ViewProfile.setBounds(20,90,350,30);
        EditProfile.setBounds(20,130,350,30);
        CheckAppointment.setBounds(20,170,350,30);
        UpdateAppointment.setBounds(20,210,350,30);
        LogOut.setBounds(20,250,350,30);
        
                
        
        // Set the Action Events for JButtons
        ViewProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dash.dispose();
                Profile pf = new Profile(currentTechnician);
                pf.Profile();
            }
        });
        
        EditProfile.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dash.dispose();
                ProfileEdit pe = new ProfileEdit(currentTechnician);
                pe.EditPage();
            }
        });
        
        CheckAppointment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dash.dispose();
                Appointments ap = new Appointments(currentTechnician);
                ap.AppointList();
            }
        });
        
        
        UpdateAppointment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dash.dispose();
                AppointmentTable at = new AppointmentTable(currentTechnician);
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
        UpdateAppointment.setFont(new Font("Times New Roman", Font.BOLD, 18));
        LogOut.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        // Display Frame and objects
        
        dash.add(label1);
        dash.add(ViewProfile);
        dash.add(EditProfile);
        dash.add(CheckAppointment);
        dash.add(UpdateAppointment);
        dash.add(LogOut);
        dash.setVisible(true);
    }
    
    public static void main(String [] args){
        
    }
    // Logic Programming
    
    // Methods
    
   
}
