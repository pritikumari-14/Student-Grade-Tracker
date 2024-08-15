import java.util.ArrayList;
import java.util.Scanner;

public class grade {

    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        // Input grades
        System.out.println("Enter student grades (type 'done' to finish): ");
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int grade = Integer.parseInt(input);
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Please enter a valid grade (0-100).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        if (grades.size() == 0) {
            System.out.println("No grades entered.");
        } else {
            // Compute average
            double average = computeAverage(grades);
            int highest = findHighest(grades);
            int lowest = findLowest(grades);

            // Output results
            System.out.println("Number of grades entered: " + grades.size());
            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        }

        scanner.close();
    }

    // Method to compute average
    public static double computeAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Method to find highest grade
    public static int findHighest(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find lowest grade
    public static int findLowest(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
