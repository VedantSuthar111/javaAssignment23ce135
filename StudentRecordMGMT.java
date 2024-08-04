import java.util.Scanner;

class Student {
    private int studentID;
    private String name;
    private int age;
    private String department;

    public Student(int studentID, String name, int age, String department) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Student(ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Department: " + department + ")";
    }
}

class StudentRecordSystem {
    private Student[] students;
    private int count;

    public StudentRecordSystem(int capacity) {
        students = new Student[capacity];
        count = 0;
    }

    public void addStudent(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Student record system is full.");
        }
    }

    public Student getStudent(int studentID) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID() == studentID) {
                return students[i];
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (count == 0) {
            System.out.println("No students in the database.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(students[i]);
            }
        }
    }
}

public class StudentRecordMGMT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRecordSystem recordSystem = new StudentRecordSystem(100); // Assume capacity of 100 students

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter student department: ");
                    String department = scanner.nextLine();

                    Student student = new Student(studentID, name, age, department);
                    recordSystem.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.println("\nStudent Records:");
                    recordSystem.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    int searchID = scanner.nextInt();
                    Student foundStudent = recordSystem.getStudent(searchID);
                    if (foundStudent != null) {
                        System.out.println("\nStudent found:");
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("\nStudent not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
