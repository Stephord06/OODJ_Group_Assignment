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
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentTable {
    
    // UI Design 
    public void AppointRecordTable(){
        
        // Frame Setting
        JFrame frame = new JFrame("Appointment Record");
        frame.setLayout(null);
        frame.setSize(860,560);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        
        // Label Setting
        JLabel title = new JLabel("Appointment Record Table");
        title.setBounds(0,20,844,36);
        title.setFont(new Font("Times New Roman", Font.BOLD, 26));
        
        // Button Setting
        JButton btn_reload = new JButton("⟳  Reload Appointment Record");
        JButton btn_update = new JButton("✓  Update Appointment Status");
        JButton btn_cancel = new JButton("✕  Cancel Update");
        
        btn_reload.setBounds(60,445,240,36);
        btn_update.setBounds(312,445,240,36);
        btn_cancel.setBounds(564,445,160,36);
        
        btn_reload.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btn_update.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btn_cancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        
        // Button Action Event Setting
        btn_update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        
            }
        });
        
        btn_reload.addActionListener(new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent e){
        
            }
        });
        
        btn_cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        // Table Setting
        
        
        // Panel Setting (to store Table)
      
        
        // Display Frame & Object
        frame.setVisible(true);
        frame.add(title);
        frame.add(btn_reload);
        frame.add(btn_update);
        frame.add(btn_cancel);
    }
    
    public static void main(String[] args){
        new AppointmentTable().AppointRecordTable();
    }
}
