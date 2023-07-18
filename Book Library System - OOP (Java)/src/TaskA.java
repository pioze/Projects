import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {

        //PART A - TASK 1
        System.out.print("Divisible by 4: ");
        for (int i = 1; i < 100; i++) {
            if (i % 4 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        System.out.print("Divisible by 10: ");
        for (int i = 1; i < 100; i++) {
            if (i % 10 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        System.out.print("Divisible by both 4 and 10: ");
        for (int i = 1; i < 100; i++) {
            if (i % 4 == 0 && i % 10 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        System.out.println();

        //PART A - TASK 2
        double sum = 0;
        for (int i = 1; i <= 15; i++) {
            sum += Math.pow(2, i);
        }
        System.out.print("Sum = " + sum);

        System.out.println();
        System.out.println();

        //PART A - TASK 3 (Function called : N = 5)
        Scanner a = new Scanner(System.in);
        System.out.println("Please enter an integer > 0");
        int c = a.nextInt();
        pyramid(c);

        System.out.println();

        //PART A - TASK 4
        MonthlyCost();


    }

    //PART A - TASK 3 (Function)
    public static void pyramid(int n)
    {
        for(int i=n;i>=1;i--)
        {
            for(int j=i;j>=1;j--)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }


    //PART A - TASK 4
    public static void MonthlyCost(){
        int Rent_payment;
        int Phone_bill;
        int Utility_costs;
        int Cable_fee;

        while(true) {
            try {
                Scanner user = new Scanner(System.in);

                System.out.println("Please enter your monthly rent");
                Rent_payment = user.nextInt();

                System.out.println("Please enter your monthly phone bill");
                Phone_bill = user.nextInt();

                System.out.println("Please enter your monthly utility costs");
                Utility_costs = user.nextInt();

                System.out.println("Enter your monthly cable fee");
                Cable_fee = user.nextInt();
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Please enter a valid number (Integer)");
            }
        }

        //Calling monthly expenses sum function in current function
        System.out.println("Your total monthly bill is: " + ExpenditureSum(Rent_payment, Phone_bill, Utility_costs, Cable_fee));
        System.out.println("Your annual bill for all expenses is: " + (ExpenditureSum(Rent_payment, Phone_bill, Utility_costs, Cable_fee)) * 12);
    }

    public static int ExpenditureSum(int rent, int phone, int utility, int cable){
        int expenses_sum = rent + phone + utility + cable;
        return expenses_sum;
    }

}
