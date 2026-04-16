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

public class Profile {
    
    public void Profile(){
        // UI Interface Design
        
        // JFrame
        JFrame profile = new JFrame("Technician Personal Profile");
        profile.setSize(600,600);
        profile.setLayout(null);
        
        // JLabel
        JLabel title = new JLabel("Personal Profile");
        
        JLabel label1 = new JLabel("Staff ID:");
        JLabel label2 = new JLabel("Username:");
        JLabel label3 = new JLabel("Role:");
        JLabel label4 = new JLabel("Contact Number:");
        JLabel label5 = new JLabel("Email:");
        
        JLabel lbl_staffID = new JLabel("*ID*");
        JLabel lbl_username = new JLabel("*Name*");
        JLabel lbl_role = new JLabel("*role*");
        JLabel lbl_contactNum = new JLabel("*Contact*");
        JLabel lbl_email = new JLabel("*Email*");
        
        title.setBounds(25,25,200,50);
        
        label1.setBounds(25,75,120,30);
        label2.setBounds(25,105,120,30);
        label3.setBounds(25,135,120,30);
        label4.setBounds(25,165,150,30);
        label5.setBounds(25,195,120,30);
        
        lbl_staffID.setBounds(200,75,275,30);
        lbl_username.setBounds(200,105,275,30);
        lbl_role.setBounds(200,135,275,30);
        lbl_contactNum.setBounds(200,165,275,30);
        lbl_email.setBounds(200,195,275,30);
        
        
        // JButton
        JButton btn_finish = new JButton("Finish Review");
        
        btn_finish.setBounds(100,300,200,50);
        
        // JPanel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(25,25,500,500);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Font Setting
        title.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_staffID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_username.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_role.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_contactNum.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbl_email.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        
        btn_finish.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        // Display objects
        profile.setVisible(true);
        profile.add(panel);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(lbl_username);
        panel.add(lbl_staffID);
        panel.add(lbl_role);
        panel.add(lbl_email);
        panel.add(lbl_contactNum);
        panel.add(btn_finish);
        panel.add(title);
       
        
    }
    
    public static void main(String[] args){
        new Profile().Profile();
    }
}
