import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Part2{
    //Input: HashMap of ArrayList of Students
    //Output: Sections
    ArrayList<String> course9 = new ArrayList<>();
    ArrayList<String> course10 = new ArrayList<>();
    ArrayList<String> course11 = new ArrayList<>();
    ArrayList<String> course12 = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    double MAX_SIZE = 32;
    public static void main(String[] args) throws Exception{
        new Part2().RUN();
    }
    //Population: 500 (125 126 114 135)
    //Courses: 15 17 22 24
    //Size: 25-32
    //Maximum: 125 (including alt) => 4 sections maximum
    public void RUN() throws Exception{
        Scanner courseS = new Scanner(new File("Courses.csv"));
        while (courseS.hasNextLine()){
            String course = courseS.nextLine();
            if (course.charAt(3) == '1') course9.add(course);
            if (course.charAt(3) == '2') course10.add(course);
            if (course.charAt(3) == '3') course11.add(course);
            if (course.charAt(3) == '4') course12.add(course);
        }

        Part1 lol = new Part1();
        lol.adjList();
        HashMap<String, ArrayList<Student>> list = lol.list;
        int[] perSection = new int[8]; //8 sections
        for (String c: course9){
            ArrayList<Student> students = list.get(c);
            //System.out.println(c + " " + Math.ceil(students.size()/MAX_SIZE));
            map.put(c, (int)Math.ceil(students.size()/MAX_SIZE));
        }
        recursion(new int[8], 0);
    }

    public void recursion(int[] perSection, int index){
        //System.out.println(index);
        ArrayList<Integer> tempIndex = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            if (perSection[i] <= 2){
                tempIndex.add(i);
                // MAGIC NUMBER
            }
        }
        int sections = map.get(course9.get(index));
        if (sections == 1){
            for (int i: tempIndex){
                perSection[i]++;
                if (index + 1 < course9.size()) recursion(perSection, index + 1);
                perSection[i]--;
            }
        }else if (sections == 2){
            ArrayList<Pair> realTemp = shuffle2(tempIndex.size());
            for (Pair lol: realTemp){
                perSection[tempIndex.get(lol.a)]++;
                perSection[tempIndex.get(lol.b)]++;
                if (index + 1 < course9.size()) recursion(perSection, index + 1);
                perSection[tempIndex.get(lol.a)]--;
                perSection[tempIndex.get(lol.b)]--;
            }
        }else if (sections == 3){
            ArrayList<Triple> realTemp = shuffle3(tempIndex.size());
            ArrayList<Triple> realIndex = new ArrayList<>();
            for (Triple lol: realTemp){
                perSection[tempIndex.get(lol.x)]++;
                perSection[tempIndex.get(lol.y)]++;
                perSection[tempIndex.get(lol.z)]++;
                if (index + 1 < course9.size()) recursion(perSection, index + 1);
                perSection[tempIndex.get(lol.x)]--;
                perSection[tempIndex.get(lol.y)]--;
                perSection[tempIndex.get(lol.z)]--;
            }
        }
    }

    public ArrayList<Pair> shuffle2(int size){
        ArrayList<Pair> really = new ArrayList<>();
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j < size; j++){
                really.add(new Pair(i, j));
            }
        }
        return really;
    }

    public ArrayList<Triple> shuffle3(int size){
        ArrayList<Triple> really = new ArrayList<>();
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j < size; j++){
                for (int l = j + 1; l < size; l++){
                    really.add(new Triple(i, j, l));
                }
            }
        }
        return really;
    }
}