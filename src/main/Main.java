package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

//        Parent root = FXMLLoader.load(getClass().getResource("primaryFXML.fxml"));
        VBox root = new VBox(10);
        Image image = new Image(getClass().getResourceAsStream("plane_city_view.png"));

        // Image -> ImageView
        ImageView cityView = new ImageView();
        cityView.setImage(image);
        cityView.setFitWidth(300);
        cityView.setPreserveRatio(true);

        // GridPane
        GridPane grid1 = new GridPane();

        // userName entry section
        Label userName = new Label("Name:");
        TextField userField = new TextField();

        // password entry section
        Label passWord = new Label("Password: ");
        PasswordField passField = new PasswordField();

        // GridPane ----------------------------------------------------------------->
        GridPane logGrid = new GridPane();
        // add the elements to the gridpane
        logGrid.add(userName,0,0,1,1);
        logGrid.add(userField,1,0,1,1);
        logGrid.add(passWord,0,1,1,1);
        logGrid.add(passField,1,1,1,1);
        // set view attributes
        logGrid.setPadding(new Insets(10,10,10,10));
        logGrid.setHgap(10);
        logGrid.setVgap(10);
        // GridPane ----------------------------------------------------------------->

        //BUTTONS ---------------------------------------------------------------------->

        // Button1 --------->
        Button button1 = new Button("Login ");
        button1.setId("button1");
        button1.setOnAction(e->{
            String message;
            if (userField.getText().equals("admin") && (passField.getText().equals("admin"))){
                message = "Authenticated";
            } else {
                message = "Not Authenticated";
            }
                PopUp authenticated = new PopUp(message);
        });

        // Button 2---------->
        Button button2 = new Button("Exit");
        button2.setId("button2");
        button2.setOnAction(e->primaryStage.close());
        //<---END BUTTONS ------------------------------------------------------------>

        // HBox--------->
        HBox buttonBox = new HBox(10);
        buttonBox.setId("button-box");
        buttonBox.getChildren().addAll(button1,button2);

        // add all children elements to the scene.
        root.getChildren().addAll(cityView,logGrid,buttonBox);

        // set initial scene for login -- can and will redesign.
        Scene scene1 = new Scene(root);
        scene1.getStylesheets().add("main/scene1Style.css");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

        // Main class runner
        public static void main (String[]args){
            launch();
        }
    }
