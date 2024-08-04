import java.util.Scanner;

class student {
    private int studentID;
    private String name;
    private int age;
    private String department;

    student(int id, String name, int age, String department) {
        studentID = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    int getStudentID() {
        return studentID;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getDepartment() {
        return department;
    }

    public String toString() {
        return "Student id : " + studentID + "Name : " + name + "age : " + age + "Department : " + department;
    }
}

class StudentRecordSystem {
    Scanner sc = new Scanner(System.in);
    private student[] students = new student[10];
    private int count = 0;

    void addstudent() {
        if (count == 10) {
            System.out.println("Sorry, the student record system is full.");
        }
        System.out.println("Enter your ID : ");
        int id = sc.nextInt();
        System.out.println("Enter your Name : ");
        String name = sc.nextLine();
        System.out.println("Enter your Age : ");
        int age = sc.nextInt();
        System.out.println("Enter your department : ");
        String department = sc.nextLine();
        students[count] = new student(id, name, age, department);
        count++;
    }

    student getStudent(int id) {

        sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID() == id) {
                return students[i];
            }
        }
        return null;
    }

    void displayAllStudent() {
        if (count == 0) {
            System.out.println("No students in the system");
        }
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].toString());
        }
    }
}

class StudentRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecordSystem srs = new StudentRecordSystem();
        srs.addstudent();
        while (true) {
            System.out.println("1. Add student data");
            System.out.println("2. get student by id number");
            System.out.println("3. Display data of all student");
            System.out.println("4. Exit");
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    srs.addstudent();
                    break;

                case 2:
                    System.out.println("Enter the student id to get the student details : ");
                    int id = sc.nextInt();
                    srs.getStudent(id);
                    break;

                case 3:
                    srs.displayAllStudent();
                    break;
                default:
                System.out.println("Invalid choice");
                    break;
            }
        }
    }
}