/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GeneralTools;

/**
 *
 * @author wongj
 */
// Imports:
import javax.swing.*;
import java.awt.*;
public class Login {
    
    // UI Interface Design:
    public void LoginPage()
    {
        // Set JFrame
        
        JFrame login = new JFrame("Login Page");
        login.setSize(800, 600);
        login.setLayout(null);
        
        
        // Set Label
        JLabel title1 = new JLabel("Welcome");
        JLabel title2 = new JLabel("to");
        JLabel title3 = new JLabel("XXXX");
        JLabel title4 = new JLabel("System");
        
        JLabel label2 = new JLabel("Staff / Customer ID:");
        JLabel label3 = new JLabel("Password:");
        
        title1.setBounds(30,70,200,50);
        title2.setBounds(30,120,200,50);
        title3.setBounds(30,170,200,50);
        title4.setBounds(30,220,200,50);
        
        label2.setBounds(325,150,350,30);
        label3.setBounds(325,200,350,30);
        
        
        // Set Text Field
        JTextField txt_id = new JTextField();
        JTextField txt_password = new JTextField();
        
        txt_id.setBounds(500,150,250,30);
        txt_password.setBounds(500,200,250,30);
        
        // Button
        JButton btn_login = new JButton("Login");
        btn_login.setBounds(375,350,350,30);
        
        // Panel
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 300, 600);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        
        
        // Font Setting
        title1.setFont(new Font("Times New Roman", Font.BOLD, 45));
        title2.setFont(new Font("Times New Roman", Font.BOLD, 45));
        title3.setFont(new Font("Times New Roman", Font.BOLD, 45));
        title4.setFont(new Font("Times New Roman", Font.BOLD, 45));
        
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txt_id.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txt_password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btn_login.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        // Display all the objects into the frame
        login.setVisible(true);
        login.add(panel);
        panel.add(title1);
        panel.add(title2);
        panel.add(title3);
        panel.add(title4);
        
        login.add(label2);
        login.add(label3);
        login.add(txt_id);
        login.add(txt_password);
        login.add(btn_login);
       }
    
    // -------------------------------------------------------------------------------------------------
    // Logic Programming Design:
    
    // -------------------------------------------------------------------------------------------------
    // Parameters:
    

    
    // -------------------------------------------------------------------------------------------------
    // Constructor:

    // -------------------------------------------------------------------------------------------------
    // Methods:

    public static void main(String[] args) {
            new Login().LoginPage();
    }
}
