import java.util.ArrayList;
import java.util.Scanner;

// --- Main Class --- 
public class StudentManagement2
{ 
    public static void main(String[] args)
	{ 
        Scanner sc = new Scanner(System.in); 
        StudentService service = new StudentService(); 
        int choice; 
 
        do { 
            System.out.println("\n--- Student Management System ---"); 
            System.out.println("1. Add Student"); 
            System.out.println("2. View Students"); 
            System.out.println("3. Search Student by ID"); 
            System.out.println("4. Delete Student by ID"); 
            System.out.println("5. Exit"); 
            System.out.print("Enter choice: "); 
            choice = sc.nextInt(); 
 
            try { 
                switch (choice) { 
                    case 1: 
                        System.out.print("Enter ID: "); 
                        int id = sc.nextInt(); 
                        sc.nextLine(); // consume newline 
                        System.out.print("Enter Name: "); 
                        String name = sc.nextLine(); 
                        System.out.print("Enter Course: "); 
                        String course = sc.nextLine(); 
 
                        service.addStudent(new Student(id, name, course)); 
                        break; 
 
                    case 2: 
                        service.viewStudents(); 
                        break; 
 
                    case 3: 
                        System.out.print("Enter ID to search: "); 
                        int searchId = sc.nextInt(); 
                        Student s = service.searchStudent(searchId); 
                        System.out.println("Found: " + s); 
                        break; 
 
                    case 4: 
                        System.out.print("Enter ID to delete: "); 
                        int delId = sc.nextInt(); 
                        service.deleteStudent(delId); 
                        break; 
 
                    case 5: 
                        System.out.println("Exiting...          "); 
                        break; 
 
                    default: 
                        System.out.println("    Invalid choice. Try again."); 
                } 
			}
			catch (DuplicateStudentException | StudentNotFoundException e) 
			{ 
				System.out.println(e.getMessage()); 
			} 
		}
		while (choice != 5); 
		sc.close();
	}
}