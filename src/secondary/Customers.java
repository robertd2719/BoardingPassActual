package secondary;

import java.util.ArrayList;

public class Customers {
    public ArrayList<Customer> customerList;

    public Customers(){
        this.customerList = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerList() {
        return this.customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addCustomer(Customer customer){
        this.customerList.add(customer);
    }

}
