/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import java.io.*;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author User
 */
public class ModifyRoles extends IdGeneretor{
    
    private JFrame Frame;
    
    private List<String[]> ViewTableData = new ArrayList<>();
    
    
    private String updID;
    private String updName;
    private String updRole;
    private String updEmail;
    private String updPhone;
    
    private JComboBox rolesBox;
    private int selectedrow = 0;
    private JTable ViewTable;
    private DefaultTableModel model;
    private final String[] columns = {"ID", "Name", "Role", "Email", "PhoneNumber"};;
    private boolean confirmFile = true ;
    
    
    
    public ModifyRoles(){
        
    }
    
    public void ModifyRolesUI(){
        Frame = new JFrame("ModifyRoles");
        Frame.setLayout(new BorderLayout(10,10));
        Frame.setSize(800,500);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
        
        //Search Main Panel
        
        JPanel SearchBarPabel = new JPanel();
        SearchBarPabel.setBorder(BorderFactory.createLineBorder(Color.GRAY,2,true));
        SearchBarPabel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        SearchBarPabel.setSize(20,10);
        Frame.add(SearchBarPabel, BorderLayout.NORTH);
        
        //Search Label
        
        JLabel SearchLabel = new JLabel("Search name/id: ");
        SearchLabel.setPreferredSize(new Dimension(110,25));
        SearchBarPabel.add(SearchLabel);
        
        //search textfield
        
        JTextField SearchField = new JTextField("Type Name or ID here");
        SearchField.setPreferredSize(new Dimension(200,25));
        SearchBarPabel.add(SearchField);
        
        //search focusListener
        SearchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (SearchField.getText().equals("Type Name or ID here")) {
                    SearchField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (SearchField.getText().isEmpty()) {
                    SearchField.setText("Type Name or ID here");
                }
            }
        });
        
        //search documentlistener
        SearchField.getDocument().addDocumentListener(new DocumentListener(){
           
            @Override
            public void insertUpdate(DocumentEvent e){
               SearchTable(SearchField.getText());
               
              
            }
            
            @Override
            public void removeUpdate(DocumentEvent e){
               SearchTable(SearchField.getText());
               
            }
            
            @Override
            public void changedUpdate(DocumentEvent e){
                
            }
        });
        
        //ComboBox of select roles file
        String[] roles = {"CounterStaff","Manager","Technician","Customer"};
        
        rolesBox = new JComboBox(roles);
        SearchBarPabel.add(rolesBox);
        
        // select roles ComboBox actionListener to avoid comboBox switched and data didn't change
        
        rolesBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                ViewTableData.clear();
                confirmFile = true;
                selectedrow = 0;
            }                 
        });
            
        
   
    
        //Big table main panel 
        String[][] tableData = ViewTableData.toArray(new String[ViewTableData.size()][]);
        
        model = new DefaultTableModel(tableData, columns);
        
        ViewTable = new JTable(model);
        
        ViewTable.getTableHeader().setReorderingAllowed(false);
        
        //JTable event
        ViewTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                selectedrow = ViewTable.getSelectedRow();
                
                if (e.getClickCount() == 1){
                    updID = ViewTable.getValueAt(selectedrow, 0).toString();
                    updName = ViewTable.getValueAt(selectedrow, 1).toString();
                    updRole = ViewTable.getValueAt(selectedrow, 2).toString();
                    updEmail = ViewTable.getValueAt(selectedrow, 3).toString();
                    updPhone = ViewTable.getValueAt(selectedrow, 4).toString();
                }
            } 
        });
        
        
        
        
        
        
        //JTable panel
        JScrollPane sp = new JScrollPane(ViewTable);
        Frame.add(sp, BorderLayout.CENTER);
        
        //four button UI panel
        JPanel btnpanel = new JPanel();
        btnpanel.setPreferredSize(new Dimension(300,50));
        btnpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
                      
        //five button UI
        
        JButton createbtn = new JButton("CREATE");
        createbtn.setPreferredSize(new Dimension(100,30));
        
        JButton readbtn = new JButton("READ/SAVE");
        readbtn.setPreferredSize(new Dimension(100,30));
        
        JButton updatebtn = new JButton("UPDATE");
        updatebtn.setPreferredSize(new Dimension(100,30));
        
        JButton deletebtn = new JButton("DELETE");
        deletebtn.setPreferredSize(new Dimension(100,30));
        
        JButton backbtn = new JButton("BACK");
        backbtn.setPreferredSize(new Dimension(100,30));
        
        btnpanel.add(createbtn);
        btnpanel.add(readbtn);
        btnpanel.add(updatebtn);
        btnpanel.add(deletebtn);
        btnpanel.add(backbtn);
        
        
        //frame add component
        Frame.add(btnpanel, BorderLayout.SOUTH);
        
        
        //event handler
        
        createbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(confirmFile){
                    JOptionPane.showMessageDialog(null, "Press The Read File Button First");
                }
                else{
                     CreateBtnFrame(); // open new window
                }
            }   
            
        });
        
        readbtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
               confirmFile = false;
               int firstcount = ViewTable.getRowCount();

                if (firstcount == 0 ) {
                    
                    loadfile(returnFile(rolesBox.getSelectedItem().toString()));
                    int secondcount = ViewTable.getRowCount();
                    
                    if(secondcount > 0 ){
                        
                      JOptionPane.showMessageDialog(null, "Load Successfully");  
                    }
                    else{
                        
                        JOptionPane.showMessageDialog(null, "Load Successfully, NO Data Found");
                        
                    }
                } 
                else {
                    savefile(returnFile(rolesBox.getSelectedItem().toString()));
                    JOptionPane.showMessageDialog(null, "Save Successfully");
                } 
           }
        });
        
        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  UpdateBtnFrame(selectedrow);   // open new window 
            }
        });
        
        deletebtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeRow(selectedrow);
                ViewTableData.remove(selectedrow);
            }
        });
        
        backbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Frame.dispose(); // close this window
            ManagerDashBoard back = new ManagerDashBoard();
            back.DashBoardUI();
            }
        });
          
    }
    
    
    
    
    //search name and id 
    public void SearchTable(String text){
        model.setRowCount(0); 

        if (text == null || text.isEmpty()) {
            for (String[] row : ViewTableData) {
                model.addRow(row);
            }
            return;
        }

        for (String[] row : ViewTableData) {
            if (row[0].contains(text) || row[1].contains(text)){
                model.addRow(row);
            }
        }
    }
    
    //Roles comboBox return specific file
    public String returnFile(String role){
        if(role == "CounterStaff"){
            return "CounterStaff.txt";
        }
        else if(role == "Manager"){
            return "Manager.txt";
        }
        else if(role == "Technician"){
            return "Technician.txt";
        }
        else{
            return "Customer.txt";
        }
            
    }
    
    
    
    //load file
    
    public void loadfile(String file){
       try{
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            String line;
            
            ViewTableData.clear();
            model.setRowCount(0);
            
            while ((line = br.readLine()) != null) {
                String[] body = line.split(",");
                ViewTableData.add(body);
                model.addRow(body);
            }
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
            }
    }
    
    //save file 
    
    public void savefile(String file){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            
            for (String[] data : ViewTableData){
                    String body = String.join(",", data);
                    bw.write(body);
                    bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){
            e.printStackTrace();
            }
    }
    
    
    public void UpdateBtnFrame(int row){    //similir method like CreateBtnFrame();
        JFrame updbtnframe = new JFrame("Update Form");
        updbtnframe.setLayout(new BorderLayout());
        updbtnframe.setLocationRelativeTo(Frame);
        updbtnframe.setSize(300, 250);
        
        JPanel updmainpanel = new JPanel();
        updmainpanel.setLayout(new GridLayout(4, 2, 10, 10));
        updmainpanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        
        JPanel btnpanel = new JPanel();
        btnpanel.setLayout(new FlowLayout());
        
        JButton updatebtn = new JButton("UPDATE");
        btnpanel.add(updatebtn);
        
        JButton backbtn = new JButton("BACK");
        btnpanel.add(backbtn);
        
        // Form Fields and label
        
        updbtnframe.add(new JLabel("ID number ------ ["+updID+"]" , SwingConstants.CENTER), BorderLayout.NORTH);
        
        updmainpanel.add(new JLabel("Name:", SwingConstants.LEFT));
        JTextField nameField = new JTextField(updName);
        updmainpanel.add(nameField);

        updmainpanel.add(new JLabel("Role:", SwingConstants.LEFT));
        JTextField roleField = new JTextField(updRole);
        updmainpanel.add(roleField);

        updmainpanel.add(new JLabel("Email:", SwingConstants.LEFT));
        JTextField emailField = new JTextField(updEmail);
        updmainpanel.add(emailField);

        updmainpanel.add(new JLabel("Phone Number:", SwingConstants.LEFT));
        JTextField phoneField = new JTextField(updPhone);
        updmainpanel.add(phoneField);
        
        
         //createbtn event
        updatebtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            ViewTable.setValueAt(nameField.getText(), row, 1);
            ViewTable.setValueAt(roleField.getText(), row, 2);
            ViewTable.setValueAt(emailField.getText(), row, 3);
            ViewTable.setValueAt (phoneField.getText(), row, 4);
            JOptionPane.showMessageDialog(null, "Record updated!");
            }

            // ****** REMEMBER ADD SAVE TO FILE <> LATER WILL BE ADDED
        });



        //backbtn event
        backbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updbtnframe.dispose(); // close this window
            }
        });
        
        
        //frame add component
        updbtnframe.add(updmainpanel,BorderLayout.CENTER);
        updbtnframe.add(btnpanel, BorderLayout.SOUTH);
        updbtnframe.setVisible(true);
        updbtnframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    
    
    
    
    public void CreateBtnFrame(){
        JFrame crtbtnframe = new JFrame("Infomation Form");
        crtbtnframe.setLocationRelativeTo(Frame);
        crtbtnframe.setLayout(new BorderLayout());
        crtbtnframe.setSize(300, 250);

        JPanel crtmainpanel = new JPanel();
        crtmainpanel.setLayout(new GridLayout(4, 2, 10, 10));
        crtmainpanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));


        //button panel
        JPanel btnpanel = new JPanel();
        btnpanel.setLayout(new FlowLayout());

        // two button
        JButton createbtn = new JButton("CREATE");
        btnpanel.add(createbtn);

        JButton backbtn = new JButton("BACK");
        btnpanel.add(backbtn);

        // Form Fields
        crtmainpanel.add(new JLabel("Name:", SwingConstants.LEFT));
        JTextField nameField = new JTextField();
        crtmainpanel.add(nameField);

        crtmainpanel.add(new JLabel("Role:", SwingConstants.LEFT));
         JTextField roleField = new JTextField();
        crtmainpanel.add(roleField);

        crtmainpanel.add(new JLabel("Email:", SwingConstants.LEFT));
        JTextField emailField = new JTextField();
        crtmainpanel.add(emailField);

        crtmainpanel.add(new JLabel("Phone Number:", SwingConstants.LEFT));
        JTextField phoneField = new JTextField();
        crtmainpanel.add(phoneField);

        
        //createbtn event
        createbtn.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String file = returnFile(rolesBox.getSelectedItem().toString());
            String id = IdAutoGenerate(file, ViewTableData.size());
            
            String[] newrow = {id,nameField.getText(),roleField.getText(),emailField.getText(),phoneField.getText()};
            ViewTableData.add(newrow);
            model.addRow(newrow);
            }

            // ****** REMEMBER ADD SAVE TO FILE <> LATER WILL BE ADDED
        });

        

        //backbtn event
        backbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            crtbtnframe.dispose(); // close this window
            }
        });


        //frame add component
        crtbtnframe.add(crtmainpanel,BorderLayout.CENTER);
        crtbtnframe.add(btnpanel, BorderLayout.SOUTH);
        crtbtnframe.setVisible(true);
        crtbtnframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    
    
    
    


}
