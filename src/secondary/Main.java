package secondary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;


public class Main extends Application {
    public Customers customers;

    @Override
    public void start(Stage primaryStage) throws Exception {
        customers = new Customers();

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
        root.setBottom(tBar);

        // Create our TableView with the customer data
        TableView<Customer> customerTableView = new TableView<>();
        // Create the columns to add to the tableview
        TableColumn<Customer,String>

        Scene scene1 = new Scene(root,400,400);
        primaryStage.setScene(scene1);
        primaryStage.show();



    }
    public static void main(String[] args) {
        launch();
    }

}
