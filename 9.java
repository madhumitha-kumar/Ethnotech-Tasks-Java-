package MC;

import java.util.Scanner;

public class MiniCalc {

 
    static int mul(int a,int b){ return a*b; }
    static int div(int a,int b){ return a/b; }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter first number: ");
        int x=sc.nextInt();

        System.out.print("Enter second number: ");
        int y=sc.nextInt();

        System.out.println("Choose operation:");
        System.out.println("*  /");

        char op=sc.next().charAt(0);

        switch(op){
            case '*': System.out.println("Result = "+mul(x,y)); break;
            case '/': System.out.println("Result = "+div(x,y)); break;
            default: System.out.println("Invalid operation");
        }
    }
}












