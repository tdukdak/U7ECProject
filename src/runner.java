import java.sql.SQLOutput;
import java.util.Scanner;

public class runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("4")) {
            if (choice.equals("4")) {
                System.out.println("Successfully exited the menu.");
            }
            System.out.print("""
               --------------------------------------------------
               What would you like to do?
               1. Calculate cost of one package
               2. Simulate packages
               3. How package costs are calculated
               4. Exit
               """);
            System.out.print("Input: ");
            choice = s.nextLine();
            while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) {
                clearScreen();
                System.out.print("""
                       ------------------------------------------------
                       What would you like to do?
                       1. Calculate cost of one package
                       2. Simulate packages
                       3. How package costs are calculated
                       4. Exit
                       """);
                System.out.print("Input: ");
                choice = s.nextLine();
            }
            System.out.println("------------------------------------------------");
            if (choice.equals("3")) {
                System.out.println("""
                       The program factors in the zipcodes of the origin and destination, the package's weight, and its dimensions to determine how much each package will cost.
                                              
                       - The base price for packages is $3.75.
                       - The base price is increased by $0.05 for every tenth of a pound.
                       - The positive difference between the first three digits of both zipcodes is divided by 100 and then added to the total cost to determine the final cost.
                                              
                       If the package is longer than a total of 36 inches: - For packages longer than a total of 36 inches (h + l + w), an additional $0.10 is added to the final price for each inch longer than 36in.
                                              
                       If the package weighs more than the 40-pound limit, an extra $0.10 will be charged.
                       """);
            }
            if (choice.equals("1")) {
                System.out.print("Enter the zip code of the origin package: ");
                String ogZip = s.nextLine();
                System.out.print("Enter the zip code of the destination package: ");
                String desZip = s.nextLine();
                System.out.print("Enter the weight of the package: ");
                Double weight = Double.parseDouble(s.nextLine());
                System.out.print("Enter the height of the package: ");
                Double height = Double.parseDouble(s.nextLine());
                System.out.print("Enter the length of the package: ");
                Double length = Double.parseDouble(s.nextLine());
                System.out.print("Enter the width of the package: ");
                Double width = Double.parseDouble(s.nextLine());

                Double cost = PostageCalculator.calculatePostage(ogZip, desZip, weight, height, length, width);
                System.out.printf("Cost: $%.2f", cost);
            }
        }
    }

    public static void clearScreen(){
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    }
}
