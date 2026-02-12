package Cl;

import java.util.Scanner;

class Calculator {

    static int add(int a,int b){
        return a+b;
    }

    static int sub(int a,int b){
        return a-b;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);2
        

        System.out.print("Enter first number: ");
        int x=sc.nextInt();

        System.out.print("Enter second number: ");
        int y=sc.nextInt();

        System.out.print("Choose operation (+ or -): ");
        char op=sc.next().charAt(0);

        switch(op){
            case '+': System.out.println("Result = "+add(x,y)); break;
            case '-': System.out.println("Result = "+sub(x,y)); break;
            default: System.out.println("Invalid choice");
        }
    }
}
