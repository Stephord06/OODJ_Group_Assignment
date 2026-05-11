/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package manager;

import GeneralTools.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerDashBoard extends User implements ManagerStandard_Method {
    
    private String username;


    public ManagerDashBoard(User matchUser) {
        super(matchUser.getID(),matchUser.getName(),matchUser.getPassword());
        this.username = getName();
    }
    
    public ManagerDashBoard(String username ){
        this.username = username;
    }

    @Override
    public void UI() {
        
        // Frame
        JFrame frame = new JFrame("Manager Dash Board");
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Outer panel with GridBagLayout to center content
        JPanel outer = new JPanel(new GridBagLayout());
        frame.add(outer, BorderLayout.CENTER);
        
        //Log out button
        JPanel logOutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton logOutBtn = new JButton("Log Out");
        logOutPanel.add(logOutBtn);
        
        
        
        frame.add(logOutPanel, BorderLayout.NORTH);
        
        
        // Container panel to stack label and button panel vertically
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        // Greeting label
        JLabel greeting = new JLabel("Welcome to the Manager Dashboard, " + username);
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
                
        JButton AnalyzedReport = new JButton("Analyzed Report");
        buttonPanel.add(AnalyzedReport);
        
        JButton ViewComment = new JButton("View Comment");
        buttonPanel.add(ViewComment);   

        container.add(buttonPanel);                 

        // GridBagConstraints to center container in outer panel
        GridBagConstraints c = new GridBagConstraints();
        outer.add(container, c);

        // Show frame
        frame.setVisible(true);
        
        
        // event button handler
        
        logOutBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are u sure to log out?","Log Out", JOptionPane.YES_NO_OPTION);
                
                Login login = new Login();
                
                if(result == JOptionPane.YES_OPTION){
                    frame.dispose();
                    login.LoginPage();
                    
                }
                else if(result == JOptionPane.NO_OPTION){
                    //nothing
                }
            }
        });
        
        
        modify.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.dispose();

               ModifyRoles mr = new ModifyRoles(username);
               mr.UI();
               }
           });

        SetPrices.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              frame.dispose();

              SetPrices sp = new SetPrices(username);
              sp.UI();
              }
          });

        AnalyzedReport.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();

                AnalyzedReport ar = new AnalyzedReport(username);
                ar.UI();
            }
        });

        ViewComment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();

                ViewComment vr = new ViewComment(username);
                vr.UI();
            }
        });
         
          
        
         
    }
    
}