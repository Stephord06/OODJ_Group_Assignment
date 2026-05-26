
package counterstaff;

import GeneralTools.User;


public class CounterStaff extends User implements CounterStaffStandardMethod {
    
    public CounterStaff(String id, String name, String contact, String email, String password) {
        super(id, name, contact, email, password, "Counter Staff");
    }
    
    public void staffDashboard() {
        System.out.println("====== COUNTER STAFF DASHBOARD (START) ======");
        System.out.println("Staff ID: " + this.getID());
        System.out.println("Staff Name: " + this.getName());
        System.out.println("Role: " + this.getRole());
        System.out.println("====== COUNTER STAFF DASHBOARD (END) ======");
        StaffDashboard sd = new StaffDashboard(this);
     
    }
    
    public void addCustomer() {
        AddCustomer ac = new AddCustomer(this);
    }
    
    public void manageCustomer() {
        ManageCustomer mc = new ManageCustomer(this);
    }
    
    public void editCustomer(String customerId, String name, String contact, String email) {
        EditCustomer ec = new EditCustomer(this, customerId, name, contact, email);
    }
    
    public void createAppointment() {
        CreateAppointment ca = new CreateAppointment(this);
    }
    
    public void collectPayment() {
        CollectPayment cp = new CollectPayment(this);
    }
    
    public void receipt(String receiptId, String appointmentId, String customerName,
                        String serviceType, String techName, String date,
                        String timeSlot, String paymentMethod, String totalPaid) {
        Receipt rp = new Receipt(this, receiptId, appointmentId, customerName,
                                 serviceType, techName, date, timeSlot, paymentMethod,
                                 totalPaid);
    }
    
    public void editProfile() {
        EditProfile ep = new EditProfile(this);
    }
    
}
