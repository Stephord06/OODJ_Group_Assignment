/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GeneralTools;

/**
 *
 * @author wongj
 */

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
        
public class ReadAppointment {
    // FileName Needs
    private static final String filePath = "appointments.txt";          // The file to read and provide data
    
    // Parameters
    protected String appointID, customerID, technicianID, staffID, serviceType,
            date, timeStart, timeEnd, 
            comments, feedback, statusDescription;
    
    // Constructors
    public ReadAppointment(String appointID, String customerID, 
            String technicianID, String staffID, String serviceType, 
            String date, String timeStart, String timeEnd, 
            String comments, String feedback, String statusDescription){
        
        this.appointID = appointID;
        this.customerID = customerID;
        this.technicianID = technicianID;     
        this.staffID = staffID;
        this.serviceType = serviceType;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.comments = comments;
        this.feedback = feedback;
        this.statusDescription = statusDescription;
    }
    
    public String getAppointID(){
        return appointID;
    }
    
    public String getCustomerID(){
        return customerID;
    }
    
    public String getTechnicianID(){
        return technicianID;
    }
    
    public String getstaffID(){
        return staffID;
    }
    
    public String getServiceType(){
        return serviceType;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getTimeStart(){
        return timeStart;
    }
    
    public String getTimeEnd(){
        return timeEnd;
    }
    
    public String getCustomerComment(){
        return comments;
    }
    
    public String getTechnicianFeedback(){
        return feedback;
    }
    
    public String getStatusDescription(){
        return statusDescription;
    }
    
    public static List<ReadAppointment> readAppointments(){
        List<ReadAppointment> appointmentList = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            
            String line;
            
            while ((line = br.readLine()) != null){
            
                if (line.trim().isEmpty()) continue;
            
                String[] data = line.split("\\|");
            
                if (data.length == 11){
                    ReadAppointment appt = new ReadAppointment(             // Store the data from appointment into a list
                            data[0].trim(),                                 // data: appointmentID
                            data[1].trim(),                                 // data: customerID
                            data[2].trim(),                                 // data: technicianID
                            data[3].trim(),                                 // data: staffID
                            data[4].trim(),                                 // data: serviceType 
                            data[5].trim(),                                 // data: date
                            data[6].trim(),                                 // data: timeStart
                            data[7].trim(),                                 // data: timeEnd
                            data[8].trim(),                                 // data: customer comment
                            data[9].trim(),                                 // data: technician feedback
                            data[10].trim()                                 // data: appointment status
                    );
                    appointmentList.add(appt);
                    
                }
                else{
                        System.out.println("File Reading Error: line " + line);
                    }
            }
            
        }catch (FileNotFoundException e){
            JLabel message = new JLabel("The " + filePath + " not found .......");
            message.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            JOptionPane.showMessageDialog(
                null,
                message,
                "Appointment Reading Satus",
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch(IOException e ){
            JLabel message1 = new JLabel("Reading Error: " + e.getMessage());
            message1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            JOptionPane.showMessageDialog(
                null,
                message1,
                "Reading Error Message",
                JOptionPane.INFORMATION_MESSAGE);
        } 
        
        return appointmentList;
    }
    
    
}
