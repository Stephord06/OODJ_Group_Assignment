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
import technician.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class AppointmentTable {
    
    Technician currentTechnician;
    
    private JTable table;
    private DefaultTableModel tableModel;
    private final String currentTechnicianID;
    
    public AppointmentTable(Technician currentTechnician){
        this.currentTechnician = currentTechnician;
        currentTechnicianID = currentTechnician.getID();
    }
    
    // UI Design 
    public void AppointRecordTable(){
        
        
        // Frame Setting
        JFrame frame = new JFrame("Appointment Record - " + currentTechnicianID);
        frame.setLayout(null);
        frame.setSize(980,580);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        // Label Setting
        JLabel title = new JLabel("Appointment Record Table");
        title.setBounds(0,20,844,40);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setBorder(BorderFactory.createEmptyBorder(28, 0, 16, 0));
        title.setForeground(new Color(40, 40, 40));
        
        // Button Setting
        JButton btn_reload = new JButton("⟳  Reload Appointment Record");
        JButton btn_update = new JButton("✓  Update Appointment Status");
        JButton btn_cancel = new JButton("✕  Cancel Update");
        
        btn_reload.setBounds(60,445,240,36);
        btn_update.setBounds(312,445,240,36);
        btn_cancel.setBounds(564,445,160,36);
        
        btn_reload.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btn_update.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btn_cancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        
        // Button Action Event Setting
        btn_update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1){
                    JOptionPane.showMessageDialog(null,
                                                  "Please select an appointment row to update",
                                                  "No Selection",
                                                  JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                String appointID = (String) tableModel.getValueAt(selectedRow, 0);
                String currentStatus = (String) tableModel.getValueAt(selectedRow, 9);
                
                String[] statusOption = {"Pending", "Completed"};
                String newStatus = (String) JOptionPane.showInputDialog(
                                            frame,
                                            "Update status for Appointment: " + appointID,
                                            "Update Appointment Status",
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,
                                            statusOption,
                                            currentStatus);
                
                if (newStatus != null && !newStatus.equals(currentStatus)){
                    if (updateStatusInFile(appointID, newStatus)){
                        tableModel.setValueAt(newStatus, selectedRow, 9);
                        JOptionPane.showMessageDialog(frame,
                                                      "Status updated to: " + newStatus,
                                                      "Update Successful",
                                                      JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,
                                                      "Failed to updated appointment to file",
                                                      "Update Error",
                                                      JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        btn_reload.addActionListener(new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent e){
                loadTableData();
            }
        });
        
        btn_cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                TechnicianDashBoard tdb = new TechnicianDashBoard(currentTechnician);
                tdb.TechDashBoard();
                
            }
        });
        
        // Table Setting
        // Set the Column name
        String[] columnName = {
            "Appointment ID", "Customer ID", "Customer Name", "Staff ID", "Staff Name", "Service Type", "Date", 
            "Time (Start)", "Time (End)", "Status"};
        
        // Default the table model, and set not for edit the table
        tableModel = new DefaultTableModel(columnName, 0){
          @Override
          public boolean isCellEditable(int row, int col){
              return false;
          }
        };
        
        
        // JTable Size Setting
        table = new JTable(tableModel);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setRowHeight(50);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setGridColor(new Color(210, 225, 240));
        table.setBackground(new Color(236, 245, 253));
        table.setSelectionBackground(new Color(196, 221, 244));
        table.setSelectionForeground(Color.BLACK);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // JTable Heading Setting
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        header.setPreferredSize(new Dimension(0, 46));
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value,
                boolean isSel, boolean hasFocus, int row, int col) {
                    JLabel lbl = new JLabel(value == null ? "NULL" : value.toString(), SwingConstants.CENTER);
                    lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                    lbl.setForeground(new Color(42, 110, 181));
                    lbl.setBackground(new Color(212, 232, 249));
                    lbl.setOpaque(true);
                    lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(180, 212, 240)));
                    return lbl;
            }
        });
        
        // Column Width Setting
        int[] colWidth = {120, 100, 160, 90, 130, 120, 100, 100, 100, 100};
        
            // Set for loop to count the fixed width of the table and get the column information and size, etc. into JTable
        for (int i = 0; i < colWidth.length; i++){
            table.getColumnModel().getColumn(i).setPreferredWidth(colWidth[i]);
        }
        
        
        // Set the allign of the data (CENTER)
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value,
                    boolean isSel, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(t, value, isSel, hasFocus, row, col);
                setHorizontalAlignment(SwingConstants.CENTER);
                setBackground(isSel ? new Color(196, 221, 244) : new Color(236, 245, 253));
                setFont(new Font("Times New Roman", Font.PLAIN, 14));
                setBorder(BorderFactory.createEmptyBorder());
                return this;
            }
        };
        
        for(int i = 0; i < columnName.length; i++){
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        // Scroll Panel Setting into JTable
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        scrollPane.setBounds(20,70,940,360);
        scrollPane.getViewport().setBackground(new Color(236, 245, 253));
        
        
        
        // Display Frame & Object
        frame.add(scrollPane);
        frame.add(title);
        frame.add(btn_reload);
        frame.add(btn_update);
        frame.add(btn_cancel);
        frame.setVisible(true);
        
        loadTableData();
    }
    
    private void loadTableData(){
        
        // To clear off the data of appointment record
        tableModel.setRowCount(0);
        
        List<User> customers = User.loadFromFile("customers.txt", "Customer");
        
        List<User> staffs = User.loadFromFile("counterStaffs.txt", "Counter Staff");
        
        List<ReadAppointment> appointments = ReadAppointment.readAppointments();
        
        int count = 0;
        
        for (ReadAppointment appt : appointments){
            
            if (!appt.getTechnicianID().equalsIgnoreCase(currentTechnicianID)){
                continue;
            }
                
            String customerName = findNamebyID(customers, appt.getCustomerID());
            String staffName = findNamebyID(staffs, appt.getstaffID());
                
            tableModel.addRow(new Object[]{
                appt.getAppointID(),
                appt.getCustomerID(),
                customerName,
                appt.getstaffID(),
                staffName,
                appt.getServiceType(),
                appt.getDate(),
                appt.getTimeStart(),
                appt.getTimeEnd(),
                appt.getStatusDescription()
            });
            count = count + 1;
        }
            
        if (count == 0){
            JOptionPane.showMessageDialog(null,
                                          "No appointments found for Technician ID" + currentTechnicianID,
                                          "No Records",
                                          JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    private String findNamebyID(List<User> userList, String id){
        for (User u : userList){
            if(u.getID().equalsIgnoreCase(id)){
                return u.getName();
            }
        }
        return "Unknown";
    }
    
    private boolean updateStatusInFile(String targetAppointID, String newStatus){
        String filePath = "appointments.txt";
        StringBuilder sb = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null){
                
                if(line.trim().isEmpty()){
                    sb.append("\n");
                    continue;
                }
                String[] data = line.split("\\|", -1);
                if (data.length == 11 && data[0].trim().equalsIgnoreCase(targetAppointID)){
                    data[10] = newStatus;               // appointment Status
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
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    }
}
            
    