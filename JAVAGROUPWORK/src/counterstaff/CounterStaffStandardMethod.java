
package counterstaff;


public interface CounterStaffStandardMethod {
    public void staffDashboard();
    
    public void addCustomer();
    
    public void manageCustomer();
    
    public void editCustomer(String customerId, String name, String contact, String email);
    
    public void createAppointment();
    
    public void collectPayment();
    
    public void receipt(String receiptId, String appointmentId, String customerName,
                        String serviceType, String techName, String date,
                        String timeSlot, String paymentMethod, String totalPaid);
    
    public void editProfile();
    
    
}
