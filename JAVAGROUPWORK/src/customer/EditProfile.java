/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;
import GeneralTools.Login;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 *
 * @author User
 */
public class EditProfile  implements CustomerStandard_Method {
    
    private JFrame Frame;
    
    private String id;
    private String name;
    private String password;
    
    private List<String[]> customerData = new ArrayList<>();
    
    private JTextField phoneText;
    private JTextField emailText;
    private JTextField passwordText;
    
    public EditProfile(String id, String name, String password){

        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    @Override
    public void UI (){
        Frame = new JFrame();
        Frame.setTitle("Edit Profile");
        Frame.setSize(1100, 700);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLocationRelativeTo(null);
        
        Frame.add(mainPanel());   
        Frame.setVisible(true);
        
        //readFile from customers.txt
        JOptionPane.showMessageDialog(null, readFile("customers.txt"));
        
    }
    
    
    private JPanel mainPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(new BorderLayout());
        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        
        //top bar panel
        JPanel topPanel = new JPanel(new BorderLayout(0,20));
        topPanel.setBackground(new Color(60, 52, 137)); //purple
        topPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true), BorderFactory.createEmptyBorder(15, 20, 15, 20)));
        
        //top bar left side
        JLabel topLabel = new JLabel("Edit Profile");
        topLabel.setForeground(Color.WHITE);
        topLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        
        //top bar right side
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10,0));
        backPanel.setBackground(new Color(60, 52, 137)); //purple
        
        JLabel customerName = new JLabel(this.name);
        customerName.setForeground(Color.WHITE);
        customerName.setFont(new Font("SansSerif", Font.BOLD, 25));
        
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 25));
        
        backPanel.add(customerName);
        backPanel.add(backBtn);
        
        topPanel.add(topLabel, BorderLayout.WEST);
        topPanel.add(backPanel, BorderLayout.EAST);
        
        // main Label and textfield for phoneNumber, email, password
        
        JPanel outer = new JPanel(new GridBagLayout());
        outer.setBackground(Color.LIGHT_GRAY);
        outer.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true), BorderFactory.createEmptyBorder(20,20,20,20)));
        
        JPanel editProfile = new JPanel(new GridLayout(3,2,20,30));
        editProfile.setBackground(Color.LIGHT_GRAY);
        editProfile.setPreferredSize(new Dimension(900,250));
        
        //phoneNumber edit
        JLabel phoneLabel = new JLabel("Phone Number : ");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 25));
        
        phoneText = new JTextField();
        phoneText.setFont(new Font("Arial", Font.BOLD, 25));
        
        //email edit
        JLabel emailLabel = new JLabel("Email : ");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 25));
        
        emailText = new JTextField();
        emailText.setFont(new Font("Arial", Font.BOLD, 25));
        
        //password
        JLabel passwordLabel = new JLabel("Password : ");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 25));
        
        passwordText = new JTextField();
        passwordText.setFont(new Font("Arial", Font.BOLD, 25));
        
        editProfile.add(phoneLabel);
        editProfile.add(phoneText);
        editProfile.add(emailLabel);
        editProfile.add(emailText);
        editProfile.add(passwordLabel);
        editProfile.add(passwordText);
        
        // to center the editProfile at the center of outer
        outer.add(editProfile);
        
        //Button for Save and Revert
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,0));
        btnPanel.setBackground(Color.LIGHT_GRAY);
        
        JButton saveBtn = new JButton("Save");
        saveBtn.setFont(new Font("Arial", Font.BOLD, 20));
        saveBtn.setPreferredSize(new Dimension(150, 50));
        saveBtn.setBackground(new Color(60, 52, 137)); //purple 
        saveBtn.setForeground(Color.WHITE);
        
        
        JButton revertBtn = new JButton("Revert");
        revertBtn.setFont(new Font("Arial", Font.BOLD, 20));
        revertBtn.setPreferredSize(new Dimension(150, 50));
        revertBtn.setBackground(new Color(200, 50, 50));  // red
        revertBtn.setForeground(Color.WHITE);
        
        btnPanel.add(saveBtn);
        btnPanel.add(revertBtn);
        
        
        //Event Handling
        
        saveBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int result = JOptionPane.showConfirmDialog(null, "Are u sure to save?","Save Confirmation", JOptionPane.YES_NO_OPTION);
                
                if(result == JOptionPane.YES_OPTION){
                    
                    JOptionPane.showMessageDialog(null, writeFile("customers.txt"));
                    
                    if (!(passwordText.getText().equals(password))){
                        JOptionPane.showMessageDialog(null, "Password Changed \n PLease Login Again");
                        Frame.dispose();
                        Login login = new Login();
                        login.LoginPage();
                        
                    }
                }
                else if(result == JOptionPane.NO_OPTION){
                    //nothing
                }
            }
        });
        
        revertBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                customerData.clear();
                readFile("customers.txt");
                
                JOptionPane.showMessageDialog(null, "Reverted Successfully!");
            }
        });
        
        backBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Frame.dispose();
                CustomerDashBoard back = new CustomerDashBoard(id, name, password);
                back.UI();
            }
        });
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(outer, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        
        return mainPanel;
    }
    
    private String readFile(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            
            
            while((line = br.readLine()) != null){
                String[] body = line.split("\\|");
                customerData.add(body);
                
                if(body[0].equals(this.id) && body[4].equals(this.password)){
                    phoneText.setText(body[2]);
                    emailText.setText(body[3]);
                    passwordText.setText(body[4]);
                }
            }
            return "Load Successful"; //file found
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return "Load Unsuccessful"; //no file found  
    }
    
    private String writeFile(String file){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for (String[] data : customerData){
                if(data[0].equals(this.id) && data[4].equals(this.password)){
                    data[2] = phoneText.getText();
                    data[3] = emailText.getText();
                    data[4] = passwordText.getText();
                }
                String body = String.join("|", data);
                bw.write(body);
                bw.newLine();
            }
            customerData.clear();
            return "Saved Successful"; //file found
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return "Saved Unsuccessful"; //no file found  
    }
}
