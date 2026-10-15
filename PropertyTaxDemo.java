import java.util.ArrayList;
import java.util.Scanner;

public class PropertyTaxDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Parcel> parcelList = new ArrayList<>();

        System.out.println("=== Property Tax Calculator ===");

        while (true) {
            System.out.print("\nWould you like to enter a parcel? (yes/no): ");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("no")) {
                break;
            } else if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
                continue;
            }

            // Parcel ID
            System.out.print("Enter Parcel ID: ");
            String id = scanner.nextLine();

            // Land Size input (>= 0)
            double landSize = -1;
            while (landSize < 0) {
                System.out.print("Enter Parcel Size in acres (>= 0): ");
                if (scanner.hasNextDouble()) {
                    landSize = scanner.nextDouble();
                    if (landSize < 0) {
                        System.out.println("Size cannot be negative. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Enter a number.");
                    scanner.next();
                }
            }
            scanner.nextLine(); // Clear buffer

            // Zoning Type
            System.out.print("Enter Zoning Type (Residential / Commercial): ");
            String zoning = scanner.nextLine();

            // Building Address
            System.out.print("Enter Building Street Address: ");
            String address = scanner.nextLine();

            // Building Size input (>= 0)
            double bldSize = -1;
            while (bldSize < 0) {
                System.out.print("Enter Building Size in sq ft (>= 0): ");
                if (scanner.hasNextDouble()) {
                    bldSize = scanner.nextDouble();
                    if (bldSize < 0) {
                        System.out.println("Size cannot be negative. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Enter a number.");
                    scanner.next();
                }
            }
            scanner.nextLine(); // Clear buffer

            // Create objects and store in ArrayList
            Building building = new Building(address, bldSize);
            Parcel parcel = new Parcel(id, landSize, zoning, building);
            parcelList.add(parcel);
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("      PARCEL DISPLAY & TAX SUMMARY        ");
        System.out.println("-------------------------------------------");

        if (parcelList.isEmpty()) {
            System.out.println("No parcels were entered.");
        } else {
            double totalTax = 0.0;

            for (int i = 0; i < parcelList.size(); i++) {
                System.out.println("\n--- Parcel #" + (i + 1) + " ---");
                System.out.println(parcelList.get(i).toString());
                totalTax += parcelList.get(i).calculatePropertyTax();
            }

            double averageTax = totalTax / parcelList.size();
            System.out.println("\n-------------------------------------------");
            System.out.printf("Average Property Tax: $%.2f\n", averageTax);
            System.out.println("-------------------------------------------");
        }

        scanner.close();
    }
}