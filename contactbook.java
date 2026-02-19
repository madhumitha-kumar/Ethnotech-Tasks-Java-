package CB;

import java.util.Scanner;

//===== Custom Exceptions =====

class DuplicateContactException extends Exception {
 public DuplicateContactException(String msg) {
     super(msg);
 }
}

class EmptyContactBookException extends Exception {
 public EmptyContactBookException(String msg) {
     super(msg);
 }
}

class InvalidPhoneNumberException extends Exception {
 public InvalidPhoneNumberException(String msg) {
     super(msg);
 }
}

class InvalidNameException extends Exception {
 public InvalidNameException(String msg) {
     super(msg);
 }
}

//===== Contact Class =====

class Contact {
 String name;
 String phone;

 Contact(String name, String phone) {
     this.name = name;
     this.phone = phone;
 }
}

//===== Main Application =====

public class ContactBookApp {

 static Contact[] contacts = new Contact[10];
 static int count = 0;

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     while (true) {

         System.out.println("\n---- CONTACT MANAGEMENT ----");
         System.out.println("1. Add Contact");
         System.out.println("2. Delete Contact");
         System.out.println("3. Edit Contact");
         System.out.println("4. Display Contacts");
         System.out.println("5. Exit");

         System.out.print("Enter choice: ");
         int choice = sc.nextInt();
         sc.nextLine();

         switch (choice) {
             case 1: addContact(sc); break;
             case 2: deleteContact(sc); break;
             case 3: editContact(sc); break;
             case 4: displayContacts(); break;
             case 5: System.exit(0);
             default: System.out.println("Invalid choice!");
         }
     }
 }

 // ===== ADD =====
 static void addContact(Scanner sc) {

     if (count == 10) {
         System.out.println("Contact limit reached!");
         return;
     }

     try {
         System.out.print("Enter Name: ");
         String name = sc.nextLine();

         validateName(name);
         checkDuplicate(name);

         System.out.print("Enter Phone Number: ");
         String phone = sc.nextLine();

         validatePhone(phone);

         contacts[count] = new Contact(name, phone);
         count++;

         System.out.println("Contact Added Successfully!");

     } catch (Exception e) {
         System.out.println("Exception: " + e.getMessage());
     }
 }

 // ===== NAME VALIDATION =====
 static void validateName(String name) throws InvalidNameException {
     if (!name.matches("[A-Za-z]+")) {
         throw new InvalidNameException(
             "Name must contain only alphabets (no numbers or special characters)."
         );
     }
 }

 // ===== DUPLICATE CHECK =====
 static void checkDuplicate(String name) throws DuplicateContactException {
     for (int i = 0; i < count; i++) {
         if (contacts[i].name.equalsIgnoreCase(name)) {
             throw new DuplicateContactException("Contact already exists!");
         }
     }
 }

 // ===== PHONE VALIDATION =====
 static void validatePhone(String phone) throws InvalidPhoneNumberException {
     if (!phone.matches("\\d{10}")) {
         throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits!");
     }
 }

 // ===== DELETE =====
 static void deleteContact(Scanner sc) {

     try {
         if (count == 0) {
             throw new EmptyContactBookException("Contact Book is Empty!");
         }

         System.out.print("Enter name to delete: ");
         String name = sc.nextLine();

         for (int i = 0; i < count; i++) {
             if (contacts[i].name.equalsIgnoreCase(name)) {

                 for (int j = i; j < count - 1; j++) {
                     contacts[j] = contacts[j + 1];
                 }

                 count--;
                 System.out.println("Contact Deleted!");
                 return;
             }
         }

         System.out.println("Contact not found!");

     } catch (EmptyContactBookException e) {
         System.out.println("Exception: " + e.getMessage());
     }
 }

 // ===== EDIT =====
 static void editContact(Scanner sc) {

     if (count == 0) {
         System.out.println("Contact Book is Empty!");
         return;
     }

     System.out.print("Enter name to edit: ");
     String name = sc.nextLine();

     for (int i = 0; i < count; i++) {

         if (contacts[i].name.equalsIgnoreCase(name)) {

             try {
                 System.out.print("Enter new phone number: ");
                 String phone = sc.nextLine();

                 validatePhone(phone);
                 contacts[i].phone = phone;

                 System.out.println("Contact Updated!");
                 return;

             } catch (InvalidPhoneNumberException e) {
                 System.out.println("Exception: " + e.getMessage());
                 return;
             }
         }
     }

     System.out.println("Contact not found!");
 }

 // ===== DISPLAY =====
 static void displayContacts() {

     if (count == 0) {
         System.out.println("Contact Book is Empty!");
         return;
     }

     System.out.println("\n--- CONTACT LIST ---");

     for (int i = 0; i < count; i++) {
         System.out.println(contacts[i].name + "  |  " + contacts[i].phone);
     }
 }
}

