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
        login.setSize(500, 600);
        login.setLayout(null);
        
        // Set Label
        JLabel label1 = new JLabel("Welcome to XXXX System");
        JLabel label2 = new JLabel("Username:");
        JLabel label3 = new JLabel("Password:");
        
        label1.setBounds(30,50,50,100);
        label2.setBounds(30,50,100,120);
        label3.setBounds(30,50,100,140);
        
        // Set Text Field
        
        // Display all the objects into the frame
        login.setVisible(true);
        login.add(label1);
        login.add(label2);
        login.add(label3);
       }
    
    // -------------------------------------------------------------------------------------------------
    // Logic Programming Design:
    
    // -------------------------------------------------------------------------------------------------
    // Parameters:
    
    public String name;
    public String password;
    
    // -------------------------------------------------------------------------------------------------
    // Constructor:
    public void LoginPage(String name, String password)
    {
        this.name = name;
        this.password = password;
    }
    
    // -------------------------------------------------------------------------------------------------
    // Methods:

    private static class setSize {

        public setSize() {
        }
    }
}
