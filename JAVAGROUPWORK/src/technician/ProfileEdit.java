/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package technician;

/**
 *
 * @author wongj
 */
import GeneralTools.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class ProfileEdit {
    
    private Technician currentTechnician;
    
    public ProfileEdit(Technician currentTechnician){
        this.currentTechnician = currentTechnician;
    }
    
    public void EditPage(){
        
        // JFrame Setting
        JFrame profileEdit = new JFrame("Personal Profile Modification");
        
        profileEdit.setSize(600,600);
        profileEdit.setLayout(null);
        profileEdit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // JButton Setting
        JButton btn_update = new JButton("Update Profile");
        JButton btn_cancel = new JButton("Cancel Edit Profile");
        
        btn_update.setBounds(50,300,200,30);
        btn_cancel.setBounds(270,300,200,30);
        
        // Action Event Setting
        
        btn_cancel.addActionListener(e -> {
            profileEdit.dispose();
            TechnicianDashBoard tdb = new TechnicianDashBoard(currentTechnician);
            tdb.TechDashBoard();
            
        });
        
        // JPanel Setting
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(25,25,500,500);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
        // JLabel Setting
        
        JLabel title = new JLabel("Modify Personal Profile");
        JLabel label1 = new JLabel("Contact Number:");
        JLabel label2 = new JLabel("Email:");
        JLabel label3 = new JLabel("Password:");
        
        title.setBounds(50,25,300,50);
        label1.setBounds(25,75,120,30);
        label2.setBounds(25,115,150,30);
        label3.setBounds(25,155,120,30);
        
        
        // JTextField Setting
        
        JTextField txt_contact = new JTextField(currentTechnician.getContact());
        JTextField txt_email = new JTextField(currentTechnician.getEmail());
        JTextField txt_password = new JTextField(currentTechnician.getPassword());
        
        txt_contact.setBounds(200,75,275,30);
        txt_email.setBounds(200,115,275,30);
        txt_password.setBounds(200,155,275,30);
        
        // Font Setting
        
        title.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txt_password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txt_contact.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txt_email.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        
        btn_update.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btn_cancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String inputPassword = txt_password.getText().trim();
                String inputContact = txt_contact.getText().trim();
                String inputEmail = txt_email.getText().trim();
                
                if (inputPassword.isEmpty()){
                    JOptionPane.showMessageDialog(null,
                                                  "The password should not be empty",
                                                  "Password Error",
                                                  JOptionPane.WARNING_MESSAGE);
                    
                    return;
                }
                
                if (inputContact.isEmpty()){
                    JOptionPane.showMessageDialog(null,
                                                  "Contact number should not be empty",
                                                  "Contact Number Error",
                                                  JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if (inputEmail.isEmpty()){
                    JOptionPane.showMessageDialog(null,
                                                  "Contact number should not be empty",
                                                  "Contact Number Error",
                                                  JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                boolean success = verifyAndUpdate(inputContact, inputEmail, inputPassword);
                
                if (success){
                    
                    currentTechnician.setContact(inputContact);
                    currentTechnician.setEmail(inputEmail);
                    currentTechnician.setPassword(inputPassword);
                    
                    JOptionPane.showMessageDialog(null,
                                                  "Profile Updated Successfully",
                                                  "Profile Update Status",
                                                  JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,
                                                  "Failed to Update Profile",
                                                  "Profile Update Status",
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Display Objects and Frame
                
        profileEdit.add(title);
        profileEdit.add(panel);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(txt_password);
        panel.add(txt_contact);
        panel.add(txt_email);
        panel.add(btn_update);
        panel.add(btn_cancel);
        profileEdit.setVisible(true);
    }
    
    private boolean verifyAndUpdate(String inputContact, String inputEmail, String inputPassword){
        
        if (!inputContact.matches("^[0-9]{10,11}$")){
            JOptionPane.showMessageDialog(null,
                                                  "Contact number must be 10-11 digits",
                                                  "Format Error",
                                                  JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!inputEmail.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")){
            JOptionPane.showMessageDialog(null,
                                                  "Invalid email format (e.g abc@gmail.com)",
                                                  "Format Error",
                                                  JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (inputPassword.length() < 6){
            JOptionPane.showMessageDialog(null,
                                                  "Password must be at least 6 characters",
                                                  "Format Error",
                                                  JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return writeToFile(inputContact, inputEmail, inputPassword);
    }
    
    private boolean writeToFile(String newContact, String newEmail, String newPassword){
        
        String filePath = "technicians.txt";
        List<String> lines = new ArrayList<>();
        boolean found = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null){
                
                if (line.trim().isEmpty()){
                    lines.add(line);
                    continue;
                }
                
                String[] data = line.split("\\|", -1);
                
                
                
                if (data.length >= 5 && data[0].trim().equals(currentTechnician.getID())){
                    data[2] = newContact;
                    data[3] = newEmail;
                    data[4] = newPassword;
                    
                    lines.add(String.join("|", data));
                    found = true;
                            
                    System.out.println("==== DEBUGGING UPDATE PROFILE STATUS (START) ====");
                    System.out.println("filePath: " + filePath);
                    System.out.println("currentTechnician: " + currentTechnician.getID());
                    System.out.println("==== DEBUGGING UPDATE PROFILE STATUS (END) ====\n");
                    
                }
                else {
                    lines.add(line);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
        
        if (!found){
            System.out.println("Technician ID not found: " + currentTechnician.getID());
            return false;
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            for (int i = 0; i < lines.size(); i++){
                bw.write(lines.get(i));
                if (i < lines.size() - 1){
                    bw.newLine();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
        
        System.out.println(lines);
        return true;
    }
    
    public static void main(String[] args){
        
    }
}
