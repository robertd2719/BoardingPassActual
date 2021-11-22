package secondary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Customers customers = new Customers();
        customers = loadData(customers);
        // Borderpane for root.
        BorderPane root = new BorderPane();

//        MENU BAR
        MenuBar mBar = new MenuBar();
        Menu fileMenu = new Menu("File");

//        New Items for fileMenu
        MenuItem newCustomer = new MenuItem("New Customer");
        fileMenu.getItems().addAll(newCustomer);
        newCustomer.setOnAction(e->{
            Customer customer = new NewCustomerStage().getCustomer();
            System.out.println(customer);

        });

//          Add all menus to bar
        mBar.getMenus().addAll(fileMenu);
        ToolBar tBar = new ToolBar();
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        tBar.getItems().addAll(button1,button2);
        root.setTop(mBar);

        // Create our TableView with the customer data
        TableView<Customer> customerTableView = new TableView<>();
        // Create the columns to add to the tableview
        TableColumn<Customer,String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));

        TableColumn<Customer, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));

        TableColumn<Customer, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("age"));

        TableColumn<Customer, Gender> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<Customer, Gender>("gender"));

        TableColumn<Customer, Double> discountColumn = new TableColumn<>("Discount");
        discountColumn.setCellValueFactory(new PropertyValueFactory<Customer, Double>("discount"));

        customerTableView.getColumns().add(firstNameColumn);
        customerTableView.getColumns().add(lastNameColumn);
        customerTableView.getColumns().add(ageColumn);
        customerTableView.getColumns().add(genderColumn);
        customerTableView.getColumns().add(discountColumn);

        //load data from customers into the table
//        for(Customer customer: customers.getCustomerList()){
//            customerTableView.getItems().add(customer);
//        }
        for (Customer customer: customers.getCustomerList()){
            customerTableView.getItems().add(customer);
        }

        root.setCenter(customerTableView);

        Scene scene1 = new Scene(root,400,400);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    public static Customers loadData(Customers customers){
        Customer customer1 = new Customer("Robert","Deal","22",Gender.MALE);
        Customer customer2 = new Customer("Mary","Jones","10",Gender.FEMALE);
        Customer customer3 = new Customer("Judge","Judy","88",Gender.FEMALE);
        Customer customer4 = new Customer("Opie","Taylor","8",Gender.MALE);
        customers.addCustomer(customer1);
        customers.addCustomer(customer2);
        customers.addCustomer(customer3);
        customers.addCustomer(customer4);
        return customers;
    }
    public static void main(String[] args) {

        launch();
    }

}
