/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerDashBoard {

    private static String name;
    private static String password;
    

    public ManagerDashBoard(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public ManagerDashBoard(){
        
    }

    public void DashBoardUI() {
        // Frame
        JFrame frame = new JFrame("Manager Dash Board");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Outer panel with GridBagLayout to center content
        JPanel outer = new JPanel(new GridBagLayout());
        frame.add(outer);

        // Container panel to stack label and button panel vertically
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        // Greeting label
        JLabel greeting = new JLabel("Welcome to the Manager Dashboard, " + this.name);
        greeting.setFont(new Font("Arial", Font.BOLD, 18));
        greeting.setAlignmentX(Component.CENTER_ALIGNMENT); // center horizontally
        container.add(greeting);

        // Gap between label and buttons
        container.add(Box.createVerticalStrut(50));
         // 50 pixels gap

        // Button panel with GridLayout 2x2
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setPreferredSize(new Dimension(300, 150));
                                                            
        // Add buttons
        
        JButton modify = new JButton("Modify Roles");
        buttonPanel.add(modify);
        
        JButton SetPrices = new JButton("Set Prices");
        buttonPanel.add(SetPrices);
                
        JButton AnalysisReport = new JButton("Analyzed Report");
        buttonPanel.add(AnalysisReport);
        
        JButton ViewComment = new JButton("View Comment");
        buttonPanel.add(ViewComment);   

        container.add(buttonPanel);                 

        // GridBagConstraints to center container in outer panel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        outer.add(container, c);

        // Show frame
        frame.setVisible(true);
        
        
        // event button handler
        
         modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                    
                ModifyRoles mr = new ModifyRoles();
                mr.ModifyRolesUI();
                }
            });
         
          SetPrices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                
                SetPrices sp = new SetPrices();
                sp.SetPricesUI();
                }
            });
         
         
    }

    public static void main(String[] args) {
        new ManagerDashBoard("Alice", "pass123").DashBoardUI();
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPassword(){
        return this.password;
    }
}