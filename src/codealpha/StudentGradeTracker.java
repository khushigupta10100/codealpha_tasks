package codealpha;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

 static class Student {
	    String name;
	    ArrayList<Integer> grades;

	    Student(String name) {
	        this.name = name;
	        this.grades = new ArrayList<>();
	    }

	    double getAverage() {
	        int sum = 0;
	        for (int grade : grades) {
	            sum += grade;
	        }
	        return grades.size() > 0 ? (double) sum / grades.size() : 0;
	    }

	    int getHighest() {
	        int max = Integer.MIN_VALUE;
	        for (int grade : grades) {
	            if (grade > max) {
	                max = grade;
	            }
	        }
	        return max;
	    }

	    int getLowest() {
	        int min = Integer.MAX_VALUE;
	        for (int grade : grades) {
	            if (grade < min) {
	                min = grade;
	            }
	        }
	        return min;
	    }

	    void printReport() {
	        System.out.println("\nStudent: " + name);
	        System.out.println("Grades: " + grades);
	        System.out.printf("Average: %.2f\n", getAverage());
	        System.out.println("Highest: " + getHighest());
	        System.out.println("Lowest: " + getLowest());
	    }
	}


	    static ArrayList<Student> students = new ArrayList<>();
	    static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int option;

	        do {
	            System.out.println("\n===== Student Grade Tracker =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. Add Grades to Student");
	            System.out.println("3. View Student Reports");
	            System.out.println("4. Exit");
	            System.out.print("Enter option: ");
	            option = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            switch (option) {
	                case 1:
	                    addStudent();
	                    break;
	                case 2:
	                    addGrades();
	                    break;
	                case 3:
	                    viewReports();
	                    break;
	                case 4:
	                    System.out.println("Exiting program.");
	                    break;
	                default:
	                    System.out.println("Invalid option. Try again.");
	            }

	        } while (option != 4);
	    }

	    static void addStudent() {
	        System.out.print("Enter student name: ");
	        String name = scanner.nextLine();
	        students.add(new Student(name));
	        System.out.println("Student added.");
	    }

	    static void addGrades() {
	        if (students.isEmpty()) {
	            System.out.println("No students available. Add a student first.");
	            return;
	        }

	        System.out.print("Enter student name to add grades: ");
	        String name = scanner.nextLine();
	        Student student = findStudentByName(name);

	        if (student == null) {
	            System.out.println("Student not found.");
	            return;
	        }

	        System.out.print("How many grades to enter? ");
	        int count = scanner.nextInt();

	        for (int i = 0; i < count; i++) {
	            System.out.print("Enter grade " + (i + 1) + ": ");
	            int grade = scanner.nextInt();
	            student.grades.add(grade);
	        }
	        scanner.nextLine(); // consume newline
	        System.out.println("Grades added.");
	    }

	    static void viewReports() {
	        if (students.isEmpty()) {
	            System.out.println("No students to display.");
	            return;
	        }

	        for (Student student : students) {
	            student.printReport();
	        }
	    }

	    static Student findStudentByName(String name) {
	        for (Student student : students) {
	            if (student.name.equalsIgnoreCase(name)) {
	                return student;
	            }
	        }
	        return null;
	    }
	}



