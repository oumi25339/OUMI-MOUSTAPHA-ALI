package oop;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


    public class ExceptionHandlingExamplesWithInput {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Checked Exceptions
            simulateIOException(scanner);
            simulateFileNotFoundException(scanner);
            simulateSQLException(scanner);

            // Unchecked Exceptions
            simulateArithmeticException(scanner);
            simulateNumberFormatException(scanner);

            scanner.close();
        }

        // Simulate IOException with user input
        private static void simulateIOException(Scanner scanner) {
            System.out.println("\n=== IOException Example ===");
            System.out.print("Enter a file name to read: ");
            String fileName = scanner.nextLine();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                System.out.println(reader.readLine());
            } catch (IOException e) {
                System.out.println("IOException caught: " + e.getMessage());
            }
        }

        // Simulate FileNotFoundException with user input
        private static void simulateFileNotFoundException(Scanner scanner) {
            System.out.println("\n=== FileNotFoundException Example ===");
            System.out.print("Enter a file name to check: ");
            String fileName = scanner.nextLine();
            try {
                FileInputStream file = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException caught: " + e.getMessage());
            }
        }

        // Simulate SQLException with user input
        private static void simulateSQLException(Scanner scanner) {
            System.out.println("\n=== SQLException Example ===");
            System.out.print("Enter database URL: ");
            String dbUrl = scanner.nextLine();
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            try {
                Connection connection = DriverManager.getConnection(dbUrl, username, password);
            } catch (SQLException e) {
                System.out.println("SQLException caught: " + e.getMessage());
            }
        }

        // Simulate ArithmeticException with user input
        private static void simulateArithmeticException(Scanner scanner) {
            System.out.println("\n=== ArithmeticException Example ===");
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();
            try {
                int result = numerator / denominator;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException caught: Cannot divide by zero.");
            }
        }

        // Simulate NumberFormatException with user input
        private static void simulateNumberFormatException(Scanner scanner) {
            System.out.println("\n=== NumberFormatException Example ===");
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                System.out.println("You entered: " + number);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException caught: " + e.getMessage());
            }
        }
    }


