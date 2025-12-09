import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Input School Details
        System.out.println("=== Student Performance Report System ===\n");
        System.out.print("Enter School Name: ");
        String schoolName = scanner.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacherName = scanner.nextLine();

        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        System.out.print("Enter Year: ");
        String year = scanner.nextLine();

        System.out.print("\nEnter number of students (minimum 12): ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        while (numStudents < 12) {
            System.out.print("Please enter at least 12 students: ");
            numStudents = scanner.nextInt();
            scanner.nextLine();
        }

        // 2. Arrays to store student data
        String[] studentNames = new String[numStudents];
        double[] englishMarks = new double[numStudents];
        double[] mathMarks = new double[numStudents];
        double[] historyMarks = new double[numStudents];
        double[] geographyMarks = new double[numStudents];
        double[] scienceMarks = new double[numStudents];
        double[] programmingMarks = new double[numStudents];
        double[] totalMarks = new double[numStudents];
        String[] ranks = new String[numStudents];

        // Input student records
        System.out.println("\n=== Enter Student Records ===");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.print("  Name: ");
            studentNames[i] = scanner.nextLine();

            System.out.print("  English: ");
            englishMarks[i] = scanner.nextDouble();

            System.out.print("  Math: ");
            mathMarks[i] = scanner.nextDouble();

            System.out.print("  History: ");
            historyMarks[i] = scanner.nextDouble();

            System.out.print("  Geography: ");
            geographyMarks[i] = scanner.nextDouble();

            System.out.print("  Science: ");
            scienceMarks[i] = scanner.nextDouble();

            System.out.print("  Programming: ");
            programmingMarks[i] = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            // 3. Compute total marks and rank
            totalMarks[i] = englishMarks[i] + mathMarks[i] + historyMarks[i] +
                    geographyMarks[i] + scienceMarks[i] + programmingMarks[i];

            ranks[i] = calculateRank(totalMarks[i]);
        }

        // 4. Compute class statistics
        double totalEnglish = 0, totalMath = 0, totalHistory = 0;
        double totalGeography = 0, totalScience = 0, totalProgramming = 0;
        double grandTotal = 0;

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int i = 0; i < numStudents; i++) {
            totalEnglish += englishMarks[i];
            totalMath += mathMarks[i];
            totalHistory += historyMarks[i];
            totalGeography += geographyMarks[i];
            totalScience += scienceMarks[i];
            totalProgramming += programmingMarks[i];
            grandTotal += totalMarks[i];

            switch (ranks[i]) {
                case "A": countA++; break;
                case "B": countB++; break;
                case "C": countC++; break;
                case "D": countD++; break;
                case "F": countF++; break;
            }
        }

        double avgEnglish = totalEnglish / numStudents;
        double avgMath = totalMath / numStudents;
        double avgHistory = totalHistory / numStudents;
        double avgGeography = totalGeography / numStudents;
        double avgScience = totalScience / numStudents;
        double avgProgramming = totalProgramming / numStudents;
        double avgTotal = grandTotal / numStudents;

        // 5. Generate formatted report
        printReport(schoolName, teacherName, grade, year,
                studentNames, englishMarks, mathMarks, historyMarks,
                geographyMarks, scienceMarks, programmingMarks,
                totalMarks, ranks, numStudents,
                totalEnglish, totalMath, totalHistory, totalGeography,
                totalScience, totalProgramming, grandTotal,
                avgEnglish, avgMath, avgHistory, avgGeography,
                avgScience, avgProgramming, avgTotal,
                countA, countB, countC, countD, countF);

        scanner.close();
    }

    // Method to calculate rank based on total marks
    public static String calculateRank(double total) {
        if (total >= 540.0) {
            return "A";
        } else if (total >= 480.0) {
            return "B";
        } else if (total >= 420.0) {
            return "C";
        } else if (total >= 360.0) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to print the formatted report
    public static void printReport(String schoolName, String teacherName,
                                   String grade, String year,
                                   String[] names, double[] english, double[] math,
                                   double[] history, double[] geography,
                                   double[] science, double[] programming,
                                   double[] total, String[] ranks, int numStudents,
                                   double totEng, double totMath, double totHist,
                                   double totGeo, double totSci, double totProg,
                                   double grandTotal, double avgEng, double avgMath,
                                   double avgHist, double avgGeo, double avgSci,
                                   double avgProg, double avgTotal,
                                   int cntA, int cntB, int cntC, int cntD, int cntF) {

        System.out.println("\n" + "=".repeat(85));
        System.out.printf("%50s%n", "School Name: " + schoolName);
        System.out.printf("%45s%n", "Teacher: " + teacherName);
        System.out.printf("%38s%n", "Grade: " + grade);
        System.out.printf("%37s%n", "Year: " + year);
        System.out.println("=".repeat(85));

        // Header
        System.out.printf("%-18s %7s %7s %7s %9s %7s %11s %7s %4s%n",
                "Student Name", "English", "Math", "History",
                "Geography", "Science", "Programming", "Total", "Rank");
        System.out.println("=".repeat(85));

        // Student records
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-18s %7.2f %7.2f %7.2f %9.2f %7.2f %11.2f %7.2f %4s%n",
                    names[i], english[i], math[i], history[i],
                    geography[i], science[i], programming[i],
                    total[i], ranks[i]);
        }

        System.out.println("-".repeat(85));

        // Totals
        System.out.printf("%-18s %7.2f %7.2f %7.2f %9.2f %7.2f %11.2f %7.2f%n",
                "", totEng, totMath, totHist, totGeo, totSci, totProg, grandTotal);

        System.out.println("-".repeat(85));

        // Averages
        System.out.printf("%-18s %7.2f %7.2f %7.2f %9.2f %7.2f %11.2f %7.2f%n",
                "", avgEng, avgMath, avgHist, avgGeo, avgSci, avgProg, avgTotal);

        System.out.println("=".repeat(85));

        // Grade distribution
        System.out.printf("%n%30s  A's: %-3d   B's: %-3d   C's: %-3d   D's: %-3d   F's: %-3d%n",
                "Ranks", cntA, cntB, cntC, cntD, cntF);
        System.out.println();
    }
}