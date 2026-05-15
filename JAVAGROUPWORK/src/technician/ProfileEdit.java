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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ProfileEdit {
    
    private Technician currentTechnician;
    
    public ProfileEdit(Technician currentTechnician){
        this.currentTechnician = currentTechnician;
    }
    
    public void EditPage(){
        
        // JFrame Setting
        JFrame profileEdit = new JFrame("Personal Profile Modification");
        
        profileEdit.setSize(600,600);
        profileEdit.setLayout(null);
        
        // JButton Setting
        JButton btn_update = new JButton("Update Profile");
        JButton btn_cancel = new JButton("Cancel Edit Profile");
        
        btn_update.setBounds(50,300,200,30);
        btn_cancel.setBounds(270,300,200,30);
        
        // Action Event Setting
        
        btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JLabel message = new JLabel("Congratulations! Your Profile Has Been Updated Successfully!");
                message.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                JOptionPane.showMessageDialog(null,     
                        message,        // Message Content
                        "Update Status",        // Message Title
                        JOptionPane.INFORMATION_MESSAGE);           // Message Type (Icons)
                
                JLabel message1 = new JLabel("Sorry. Your Profile Has Failed to Update");
                message1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                JOptionPane.showMessageDialog(null, 
                        message1, 
                        "Update Status", 
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btn_cancel.addActionListener(e -> {
            profileEdit.dispose();
            
        });
        
        // JPanel Setting
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(25,25,500,500);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
        // JLabel Setting
        
        JLabel title = new JLabel("Modify Personal Profile");
        JLabel label1 = new JLabel("Contact Number:");
        JLabel label2 = new JLabel("Email:");
        JLabel label3 = new JLabel("Password:");
        
        title.setBounds(50,25,300,50);
        label1.setBounds(25,75,120,30);
        label2.setBounds(25,115,150,30);
        label3.setBounds(25,155,120,30);
        
        
        // JTextField Setting
        
        JTextField txt_contact = new JTextField(currentTechnician.getContact());
        JTextField txt_email = new JTextField(currentTechnician.getEmail());
        JTextField txt_password = new JTextField(currentTechnician.getPassword());
        
        txt_contact.setBounds(200,75,275,30);
        txt_email.setBounds(200,115,275,30);
        txt_password.setBounds(200,155,275,30);
        
        // Font Setting
        
        title.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txt_password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txt_contact.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txt_email.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        
        btn_update.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btn_cancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        // Display Objects and Frame
                
        profileEdit.add(title);
        profileEdit.add(panel);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(txt_password);
        panel.add(txt_contact);
        panel.add(txt_email);
        panel.add(btn_update);
        panel.add(btn_cancel);
        profileEdit.setVisible(true);
    }
    
    public static void main(String[] args){
        
    }
}
