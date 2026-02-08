package com.student;



import java.util.Scanner;





import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Course: ");
                String course = sc.nextLine();
                StudentDAO.addStudent(name, email, course);
                break;

            case 2:
                StudentDAO.viewStudents();
                break;

            case 3:
                System.out.print("Student ID: ");
                int uid = sc.nextInt();
                sc.nextLine();
                System.out.print("New Course: ");
                String newCourse = sc.nextLine();
                StudentDAO.updateStudent(uid, newCourse);
                break;

            case 4:
                System.out.print("Student ID: ");
                int did = sc.nextInt();
                StudentDAO.deleteStudent(did);
                break;

            default:
                System.out.println("❌ Invalid Choice");
        }
    }
}