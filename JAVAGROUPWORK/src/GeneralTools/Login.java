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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import technician.TechnicianDashBoard;
import counterstaff.StaffDashboard;
import manager.ManagerDashBoard;

public class Login extends JFrame implements ActionListener{
    
    private JTextField txt_id;
    private JPasswordField txt_password;
    private JButton btn_login;
    
    // UI Interface Design:
    public void LoginPage()
    {
        // Set JFrame
        
        setTitle("Login Page");
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        txt_id = new JTextField();
        txt_password = new JPasswordField();
        
        txt_id.setBounds(500,150,250,30);
        txt_password.setBounds(500,200,250,30);
        
        // Button
        btn_login = new JButton("Login");
        btn_login.setBounds(375,350,350,30);
        
        // Action Events
        // Analyze Users' ID and role, then provide the relevant dashboard for them
        btn_login.addActionListener(this);
         
                
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
        
        title1.setForeground(Color.WHITE);
        title2.setForeground(Color.WHITE);
        title3.setForeground(Color.WHITE);
        title4.setForeground(Color.WHITE);
        
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txt_id.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txt_password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btn_login.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        // Display all the objects into the frame   
        add(panel);
        panel.add(title1);
        panel.add(title2);
        panel.add(title3);
        panel.add(title4);
        
        add(label2);
        add(label3);
        add(txt_id);
        add(txt_password);
        add(btn_login);
        setVisible(true);
       }
    
    /**
     * 
     * @param e 
     */
    
    @Override
    public void actionPerformed(ActionEvent e ){
        if (e.getSource() == btn_login) {
            String inputID = txt_id.getText().trim();
            String inputPassword = new String(txt_password.getPassword()).trim();
            
            authenticate(inputID, inputPassword);
        }
    }
    
    /*
    * @param label
    */
    
    private String resolveFilePath(char label){
        switch (Character.toUpperCase(label)) {
            case 'S' : return "counterStaffs.txt";
            case 'M' : return "managers.txt";
            case 'T' : return "technicians.txt";
            case 'C' : return "customers.txt";
            default : return null;
        }
    }
    
    private String resolveRole(char label){
        switch(Character.toUpperCase(label)){
            case 'S' : return "Counter Staff";
            case 'M' : return "Manager";
            case 'T' : return "Technician";
            case 'C' : return "Customer";
            default : return null;
        }
    }
    /*
    * @param inputID
    * @param inputPassword
    * @param parentFrame
    */
    public void authenticate(String inputID, String inputPassword){
        
        // Display Error Message when the user did not input the information in the text field
        if (inputID.isEmpty() || inputPassword.isEmpty()){
            JLabel error_message = new JLabel("Input the form to log in to the System......");
            error_message.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            JOptionPane.showMessageDialog(
                null,
                error_message,
                "Input Error",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        char label = inputID.charAt(0);
        String filePath = resolveFilePath(label);
        String role = resolveRole(label);
        
        // Debugging to ensure whether find the textfile and the related users
        System.out.println("=== DEBUGGING START ===");
        System.out.println("inputID   : " + inputID);
        System.out.println("filePath  : " + filePath);
        System.out.println("role      : " + role);
        System.out.println("=== DEBUGGING END ===\n");
        
        User matchedUser = null;
        
        boolean isIDFormat = (filePath != null)
                            && (inputID.length() > 1)
                            && Character.isDigit(inputID.charAt(1));
                
        System.out.println("isIDFormat: " + isIDFormat + "\n");
        
        if (isIDFormat){
            // 按 ID 搜索对应文件
            List<User> userList = User.loadFromFile(filePath, role);
            System.out.println("userList size: " + userList.size());
        
            for (User user : userList){
                System.out.println("Checking ID: " + user.getID());
                if (user.getID().equalsIgnoreCase(inputID)){
                    matchedUser = user;
                    break;
                }
            }
        } else {
            // 按名字搜索所有文件
            System.out.println("Searching by name: " + inputID + "\n");
            matchedUser = searchByName(inputID);
        }
        
        System.out.println("matchUser: " + (matchedUser == null ? "null" : matchedUser.getID()));
        
        // Display Error Message when the system cannot find the related user ID from the txt file
        if (matchedUser == null){
            JLabel error_message2 = new JLabel("Your account does not exist in this system......");
            error_message2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            JOptionPane.showMessageDialog(
                null,
                error_message2,
                "Profile not Found",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!matchedUser.getPassword().equals(inputPassword)){
            JLabel error_message3 = new JLabel("Incorrect Password\nPlease Try Again......");
            error_message3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            JOptionPane.showMessageDialog(
                null,
                error_message3,
                "Login Failed",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        System.out.println("======= LOGIN STATUS CHECKING (START) =======\n" +
                           "Login Success\n" +
                           "Role: " + matchedUser.getRole() + "\n" +
                           "UserID: " + matchedUser.getID() + "\n" +
                           "UserName: " + matchedUser.getName() + "\n" +
                           "======= LOGIN STATUS CHECKING (END)   =======\n");
        dispose();
        DisplayDashboard(matchedUser);
    }
    
    /*
    * @param input
    * @return
    */
    private User searchByName(String inputName){
        String[][] allFiles ={
            {"counterStaffs.txt", "Counter Staff"},
            {"managers.txt", "Manager"},
            {"customers.txt", "Customer"},
            {"technicians.txt", "Technician"}
        };
        
        for (String[] file: allFiles){
            String filePath = file[0];
            String role = file[1];
            
            List<User> userList = User.loadFromFile(filePath, role);
            
            for(User user : userList){
                if (user.getName().equalsIgnoreCase(inputName)){
                    return user;
                }
            }
        }
        return null;
    }
    
    public void DisplayDashboard(User user){
        switch (user.getRole()){
            case "Counter Staff":
               new StaffDashboard(user);
               break;

            case "Customer":
                break;
                
            case "Manager":
                new ManagerDashBoard(user).DashBoardUI();
                break;
                
            case "Technician": 
                new TechnicianDashBoard(user).TechDashBoard();
                break;
        }
    }
    
    public static void main(String[] args) {
            new Login().LoginPage();
    }
}
