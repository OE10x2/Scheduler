import java.util.ArrayList;
import java.util.HashMap;

public class Part2{
    //Input: HashMap of ArrayList of Students
    //Output: Sections
    public static void main(String[] args){
        Part1 lol = new Part1();
        lol.adjList();
        HashMap<String, ArrayList<Student>> list = lol.list;
        ArrayList<Student> test = list.get("ICS2O1");
        int cnt = 0;
        for (Student i: test){
            System.out.println(i.nameFirst);
            cnt++;
        }
        System.out.println(cnt);
    }
    //Population: 500
    //Courses: 15 17 22 24
    //Size: 25-30
}