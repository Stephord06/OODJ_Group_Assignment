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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Appointments {
    
    private Technician currentTechnician;
    
    private String currentTechnicianID;
    private List<ReadAppointment> filteredAppointments; 
    
    public Appointments(Technician currentTechnician){
        this.currentTechnician = currentTechnician;
        this.currentTechnicianID = currentTechnician.getID();
    }
    
    // UI Interface Design
    public void AppointList(){
        
        // Frame
        JFrame frame = new JFrame("Appointment List");
        frame.setLayout(null);
        frame.setSize(800,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        
        // Label
        JLabel title = new JLabel("Appointment List");
        JLabel label1 = new JLabel("Choose one appointment record to check or review");
        
        title.setBounds(25,15,200,30);
        label1.setBounds(25,45,500,30);
        
        // Combo Box
        JComboBox<String> cmb_appointments = new JComboBox<>();
        cmb_appointments.setBounds(25,90,400,30);
        cmb_appointments.addItem("--- Select Appointment ---");
        
        // Button
        JButton btn_check = new JButton("Check & Review");
        JButton btn_feedback = new JButton("Provide Feedback");
        JButton btn_quit = new JButton("Quit");
        
        btn_check.setBounds(25, 150, 200, 30);
        btn_quit.setBounds(265, 150, 150, 30);
        btn_feedback.setBounds(430, 150, 200, 30);
        
        // Button Action Event
        btn_check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = cmb_appointments.getSelectedIndex();
            if (selectedIndex <= 0){
                    JOptionPane.showMessageDialog(frame,
                                                  "Please select an appointment",
                                                  "No Selection",
                                                  JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                ReadAppointment selectedAppt = filteredAppointments.get(selectedIndex - 1);                
                frame.dispose();
                AppointmentDetails apd = new AppointmentDetails(selectedAppt, currentTechnician);
                apd.AppointDetails();
            }
        });
        
        btn_quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                TechnicianDashBoard tdb = new TechnicianDashBoard(currentTechnician);
                tdb.TechDashBoard();
            }
        });
        
        btn_feedback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                int selectedIndex = cmb_appointments.getSelectedIndex();
                if (selectedIndex <= 0){
                    JOptionPane.showMessageDialog(frame,
                                                  "Please select an appointment before providing feedback.",
                                                  "No Selection",
                                                  JOptionPane.WARNING_MESSAGE);
                    
                    return;
                }
                
                ReadAppointment selectedAppt = filteredAppointments.get(selectedIndex - 1);
                String appointID = selectedAppt.getAppointID();
                String existingFeedback = selectedAppt.getTechnicianFeedback();
                
                JDialog feedbackDialog = new JDialog();
                feedbackDialog.setTitle("Provide Feedback - " + appointID);
                feedbackDialog.setSize(500, 400);
                feedbackDialog.setLayout(null);
                feedbackDialog.setLocationRelativeTo(frame);
                feedbackDialog.setModal(true);
                feedbackDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                
                JLabel dialogTitle = new JLabel("Feedback for Appointment: " + appointID);
                dialogTitle.setBounds(20,15,450,30);
                dialogTitle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
                
                // Long Text to provide feedback to related Appointment
                JTextArea txt_feedback = new JTextArea();
                txt_feedback.setFont(new Font("Times New Roman", Font.PLAIN, 15));
                txt_feedback.setLineWrap(true);
                txt_feedback.setWrapStyleWord(true);
                
                if (!existingFeedback.equals("-")){
                    txt_feedback.setText(existingFeedback);
                }
                
                JScrollPane scrollPane = new JScrollPane(txt_feedback);
                scrollPane.setBounds(20,55,445,230);
                
                JButton btn_submit = new JButton("Submit");
                JButton btn_cancel = new JButton("Cancel");
                
                btn_submit.setBounds(80,  310, 150, 35);
                btn_cancel.setBounds(260, 310, 150, 35);
                
                btn_submit.setFont(new Font("Times New Roman", Font.BOLD, 16));
                btn_cancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                
                btn_submit.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        String feedbackText = txt_feedback.getText().trim();
                        
                        if (feedbackText.isEmpty()){
                            JOptionPane.showMessageDialog(feedbackDialog,
                                                          "Feedback cannot be empty",
                                                          "Empty Feedback",
                                                          JOptionPane.WARNING_MESSAGE);
                            
                            return;
                        }
                        
                        boolean isSuccess = writeFeedbackToFile(appointID, feedbackText);
                        System.out.println("\n====== FEEDBACK SUBMIT STATUS (START) ======");
                        System.out.println("Status      : " + (isSuccess? "SUCCESS" : "FAILED"));
                        System.out.println("Appointment : " + appointID);
                        System.out.println("Technician  : " + currentTechnicianID);
                        
                        if (isSuccess){
                            System.out.println("Feedback    : " + feedbackText);
                        }
                        System.out.println("====== FEEDBACK SUBMIT STATUS (END) =======\n");
                        
                        
                        if (isSuccess){
                            JOptionPane.showMessageDialog(feedbackDialog,
                                                          "Feedback Submitted Successfully",
                                                          "Submit Successful",
                                                          JOptionPane.INFORMATION_MESSAGE);
                            feedbackDialog.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(feedbackDialog,
                                                           "Failed to write feedback to file",
                                                           "Submit Failed",
                                                           JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                
                btn_cancel.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
                       feedbackDialog.dispose();
                   }
                });
                
                feedbackDialog.add(dialogTitle);
                feedbackDialog.add(scrollPane);
                feedbackDialog.add(btn_submit);
                feedbackDialog.add(btn_cancel);
                feedbackDialog.setVisible(true);
            }
        });
        
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBounds(25,75,750,250);
        
        // Font Setting
        title.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        cmb_appointments.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btn_check.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btn_quit.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btn_feedback.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        // Display objects
        
        frame.add(title);
        frame.add(panel);
        panel.add(label1);
        panel.add(cmb_appointments);
        panel.add(btn_quit);
        panel.add(btn_check);
        panel.add(btn_feedback);
        frame.setVisible(true);
        
        loadAppointData(cmb_appointments);
    }
    
    public void loadAppointData(JComboBox <String> cmb_appointments){
        
        List<User> customers = User.loadFromFile("customers.txt", "Customer");
        
        List<ReadAppointment> allAppointments = ReadAppointment.readAppointments();
                
        filteredAppointments = new ArrayList<>();
        
        for (ReadAppointment appt : allAppointments){
            if (!appt.getTechnicianID().equalsIgnoreCase(currentTechnicianID)){
                continue;
            }
            
            String customerName = "Unknown";
            for (User u : customers){
                if(u.getID().equalsIgnoreCase(appt.getCustomerID())){
                    customerName = u.getName();
                    break;
                }
            }
            
            String displayText = appt.getAppointID() + " | " +
                                 appt.getCustomerID() + " | " +
                                 customerName;
            
            cmb_appointments.addItem(displayText);
            filteredAppointments.add(appt);
        }
        
        if (filteredAppointments.isEmpty()){
                JOptionPane.showMessageDialog(null,
                                              "No appointments found for Technician: " + currentTechnicianID,
                                              "No record found",
                                              JOptionPane.INFORMATION_MESSAGE);
        }
    }    

    private boolean writeFeedbackToFile(String targetAppointID, String feedbackText){
        String filePath = "appointments.txt";
        StringBuilder sb = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            
            while((line = br.readLine()) != null){
                
                if ((line.trim().isEmpty())){
                    sb.append("\n");
                    continue;
                }
                
                String[] data = line.split("\\|", -1);
                
                if (data.length == 11 && data[0].trim().equalsIgnoreCase(targetAppointID)){
                    data[9] = feedbackText;
                    sb.append(String.join("|", data)).append("\n");
                }
                else{
                    sb.append(line).append("\n");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            bw.write(sb.toString());
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    public static void main(String [] args){
        
    }
}
