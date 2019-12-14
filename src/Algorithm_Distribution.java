import java.util.ArrayList;
import java.util.HashMap;

public class Algorithm_Distribution {
	
	// Course name is key, list of students is values
	HashMap<String, ArrayList<Student>> map = new HashMap(); // list of courses with all students in it
	
	StudentsInput studentInput = new StudentsInput();
	
	Input courseInput = new Input();
	
	public void distributeStudents()
	{
		for (int i = 0; i < courseInput.CourseList.size(); i += 1) // goes through each course
		{
			for (int j = 0 ; j < studentInput.StudentInfo.size(); j += 1) // goes through each of the students
			{
				for (int x = 0; x < 8; x += 1) // goes through each of student's 8 courses
				{
					// add the student that has the course to the course using temp variables
					String course = studentInput.StudentInfo.get(j).getchoiceMain()[x];
					ArrayList<Student> courseStudents = map.get(course);
					courseStudents.add(studentInput.StudentInfo.get(j));
					map.replace(course, courseStudents);
				}
					
			}
		}
		
	}
	
	public static void main(String args[]) { 
		
		Algorithm_Distribution main = new Algorithm_Distribution();
		
		System.out.println(main.map.get("ENG1D1").size());
	}
}


/*
 * 
 * if people cant get their first choices, figure out if you can fit them into
 * their alternative classes (make sure their alternative classes dont go above
 * student limit)
 * 
 * make hashmap of arraylists. Hashmap is the name of course, arraylist stores the students in it
 */
//figure out how to give them alternatives if they cant get into their top choices
