/**write a prgrm for electriciy bill calculation frst 100 unit it shld be 5rs per unit after that next 100units 7rsper unit above 200units it should be 10rs per unit**/

package EB;

import java.util.Scanner;

class Ebill {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of units consumed: ");
        int units = scanner.nextInt();

        double totalBill = calculateBill(units);

        System.out.println("Total electricity bill: Rs. " + totalBill);

        scanner.close();
    }

    // Method to calculate electricity bill
    public static double calculateBill(int units) {

        return (units <= 100) ? (units * 5) :
               (units <= 200) ? (100 * 5 + (units - 100) * 7) :
               (100 * 5 + 100 * 7 + (units - 200) * 10);
    }
}

