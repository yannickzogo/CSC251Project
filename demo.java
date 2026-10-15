import java.util.Scanner;

public class demo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("AYANpplication that will keep track of insurance policies\n");

        System.out.print("Please enter the Policy Number: ");
        String policyNumber = input.nextLine();

        System.out.print("Please enter the Provider Name: ");
        String providerName = input.nextLine();

        System.out.print("Please enter the Policyholder's First Name: ");
        String firstName = input.nextLine();

        System.out.print("Please enter the Policyholder's Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Please enter the Policyholder's Age: ");
        int age = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        String smokingStatus = input.nextLine();

        System.out.print("Please enter the Policyholder's Height (in inches): ");
        double height = input.nextDouble();

        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        double weight = input.nextDouble();

        // Calling your updated class name blueprint
        Project_AlphonseYannick_zogo policy = new Project_AlphonseYannick_zogo(
            policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight
        );

        System.out.println("\n------------------------------------------------------------");
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("------------------------------------------------------------");
        System.out.println("Policyholder Name: " + policy.getFirstName() + " " + policy.getLastName());
        System.out.println("Policyholder Age: " + policy.getAge());
        System.out.println("Smoking Status: " + policy.getSmokingStatus());
        System.out.printf("Height: %.1f inches | Weight: %.1f pounds\n", policy.getHeight(), policy.getWeight());
        System.out.println("------------------------------------------------------------\n");

        System.out.println("***Invoice***");
        System.out.printf("Policyholder's BMI: %.2f\n", policy.getBMI());
        System.out.printf("Policy Price: $%.2f\n", policy.getPrice());

        System.out.println("\n----JGRASP: Operation complete.");
        
        input.close();
    }
}