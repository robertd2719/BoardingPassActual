import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopUp extends Stage {

    public PopUp(String message){
        Stage stage = new Stage();
        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        Label outLabel = new Label("User "+message);
        root.getChildren().addAll(outLabel);

        stage.setScene(new Scene(root,200,100));
        stage.show();
    }
}
