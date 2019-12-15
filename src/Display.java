import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
                stage.setScene(oneScene);
                stage.setMaximized(true);

                VBox wrapper = new VBox();
                wrapper.setPrefWidth(oneScene.getWidth()-66);
                wrapper.setId("wrapper");
                wrapper.setAlignment(Pos.CENTER);
                wrapper.setSpacing(50);

                Text FNT = new Text(student.FN+ " " +student.LN);
                FNT.setId("name");
                FNT.getStyleClass().add("details_header");
                //FNT.setTranslateX(480);
                //FNT.setTranslateY(100);

                wrapper.getChildren().add(FNT);

                VBox semester1 = new VBox();
                VBox semester2 = new VBox();
                semester1.setAlignment(Pos.CENTER);
                semester2.setAlignment(Pos.CENTER);
                Text sem1Title = new Text("Semester 1");
                Text sem2Title = new Text("Semester 2");
                Text course1 = new Text(student.C[0]);
                Text course2 = new Text(student.C[1]);
                Text course3 = new Text(student.C[2]);
                Text course4 = new Text(student.C[3]);
                Text course5 = new Text(student.C[4]);
                Text course6 = new Text(student.C[5]);
                Text course7 = new Text(student.C[6]);
                Text course8 = new Text(student.C[7]);

                semester1.getChildren().addAll(sem1Title,course1, course2, course3, course4);
                semester2.getChildren().addAll(sem2Title,course5, course6, course7, course8);

                sem1Title.getStyleClass().add("course");
                sem2Title.getStyleClass().add("course");

                course1.getStyleClass().add("course");
                course2.getStyleClass().add("course");
                course3.getStyleClass().add("course");
                course4.getStyleClass().add("course");
                course5.getStyleClass().add("course");
                course6.getStyleClass().add("course");
                course7.getStyleClass().add("course");
                course8.getStyleClass().add("course");


                HBox courseContainer = new HBox();
                courseContainer.setSpacing(100);
                courseContainer.setId("courses_container");
                //courseContainer.setTranslateX(400);
                //courseContainer.setTranslateY(200);
                courseContainer.setAlignment(Pos.CENTER);
                courseContainer.getChildren().addAll(semester1, semester2);


                Button goBack = new Button("Return");
                goBack.setId("return_button");
                //goBack.setTranslateX(530);
                //goBack.setTranslateY(500);
                goBack.setOnAction(ef -> {
                    stage.setScene(scene);
                    stage.setMaximized(true);
                });
                wrapper.getChildren().add(courseContainer);
                wrapper.getChildren().add(goBack);
                oneRoot.getChildren().addAll( wrapper);

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