package secondary;

import java.util.ArrayList;

public class Customers {
    private ArrayList<Customer> customerList;
    public Customers(){
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addCustomer(Customer customer){
        this.getCustomerList().add(customer);
    }

}
