interface StudentOperations
{
	void addStudent(Student student) throws DuplicateStudentException;
	void viewStudents(); 
	Student searchStudent(int id) throws StudentNotFoundException; 
	void deleteStudent(int id) throws StudentNotFoundException; 
}