package interfaces;
import java.util.*;


class exception{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int numerator = sc.nextInt();

        System.out.println("Enter the denominator: ");
        int deno = sc.nextInt();

        try{
            int res = numerator/deno;
            System.out.println("Result: " + res);
        }catch ( ArithmeticException e){
            System.out.println("Error: cannot divide by zero.");
        } finally{
            System.out.println("Program executed");
        }

        

    }
}