import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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

    Group oneRoot = new Group();
    Scene oneScene = new Scene(oneRoot, 1366, 768);

    Group root = new Group();
    Scene scene = new Scene(root, 1366, 768);
    ArrayList<Final> students = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception{
        scene.getStylesheets().add("style1.css");
        oneScene.getStylesheets().add("style2.css");
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
        for (int i = 0; i < students.size(); i++){
            Final student = students.get(i);
            Group temp = new Group();
            Text FNS = new Text(student.FN);
            FNS.setTranslateX(280);
            Text LNS = new Text(student.LN);
            LNS.setTranslateX(580);
            Text GS = new Text(Integer.toString(student.G));
            GS.setTranslateX(880);
            Button details = new Button("Details");
            details.setTranslateX(1000);
            details.setTranslateY(-50);
            details.setOnAction(e -> {
                oneRoot.getChildren().clear();
                Text FNT = new Text(student.FN);
                FNT.getStyleClass().add("details_header");
                FNT.setTranslateX(100);
                FNT.setTranslateY(50);
                oneRoot.getChildren().add(FNT);
                stage.setScene(oneScene);
                stage.setMaximized(true);

                Button goBack = new Button("Return");
                goBack.setId("return_button");
                goBack.setTranslateX(500);
                goBack.setTranslateY(400);
                goBack.setOnAction(ef -> {
                    stage.setScene(scene);
                    stage.setMaximized(true);
                });
                oneRoot.getChildren().add(goBack);
            });
            temp.getChildren().addAll(FNS, LNS, GS, details);
            lol.add(temp);
        }
        ListView LV = new ListView(lol);
        LV.setPrefSize(1000, 600);
        LV.setTranslateX(183);
        LV.setTranslateY(100);
        root.getChildren().add(LV);

        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
}