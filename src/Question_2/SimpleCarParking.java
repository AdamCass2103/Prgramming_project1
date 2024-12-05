package Question_2;

import java.util.Scanner;
import java.util.Stack;

public class SimpleCarParking {

    public static void main(String[] args) {
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number (positive to park, negative to retrieve, 0 to stop): ");
            int input = scanner.nextInt();

            if (input == 0) {
                System.out.println("Simulation stopped.");
                break;
            } else if (input > 0) {
                // Park the car in the driveway
                driveway.push(input);
                System.out.println("Car " + input + " parked in driveway.");
            } else {
                // Retrieve the car
                int carToRetrieve = -input;
                boolean found = false;

                // Move cars to street until we find the target car
                while (!driveway.isEmpty()) {
                    int car = driveway.pop();
                    if (car == carToRetrieve) {
                        System.out.println("Car " + carToRetrieve + " retrieved from driveway.");
                        found = true;
                        break;
                    } else {
                        street.push(car);
                    }
                }

                // Move cars back to driveway from street
                while (!street.isEmpty()) {
                    driveway.push(street.pop());
                }

                if (!found) {
                    System.out.println("Car " + carToRetrieve + " not found in driveway.");
                }
            }

            // Print the current state of the driveway
            System.out.println("Current state of driveway: " + driveway);
        }

        scanner.close();
    }
}

