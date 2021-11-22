package secondary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;


public class NewCustomerStage extends Stage {
    static Customer customer;
    TextField firstNameField;
    TextField lastNameField;
    TextField ageField;
    ChoiceBox<Gender> genderChoiceBox;

    public Customer getCustomer() {
        int height = 25;
        Stage stage = new Stage();
        BorderPane root = new BorderPane();

        VBox boxLeft = new VBox(10);
        boxLeft.setPadding(new Insets(10));
        boxLeft.setAlignment(Pos.TOP_CENTER);
        Label firstNameLabel = new Label("First Name: ");
        firstNameLabel.setAlignment(Pos.BASELINE_CENTER);
        firstNameLabel.setMinHeight(height);
        Label lastNameLabel = new Label("Last Name: ");
        lastNameLabel.setAlignment(Pos.BASELINE_CENTER);
        lastNameLabel.setMinHeight(height);
        Label ageLabel = new Label("Age");
        ageLabel.setAlignment(Pos.BASELINE_CENTER);
        ageLabel.setMinHeight(height);
        Label genderLabel = new Label("Gender");
        genderLabel.setAlignment(Pos.BASELINE_CENTER);
        genderLabel.setMinHeight(height);
        boxLeft.getChildren().addAll(firstNameLabel,lastNameLabel,ageLabel,genderLabel);

        VBox boxCenter = new VBox(10);
        boxCenter.setPadding(new Insets(10));
        boxCenter.setAlignment(Pos.TOP_CENTER);
        firstNameField = new TextField();
        lastNameField = new TextField();
        ageField = new TextField();
//        Apparently you need to parse all of these.
        genderChoiceBox = new ChoiceBox<>();
        genderChoiceBox.getItems().setAll(Gender.values());
        boxCenter.getChildren().addAll(firstNameField,lastNameField,ageField,genderChoiceBox);

        Button createButton = new Button("Create Customer");
        createButton.setStyle("-fx-text-fill: cornflowerblue");
        createButton.setOnAction(e->{
            String firstName = this.firstNameField.getText();
            String lastName = this.lastNameField.getText();
            String age = this.ageField.getText();
            Gender gender = this.genderChoiceBox.getValue();
            customer = new Customer(firstName,lastName,age,gender);
        });
        System.out.println(customer);
        HBox bottomBox = new HBox(10);
        bottomBox.setPadding(new Insets(10));
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setMinHeight(100);
        bottomBox.getChildren().add(createButton);

        root.setLeft(boxLeft);
        root.setCenter(boxCenter);
        root.setBottom(bottomBox);
        stage.setScene(new Scene(root,300,300));
        stage.showAndWait();

        return customer;
    }


}
