package sw;

import java.util.Scanner;

interface PayMode {
    void pay(double amount);
}

class UPI implements PayMode {
    public void pay(double amount) {
        System.out.println("UPI payment done: ₹" + amount);
    }
}

class Card implements PayMode {
    public void pay(double amount) {
        System.out.println("Card payment done: ₹" + amount);
    }
}

class Cash implements PayMode {
    public void pay(double amount) {
        System.out.println("Cash payment done: ₹" + amount);
    }
}

public class ShopWallet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Add money to wallet: ₹");
        double wallet = sc.nextDouble();

        System.out.println("\nChoose payment method:");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Cash");

        int choice = sc.nextInt();

        System.out.print("Enter payment amount: ₹");
        double payAmount = sc.nextDouble();

        if(payAmount > wallet) {
            System.out.println("Not enough balance!");
            return;
        }

        PayMode mode;

        if(choice == 1)
            mode = new UPI();
        else if(choice == 2)
            mode = new Card();
        else
            mode = new Cash();

        mode.pay(payAmount);

        wallet = wallet - payAmount;

        System.out.println("Remaining wallet balance: ₹" + wallet);
    }
}
