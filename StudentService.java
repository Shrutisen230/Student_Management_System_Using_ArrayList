//----Implementation Class----
import java.util.ArrayList;

class StudentService implements StudentOperations
{ 
	private ArrayList<Student> students = new ArrayList<>(); 
	@Override 
	public void addStudent(Student student) throws DuplicateStudentException
	{ 
	// Check for duplicate ID 
	for (Student s : students)
	{ 
		if (s.id == student.id)
		{ 
			throw new DuplicateStudentException("Student with ID : "+ student.id + " already exists."); 
		} 
	} 
	students.add(student); 
	System.out.println("Sudent Added Successfully!"); 
	}
	
	@Override 
	public void viewStudents()
	{ 
		if (students.isEmpty()) { 
			System.out.println("No students available."); 
		} else { 
			System.out.println("\n--- Student List ---"); 
			for (Student s : students) { 
				System.out.println(s); 
			} 
		} 
	}
	
	@Override 
	public Student searchStudent(int id) throws StudentNotFoundException 
	{ 
        for (Student s : students) { 
            if (s.id == id) { 
                return s; 
            } 
        } 
        throw new StudentNotFoundException("  Student with ID " + id + " not found."); 
    } 
 
    @Override 
    public void deleteStudent(int id) throws StudentNotFoundException { 
        Student toRemove = null; 
        for (Student s : students) { 
            if (s.id == id) { 
                toRemove = s; 
                break; 
            } 
        } 
        if (toRemove != null) { 
            students.remove(toRemove); 
            System.out.println("   Student Deleted Successfully!"); 
        } else { 
            throw new StudentNotFoundException("  Student with ID " + id + " not found."); 
        } 
    } 
}