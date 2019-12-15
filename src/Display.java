import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
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
    HBox organize = new HBox(100);
    ArrayList<Final> students = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception{
        Scanner read = new Scanner(new File("results.csv"));
        while (read.hasNextLine()){
            String[] line = read.nextLine().split(" ");
            String[] C = new String[8];
            for (int i = 0; i < 8; i++) C[i] = line[i + 3];
            Final current = new Final(line[0], line[1], Integer.parseInt(line[2]), C);
            students.add(current);
        }
        //Main page
        ObservableList<Group> lol = FXCollections.observableArrayList();
        for (Final student: students){
            Group temp = new Group();
            Text FNS = new Text(student.FN);
            FNS.setFont(new Font("Arial", 50));
            FNS.setTranslateX(280);
            temp.getChildren().add(FNS);
            Text LNS = new Text(student.LN);
            LNS.setTranslateX(580);
            LNS.setFont(new Font("Arial", 50));
            temp.getChildren().add(LNS);
            Text GS = new Text(Integer.toString(student.G));
            GS.setTranslateX(880);
            GS.setFont(new Font("Arial", 50));
            temp.getChildren().add(GS);
            lol.add(temp);
        }
        ListView LV = new ListView(lol);
        LV.setPrefSize(1000, 600);
        LV.setTranslateX(183);
        LV.setTranslateY(100);
        root.getChildren().add(LV);
        /*
        organize.setTranslateX(280);
        ListView FNSL = new ListView(FNS);
        FNSL.setTranslateY(200);
        FNSL.setPrefSize(800, 600);
        FNSL.setEditable(true);
        organize.getChildren().add(FNSL);
        ListView LNSL = new ListView(LNS);
        LNSL.setTranslateY(200);
        LNSL.setPrefSize(800, 600);
        LNSL.setEditable(true);
        organize.getChildren().add(LNSL);
        ListView LNSL = new ListView(LNS);
        LNSL.setTranslateY(200);
        LNSL.setPrefSize(800, 600);
        LNSL.setEditable(true);
        organize.getChildren().add(LNSL);

         */

        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
}