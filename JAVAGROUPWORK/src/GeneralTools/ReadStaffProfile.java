/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GeneralTools;

/**
 *
 * @author wongj
 */

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class ReadStaffProfile {
    
    // Parameters
    private String userID;
    private String userName;
    private String contactNum;
    private String email;
    private String password;
    private String role;
    
    /**
     *@param userID
     *@param userName
     *@param contactNum
     *@param email
     *@param password
     *@param role
     */
    
    // Constructor
    public ReadStaffProfile(String userID, String userName, String contactNum, String email, String password, String role){
        this.userID = userID;
        this.userName = userName;
        this.contactNum = contactNum;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    // Methods
    public String getID(){
        return userID;
    }
    
    public String getName(){
        return userName;
    }
    
    public String getContact(){
        return contactNum;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getRole(){
        return role;
    }
    /**
     *@param filePath
     *@param role
     *@return
     */        
    
    public static List <ReadStaffProfile> loadFromFile(String filePath, String role){
        
        List <ReadStaffProfile> list = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            
            String line;
            
            while ((line = br.readLine()) != null){
            
                if (line.trim().isEmpty()) continue;
                String [] data = line.split("\\|", -1);
                
                if (data.length >= 5)
                {
                    list.add(new ReadStaffProfile(              // Get the Data and input into the List with the format
                        data[0].trim(),                         // [userID, userName, contactNum, email, password]
                        data[1].trim(),
                        data[2].trim(),
                        data[3].trim(),
                        data[4].trim(),
                        role                                   // Use for Identifying and provide relevant dashboard by the role
                    ));
                }
                else{
                    JLabel message = new JLabel("Skipping Read Line: " + line);
                    message.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                    
                    JOptionPane.showMessageDialog(
                        null,
                        message,
                        "Line Skipping Message",
                        JOptionPane.INFORMATION_MESSAGE
                        );
                }
            }  
        }catch(FileNotFoundException e){
            JLabel message1 = new JLabel("The .txt file was not found: " + filePath);
                    message1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                    
                    JOptionPane.showMessageDialog(
                        null,
                        message1,
                        "FIle Not Found",
                        JOptionPane.ERROR_MESSAGE
                        );
        }catch(IOException e){
            JLabel message2 = new JLabel("Error Reading: " + e.getMessage());
                    message2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                    
                    JOptionPane.showMessageDialog(
                        null,
                        message2,
                        "FIle Not Found",
                        JOptionPane.ERROR_MESSAGE
                        );
        }
        return list;
    }
}
