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
import java.util.*;
        
public class ReadAppointment {
    // FileName Needs
    private static final String filePath = "Appointments.txt";
    
    // Parameters
    protected String appointID, customerID, customerName, technicianID, 
            technicianName, staffID, staffName, 
            date, timeStart, timeEnd, 
            comments, feedback, statusDescription;
    
    protected boolean status;
    
    // Constructors
    public ReadAppointment(String appointID, String customerID, String customerName, 
            String technicianID, String technicianName, String staffID, 
            String staffName, String date, String timeStart, String timeEnd, 
            String comments, String feedback, boolean status, String statusDescription){
        
        this.appointID = appointID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.technicianID = technicianID;
        this.technicianName = technicianName;
        this.staffID = staffID;
        this.staffName = staffName;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.comments = comments;
        this.feedback = feedback;
        this.status = status;
        this.statusDescription = statusDescription;
    }
    
    List<ReadAppointment> readAppointments(){
        List<ReadAppointment> appointmentList = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            
            String line;
            
            while ((line = br.readLine()) != null){
            
                if (line.trim().isEmpty()) continue;
            
                String[] data = line.split("|");
            
                if (data.length == 14){
                    ReadAppointment appt = new ReadAppointment(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            data[4].trim(),
                            data[5].trim(),
                            data[6].trim(),
                            data[7].trim(),
                            data[8].trim(),
                            data[9].trim(),
                            data[10].trim(),
                            data[11].trim(),
                            Boolean.parseBoolean(data[12].trim()),
                            data[13].trim()
                    );
                    appointmentList.add(appt);
                    
                }
                else{
                        System.out.println("File Reading Error: line " + line);
                    }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("The " + filePath + " not found......");
        } 
        catch(IO Exception e ){
        System.out.println("Reading Error: " + e.getMessage());
        } 
}
