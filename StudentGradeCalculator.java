import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("STUDENT GRADE CALCULATOR");

        System.out.print("Enter the Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter the Number of Subjects: ");
        int numberOfSubjects = scanner.nextInt();

        String[] subjects = new String[numberOfSubjects];
        int[] marks = new int[numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter the Subject Name " + (i + 1) + ": ");
            subjects[i] = scanner.next();
            System.out.print("Enter the Marks Obtained in " + subjects[i] + " (out of 100): ");
            marks[i] = scanner.nextInt();
        }

        int total = numberOfSubjects * 100;
        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
        char grade = calculateGrade(averagePercentage);

        System.out.println("\nResults:");
        System.out.println("Student Name: " + studentName);
        System.out.println("Total Marks: " + totalMarks + "/" + total);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    public static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 95) {
            return 'S';
        } else if(averagePercentage >=90){
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
