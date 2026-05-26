
package counterstaff;

import GeneralTools.User;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ManageCustomer extends JFrame {
    
    private User counterStaff;
    
    public ManageCustomer(CounterStaff counterStaff){
        this.counterStaff = counterStaff;
        
        setTitle("APU - Automotive Service Centre | Manage Customers");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        //Panels
            // Root Panel (holds every panels)
            JPanel rootPanel = new JPanel();
            rootPanel.setLayout(new BorderLayout());
            rootPanel.setBackground(Color.WHITE);
            rootPanel.setBorder(BorderFactory.createEmptyBorder(40, 140, 40, 140));
            add(rootPanel);
            
            // Header Panel (holds title and back button)
            JPanel headerPanel = new JPanel();
            headerPanel.setLayout(new BorderLayout());
            headerPanel.setBackground(Color.WHITE);
            rootPanel.add(headerPanel, BorderLayout.NORTH);
                // Left Panel
                JPanel headerLeftPanel = new JPanel();
                headerLeftPanel.setLayout(new BoxLayout(headerLeftPanel, BoxLayout.Y_AXIS));
                headerLeftPanel.setBackground(Color.WHITE);
                headerPanel.add(headerLeftPanel, BorderLayout.WEST);
                
                //Label
                JLabel titleLabel = new JLabel("Manage Customers");
                titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
                titleLabel.setForeground(new Color(218, 87, 0));
                headerLeftPanel.add(titleLabel);
                
                JLabel  subLabel = new JLabel("APU Automotive Service Centre");
                subLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                subLabel.setForeground(new Color(69, 69, 69));
                headerLeftPanel.add(subLabel);
                
                //Button
                JButton backButton = new JButton("← Back");
                backButton.setBackground(Color.BLACK);
                backButton.setForeground(Color.WHITE);
                backButton.setFont(new Font("Arial", Font.BOLD, 14));
                backButton.setFocusPainted(false);
                headerPanel.add(backButton, BorderLayout.EAST);
                
            // Body Panel (holds search bar, table and buttons)
            JPanel bodyPanel = new JPanel();
            bodyPanel.setLayout(new BorderLayout());
            bodyPanel.setBackground(Color.WHITE);
            rootPanel.add(bodyPanel, BorderLayout.CENTER);
            
                // Search Panel (holds search field and search button)
                JPanel searchPanel = new JPanel();
                searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
                searchPanel.setBackground(Color.WHITE);
                searchPanel.setBorder(BorderFactory.createEmptyBorder(16, 0, 14, 0));
                bodyPanel.add(searchPanel, BorderLayout.NORTH);
                    //Search field
                    JTextField searchField = new JTextField("Search by name, email or phone...", 62);
                    searchField.setForeground(Color.GRAY);
                    searchField.setFont(new Font("Arial", Font.PLAIN, 14));
                    searchField.setPreferredSize(new Dimension(300, 35));
                    searchPanel.add(searchField);                    
                        // Focus Listeners
                        searchField.addFocusListener(new FocusAdapter() {
                            public void focusGained(FocusEvent e) {
                                // Clear the hint text when user clicked on the field
                                if (searchField.getText().equals("Search by name, email or phone...")) {
                                    searchField.setText("");
                                    searchField.setForeground(Color.BLACK);
                                }
                            }

                            public void focusLost(FocusEvent e) {
                                //bring back hint when user clicked away
                                if (searchField.getText().isEmpty()) {
                                    searchField.setText("Search by name, email or phone...");
                                    searchField.setForeground(Color.GRAY);
                                }
                            }
                        });                    
                    
                    // create a gap between search field and button
                    searchPanel.add(Box.createHorizontalStrut(20));
                    
                    //Button
                    JButton searchButton = new JButton("SEARCH");
                    searchButton.setBackground(new Color(218, 87, 0));
                    searchButton.setForeground(Color.WHITE);
                    searchButton.setFont(new Font("Arial", Font.BOLD, 14));
                    searchButton.setFocusPainted(false);
                    searchButton.setBorderPainted(false);
                    searchButton.setPreferredSize(new Dimension(100, 35));
                    searchPanel.add(searchButton);
                    
                // Table (Show customer info)
                String[] columns = {"Customer ID", "Name", "Contact Number", "Email"};
                
                // Load data from customers.txt
                ArrayList<String[]> customerList = new ArrayList<>();
                java.util.List<String> lines = FileManager.readFile("customers.txt");
                
                for (String line : lines) {
                    String[] parts = line.split("\\|");
                    customerList.add(parts);
                }
                
                DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                
                for (String[] parts : customerList) {
                    tableModel.addRow(new String[] {
                        parts[0], // Customer ID
                        parts[1], // Name
                        parts[2], // Contact No
                        parts[3]  // Email
                    });
                    
                }
                
                JTable customerTable = new JTable(tableModel);
                customerTable.setFont(new Font("Arial", Font.PLAIN, 14));
                customerTable.setRowHeight(35);
                customerTable.setGridColor(new Color(238, 238, 238));
                customerTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
                customerTable.getTableHeader().setBackground(new Color(58, 58, 58));
                customerTable.getTableHeader().setForeground(Color.WHITE);
                customerTable.setSelectionBackground(new Color(255, 229, 208));
                customerTable.setSelectionForeground(Color.BLACK);
                    
                    // Wrap table in a scroll pane
                    JScrollPane scrollPane = new JScrollPane(customerTable);
                    scrollPane.setBorder(BorderFactory.createLineBorder(new Color(221, 221, 221)));
                    bodyPanel.add(scrollPane, BorderLayout.CENTER);
                    
                // Bottom Panel (holds Add, Edit and Delete buttons)
                JPanel bottomPanel = new JPanel();
                bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
                bottomPanel.setBackground(Color.WHITE);
                bottomPanel.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
                bodyPanel.add(bottomPanel, BorderLayout.SOUTH);
                    //Button
                    //Add Button
                    JButton addButton = new JButton("+ ADD CUSTOMER");
                    addButton.setBackground(new Color(218, 87, 0));
                    addButton.setForeground(Color.WHITE);
                    addButton.setFont(new Font("Arial", Font.BOLD, 14));
                    addButton.setFocusPainted(false);
                    addButton.setBorderPainted(false);
                    addButton.setPreferredSize(new Dimension(200, 38));
                    bottomPanel.add(addButton);
                    
                    bottomPanel.add(Box.createHorizontalStrut(12));
                    
                    //Edit Button
                    JButton editButton = new JButton("EDIT");
                    editButton.setBackground(new Color(58, 58, 58));
                    editButton.setForeground(Color.WHITE);
                    editButton.setFont(new Font("Arial", Font.BOLD, 14));
                    editButton.setFocusPainted(false);
                    editButton.setBorderPainted(false);
                    editButton.setPreferredSize(new Dimension(100, 38));
                    editButton.setEnabled(false);
                    bottomPanel.add(editButton);
                    
                    bottomPanel.add(Box.createHorizontalStrut(12));
                    
                    //Delete Button
                    JButton delButton = new JButton("DELETE");
                    delButton.setBackground(Color.WHITE);
                    delButton.setForeground(new Color(218, 87, 0));
                    delButton.setFont(new Font("Arial", Font.BOLD, 14));
                    delButton.setFocusPainted(false);
                    delButton.setBorderPainted(true);
                    delButton.setPreferredSize(new Dimension(110, 38));
                    delButton.setEnabled(false);
                    bottomPanel.add(delButton);
                    
            // Action Listeners
            backButton.addActionListener(e -> {
                dispose();
                new StaffDashboard(counterStaff);
            });
                
              //Search button
              searchButton.addActionListener(e -> {
                 String query = searchField.getText().trim().toLowerCase();
                 
                 // Clear the table
                 tableModel.setRowCount(0);
                 
                 // Reload from file and filter
                 ArrayList<String[]> customerList2 = new ArrayList<>();
                 java.util.List<String> allLines = FileManager.readFile("customers.txt");
                 
                 for (String line : allLines) {
                     String[] parts = line.split("\\|");
                     // Make sure parts has all 4 required columns before adding into the list
                     if (parts.length >= 4) {
                        customerList2.add(parts);
                     }
                 }
                 
                 // If search field is empty or with a placeholder, reload all
                 if (query.isEmpty() || query.equals("search by name, email or phone...")) {
                     for (String[] parts : customerList2) {
                         tableModel.addRow(new String[]{
                             parts[0], // Customer ID
                             parts[1], // Name
                             parts[2], // Contact No
                             parts[3] // Email
                         });
                     }
                 }
                 else {
                     // Filter by query
                     for (String[] parts : customerList2) {
                         if (parts[0].toLowerCase().contains(query)||
                             parts[1].toLowerCase().contains(query)||
                             parts[2].toLowerCase().contains(query)||
                             parts[3].toLowerCase().contains(query)) {
                             tableModel.addRow(new String[] {
                                 parts[0], // Customer ID
                                 parts[1], // Name
                                 parts[2], // Contact No
                                 parts[3] // Email
                             });
                         }
                     }
                 }
              });
              
            addButton.addActionListener(e ->{
                dispose();
                new AddCustomer(counterStaff);
            });
                
            editButton.addActionListener(e -> {
                int selectedRow = customerTable.getSelectedRow();
                String customerId = (String) tableModel.getValueAt(selectedRow, 0);
                String customerName = (String) tableModel.getValueAt(selectedRow, 1);
                String customerContact = (String) tableModel.getValueAt(selectedRow, 2);
                String customerEmail = (String) tableModel.getValueAt(selectedRow, 3);
                
                dispose();
                new EditCustomer(counterStaff, customerId, customerName, customerContact, customerEmail);
            });
                
            delButton.addActionListener(e -> {
                int selectedRow = customerTable.getSelectedRow();
                String customerId = (String) tableModel.getValueAt(selectedRow, 0);
                String customerName = (String) tableModel.getValueAt(selectedRow, 1);
                
                int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete " + customerName + "?",
                    "Delete Customer",
                    JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    // Read all lines from file
                    java.util.List<String> deleteLines = FileManager.readFile("customers.txt");
                    
                    // Remove the line that matches with the selected row Customer ID
                    for (int i = 0; i < deleteLines.size(); i ++) {
                        String[] parts = deleteLines.get(i).split("\\|");
                        if (parts[0].equals(customerId)) {
                            deleteLines.remove(i);
                            break;
                        }
                    }
                    
                    // Write updated list into txt
                    FileManager.writeFile("customers.txt", deleteLines);
                    
                    // Remove row from table
                    tableModel.removeRow(selectedRow);
                    
                    JOptionPane.showMessageDialog(this, 
                            customerName + " has been deleted successfully!",
                            "Deleted",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            });
                
            //Enable Edit and Delete buttons only when a row is selected
            customerTable.getSelectionModel().addListSelectionListener(e -> {
                boolean selected = customerTable.getSelectedRow() != -1;
                editButton.setEnabled(selected);
                delButton.setEnabled(selected);
            });
        
            
            setVisible(true);
    }
    
    public static void main(String[] args){
        CounterStaff test = new CounterStaff("S000", "Test", "010-0000000", "test@gmail.com", "123");
        
        new ManageCustomer(test);
    }
}

