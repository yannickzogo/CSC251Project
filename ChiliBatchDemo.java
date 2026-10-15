import java.util.ArrayList;
import java.util.Scanner;

/*
 * REFLECTION BLOCK
 * Name: Alphonse Yannick Zogo
 * Initials: AYZ
 * --------------------------------------------------
 * One thing I learned:
 * I learned how price thresholds affect purchasing behavior, where ordering a larger 
 * quantity of ground beef reaches bulk pricing and lowers total overall cost.
 * 
 * I affirm that the code and reflection in this submission are my own work,
 * produced without the use of generative AI.
 * Alphonse Yannick Zogo, September 27, 2026
 */

public class ChiliBatchDemo {
    public static void main(String[] args) {
        Scanner keyboardAYZ = new Scanner(System.in);
        ArrayList<ChiliBatch> batchListAYZ = new ArrayList<>();

        int numBatchesAYZ = 0;

        // Prompt for number of batches with validation loop
        System.out.print("Enter the number of batches of chili (min: 1 - max: 10): ");
        numBatchesAYZ = keyboardAYZ.nextInt();

        while (numBatchesAYZ < 1 || numBatchesAYZ > 10) {
            System.out.print("ERROR: INVALID NUMBER OF BATCHES ENTERED. TRY AGAIN.");
            System.out.println();
            System.out.print("Enter the number of batches of chili (min: 1 - max: 10): ");
            numBatchesAYZ = keyboardAYZ.nextInt();
        }

        System.out.println();

        // Prompt for servings for each batch with validation loop
        for (int iAYZ = 1; iAYZ <= numBatchesAYZ; iAYZ++) {
            System.out.print("How many servings are in batch #" + iAYZ + "? (min: 25 - max: 300) ");
            int servingsAYZ = keyboardAYZ.nextInt();

            while (servingsAYZ < 25 || servingsAYZ > 300) {
                System.out.println("ERROR: INVALID NUMBER OF SERVINGS. TRY AGAIN.");
                System.out.println();
                System.out.print("How many servings are in batch #" + iAYZ + "? (min: 25 - max: 300) ");
                servingsAYZ = keyboardAYZ.nextInt();
            }

            ChiliBatch newBatchAYZ = new ChiliBatch(servingsAYZ);
            batchListAYZ.add(newBatchAYZ);
        }

        System.out.println();
        System.out.println("---Homecoming Tailgate Chili Batches---");

        // Running totals variables
        int totalServingsAYZ = 0;
        double totalBeefAYZ = 0.0;
        double totalBeansAYZ = 0.0;
        double totalTomatoesAYZ = 0.0;
        int totalMuffinsAYZ = 0;
        int bulkBatchCountAYZ = 0;
        double totalBeefCostAYZ = 0.0;
        double totalEstimatedCostAYZ = 0.0;

        // Print individual batch details
        for (int iAYZ = 0; iAYZ < batchListAYZ.size(); iAYZ++) {
            ChiliBatch bAYZ = batchListAYZ.get(iAYZ);

            int batchServingsAYZ = bAYZ.getServings();
            double batchBeefAYZ = bAYZ.getBeef();
            double batchBeansAYZ = bAYZ.getBeans();
            double batchTomatoesAYZ = bAYZ.getTomatoes();
            int batchMuffinsAYZ = bAYZ.getMuffins();
            boolean isBulkAYZ = bAYZ.qualifiesForBulk();
            double batchBeefCostAYZ = bAYZ.calculateBeefCost();
            double batchCostAYZ = bAYZ.calculateCost();

            // Accumulate totals
            totalServingsAYZ += batchServingsAYZ;
            totalBeefAYZ += batchBeefAYZ;
            totalBeansAYZ += batchBeansAYZ;
            totalTomatoesAYZ += batchTomatoesAYZ;
            totalMuffinsAYZ += batchMuffinsAYZ;
            if (isBulkAYZ) {
                bulkBatchCountAYZ++;
            }
            totalBeefCostAYZ += batchBeefCostAYZ;
            totalEstimatedCostAYZ += batchCostAYZ;

            System.out.println("--Batch #" + (iAYZ + 1) + "--");
            System.out.println("--------------------------------------------------");
            System.out.println("  Ingredients needed for Batch:");
            System.out.printf("    %-28s %6d%n", "Number of Servings:", batchServingsAYZ);
            System.out.printf("    %-28s %6.2f%n", "Pounds of Ground Beef:", batchBeefAYZ);
            System.out.printf("    %-28s %6.2f%n", "Pounds of Beans:", batchBeansAYZ);
            System.out.printf("    %-28s %6.2f%n", "Cups of Diced Tomatoes:", batchTomatoesAYZ);
            System.out.printf("    %-28s %6d%n", "Cornbread Muffins:", batchMuffinsAYZ);
            System.out.printf("    %-28s %6s%n", "Bulk Beef Price Applied:", (isBulkAYZ ? "Yes" : "No"));
            System.out.printf("    %-28s $%5.2f%n", "Ground Beef Cost:", batchBeefCostAYZ);
            System.out.printf("    %-28s $%5.2f%n", "Estimated Cost:", batchCostAYZ);
            System.out.println("--------------------------------------------------");
            System.out.println();
        }

        // Output overall totals report
        System.out.printf("  %-30s %6d%n", "Batches of Chili:", batchListAYZ.size());
        System.out.printf("  %-30s %6d%n", "Total Servings:", totalServingsAYZ);
        System.out.printf("  %-30s %6.2f%n", "Total Pounds of Ground Beef:", totalBeefAYZ);
        System.out.printf("  %-30s %6.2f%n", "Total Pounds of Beans:", totalBeansAYZ);
        System.out.printf("  %-30s %6.2f%n", "Total Cups of Diced Tomatoes:", totalTomatoesAYZ);
        System.out.printf("  %-30s %6d%n", "Total Cornbread Muffins:", totalMuffinsAYZ);
        System.out.printf("  %-30s %6d%n", "Batches at the Bulk Beef Price:", bulkBatchCountAYZ);
        System.out.printf("  %-30s $%5.2f%n", "Total Ground Beef Cost:", totalBeefCostAYZ);
        System.out.printf("  %-30s $%5.2f%n", "Total Estimated Cost:", totalEstimatedCostAYZ);

        keyboardAYZ.close();
    }
}