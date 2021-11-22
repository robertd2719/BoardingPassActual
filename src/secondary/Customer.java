package secondary;

// Storage of customer information
public class Customer {
    String firstName;
    String lastName;
    String age;
    Gender gender;
    double discount;  //0.0 if no discount

    // Make sure we also have a no-args constructor
    public Customer(){
        this.firstName = "";
        this.lastName = "";
        this.age = "";
        this.gender = null;
        this.discount = 0;
    }

    public Customer(String firstName, String lastName, String age, Gender gender) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        System.out.println("New Customer was created!!!");
        if (Integer.parseInt(age)>60){
            this.discount = 0.6;
        } else if ( Integer.parseInt(age)<12){
            this.discount = 0.5;
        } else if  ( this.gender == Gender.FEMALE){
            this.discount = 0.25;
        } else {
            this.discount = 0;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                ", discount=" + discount +
                '}';
    }
}
