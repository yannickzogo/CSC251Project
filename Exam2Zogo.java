import java.util.Scanner;

public class Exam2Zogo
{
   public static String getMembershipType()
   {
      Scanner input = new Scanner(System.in);
      String membershipType;
      
      System.out.println("*Book your Beachside Water Sports Equipment Rentals*\n");
      
      System.out.print("Enter your type of Beach Club Membership ('Wave-Rider' or 'Ocean-Explorer'): ");
      membershipType = input.nextLine();
      
      while(!membershipType.equalsIgnoreCase("Wave-Rider") && !membershipType.equalsIgnoreCase("Ocean-Explorer"))
      {
         System.out.println("\nERROR: Invalid membership entered. Try Again. \n");
         System.out.print("Enter your type of Beach Club Membership ('Wave-Rider' or 'Ocean-Explorer'): ");
         membershipType = input.nextLine();
      } 
   
      return membershipType;
   }

   public static double getBaseCost(String membershipType)
   {
      if(membershipType.equalsIgnoreCase("Wave-Rider"))
         return 42.50;
      else
         return 88.00;
   }
   
   public static int getFreeRentals(String membershipType)
   {
      if(membershipType.equalsIgnoreCase("Wave-Rider"))
         return 2;
      else
         return 5;
   }
   
   public static double getHourlyRate(String membershipType)
   {
      if(membershipType.equalsIgnoreCase("Wave-Rider"))
         return 8.75;
      else
         return 6.50;
   }
      
   public static void displayMembershipInformation(String type, int maxFreeRentals, double hourlyRate, 
      double cost)
   {
      System.out.println("-----------------------------------------------------------------------");
      System.out.println("Beach Club Membership Type: " + type);
      System.out.printf("Free Equipment Rental Sessions Included: %.1f \n", (double)maxFreeRentals);
      System.out.printf("Hourly Rate for Equipment Rentals: $%.2f per session \n", hourlyRate);
      System.out.println("-----------------------------------------------------------------------");
      System.out.printf("%s Membership Base Cost: $%.2f \n", type, cost);
      System.out.println("-----------------------------------------------------------------------");
   }
      
   public static String repeatServiceInput(int count)
   {
      Scanner input = new Scanner(System.in);
      String repeat;
      
      System.out.print("\nEnter y or yes to add a water sports session. Enter no or n to stop and process your invoice: ");
      repeat = input.nextLine();
      
      while(!repeat.equalsIgnoreCase("yes") && !repeat.equalsIgnoreCase("y") &&
            !repeat.equalsIgnoreCase("no") && !repeat.equalsIgnoreCase("n"))
      {
         System.out.println("\nERROR: Invalid response. Try again. \n");
         System.out.print("\nEnter y or yes to add a water sports session. Enter no or n to stop and process your invoice: ");
         repeat = input.nextLine();
      }
      
      return repeat;
   }

   public static double getRentalHours()
   {
      Scanner input = new Scanner(System.in);
      double hours;
      
      while (true)
      {
         System.out.print("How many hours are you looking to rent equipment for this Water Sports Session? (min: 1 hour - max: 4 hours) : ");
         try {
            hours = Double.parseDouble(input.nextLine());
            if (hours >= 1.0 && hours <= 4.0) {
               return hours;
            }
         } catch (NumberFormatException ignored) {}
         
         System.out.println("\nERROR: Invalid hours entered. Try Again. \n");
      }
   }
   
   public static void getEquipmentRentalCost(String membershipType, int remainingFreeSessions, double hourlyRate)
   {
      if(remainingFreeSessions >= 1)
      {
         System.out.printf("\nNOTE: You have %d.00 remaining Free Rental Sessions with your %s membership. \n" + 
         "You will be charged at a rate of $%.2f per hour for Equipment Rentals if you exceed the free rentals. \n", 
            remainingFreeSessions, membershipType, hourlyRate);
      }        
      else
      {
         System.out.printf("\nNOTE: You do not have any Free Rental Sessions remaining with your %s membership. \n" 
         +"You will be charged at a rate of $%.2f per hour for equipment rentals. \n", membershipType, hourlyRate);
      }
   }
   
   public static double calcEquipmentRentalCost(int remainingFreeSessions, double hourlyRate, double hours)
   {
      double sessionCharge;
      if(remainingFreeSessions < 1)
      {
         sessionCharge = hours * hourlyRate;
         System.out.printf("\nEquipment Rental Session Charge: $%.2f\n", sessionCharge);
         return sessionCharge;
      }
      else
      {
         System.out.println("\nEquipment Rental Session Charge: $0.00");
         return 0.00;
      }
   } 

   public static void invoice(double mCost, int nServices, double totalHours, double totalEquipmentRentalCharges)
   {
      System.out.println("\n\n\t****Invoice**");
      System.out.printf("Beach Club Membership Base Cost: $%.2f\n", mCost);
      System.out.println("Number of Equipment Rental Sessions: " + nServices);
      System.out.printf("Total Hours of Equipment Rentals: %.2f\n", totalHours);
      System.out.println("----------------------------------");
      System.out.printf("Equipment Rental Charges: $%.2f \n", totalEquipmentRentalCharges);
      System.out.printf("\nTotal Charges: $%.2f \n", (mCost + totalEquipmentRentalCharges));
   }

   public static void main(String[] args)
   {
      String membershipType;
      double membershipCost, hourlyRate, rentalHours;
      double sessionCost;
      double totalCharges = 0, totalEquipmentRentalCharges = 0, totalHours = 0;
      int serviceCount = 0, maxFreeRentals, remainingFreeSessions;
      String moreServices = "yes";
      
      membershipType = getMembershipType();
      membershipCost = getBaseCost(membershipType);
      maxFreeRentals = getFreeRentals(membershipType);
      hourlyRate = getHourlyRate(membershipType);
      
      displayMembershipInformation(membershipType, maxFreeRentals, hourlyRate, membershipCost);
      
      remainingFreeSessions = maxFreeRentals;
      totalCharges += membershipCost;
      
      do
      {
         moreServices = repeatServiceInput(serviceCount);
         
         if(moreServices.equalsIgnoreCase("yes") || moreServices.equalsIgnoreCase("y"))
         {  
            serviceCount++;
                   
            getEquipmentRentalCost(membershipType, remainingFreeSessions, hourlyRate);
            
            rentalHours = getRentalHours();
            totalHours += rentalHours;
            
            sessionCost = calcEquipmentRentalCost(remainingFreeSessions, hourlyRate, rentalHours);
           
            totalEquipmentRentalCharges += sessionCost;
            
            if(remainingFreeSessions > 0)
               remainingFreeSessions--;
            else
               remainingFreeSessions = 0;
         }
          
      }while(moreServices.equalsIgnoreCase("yes") || moreServices.equalsIgnoreCase("y"));
      
      invoice(membershipCost, serviceCount, totalHours, totalEquipmentRentalCharges);
   }
}