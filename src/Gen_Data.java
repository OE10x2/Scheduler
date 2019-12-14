import java.io.File;
import java.util.*;

public class Gen_Data{
    public ArrayList<String> course9 = new ArrayList<>();
    public ArrayList<String> course10 = new ArrayList<>();
    public ArrayList<String> course11 = new ArrayList<>();
    public ArrayList<String> course12 = new ArrayList<>();
    public ArrayList<String> students = new ArrayList<>();
    public int nine = 0, ten = 0, eleven = 0, twelve = 0;
    public static void main(String[] args) throws Exception{
        new Gen_Data().RUN();
    }
    public void RUN() throws Exception{
        File file = new File("Courses.csv");
        Scanner in = new Scanner(file);
        File SFile = new File("StudentName.csv");
        Scanner SIN = new Scanner(SFile);
        while (in.hasNextLine()){
            String next = in.nextLine();
            if (next.charAt(3) == '1') course9.add(next);
            if (next.charAt(3) == '2') course10.add(next);
            if (next.charAt(3) == '3') course11.add(next);
            if (next.charAt(3) == '4') course12.add(next);
        }
        while (SIN.hasNextLine()) students.add(SIN.nextLine());
        for (String i: students){
            int grade = (int)(Math.random() * 4 + 9);
            System.out.print(i + " " + grade + " ");
            HashSet<Integer> s = new HashSet<>();
            if (grade == 9){
                while (!(s.size() == 11)) s.add(new Random().nextInt(course9.size()));
                for (int ij: s) System.out.print(course9.get(ij) + " ");
                nine++;
            }else if (grade == 10){
                while (!(s.size() == 11)) s.add(new Random().nextInt(course10.size()));
                for (int ij: s) System.out.print(course10.get(ij) + " ");
                ten++;
            }else if (grade == 11){
                while (!(s.size() == 11)) s.add(new Random().nextInt(course11.size()));
                for (int ij: s) System.out.print(course11.get(ij) + " ");
                eleven++;
            }else{
                while (!(s.size() == 11)) s.add(new Random().nextInt(course12.size()));
                for (int ij: s) System.out.print(course12.get(ij) + " ");
                twelve++;
            }
            System.out.println();
        }
        System.out.println(nine + " " + ten + " " + eleven + " " + twelve);
    }
}