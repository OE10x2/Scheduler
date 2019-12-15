import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Display extends Application{
    public static void main(String[] args){
        launch(args);
    }

    Group root = new Group();
    Scene scene = new Scene(root);
    BorderPane pane = new BorderPane();
    HBox profile = new HBox();
    ArrayList<Final> students = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception{
        scene.getStylesheets().add("style1.css");

        Scanner read = new Scanner(new File("results.csv"));
        while (read.hasNextLine()){
            String[] line = read.nextLine().split(" ");
            String FN = line[0], LN = line[1];
            int G = Integer.parseInt(line[2]);
            String[] C = new String[8];
            for (int i = 0; i < 8; i++) C[i] = line[i + 3];
            Final current = new Final(line[0], line[1], Integer.parseInt(line[2]), C);
            students.add(current);
        }
        for (Final student: students){
            /*
            if (student.FN.equalsIgnoreCase("Divine")){
                Text name = new Text(student.FN + " " + student.LN);
                Text grade = new Text(Integer.toString(student.G));
                profile.getChildren().addAll(name, grade);
            }
             */
        }
        Text hoang = new Text("Hoang is cool");
        profile.getChildren().add(hoang);
        Rectangle rect = new Rectangle(300, 200);
        rect.getStyleClass().add("style1.css");
        pane.setCenter(rect);

        pane.setTop(profile);
        profile.getStylesheets().add("style1.css");
        root.getChildren().add(pane);

        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
}