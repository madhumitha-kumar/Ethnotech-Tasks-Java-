package loginvalidation;

import java.util.Scanner;

class userlogin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int attempts = 0;

        while (attempts < 3) {

            System.out.print("Username: ");
            String user = sc.next();

            System.out.print("Password: ");
            String pass = sc.next();

            if (user.equals("admin") && pass.equals("123")) {
                System.out.println("Login successful!");
                break;
            } 
            else {
                attempts++;
                System.out.println("Wrong! Left: " + (3 - attempts));
            }
        }

        if (attempts == 3) {
            System.out.println("Account blocked!");
        }

        sc.close();
    }
}
