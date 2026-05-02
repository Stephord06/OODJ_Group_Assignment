
package counterstaff;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ManageCustomer extends JFrame {
    
    public ManageCustomer(){
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
                String[] columns = {"Customer ID", "Name", "Email", "Phone Number"};
                String[][] data = {};
                
                JTable customerTable = new JTable(data, columns);
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
                new StaffDashboard();
            });
                
            addButton.addActionListener(e ->{
                dispose();
                new AddCustomer();
            });
                
            editButton.addActionListener(e -> {
                dispose();
                new EditCustomer();
            });
                
            delButton.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete this customer?",
                    "Delete Customer",
                    JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // TODO: delete selected row from file
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
        new ManageCustomer();
    }
}

