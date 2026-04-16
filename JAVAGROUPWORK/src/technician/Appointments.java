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


public class Appointments {
    
    // UI Interface Design
    public void AppointList(){
        
        // Frame
        JFrame frame = new JFrame("Appointment List");
        frame.setLayout(null);
        frame.setSize(800,400);
        
        // Label
        JLabel title = new JLabel("Appointment List");
        JLabel label1 = new JLabel("Choose one appointment record to check or review");
        
        title.setBounds(25,25,200,30);
        label1.setBounds(25,25,450,30);
        
        // Combo Box
        JComboBox cmb_appointments = new JComboBox();
        cmb_appointments.setBounds(25,90,400,30);
        cmb_appointments.addItem("*Appointments*");
        
        // Button
        JButton btn_check = new JButton("Check & Review");
        JButton btn_quit = new JButton("Quit");
        
        btn_check.setBounds(25,150,200,30);
        btn_quit.setBounds(265,150,150,30);
        
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBounds(25,75,750,250);
        
        // Font Setting
        title.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        cmb_appointments.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btn_check.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btn_quit.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        // Display objects
        frame.setVisible(true);
        frame.add(title);
        frame.add(panel);
        panel.add(label1);
        panel.add(cmb_appointments);
        panel.add(btn_quit);
        panel.add(btn_check);
    }
    
    public static void main(String [] args){
        new Appointments().AppointList();
    }
}
