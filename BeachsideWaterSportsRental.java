import java.util.Scanner;

public class BeachsideWaterSportsRental {

    // Global Scanner to prevent resource conflicts across methods
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("**Book your Beachside Water Sports Equipment Rentals**\n");

        // 1. Call Method 1 to get membership type
        String membershipType = getMembershipType();

        // Call look-up methods to initialize variables
        double baseCost = getBaseCost(membershipType);
        int freeSessions = getFreeRentals(membershipType);
        double hourlyRate = getHourlyRate(membershipType);

        // 2. Call Method 6 to display information about the customer's membership
        displayMembershipInfo(membershipType, freeSessions, hourlyRate, baseCost);

        // Accumulators for the final invoice
        int totalRentalsBooked = 0;
        double totalHoursRentals = 0;
        double totalRentalCharges = 0;
        int remainingFreeSessions = freeSessions;

        // 3. Loop for renting equipment
        System.out.print("\nEnter y or n to rent equipment for a water sports session. Enter no or n to stop and process your invoice: ");
        String choice = input.nextLine().trim().toLowerCase();

        while (choice.equals("y") || choice.equals("yes")) {
            // Call Method 5 to get validated hours
            double hours = getRentalHours(membershipType, remainingFreeSessions, hourlyRate);

            // Call Method 8 to calculate the price of this single session
            double sessionCharge = calculateSessionPrice(remainingFreeSessions, hourlyRate, hours);

            // Update remaining free sessions (decrement by 1 if we had any left)
            if (remainingFreeSessions > 0) {
                remainingFreeSessions--;
            }

            // Print individual session charge info
            System.out.printf("Equipment Rental Session Charge: $%.2f\n\n", sessionCharge);

            // Update counters and accumulators
            totalRentalsBooked++;
            totalHoursRentals += hours;
            totalRentalCharges += sessionCharge;

            // Prompt for next iteration
            System.out.print("Enter y or n to rent equipment for another water sports session. Enter no or n to stop and process your invoice: ");
            choice = input.nextLine().trim().toLowerCase();
        }

        // 4. Call Method 7 to display the final invoice
        displayFinalInvoice(baseCost, totalRentalsBooked, totalHoursRentals, totalRentalCharges);
    }

    /**
     * Method 1: Presents options, validates user input, and returns membership type.
     */
    public static String getMembershipType() {
        String membership = "";
        while (true) {
            System.out.print("Enter your type of Beach Club Membership ('Wave-Rider' or 'Ocean-Explorer'): ");
            membership = input.nextLine().trim();
            if (membership.equals("Wave-Rider") || membership.equals("Ocean-Explorer")) {
                return membership;
            }
            System.out.println("Invalid input. Please try again.");
        }
    }

    /**
     * Method 2: Returns the base cost of membership based on membership type.
     */
    public static double getBaseCost(String membershipType) {
        if (membershipType.equals("Wave-Rider")) {
            return 42.50;
        } else if (membershipType.equals("Ocean-Explorer")) {
            return 88.00;
        }
        return 0.0;
    }

    /**
     * Method 3: Returns maximum free equipment rental sessions included.
     */
    public static int getFreeRentals(String membershipType) {
        if (membershipType.equals("Wave-Rider")) {
            return 2;
        } else if (membershipType.equals("Ocean-Explorer")) {
            return 5;
        }
        return 0;
    }

    /**
     * Method 4: Returns the hourly rate for equipment rentals.
     */
    public static double getHourlyRate(String membershipType) {
        if (membershipType.equals("Wave-Rider")) {
            return 8.75;
        } else if (membershipType.equals("Ocean-Explorer")) {
            return 6.50;
        }
        return 0.0;
    }

    /**
     * Method 5: Prompts for hours, validates input between 1 and 4, and prints status notes.
     */
    public static double getRentalHours(String membershipType, int remainingFreeSessions, double hourlyRate) {
        System.out.println(); // matching blank line spacing
        if (remainingFreeSessions > 0) {
            System.out.printf("NOTE: You have %d.00 remaining Free Rental Sessions with your %s membership.\n", remainingFreeSessions, membershipType);
            System.out.printf("You will be charged at a rate of $%.2f per hour for Equipment Rentals if you exceed the free rentals.\n", hourlyRate);
        } else {
            System.out.printf("NOTE: You do not have any Free Rental Sessions remaining with your %s membership. You will be charged at a rate of $%.2f per hour for equipment rentals.\n", membershipType, hourlyRate);
        }

        double hours = 0;
        while (true) {
            System.out.print("How many hours are you looking to rent equipment for this Water Sports Session? (min: 1 hour - max: 4 hours) : ");
            try {
                hours = Double.parseDouble(input.nextLine().trim());
                if (hours >= 1.0 && hours <= 4.0) {
                    return hours;
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid hours. Please enter a value between 1 and 4.");
        }
    }

    /**
     * Method 6: Displays information about the customer's initial membership configuration.
     */
    public static void displayMembershipInfo(String membershipType, int freeSessions, double hourlyRate, double baseCost) {
        System.out.println("Beach Club Membership Type: " + membershipType);
        System.out.printf("Free Equipment Rental Sessions Included: %.1f\n", (double) freeSessions);
        System.out.printf("Hourly Rate for Equipment Rentals: $%.2f per session\n", hourlyRate);
        System.out.println("-------------------------------------------------------");
        System.out.printf("%s Membership Base Cost: $%.2f\n", membershipType, baseCost);
    }

    /**
     * Method 7: Displays final invoice summarizing all metrics and totals.
     */
    public static void displayFinalInvoice(double baseCost, int totalRentals, double totalHours, double totalCharges) {
        System.out.println("\n*********Invoice*********");
        System.out.printf("Beach Club Membership Base Cost: $%.2f\n", baseCost);
        System.out.printf("Number of Equipment Rental Sessions: %d\n", totalRentals);
        System.out.printf("Total Hours of Equipment Rentals: %.2f\n", totalHours);
        System.out.println("-----------------------------------");
        System.out.printf("Equipment Rental Charges: $%.2f\n\n", totalCharges);
        System.out.printf("Total Charges: $%.2f\n", (baseCost + totalCharges));
    }

    /**
     * Method 8: Calculates individual session price based on remaining free session status.
     */
    public static double calculateSessionPrice(int remainingFreeSessions, double hourlyRate, double hours) {
        if (remainingFreeSessions > 0) {
            return 0.00; 
        } else {
            return hours * hourlyRate;
        }
    }
}