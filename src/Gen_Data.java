import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Gen_Data{
    public ArrayList<String> courses = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        new Gen_Data().RUN();
    }
    public void RUN() throws Exception{
        File file = new File("Courses.csv");
        Scanner in = new Scanner(file);
        while (in.hasNextLine()){
            System.out.println("Course: " + in.nextLine());
            courses.add(in.nextLine());
        }
    }
}