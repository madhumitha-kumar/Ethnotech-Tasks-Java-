package TB;

import java.util.*;

class Booking {
    int bookingId, customerId, pickupTime, dropTime, amount;
    char from, to;

    Booking(int bid, int cid, char f, char t, int pt, int dt, int amt) {
        bookingId = bid;
        customerId = cid;
        from = f;
        to = t;
        pickupTime = pt;
        dropTime = dt;
        amount = amt;
    }
}

class Taxi {
    int taxiId;
    char currentPoint = 'A';
    int freeTime = 0;
    int totalEarnings = 0;
    List<Booking> bookings = new ArrayList<>();

    Taxi(int id) {
        taxiId = id;
    }
}

class TaxiBookingApp {

    static List<Taxi> taxis = new ArrayList<>();
    static int bookingCounter = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of taxis: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            taxis.add(new Taxi(i));
        }

        while (true) {

            System.out.println("\n1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Customer ID: ");
                int cid = sc.nextInt();

                System.out.print("Enter Pickup Point (A-F): ");
                char from = sc.next().charAt(0);

                System.out.print("Enter Drop Point (A-F): ");
                char to = sc.next().charAt(0);

                System.out.print("Enter Pickup Time (hour): ");
                int time = sc.nextInt();

                bookTaxi(cid, from, to, time);

            } else if (choice == 2) {
                displayTaxiDetails();
            } else {
                break;
            }
        }

        sc.close();
    }

    static void bookTaxi(int customerId, char from, char to, int pickupTime) {

        List<Taxi> freeTaxis = new ArrayList<>();

        for (Taxi t : taxis) {
            if (t.freeTime <= pickupTime) {
                freeTaxis.add(t);
            }
        }

        if (freeTaxis.isEmpty()) {
            System.out.println("Booking rejected. No taxi available.");
            return;
        }

        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi t : freeTaxis) {

            int distance = Math.abs(t.currentPoint - from);

            if (distance < minDistance) {
                minDistance = distance;
                selectedTaxi = t;
            } else if (distance == minDistance) {
                if (t.totalEarnings < selectedTaxi.totalEarnings) {
                    selectedTaxi = t;
                }
            }
        }

        int travelDistance = Math.abs(from - to) * 15;
        int travelTime = Math.abs(from - to);
        int dropTime = pickupTime + travelTime;

        int amount = calculateFare(travelDistance);

        Booking booking = new Booking(
                bookingCounter++,
                customerId,
                from,
                to,
                pickupTime,
                dropTime,
                amount
        );

        selectedTaxi.bookings.add(booking);
        selectedTaxi.totalEarnings += amount;
        selectedTaxi.currentPoint = to;
        selectedTaxi.freeTime = dropTime;

        System.out.println("Taxi can be allotted.");
        System.out.println("Taxi-" + selectedTaxi.taxiId + " is allotted");
    }

    static int calculateFare(int distance) {
        if (distance <= 5)
            return 100;
        return 100 + (distance - 5) * 10;
    }

    static void displayTaxiDetails() {

        for (Taxi t : taxis) {

            if (t.bookings.isEmpty()) continue;

            System.out.println("\nTaxi-" + t.taxiId + " Total Earnings: Rs. " + t.totalEarnings);
            System.out.println("BookingID  CustomerID  From  To  Pickup  Drop  Amount");

            for (Booking b : t.bookings) {
                System.out.println(
                        b.bookingId + "          " +
                        b.customerId + "           " +
                        b.from + "     " +
                        b.to + "     " +
                        b.pickupTime + "      " +
                        b.dropTime + "     " +
                        b.amount
                );
            }
        }
    }
}
