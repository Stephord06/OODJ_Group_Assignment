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
        appointDetails.setSize(800,800);
        appointDetails.setLayout(null);
        
        // Jlabel Settings
        JLabel title = new JLabel("Appointment Details");
        JLabel label1 = new JLabel("Appointment ID:");
        JLabel label2 = new JLabel("Customer Name:");
        JLabel label3 = new JLabel("Appointment Date:");
        JLabel label4 = new JLabel("Description:");
        JLabel label5 = new JLabel("Comment:");
        JLabel label6 = new JLabel("Staff Name:");
        
        // used to display the information from txt file
        JLabel lbl_appointID = new JLabel("*ID*");
        JLabel lbl_cusName = new JLabel("*Cus Name*");
        JLabel lbl_appointDate = new JLabel("*Date*");
        JLabel lbl_description = new JLabel("*Des*");
        JLabel lbl_comment = new JLabel("*comment*");
        JLabel lbl_staffName = new JLabel("*Staff Name*");
        
        // setBounds
        title.setBounds(50,25,200,50);
        label1.setBounds(25,10,200,50);
        label2.setBounds(25,60,200,50);
        label3.setBounds(25,110,200,50);
        label4.setBounds(25,210,200,50);
        label5.setBounds(25,260,200,50);
        label6.setBounds(25,160,200,50);
        
        lbl_appointID.setBounds(210,10,200,50);
        lbl_cusName.setBounds(210,60,200,50);
        lbl_appointDate.setBounds(210,110,200,50);
        lbl_staffName.setBounds(210,160,200,50);
        lbl_description.setBounds(210,210,200,50);
        lbl_comment.setBounds(210,260,200,50);
       
        // ---------------------------------------------------------------------------------------------
        // JButton Settings
        JButton btn_finish = new JButton("Finish Review");
        
        btn_finish.setBounds(100,400,250,30);
        
        // JPanel Settings
        JPanel panel = new JPanel();
        panel.setBounds(50,90,500,500);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);
        
        // Font Setting
        title.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        
        lbl_appointID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_cusName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_appointDate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_description.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_comment.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_staffName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
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
        panel.add(lbl_appointID);
        panel.add(lbl_cusName);
        panel.add(lbl_appointDate);
        panel.add(lbl_description);
        panel.add(lbl_comment);
        panel.add(lbl_staffName);
        panel.add(btn_finish);
    } 
            
    
    public static void main(String [] args){
        new AppointmentDetails().AppointDetails();
    }
}
