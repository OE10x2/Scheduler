import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display extends Application{
    public static void main(String[] args){
        launch(args);
    }

    Group root = new Group();
    Scene scene = new Scene(root);


    @Override
    public void start(Stage stage) throws Exception{

        BorderPane pane = new BorderPane();
        HBox profile = new HBox();
        profile.getStylesheets().add("style1.css");
        Text lol = new Text("Hoang is cool");
        profile.getChildren().add(lol);
        pane.setTop(profile);
        root.getChildren().add(pane);

        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
}