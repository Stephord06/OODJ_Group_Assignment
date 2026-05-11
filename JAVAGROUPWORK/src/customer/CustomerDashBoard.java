/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;
import GeneralTools.*;

import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CustomerDashBoard extends User implements Standard_Method {
    
    private String name;
    private String id;
    private String password;
    
    private JFrame Frame;
    
    private final List<String> nameId = new ArrayList<>();
    
    public CustomerDashBoard(){
        this.name = super.getName();
        this.id = super.getID();
        this.password = super.getPassword();
    }
    
    @Override
    public void UI(){
        Frame = new JFrame();
        Frame.setTitle("Customer Dash Board");
        Frame.setSize(1100, 700);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLocationRelativeTo(null);
        
        
        Frame.add(mainPanel());
        
        Frame.setVisible(true);
        

    }
    
    private JPanel mainPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(new BorderLayout());
        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        //top bar panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(60, 52, 137));
        topPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true), BorderFactory.createEmptyBorder(15, 20, 15, 20)));
        
        //top bar left side
        JLabel topLabel = new JLabel("Customer DashBoard");
        topLabel.setForeground(Color.WHITE);
        topLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        
        
        //top bar right side
        JPanel logOutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10,0));
        logOutPanel.setBackground(new Color(60, 52, 137));
        
        JLabel customerName = new JLabel(this.name);
        customerName.setForeground(Color.WHITE);
        customerName.setFont(new Font("SansSerif", Font.BOLD, 25));
        
        JButton logOutBtn = new JButton("Log out");
        logOutBtn.setFont(new Font("SansSerif", Font.BOLD, 25));
        
        logOutPanel.add(customerName);
        logOutPanel.add(logOutBtn);
        
        topPanel.add(topLabel, BorderLayout.WEST);
        topPanel.add(logOutPanel, BorderLayout.EAST);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        // main Button for edit profile, access history, access feedback, provide comments
        
        JPanel outer = new JPanel(new GridBagLayout());
        
        JPanel buttonPanel = new JPanel(new GridLayout(4,1,0,40));
        buttonPanel.setPreferredSize(new Dimension(800, 350));
        
        JButton editBtn = new JButton("Edit Profile");
        editBtn.setFont(new Font("Arial", Font.BOLD, 30));
        
        JButton historyBtn = new JButton("Individual Service And Payment Histories");
        historyBtn.setFont(new Font("Arial", Font.BOLD, 30));
        
        JButton feedbackBtn = new JButton("FeedBacks Of Individual Appointment");
        feedbackBtn.setFont(new Font("Arial", Font.BOLD, 30));
        
        JButton commentsBtn = new JButton("Comments For Counter Staff And Technician");
        commentsBtn.setFont(new Font("Arial", Font.BOLD, 30));
        
        buttonPanel.add(editBtn);
        buttonPanel.add(historyBtn);
        buttonPanel.add(feedbackBtn);
        buttonPanel.add(commentsBtn);
        
        // GridBagConstraints to center buttonPanel in outer panel
        GridBagConstraints c = new GridBagConstraints();
        outer.add(buttonPanel, c);
        
        mainPanel.add(outer, BorderLayout.CENTER);
        
        //EVENT HANDLING
        
        logOutBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are u sure to log out?","Log Out", JOptionPane.YES_NO_OPTION);
                
                Login login = new Login();
                
                if(result == JOptionPane.YES_OPTION){
                    Frame.dispose();
                    login.LoginPage();
                    
                }
                else if(result == JOptionPane.NO_OPTION){
                    //nothing
                }
            }
        });
        
        editBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Frame.dispose();
                EditProfile ep = new EditProfile();
                ep.UI();
            }
            
        });
        
        historyBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Frame.dispose();
                ViewHistory vh = new ViewHistory();
                vh.UI();
            }
        });
        
        
        
        //return back the panel to the frame
        return mainPanel;
    }
    
    private void customerNameId(String identify,String password, String file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            
            while((line = br.readLine()) != null){
                String[] body = line.split("\\|");
                if((body[0].equals(identify) || body[1].equals(identify)) && body[4].equals(password)){
                    nameId.add(body[0]);
                    nameId.add(body[1]);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    
    public static void main(String[] args){
        
    }
    
    
}

