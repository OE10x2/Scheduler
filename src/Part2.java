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
    //Part 1: generate all possible timetables
    //Part 2: fit all students in; find error value
}