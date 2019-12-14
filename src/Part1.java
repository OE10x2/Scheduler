import java.util.ArrayList;
import java.util.HashMap;

public class Part1 {
	
	public HashMap<String, ArrayList<Student>> list = new HashMap<String, ArrayList<Student>>();
	public void adjList() {
		CourseInput c = new CourseInput();
		StudentsInput s = new StudentsInput();
		c.ReadInput("Courses.csv");
		s.ReadStudentInput("Students.csv");
		ArrayList<String> CourseList = c.CourseList;
		for (int i = 0; i < c.getcourseSize(); i++) {
			String curCourse = CourseList.get(i);
			ArrayList<Student> students = new ArrayList<Student>();
			for (int j = 0; j < s.StudentInfo.size(); j++) {
				Student curStudent = s.StudentInfo.get(j);
				for (int k = 0; k < 8; k++) {
					
					if (curStudent.getchoiceMain()[k].equals(curCourse)) {
						students.add(curStudent);
						
						break;
					}
				}
			}
			list.put(curCourse, students);
			
		}
	}
	
	/*public static void main(String args[]) {
		adjList();
		ArrayList<Student> test = list.get("ICS2O1");
		int cnt = 0;
		for (int i=0;i<test.size();i++) {
			Student xyzzy = test.get(i);
			System.out.println(xyzzy.nameFirst);
			cnt++;
		}
		System.out.println(cnt);
	}*/
	
}
