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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AppointmentDetails{
    
    private ReadAppointment appointment;
    private Technician currentTechnician;
    
    public AppointmentDetails(ReadAppointment appointment, Technician currentTechnician){
        this.appointment = appointment;
        this.currentTechnician = currentTechnician;
    }
    
    
    public void AppointDetails(){
        
        List<User> customers = User.loadFromFile("customers.txt", "Customer");
        List <User> staffs = User.loadFromFile("counterStaffs.txt", "Counter Staff");
        
        String customerName = "Unknown";
        for (User u : customers){
            if (u.getID().equalsIgnoreCase(appointment.getCustomerID())){
                customerName = u.getName();
                break;
            }
        }
        
        String staffName = "Unknown";
        for (User u : staffs){
            if (u.getID().equalsIgnoreCase(appointment.getstaffID())){
                staffName = u.getName();
                break;
            }
        }
        
        // UI Interface Design:
        // JFrame Settings
        JFrame appointDetails = new JFrame("Appointment Details");
        appointDetails.setSize(800,800);
        appointDetails.setLayout(null);
        appointDetails.setLocationRelativeTo(null);
        appointDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Jlabel Settings
        JLabel title = new JLabel("Appointment Details");
        JLabel label1 = new JLabel("Appointment ID:");
        JLabel label2 = new JLabel("Customer ID/Name:");
        JLabel label3 = new JLabel("Reservation Date:");
        JLabel label4 = new JLabel("Service Type:");
        JLabel label5 = new JLabel("Comment:");
        JLabel label6 = new JLabel("Staff ID/Name:");
        JLabel label7 = new JLabel("Time:");
        JLabel label8 = new JLabel("Status:");
        
        // used to display the information 
        JLabel lbl_appointID = new JLabel(appointment.getAppointID());
        JLabel lbl_cusName = new JLabel(appointment.getCustomerID() + " / " + customerName);
        JLabel lbl_appointDate = new JLabel(appointment.getDate());
        JLabel lbl_serviceType = new JLabel(appointment.getServiceType());
        JLabel lbl_comment = new JLabel(
                             appointment.getCustomerComment().equals("-") ? "No Comment" : appointment.getCustomerComment());
        JLabel lbl_staffName = new JLabel(appointment.getstaffID() + " / " + staffName);
        JLabel lbl_time = new JLabel(appointment.getTimeStart() + " --> " + appointment.getTimeEnd());
        JLabel lbl_status = new JLabel(appointment.getStatusDescription());
        
        // setBounds
        title.setBounds(50,25,200,50);
        label1.setBounds(25,10,200,50);
        label2.setBounds(25,60,200,50);
        label3.setBounds(25,110,200,50);
        label4.setBounds(25,210,200,50);
        label5.setBounds(25,310,200,50);
        label6.setBounds(25,160,200,50);
        label7.setBounds(25,260,200,50);
        label8.setBounds(25,360,200,50);
        
        
        lbl_appointID.setBounds(230,10,200,50);
        lbl_cusName.setBounds(230,60,200,50);
        lbl_appointDate.setBounds(230,110,200,50);
        lbl_staffName.setBounds(230,160,200,50);
        lbl_serviceType.setBounds(230,210,200,50);
        lbl_time.setBounds(230,260,200,50);
        lbl_comment.setBounds(230,310,200,50);
        lbl_status.setBounds(230,360,200,50);
       
        // ---------------------------------------------------------------------------------------------
        // JButton Settings
        JButton btn_finish = new JButton("Finish Review");
        btn_finish.setBounds(100,430,250,30);
        
        
        // JPanel Settings
        JPanel panel = new JPanel();
        panel.setBounds(50,90,650,480);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);
        
        // Set Button Event
        btn_finish.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                appointDetails.dispose();
                Appointments ap = new Appointments(currentTechnician);
                ap.AppointList();
            }
        });
        
        // Font Setting
        title.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        
        lbl_appointID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_cusName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_appointDate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_serviceType.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_comment.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_staffName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_time.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_status.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btn_finish.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        // Display objects
        appointDetails.setVisible(true);
        appointDetails.add(title);
        appointDetails.add(panel);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(lbl_appointID);
        panel.add(lbl_cusName);
        panel.add(lbl_appointDate);
        panel.add(lbl_serviceType);
        panel.add(lbl_comment);
        panel.add(lbl_staffName);
        panel.add(lbl_status);
        panel.add(lbl_time);
        panel.add(btn_finish);
    } 
            
    
    public static void main(String [] args){
    
    }
}
